package MotorPH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceRecord {
    
    private String employeeFName;
    private String employeeLName;
    private LocalDate recordDate;
    private int employeeID;
    private LocalTime timeIn;
    private LocalTime timeOut;
//    private String lates;
//    private LocalTime breakTime;
//    private double totalHoursWorked;
//    private double hoursWorked;
    
 
//    public void setCurrentTime(LocalTime currentTime) {
//        this.currentTime =  currentTime;
//    }
    
    public String getEmployeeFName() {
        return employeeFName;
    }

    public void setEmployeeFName(String employeeFName) {
        this.employeeFName = employeeFName;
    }

    public String getEmployeeLName() {
        return employeeLName;
    }

    public void setEmployeeLName(String employeeLName) {
        this.employeeLName = employeeLName;
    }
    
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate =  recordDate;
    }
        
    public LocalDate getRecordDate(){
        return recordDate;
    }
    
    public void setEmployeeID(int employeeID) {
        this.employeeID =  employeeID;
    }
        
    public int getEmployeeID(){
        return employeeID;
    }
    
    public void setTimeIn(LocalTime timeIn) {
        this.timeIn =  timeIn;
    }
        
    public LocalTime getTimeIn(){
        return timeIn;
    }
    
    public void setTimeOut(LocalTime timeOut) {
        this.timeOut =  timeOut;
    }
        
    public LocalTime getTimeOut(){
        return timeOut;
    }
    
//    public void setLates(String lates) {
//        this.lates =  lates;
//    }
//        
//    public String getLates(){
//        return lates;
//    }
    
    public static  List<AttendanceRecord> getAttendanceRecordList() throws FileNotFoundException, IOException 
    {
       String filePath = "src\\resources\\AttendanceRecord5.txt";
       BufferedReader br = new BufferedReader(new FileReader(filePath));
       
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // FORMAT FOR DATE
//        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");      // FORMAT FOR TIME
       
       String str;
       List<AttendanceRecord> attendanceRecordList = new ArrayList<>();
       
       
        while ((str = br.readLine()) != null) {
   
            var values = str.split(",");
            
            var attendanceRecord = new AttendanceRecord();
            attendanceRecord.setEmployeeID(Integer.parseInt(values[0]));
            attendanceRecord.setEmployeeLName(values[1]);
            attendanceRecord.setEmployeeFName(values[2]);
            attendanceRecord.setRecordDate(LocalDate.parse(values[3], dateFormat));
            attendanceRecord.setTimeIn(LocalTime.parse(values[4]));
            attendanceRecord.setTimeOut(LocalTime.parse(values[5]));
//            attendanceRecord.setLates(values[6]);
         
            attendanceRecordList.add(attendanceRecord);
         
             
        }
        
                
        return attendanceRecordList;
    } 

//    public void setBreakTime(LocalTime breakTime){
//        this.breakTime = breakTime;
//    }
//    
//    public double getHoursWorked(){
//        return hoursWorked;
//    }
//    
//    public double getTotalHoursWorked(){
//        return totalHoursWorked;
//    }
//    
    private static long calculateHoursWorked(LocalTime timeIn, LocalTime timeOut) {
        Duration duration = Duration.between(timeIn, timeOut);
        return duration.toHours();
    }
     
    // TO CALCULATES HOURS WORKED ON A SPECIFIC MONTH OF AN EMPLOYEE
    public static long calculateTotalHoursWorked(int year, int month, int targetEmployeeId) throws IOException {
    
        List<AttendanceRecord> attendanceRecordList = AttendanceRecord.getAttendanceRecordList().stream().filter(employee -> employee.getEmployeeID()== targetEmployeeId).collect(Collectors.toList());
        long totalHours = 0;

        for (AttendanceRecord entry : attendanceRecordList) {
          
                int entryYear = entry.getRecordDate().getYear();
                int entryMonth = entry.getRecordDate().getMonthValue();

                if (entryYear == year && entryMonth == month) {
                    // Calculate hours worked for the specified month
                    long hoursWorked = calculateHoursWorked(entry.getTimeIn(), entry.getTimeOut());               

                    // Accumulate total hours
                    totalHours += hoursWorked;
                }
            
        }
        
        return totalHours;
    }
    
    public static List<AttendanceRecord> getAttendanceRecordByEmployeeId(int targetEmployeeId) throws IOException{
    
        List<AttendanceRecord> attendanceRecordList = AttendanceRecord.getAttendanceRecordList().stream().filter(employee -> employee.getEmployeeID()== targetEmployeeId).collect(Collectors.toList());
        return attendanceRecordList;
    }
}