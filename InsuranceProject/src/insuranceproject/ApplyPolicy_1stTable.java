/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insuranceproject;

/**
 *
 * @author Pc
 */
public class ApplyPolicy_1stTable {
    String ApplicationStatus;

    public ApplyPolicy_1stTable(String ApplicationStatus, int Customerid, int Vehicleid, String VehicleName, String VehicleType, String VehicleLicense, String VehicleIssueDate) {
        this.ApplicationStatus = ApplicationStatus;
        this.Customerid = Customerid;
        this.Vehicleid = Vehicleid;
        this.VehicleName = VehicleName;
        this.VehicleType = VehicleType;
        this.VehicleLicense = VehicleLicense;
        this.VehicleIssueDate = VehicleIssueDate;
    }

    public String getApplicationStatus() {
        return ApplicationStatus;
    }

    public void setApplicationStatus(String ApplicationStatus) {
        this.ApplicationStatus = ApplicationStatus;
    }

    public ApplyPolicy_1stTable(String ApplicationStatus) {
        this.ApplicationStatus = ApplicationStatus;
    }
    int Customerid,Vehicleid;
    String VehicleName,VehicleType,VehicleLicense,VehicleIssueDate;

    public ApplyPolicy_1stTable(int Customerid, int Vehicleid, String VehicleName, String VehicleType, String VehicleLicense, String VehicleIssueDate) {
        this.Customerid = Customerid;
        this.Vehicleid = Vehicleid;
        this.VehicleName = VehicleName;
        this.VehicleType = VehicleType;
        this.VehicleLicense = VehicleLicense;
        this.VehicleIssueDate = VehicleIssueDate;
    }

    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(int Customerid) {
        this.Customerid = Customerid;
    }

    public int getVehicleid() {
        return Vehicleid;
    }

    public void setVehicleid(int Vehicleid) {
        this.Vehicleid = Vehicleid;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String VehicleName) {
        this.VehicleName = VehicleName;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String VehicleType) {
        this.VehicleType = VehicleType;
    }

    public String getVehicleLicense() {
        return VehicleLicense;
    }

    public void setVehicleLicense(String VehicleLicense) {
        this.VehicleLicense = VehicleLicense;
    }

    public String getVehicleIssueDate() {
        return VehicleIssueDate;
    }

    public void setVehicleIssueDate(String VehicleIssueDate) {
        this.VehicleIssueDate = VehicleIssueDate;
    }
    
    

  
}
