public interface VehicleParkInterface {

    public void displayVehicles(Person person);

    public void displayAvailableVehicles(Person person);

    public void addVehicle(Admin admin);

    public void removeVehicle(Admin admin);

    public void bookVehicle(RegisteredUser registeredUser);

    public void dailyReport(Admin admin);
}
