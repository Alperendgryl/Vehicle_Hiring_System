public class Car extends Vehicle {

    private String color;
    private String seatingCap;
    private int numOfDoors;
    private String typeOfCar;

    public Car(String color, String seatingCap, int numOfDoors, String PlateNumber, int numberOfTires, String typeOfCar) {
        super(PlateNumber, numberOfTires);
        this.color = color;
        this.seatingCap = seatingCap;
        this.numOfDoors = numOfDoors;
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType of car : " + typeOfCar + "\nColor : " + color + "\nSeating cap : " + seatingCap
                + "\nNumber of doors : " + numOfDoors;
    }
}
