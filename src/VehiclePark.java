
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehiclePark implements VehicleParkInterface {

    private final static Scanner A = new Scanner(System.in);

    private ArrayList<Vehicle> carsList = new ArrayList<>();
    private ArrayList<Vehicle> trucksList = new ArrayList<>();

    private ArrayList<Car> sportCarList = new ArrayList<>();
    private ArrayList<Car> suvCarList = new ArrayList<>();
    private ArrayList<Car> swCarList = new ArrayList<>();

    private ArrayList<Truck> smallTruckList = new ArrayList<>();
    private ArrayList<Truck> transportTruckList = new ArrayList<>();

    private ArrayList<RegisteredUser> registeredUserList = new ArrayList<>();

    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void displayVehicles(Person person) {
        System.out.println("Vehicles");
        System.out.println("********************");
        if (getTrucksList().isEmpty()) {
            System.out.println("There is no truck that can be shown on the system...");
        } else {
            for (int i = 0; i < getTrucksList().size(); i++) {
                if (getTrucksList().get(i) == null || getTrucksList().isEmpty()) {
                    System.out.println("Truck " + i + ") is booked\n");
                } else {
                    System.out.println("Truck " + i + ") " + getTrucksList().get(i) + "\n");
                }
            }
        }
        if (getCarsList().isEmpty()) {
            System.out.println("There is no car that can be shown on the system...\n");
        } else {
            for (int i = 0; i < getCarsList().size(); i++) {
                if (getCarsList().get(i) == null) {
                    System.out.println("Car " + i + ") is booked\n");
                } else {
                    System.out.println("Car " + i + ") " + getCarsList().get(i) + "\n");
                }
            }
        }
    }

    @Override
    public void displayAvailableVehicles(Person person) {
        try {
            // ADD DAY
            System.out.println("Available Vehicles");
            System.out.println("********************");
            System.out.print("First (DD.MM.YYYY) Date : ");
            String firstDate = A.next();
            System.out.print("Second (DD.MM.YYYY) Date : ");
            String secondDate = A.next();
            firstDatee = formatter.parse(firstDate);//CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            Date secondDatee = formatter.parse(secondDate);//CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            long differenceBetweenDates = Math.abs(secondDatee.getTime() - firstDatee.getTime()); // (date2 - date1 == difference) Math.abs makes the equation.
            long diff = TimeUnit.MILLISECONDS.toDays(differenceBetweenDates); //TO CONVERT MILLISECONDS TO DAYS BETWEEN STARTING DATE AND ENDING DATE.

            if (diff > 0) {
                System.out.println("\nBetween " + firstDate + " and " + secondDate);
                dspav();
            }
            if (diff < 0) {
                System.out.println("The first date you have entered, must be earlier than the second date.");
            }
            if (diff == 0) {
                System.out.println("Date " + firstDate + " :\n");
                dspav();
            }
        } catch (ParseException ex) {
            System.out.println("ParseException.");
        }
    }

    private void dspav() {
        if (getTrucksList().isEmpty()) {
            System.out.println("There is no available truck that can be displayed...");
        } else {
            for (int i = 0; i < getTrucksList().size(); i++) {
                if (getTrucksList().get(i) != null) {
                    System.out.println("Truck " + i + ") " + getTrucksList().get(i) + "\n");
                }
            }
        }
        if (getCarsList().isEmpty()) {
            System.out.println("There is no available car that can be displayed...\n");
        } else {
            for (int i = 0; i < getCarsList().size(); i++) {
                if (getCarsList().get(i) != null) {
                    System.out.println("Car " + i + ") " + getCarsList().get(i) + "\n");
                }
            }
        }
    }

    //DISPLAY AVAILABLE VEHICLES BY USING EXCEPTION.
    /*
    @Override
    public void displayAvailableVehicles(Person person) {
        try {
            if (getTrucksList().isEmpty()) {
                throw new NullPointerException();
            } else {
                for (int i = 0; i < getTrucksList().size(); i++) {
                    if (getTrucksList().get(i) != null) {
                        System.out.println("Truck " + i + ") " + getTrucksList().get(i) + "\n");
                    }
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("\nSorryWeDontHaveThatOne: There is no available truck that can be displayed...");
        }

        try {
            if (getCarsList().isEmpty()) {
                throw new NullPointerException();
            } else {
                for (int i = 0; i < getCarsList().size(); i++) {
                    if (getCarsList().get(i) != null) {
                        System.out.println("Truck " + i + ") " + getCarsList().get(i) + "\n");
                    }
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("\nSorryWeDontHaveThatOne: There is no available car that can be displayed...");
        }
    }
     */
    @Override
    public void addVehicle(Admin admin) {
        System.out.print("Enter the type of the vehicle (Truck - Car) ");
        String type = A.next();
        System.out.print("Enter how many vehicle you will add : ");
        int n = A.nextInt();

        if (type.equals("Truck") || type.equals("truck")) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the type of truck (Small - Transport) : ");
                String typeOfTruck = A.next();
                System.out.print("Enter the plate number : ");
                String plateNumber = A.next();
                System.out.print("Enter the number of tires : ");
                int numberOfTires = A.nextInt();
                System.out.print("Enter the loading cap : ");
                int loadingCap = A.nextInt();
                System.out.println("*****************");

                if (typeOfTruck.equals("Small") || typeOfTruck.equals("small")) {
                    trucksList.add(new SmallTrucks(plateNumber, numberOfTires, loadingCap, "Small"));
                    smallTruckList.add(new SmallTrucks(plateNumber, numberOfTires, loadingCap, "Small"));
                } else if (typeOfTruck.equals("Transport") || typeOfTruck.equals("transport")) {
                    System.out.print("Does truck goes abroad (True-False) ? ");
                    boolean isGoingAbroad = A.nextBoolean();
                    trucksList.add(new TransportTrucks(plateNumber, numberOfTires, loadingCap, "Transport", isGoingAbroad));
                    transportTruckList.add(new TransportTrucks(plateNumber, numberOfTires, loadingCap, "Transport", isGoingAbroad));
                } else {
                    System.out.println("Wrong truck type. Please enter correctly.");
                }
                System.out.println("New truck is added succesfuly...\n");
            }
        } else if (type.equals("Car") || type.equals("car")) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the type of car (Sports-SW-SUV) : ");
                String typeOfCar = A.next();
                System.out.print("Enter the color of the car : ");
                String color = A.next();
                System.out.print("Enter the seating cap : ");
                String seatingCap = A.next();
                System.out.print("Enter the number of doors : ");
                int numberOfDoors = A.nextInt();
                System.out.print("Enter the plate number : ");
                String plateNumber = A.next();
                System.out.print("Enter the number of tires : ");
                int numberOfTires = A.nextInt();
                System.out.println("*****************");

                if (typeOfCar.equals("Sports") || typeOfCar.equals("sports")) {
                    System.out.print("HP power of the car : ");
                    int Hp = A.nextInt();
                    carsList.add(new Sports(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "Sport", Hp));
                    sportCarList.add(new Sports(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "Sport", Hp));
                } else if (typeOfCar.equals("SW") || typeOfCar.equals("sw")) {
                    System.out.print("Loading cap of the car : ");
                    int Lc = A.nextInt();
                    carsList.add(new SW(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "SW", Lc));
                    swCarList.add(new SW(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "SW", Lc));
                } else if (typeOfCar.equals("SUV") || typeOfCar.equals("suv")) {
                    System.out.print("Type of wheel drive of the car : ");
                    String Tofwd = A.next();
                    carsList.add(new SUV(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "SUV", Tofwd));
                    suvCarList.add(new SUV(color, seatingCap, numberOfDoors, plateNumber, numberOfTires, "SUV", Tofwd));
                } else {
                    System.out.println("Wrong car type. Please enter correctly.");
                }
                System.out.println("New car is added succesfuly...\n");
            }
        } else {
            System.out.println("There are only cars and trucks can be added. Please enter a valid vehicle type");
        }
    }

    @Override
    public void removeVehicle(Admin admin) {
        System.out.print("Enter the type of the vehicle (Truck - Car) : ");
        String type = A.next();
        if (type.equals("Truck") || type.equals("truck")) {
            System.out.print("Enter the truck index that will be removed : ");
            int indexOfRemove = A.nextInt();
            trucksList.remove(indexOfRemove);
            System.out.println("The truck is removed succesfuly...");
        } else if (type.equals("Car") || type.equals("car")) {
            System.out.print("Enter the car index that will be removed : ");
            int indexOfRemove = A.nextInt();
            carsList.remove(indexOfRemove);
            System.out.println("The car is removed succesfuly...");
        } else {
            System.out.println("There are only cars and trucks can be removed. Please enter a valid vehicle type");
        }
    }

    @Override
    public void bookVehicle(RegisteredUser registeredUser) {
        try {
            displayVehicles(registeredUser);
            System.out.print("Enter the type of the vehicle that you want to book (Truck - Car) : ");
            String typeOfVehicle = A.next();
            System.out.print("From (DD.MM.YYYY) Date : ");
            String firstDate = A.next();
            System.out.print("To (DD.MM.YYYY) Date : ");
            String secondDate = A.next();
            firstDatee = formatter.parse(firstDate);//CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            Date secondDatee = formatter.parse(secondDate);//CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            long differenceBetweenDates = Math.abs(secondDatee.getTime() - firstDatee.getTime());
            long diff = TimeUnit.MILLISECONDS.toDays(differenceBetweenDates); // IN ORDER TO CONVERT MILLISECONDS TO DAYS BETWEEN STARTING DATE AND ENDING DATE.

            if (typeOfVehicle.equals("Truck") || typeOfVehicle.equals("truck")) {
                try {
                    if (trucksList.isEmpty()) {
                        throw new NullPointerException();
                    } else {
                        System.out.print("Select a truck (index) that will be booked : ");
                        int truckNumber = A.nextInt();
                        if (truckNumber < 0) {
                            System.out.println("Enter a valid index");
                        } else {
                            Vehicle.setNumberOfDays((int) diff);
                            if (diff < 7) {
                                System.out.println("Trucks must be booked at least 7 days.");
                            } else {
                                trucksList.set(truckNumber, null);
                                System.out.println("Truck has been booked succesfully between " + firstDate + " and "
                                        + secondDate + " for " + Vehicle.getNumberOfDays() + " days.");
                                setIsBooked7Days(true);
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.println("\nSorryWeDontHaveThatOneException:Currently there is no available truck that can be booked.");
                }
            } else if (typeOfVehicle.equals("Car") || typeOfVehicle.equals("car")) {
                try {
                    if (carsList.isEmpty()) {
                        throw new NullPointerException();
                    } else {
                        System.out.print("Select a car (index) that will be booked : ");
                        int carNumber = A.nextInt();

                        if (carNumber < 0) {
                            System.out.println("Enter a valid index");
                        } else {
                            carsList.set(carNumber, null);
                            System.out.println("Car has been booked succesfully between " + firstDate + " and "
                                    + secondDate + " for " + Vehicle.getNumberOfDays() + " days.");
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.println("SorryWeDontHaveThatOneException:Currently there is no available car that can be booked.");
                }
            } else {
                System.out.println("Wrong ID.");
            }
        } catch (ParseException ex) {
            System.out.println("ParseException");
        }
    }

    Date todaysDate = new Date();

    public void cancelBooking(RegisteredUser registeredUser) {

        displayVehicles(registeredUser);
        System.out.print("Enter the type of the vehicle that you want to cancel the booking (Truck - Car) : ");
        String typeOfVehicle = A.next();
        if (typeOfVehicle.equals("Truck") || typeOfVehicle.equals("truck")) {
            if (getTrucksList().isEmpty()) {
                System.out.println("There is no truck that was booked.");
            } else {
                System.out.print("Select a truck (index) that you want to cancel of it's booking : ");
                int truckNumber = A.nextInt();

                if (truckNumber < 0) {
                    System.out.println("Enter a valid index");
                } else {
                    try {
                        if (firstDatee == null) {
                            System.out.println("You must rent or book a truck before you cancel of its booking or renting.(StartingDate==null)");
                        } else {
                            if (todaysDate.compareTo(firstDatee) < 0) {
                                throw new Exception();
                            } else {
                                if (trucksList.get(truckNumber) == null || trucksList.get(truckNumber).toString().equals("Booked")) {
                                    System.out.println("Cancellation is successful");
                                } else if (trucksList.get(truckNumber) != null || !trucksList.get(truckNumber).toString().equals("Booked")) {
                                    System.out.println("Car is not booked yet. You cannot cancel of it's booking. ");
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("NoCancellationYouMustPayException.");
                    }
                }
            }

        } else if (typeOfVehicle.equals("Car") || typeOfVehicle.equals("car")) {

            if (getCarsList().isEmpty()) {
                System.out.println("There is no car that was booked.");
            } else {
                System.out.print("Select a car (index) that you want to cancel of it's booking : ");
                int carNumber = A.nextInt();

                if (carNumber < 0) {
                    System.out.println("Enter a valid index");
                } else {
                    try {
                        if (firstDatee == null) {
                            System.out.println("You must rent or book a car before you cancel of its booking or renting.(StartingDate==null)");
                        } else {
                            if (todaysDate.compareTo(firstDatee) < 0) {
                                throw new Exception();
                            } else {
                                if (carsList.get(carNumber) == null || carsList.get(carNumber).toString().equals("Booked")) {
                                    System.out.println("Cancellation is successful");
                                } else if (carsList.get(carNumber) != null || !carsList.get(carNumber).toString().equals("Booked")) {
                                    System.out.println("Car is not booked yet. You cannot cancel of it's booking. ");
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("NoCancellationYouMustPayException.");
                    }
                }
            }
        } else {
            System.out.println("There are only cars' and trucks' booking can be cancelled. Please enter a valid vehicle type");
        }
    }

    Date firstDatee = null;

    public void rentAVehicle(RegisteredUser registeredUser) {
        try {
            displayVehicles(registeredUser);
            System.out.print("Enter the type of the vehicle that you want to rent (Truck - Car) : ");
            String typeOfVehicle = A.next();
            System.out.print("From (DD.MM.YYYY) Date : ");
            String firstDate = A.next();
            System.out.print("To (DD.MM.YYYY) Date : ");
            String secondDate = A.next();
            firstDatee = formatter.parse(firstDate);//CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            Date secondDatee = formatter.parse(secondDate); //CONVERT AND PARSING THE DATE STRING TO DATE THAT'S FORMAT IS DD.MM.YYYY
            long differenceBetweenDates = Math.abs(secondDatee.getTime() - firstDatee.getTime());
            long diff = TimeUnit.MILLISECONDS.toDays(differenceBetweenDates); // IN ORDER TO CONVERT MILLISECONDS TO DAYS BETWEEN STARTING DATE AND ENDING DATE.

            if (typeOfVehicle.equals("Truck") || typeOfVehicle.equals("truck")) {

                if (getTrucksList().isEmpty()) {
                    System.out.println("There is no truck that can be rent.");
                } else {
                    System.out.print("Select a truck (index) that will be rent : ");
                    int truckNumber = A.nextInt();
                    if (truckNumber < 0) {
                        System.out.println("Enter a valid index");
                    } else {
                        if (getIsBooked7Days()) {
                            int dailyfee = (int) (Math.random() * 500);
                            Vehicle.setDailyFee(dailyfee);
                            Vehicle.setNumberOfDays((int) diff);
                            getTrucksList().remove(truckNumber);
                            System.out.println("Truck has been rented succesfully between " + firstDate + " and "
                                    + secondDate + " for " + Vehicle.getNumberOfDays() + " days."
                                    + "\nYour total fee is : " + Vehicle.getDailyFee() + " TL");
                        } else {
                            System.out.println("You must book a truck at least 7 days before renting.");
                        }
                    }
                }
            } else if (typeOfVehicle.equals("Car") || typeOfVehicle.equals("car")) {

                if (getCarsList().isEmpty()) {
                    System.out.println("There is no car that can be rent.");
                } else {
                    System.out.print("Select a car (index) that will rent : ");
                    int carNumber = A.nextInt();
                    if (carNumber < 0) {
                        System.out.println("Enter a valid index");
                    } else {
                        int dailyfee = (int) (Math.random() * 200);
                        Vehicle.setDailyFee(dailyfee);
                        Vehicle.setNumberOfDays((int) diff);
                        getCarsList().remove(carNumber);
                        System.out.println("Truck has been rented succesfully between " + firstDate + " and "
                                + secondDate + " for " + Vehicle.getNumberOfDays() + " days."
                                + "\nYour total fee is : " + Vehicle.getDailyFee() + " TL");
                    }
                }
            } else {
                System.out.println("There are only cars and trucks can be rent. Please enter a valid vehicle type");
            }
        } catch (ParseException ex) {
            System.out.println("ParseException");
        }
    }

    public void searchVehicleByType(RegisteredUser registeredUser) {
        System.out.print("Car types : Sport-SUV-SW\nTruck types : Small-Transport\nEnter the type of the car or truck you want to search : ");
        String type = A.next();
        System.out.println("");

        if (type.equals("Small") || type.equals("small")) {
            for (int i = 0; i < smallTruckList.size(); i++) {
                System.out.println("Small Truck " + i + ")" + getSmallTruckList().get(i));
            }
        } else if (type.equals("Transport") || type.equals("transport")) {
            for (int i = 0; i < transportTruckList.size(); i++) {
                System.out.println("Transport Truck " + i + ")" + getTransportTruckList().get(i));
            }
        } else if (type.equals("Sports") || type.equals("sports")) {
            for (int i = 0; i < sportCarList.size(); i++) {
                System.out.println("Sport Car " + i + ")" + getSportCarList().get(i));
            }
        } else if (type.equals("SUV") || type.equals("suv")) {
            for (int i = 0; i < suvCarList.size(); i++) {
                System.out.println("SUV Car " + i + ")" + getSuvCarList().get(i));
            }
        } else if (type.equals("SW") || type.equals("sw")) {
            for (int i = 0; i < swCarList.size(); i++) {
                System.out.println("SW Car " + i + ")" + getSwCarList().get(i));
            }
        } else {
            System.out.println("There is no vehicle that can be displayed...");
        }

    }

    public void dropVehicle(RegisteredUser registeredUser) {
        if (carsList.isEmpty() || trucksList.isEmpty()) {
            System.out.print("There is no vehicle that you can drop..");
        } else {
            System.out.print("Choose a vehicle type (Truck-Car) : ");
            String carType = A.next();
            displayVehicles(registeredUser);
            System.out.print("Enter the index of the vehicle that you want to drop.");
            int index = A.nextInt();

            System.out.println("\nVehicle is dropped total fee is : " + Vehicle.getDailyFee() + " TL");
        }
    }

    public void loadVehicles(RegisteredUser registeredUser) { // missing and not enough statements or conditions.
        try {
            System.out.print("Enter the amount of additional load : ");
            int load = A.nextInt();
            if (Truck.getLoadingCap() < load || SW.getLoadingCap() < load) { // Sw ya da Truck listlerin içindeki araçlardan loading capler alınacak ve eklenecek olan tutardan küçük olmaması halinde uyarı verilecek !
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ae) {
            System.out.println("OverWeightException.");
        }
    }

    @Override
    public void dailyReport(Admin admin) {

        int carBooked = 0;
        int truckBooked = 0;
        System.out.println("\nDaily report");
        System.out.println("***************");

        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i) == null) {
                carBooked++;
            }
        }
        System.out.println(carBooked + " Car has booked today.");
        for (int i = 0; i < trucksList.size(); i++) {
            if (trucksList.get(i) == null) {
                truckBooked++;
            }
        }
        System.out.println(truckBooked + " Truck has booked today.");

        int totalregistered = 0;
        for (int i = 0; i < getRegisteredUserList().size(); i++) {
            System.out.println(getRegisteredUserList().get(i));
            totalregistered++;
        }
        System.out.println("Today " + totalregistered + " users registered to the system...");
    }

    public void Register() {
        System.out.println("Registration");
        System.out.println("********************");
        System.out.print("Name : ");
        String name = A.next();
        System.out.print("Adress : ");
        String adress = A.next();
        System.out.print("Phone : ");
        String phone = A.next();
        int id = (int) (Math.random() * 100000);
        System.out.print("Your account ID : " + id);
        RegisteredUser registeredUser = new RegisteredUser(id, name, phone, adress);
        getRegisteredUserList().add(registeredUser);
        System.out.println("\nRegistiration is succesful...\n");
    }

    public ArrayList<Vehicle> getCarsList() {
        return carsList;
    }

    public ArrayList<Vehicle> getTrucksList() {
        return trucksList;
    }

    public ArrayList<Car> getSportCarList() {
        return sportCarList;
    }

    public ArrayList<Car> getSuvCarList() {
        return suvCarList;
    }

    public ArrayList<Car> getSwCarList() {
        return swCarList;
    }

    public ArrayList<Truck> getSmallTruckList() {
        return smallTruckList;
    }

    public ArrayList<Truck> getTransportTruckList() {
        return transportTruckList;
    }

    public ArrayList<RegisteredUser> getRegisteredUserList() {
        return registeredUserList;
    }

    private boolean isBooked7Days = false;

    public boolean getIsBooked7Days() {
        return isBooked7Days;
    }

    public void setIsBooked7Days(boolean isBooked7Days) {
        this.isBooked7Days = isBooked7Days;
    }

}
