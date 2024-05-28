package MotorPH;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {

    private int employeeID;
    private String employeeFName;
    private String employeeLName;
    private String employeeBDay;
    private String employeePos;
    private String employeeAddress;
    private String employeePhoneNum;
    private String employeeSssNum;
    private String employeePhilHealthNum;
    private String employeeTinNum;
    private String employeePagibigNum;
    private String employeeStatus;
    private String employeeSupervisor;
    private double hourlyRate;

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getEmployeePhoneNum() {
        return employeePhoneNum;
    }

    public String getEmployeeSssNum() {
        return employeeSssNum;
    }

    public String getEmployeePhilHealthNum() {
        return employeePhilHealthNum;
    }

    public String getEmployeeTinNum() {
        return employeeTinNum;
    }

    public String getEmployeePagibigNum() {
        return employeePagibigNum;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public String getEmployeeSupervisor() {
        return employeeSupervisor;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

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

    public String getEmployeeBDay() {
        return employeeBDay;
    }

    public void setEmployeeBDay(String employeeBDay) {
        this.employeeBDay = employeeBDay;
    }

    public String getEmployeePos() {
        return employeePos;
    }

    public void setEmployeePos(String employeePos) {
        this.employeePos = employeePos;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setEmployeePhoneNum(String employeePhoneNum) {
        this.employeePhoneNum = employeePhoneNum;
    }

    public void setEmployeeSssNum(String employeeSssNum) {
        this.employeeSssNum = employeeSssNum;
    }

    public void setEmployeePhilHealthNum(String employeePhilHealthNum) {
        this.employeePhilHealthNum = employeePhilHealthNum;
    }

    public void setEmployeeTinNum(String employeeTinNum) {
        this.employeeTinNum = employeeTinNum;
    }

    public void setEmployeePagibigNum(String employeePagibigNum) {
        this.employeePagibigNum = employeePagibigNum;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setEmployeeSupervisor(String employeeSupervisor) {
        this.employeeSupervisor = employeeSupervisor;
    }
    
     public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    /**
     * Searches for an employee based on the entered ID from a CSV file.
     * Throws exceptions if file is not found or there's an IO error.
     *
     * @param enteredEmployeeID The employee ID entered by the user.
     * @return 
     * @throws java.io.FileNotFoundException
     */
    public static EmployeeInfo searchEmployee(String enteredEmployeeID) throws FileNotFoundException, IOException {
        List<EmployeeInfo> employeeInfoList = getEmployeeInfoList();
        int enteredID = Integer.parseInt(enteredEmployeeID);
        for (EmployeeInfo employee : employeeInfoList) {
            if (employee.getEmployeeID() == enteredID) {
                return employee;
            }
        }
        return null; // No employee found
    }

    /**
     * Reads employee information from a CSV file and creates a list of EmployeeInfo objects.
     * Throws exceptions if file is not found or there's an IO error.
     *
     * @return A list of EmployeeInfo objects containing employee data.
     * @throws java.io.FileNotFoundException
     */
    public static List<EmployeeInfo> getEmployeeInfoList() throws FileNotFoundException, IOException {
        String filePath = "src\\resources\\Data.csv"; 
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String str;
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();

        str = br.readLine(); // Skip the header row (assuming the first row contains column names)
        while ((str = br.readLine()) != null) {

            var values = str.split(",");

            var employeeInfo = new EmployeeInfo();
            employeeInfo.setEmployeeID(Integer.parseInt(values[0]));
            employeeInfo.setEmployeeLName(values[1]);
            employeeInfo.setEmployeeFName(values[2]); // Ensure this is the correct index for first name
            employeeInfo.setEmployeeBDay(values[3]);
            employeeInfo.setEmployeeAddress(values[4]);
            employeeInfo.setEmployeePhoneNum(values[5]);
            employeeInfo.setEmployeeSssNum(values[6]);
            employeeInfo.setEmployeePhilHealthNum(values[7]);
            employeeInfo.setEmployeeTinNum(values[8]);
            employeeInfo.setEmployeePagibigNum(values[9]);
            employeeInfo.setEmployeeStatus(values[10]);
            employeeInfo.setEmployeePos(values[11]);
            employeeInfo.setEmployeeSupervisor(values[12]);
            employeeInfo.setHourlyRate(Double.parseDouble(values[18]));
            

            employeeInfoList.add(employeeInfo);
        }
    return employeeInfoList;
    }
    
    public static EmployeeInfo getEmployeeInfoByEmployeeId(int targetEmployeeId) throws IOException{
    
        EmployeeInfo employeeInfo = getEmployeeInfoList().stream().filter(employee -> employee.getEmployeeID()== targetEmployeeId).findAny().get();
        return employeeInfo;
    }
}
