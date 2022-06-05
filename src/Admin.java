public class Admin extends Person {

    private String userName;
    
    public Admin(int ID, String name, String phoneNo, String adress, String userName) {
        super(ID, name, phoneNo, adress);
        this.userName = userName;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nUser Name : " + userName;
    }

    public String getUserName() {
        return userName;
    }
}
/*
public void addNewVehicle() {
        getVehiclePark().addVehicle(this);  GETVEHICLE()COMES FROM PERSON'S GETTER, ADDVEHICLE() COMES FROM VEHICLEPARK CLASS. THOSE FUNCTIONS ONLY CAN INVOKED BY ADMIN.
    }

    public void removeVehicle() {
        getVehiclePark().removeVehicle(this);
    }

    public void askDailyReport() {
        getVehiclePark().dailyReport(this);
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public void displayAvailableVehicles() {
        super.displayAvailableVehicles();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nUser Name : " + userName;
    }

    public String getUserName() {
        return userName;
    }
*/