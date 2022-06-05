
public class Person {

    private int ID;
    private String name;
    private String phoneNo;
    private String adress;

    public Person(int ID, String name, String phoneNo, String adress) {
        this.ID = ID;
        this.name = name;
        this.phoneNo = phoneNo;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "\nName : " + name + "\nPhone number : " + phoneNo + "\nAdress : " + adress + "\nID : " + ID + "\n";
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
}


/*
private VehiclePark vehiclePark = new VehiclePark();

public void display() {
        getVehiclePark().displayVehicles(this);
    }

    public void displayAvailableVehicles() {
        getVehiclePark().displayAvailableVehicles(this);
    }
    public int getID() {
        return ID;
    }
    public VehiclePark getVehiclePark() {
        return vehiclePark;
    }

    From this class, display methods can be overrided in Admin and RegisteredUser classes by using getVehiclePark().
*/