
public class Vehicle {

    private String PlateNumber;
    private int numberOfTires;
    private static int DailyFee;
    private static int numberOfDays;

    public Vehicle(String PlateNumber, int numberOfTires) {
        this.PlateNumber = PlateNumber;
        this.numberOfTires = numberOfTires;
    }

    @Override
    public String toString() {
        return "\nPlate Number : " + PlateNumber + "\nNumber of tires : " + numberOfTires;
    }

    public static int getDailyFee() {
        return DailyFee*numberOfDays;
    }

    public static int getNumberOfDays() {
        return numberOfDays;
    }

    public static void setDailyFee(int Dailyfee) {
        DailyFee = Dailyfee;
    }

    public static void setNumberOfDays(int numOfDays) {
        numberOfDays = numOfDays;
    }

}
