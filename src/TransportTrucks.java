
public class TransportTrucks extends Truck {

    private boolean isGoingAbroad;

    public TransportTrucks(String PlateNumber, int numberOfTires, int LoadingCap, String typeOfTruck, boolean isGoingAbroad) {
        super(PlateNumber, numberOfTires, LoadingCap, typeOfTruck);
        this.isGoingAbroad = isGoingAbroad;
    }

    public boolean isIsGoingAbroad() {
        return isGoingAbroad;
    }

    public void setIsGoingAbroad(boolean isGoingAbroad) {
        this.isGoingAbroad = isGoingAbroad;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIs truck goes abroad : " + isGoingAbroad;
    }
}
