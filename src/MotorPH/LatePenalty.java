package MotorPH;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class LatePenalty {
    
    public static double CalculateLatePenalty(int targetEmployeeId, int targetMonth) throws IOException
    {
        List<AttendanceRecord> attendanceRecordList = AttendanceRecord.getAttendanceRecordList().stream().filter(employee -> employee.getEmployeeID()== targetEmployeeId).collect(Collectors.toList());
        EmployeeInfo employeeInfo = EmployeeInfo.getEmployeeInfoByEmployeeId(targetEmployeeId);         
        //EmployeeInfo employeeInfo = EmployeeInfo.getEmployeeInfoList().stream().filter(employee -> employee.getEmployeeID()== targetEmployeeId).findAny().get();
        //Payroll payrollInfo = Payroll.getPayrollDetails(targetEmployeeId);
        double totalLateDeduction = 0;
       
        // Iterates through every attendance record.
        for (AttendanceRecord attendanceRecord : attendanceRecordList) {     
            LocalDate recordDate = attendanceRecord.getRecordDate();
            int recordMonth = recordDate.getMonthValue(); // Month as an integer.
        
              // Check if the record is in the target month
            if (recordMonth == targetMonth) {
                // Assuming late penalty starts from 8:10 AM (490 minutes) onwards
                final int lateThreshold = 490;
                
                // Gets time in.
                LocalTime timeIn = attendanceRecord.getTimeIn();
                
                // converts hour into minutes then add it to the minutes. Sample: 8:40 is 480 + 40.
                int lateTime = timeIn.getHour() * 60 + timeIn.getMinute();
                
                // Compares late time to threshold.
                if (lateTime >= lateThreshold) {
                    // Calculate the per-minute equivalent of the hourly rate
                    double hourlyRate = employeeInfo.getHourlyRate();
                    double perMinuteRate = hourlyRate / 60.0;

                    // Calculate the deduction amount based on late time
                    double deduction = perMinuteRate * (lateTime - lateThreshold);

                    // Ensure deduction is non-negative
                    totalLateDeduction += Math.max(0, deduction);

                }
            }      
        }

        return totalLateDeduction;
    }
}
//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
