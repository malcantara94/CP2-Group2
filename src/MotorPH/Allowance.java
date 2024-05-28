package MotorPH;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Allowance {
    private int employeeID;
    private int riceAlw;
    private int clothAlw;
    private int phoneAlw;
    private int alwTotal;

    public int getAlwTotal() {
        alwTotal = phoneAlw + clothAlw + riceAlw;
        return alwTotal;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getRiceAlw() {
        return riceAlw;
    }

    public int getClothAlw() {
        return clothAlw;
    }

    public int getPhoneAlw() {
        return phoneAlw;
    }

    public void setAlwTotal(int alwTotal) {
        this.alwTotal = alwTotal;
        
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setRiceAlw(int riceAlw) {
        this.riceAlw = riceAlw;
    }

    public void setClothAlw(int clothAlw) {
        this.clothAlw = clothAlw;
    }

    public void setPhoneAlw(int phoneAlw) {
        this.phoneAlw = phoneAlw;
    }
    public static Allowance searchEmployeeAlw(String enteredEmployeeID) throws FileNotFoundException, IOException {
        List<Allowance> allowanceInfoList = getAllowanceInfoList();
        int enteredID = Integer.parseInt(enteredEmployeeID);
        for (Allowance allowance : allowanceInfoList) {
            if (allowance.getEmployeeID() == enteredID) {
                return allowance;
            }
        }
        return null; // No employee found
    }
    public static List<Allowance> getAllowanceInfoList() throws FileNotFoundException, IOException {
        String filePath = "src\\resources\\Data.csv"; 
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String str;
        List<Allowance> allowanceInfoList = new ArrayList<>();

        str = br.readLine(); // Skip the header row (assuming the first row contains column names)
        while ((str = br.readLine()) != null) {

            var values = str.split(",");

            var allowanceInfo = new Allowance();
            allowanceInfo.setEmployeeID(Integer.parseInt(values[0]));
            allowanceInfo.setRiceAlw(Integer.parseInt(values[14]));
            allowanceInfo.setPhoneAlw(Integer.parseInt(values[15]));
            allowanceInfo.setClothAlw(Integer.parseInt(values[16]));

            allowanceInfoList.add(allowanceInfo);
        }
    return allowanceInfoList;
    }

    
 
    
}
