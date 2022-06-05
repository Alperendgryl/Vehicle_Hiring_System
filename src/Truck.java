
public class Truck extends Vehicle {

    private static int loadingCap;
    private String typeOfTruck;

    public Truck(String PlateNumber, int numberOfTires, int LoadingCap, String typeOfTruck) {
        super(PlateNumber, numberOfTires);
        this.loadingCap = LoadingCap;
        this.typeOfTruck = typeOfTruck;
    }
    
    @Override
    public String toString() {
        return super.toString()  + "\nType of truck : " + typeOfTruck + "\nLoading cap : " + loadingCap;
    }
    
    public static int getLoadingCap() {
        return loadingCap;
    }

}
