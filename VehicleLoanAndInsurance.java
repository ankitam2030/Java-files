package PackFATPrep;

import java.util.Scanner;

interface VehicleLoan {

    double issueVehicleLoan();
}

interface InsuranceForVehicle {

    int getInsurance();
}

public class VehicleLoanAndInsurance implements VehicleLoan, InsuranceForVehicle {

    String vehicleNo;
    String model_Name;
    String vehicle_Type;
    double price;

    Q2(String vehicleNo, String model_Name, String vehicle_Type, double price) {
        this.vehicleNo = vehicleNo;
        this.model_Name = model_Name;
        this.vehicle_Type = vehicle_Type;
        this.price = price;
    }

    public double issueVehicleLoan() {
        if (vehicle_Type.equals("four wheeler")) {
            return 0.85 * price;
        } 
        if (vehicle_Type.equals("three wheeler")) {
            return 0.7 * price;
        } 
        if (vehicle_Type.equals("two wheeler")) {
            return 0.5 * price;
        } 
        return 0;
    }

    public int getInsurance() {
        if (price <= 550000) {
            return 6500;
        }
        if (price <= 900000 ) {
            return 8000;
        }
        if (price > 900000) {
            return 10000;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Q2 user = new Q2("1111", "Homda", "four wheeler", 870000);

        System.out.println("Vehicle Loan amount is: " + user.issueVehicleLoan());
        System.out.println("Vehicle Insurance amount is: " + user.getInsurance());
        
        scanner.close();
    }
}
