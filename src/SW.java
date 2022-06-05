
public class SW extends Car {

    private static int LoadingCap;

    public SW(String color, String seatingCap, int numOfDoors, String PlateNumber, int numberOfTires, String typeOfCar, int LoadingCap) {
        super(color, seatingCap, numOfDoors, PlateNumber, numberOfTires, typeOfCar);
        this.LoadingCap = LoadingCap;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nLoading cap : " + LoadingCap ;
    }
    public static int getLoadingCap() {
        return LoadingCap;
    }

}
