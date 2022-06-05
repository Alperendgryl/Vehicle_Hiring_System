
public class SUV extends Car{

    private String typeOfWheelDrive;

    public SUV(String color, String seatingCap, int numOfDoors, String PlateNumber, int numberOfTires, String typeOfCar, String typeOfWheelDrive) {
        super(color, seatingCap, numOfDoors, PlateNumber, numberOfTires, typeOfCar);
        this.typeOfWheelDrive = typeOfWheelDrive;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nType of wheel drive : " + typeOfWheelDrive ;
    }
    
}
