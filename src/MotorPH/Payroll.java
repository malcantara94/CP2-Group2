package MotorPH;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JustAMob
 */
public class Payroll {
    private double hourlyRate,monthlyWage,grossWage,taxedWage,netPay;
    
        public Payroll(double hourlyRate, double monthlyWage,double grossWage,double deducNoTax, double taxedWage, double netPay){
          this.hourlyRate= hourlyRate;
          this.monthlyWage= monthlyWage;
          this.grossWage=grossWage;
          this.taxedWage=taxedWage;
          this.netPay=netPay;
        }
    
        public double getHourlyRate(){
        return hourlyRate;
        }
    
        public double getMonthlyWage(){
        return monthlyWage;
        }
    
        public double calculateGrossWage(){
        return grossWage;
        } 

        public double calculateNetPay(){
        return netPay;
        }
        
        public double calculateTaxedWage(){
                return taxedWage;
        }
    
    
}
