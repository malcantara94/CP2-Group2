package MotorPH;

public class Deductions {
    private double sss;
    private double philHealth;
    private double pagIbig;
    private double deducnoTax;
    private double withholdingTax;

    
    public Deductions(double sss, double philHealth, double pagIbig,  double deducNoTax, double withholdingTax){
        this.sss = sss;
        this.philHealth = philHealth;
        this.pagIbig = pagIbig;
        this.deducnoTax = deducNoTax;
        this.withholdingTax = withholdingTax;
    }
    public double getSSS(double wage){
        if (wage < 3250){  sss =  135.00; }
        else if (wage >= 3250 && wage <= 3750){ sss = 157.50;}
        else if (wage >= 3750 && wage <= 4250){ sss =  180.00;}
        else if (wage >= 4250 && wage <= 4750){ sss =  202.50;}
        else if (wage >= 4750 && wage <= 5250){ sss =  225.00;}
        else if (wage >= 5250 && wage <= 5750){ sss =  247.50;}
        else if (wage >= 5750 && wage <= 6250){ sss =  270.00;}
        else if (wage >= 6250 && wage <= 6750){ sss =  292.50;}
        else if (wage >= 6750 && wage <= 7250){ sss =  315.00;}
        else if (wage >= 7250 && wage <= 7750){ sss =  337.50;}
        else if (wage >= 7750 && wage <= 8250){ sss =  360.00;}
        else if (wage >= 8250 && wage <= 8750){ sss =  382.50;}
        else if (wage >= 8750 && wage <= 9250){ sss =  405.00;}
        else if (wage >= 9250 && wage <= 9750){ sss =  427.50;}
        else if (wage >= 9750 && wage <= 10250){ sss =  450.00;}
        else if (wage >= 10250 && wage <= 10750){ sss =  472.50;}
        else if(wage >= 10750 && wage <= 11250){ sss =  495.00;}
        else if(wage >= 11250 && wage <= 11750){ sss =  517.50;}
        else if(wage >= 11750 && wage <= 12250){ sss =  540.00;}
        else if(wage >= 12250 && wage <= 12750){ sss =  562.50;}
        else if(wage >= 12750 && wage <= 13250){ sss =  585.00;}
        else if(wage >= 13250 && wage <= 13750){ sss =  607.50;}
        else if(wage >= 13750 && wage <= 14250){ sss =  630.00;}
        else if(wage >= 14250 && wage <= 14750){ sss =  652.50;}
        else if(wage >= 14750 && wage <= 15250){ sss =  675.00;}
        else if(wage >= 15250 && wage <= 15750){ sss =  697.50;}
        else if(wage >= 15750 && wage <= 16250){ sss =  720.00;}
        else if(wage >= 16250 && wage <= 16750){ sss =  742.50;}
        else if(wage >= 16750 && wage <= 17250){ sss =  765.00;}
        else if(wage >= 17250 && wage <= 17750){ sss =  787.50;}
        else if(wage >= 17750 && wage <= 18250){ sss =  810.00;}
        else if(wage >= 18250 && wage <= 18750){ sss =  832.50;}
        else if(wage >= 18750 && wage <= 19250){ sss =  855.00;}
        else if(wage >= 19250 && wage <= 19750){ sss =  877.50;}
        else if(wage >= 19750 && wage <= 20250){ sss =  900.00;}
        else if(wage >= 20250 && wage <= 20750){ sss =  922.50;}
        else if(wage >= 20750 && wage <= 21250){ sss =  945.00;}
        else if(wage >= 21250 && wage <= 21750){ sss =  967.50;}
        else if(wage >= 21750 && wage <= 22250){ sss =  990.00;}
        else if(wage >= 22250 && wage <= 22750){ sss =  1012.50;}
        else if(wage >= 22750 && wage <= 23250){ sss =  1035.00;}
        else if(wage >= 23250 && wage <= 23750){ sss =  1057.50;}
        else if(wage >= 23750 && wage <= 24250){ sss =  1080.00;}
        else if(wage >= 24250 && wage <= 24750){ sss =  1102.50;}
        else{sss =  1125.00;}
        return sss;
    }

    public double getPhilHealth(double wage){
            if (wage <= 10000){
              philHealth = 300;
            }
            else if (wage >= 10000.01 && wage <= 59999.99){
              philHealth = wage * 0.03;
            }
            else if (wage >= 60000){
              philHealth = 1800;
            }
            else{
              philHealth = 0;
            }
            // Monthly premium philHealth payments are equally shared between the employee and employer
            return philHealth * 0.5;
    }

    public double getPagibig(double wage){
        double management;
        double employee;
        if (wage >=1000 && wage <= 1500){
          management = wage * 0.01;
          employee = wage * 0.02;
        }
        else if (wage >1500){
          management = wage * 0.02;
          employee = wage * 0.02;
        }
        else{
          management = 0;
          employee = 0;
        }
        
        double contribution = employee + management;
        // Maximum contribution amount is 100
        if (contribution > 100){
          contribution = 100;
          management = 50;
        }
    return pagIbig = contribution - management;
    }

    public double calculateDeducNoTax(double grosswage){
        deducnoTax = grosswage - (sss + pagIbig + philHealth);
        return deducnoTax;
    }

    public double calculateWithholdingTax (double deducNoTax){
        if(deducNoTax >= 20833 && deducNoTax <= 33333){
          withholdingTax = (deducNoTax - 20833) * 0.2;
        }
        else if(deducNoTax >= 33333 && deducNoTax <= 66667){
          withholdingTax = (deducNoTax - 33333) * 0.25 + 2500;
        }
        else if(deducNoTax >= 66667 && deducNoTax <= 166667){
          withholdingTax = (deducNoTax - 66667) * 0.3 + 10833.33;
        }
        else if(deducNoTax >= 166667 && deducNoTax <= 666667){
          withholdingTax = (deducNoTax - 166667) * 0.32 + 40833.33;
        }
        else if(deducNoTax >= 666667){
          withholdingTax = (deducNoTax - 666667) * 0.35 + 200833.33;
        }
        else{
          withholdingTax = 0;
        }
        
        return withholdingTax;
      }
}//Commentary
//sssssssss