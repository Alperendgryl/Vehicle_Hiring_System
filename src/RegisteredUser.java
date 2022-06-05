public class RegisteredUser extends Person {
    
    public RegisteredUser(int ID, String name, String phoneNo, String adress) {
        super(ID, name, phoneNo, adress);
    }
    
    @Override
    public int getID(){
        return super.getID();
    }
    
    @Override
    public String getName(){
        return super.getName();
    }
}


/*
public void cancelBooking(){ 
        getVehiclePark().cancelBooking(this); SAME IDEA WITH THE ADMIN-PERSON RELATIONSHIP.
    }

    public void loadVehicle(){
        getVehiclePark().loadVehicles(this);
    }
    
    public void searchVehiclesByType(){
        getVehiclePark().searchVehicleByType(this);
    }
    
    public void rentAVehicle(){
        getVehiclePark().rentAVehicle(this);
    }
    
    public void bookVehicle(){
        getVehiclePark().bookVehicle(this);
    }
    
    public void dropVehicle(){
        getVehiclePark().dropVehicle(this);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public void display() {
        super.display();
    }

    @Override
    public void displayAvailableVehicles() {
        super.displayAvailableVehicles();
    }
*/