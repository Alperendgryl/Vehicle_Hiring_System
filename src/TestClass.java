
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass {

    private final static Scanner A = new Scanner(System.in);

    private static Person guestUser;
    private static Admin admin;
    private static RegisteredUser registeredUser;
    private static VehiclePark vehiclePark = new VehiclePark();

    public static boolean isUserRegistered = false;
    private static final Date date = new Date();

    public static void main(String[] args) {
        defaultObjects();
        loadFile();
        MainMenu();
    }

    public static void defaultObjects() {
        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Today's Date is : " + formatter.format(date) + "\tTomorrow's Date is : " + formatter.format(tomorrow));

        admin = new Admin(2182085, "AlperenDGRYL", "PhoneNo", "Adress", "Admin");
        guestUser = new Person(0, "GuestUser", "GuestUser", "GuestUser");

        vehiclePark.getTrucksList().add(new TransportTrucks("34TransportTruck123", 12, 120, "Transport Truck", true));
        vehiclePark.getTrucksList().add(new SmallTrucks("34SmallTruck123", 8, 30, "Small Truck"));

        vehiclePark.getCarsList().add(new SUV("Red", "Seating cap", 4, "34Suv123", 4, "SUV", "Type of wheel drive"));
        vehiclePark.getCarsList().add(new SW("Orange", "Seating cap", 4, "34SW123", 4, "SW", 45));
        vehiclePark.getCarsList().add(new Sports("Black", "Seating cap", 4, "34Sports123", 4, "Sports", 150));
    }

    public static void MainMenu() {
        System.out.println("\n***Main Menu***");
        System.out.println("***********************");
        System.out.println("Vehicle Hiring System");
        System.out.println("***********************");
        System.out.println("1)Display all vehicles\n"
                + "2)Display available vehicles\n"
                + "3)Register me\n"
                + "4)Continue as registered user\n"
                + "5)Continue as admin\n"
                + "6)Quit");

        while (true) {

            System.out.print("\nChoose an option : ");
            int option = A.nextInt();
            System.out.println("\n");

            switch (option) {
                case 1:
                    //Display all vehicles
                    vehiclePark.displayVehicles(guestUser); // person.displayVehicles(guestUser);
                    MainMenu();
                    break;
                case 2:
                    //Display available vehicles: asks the dates, returns to the main menu
                    vehiclePark.displayAvailableVehicles(guestUser);
                    MainMenu();
                    break;
                case 3:
                    //Register me: asks the name and contact info, returns to the main menu.
                    vehiclePark.Register();
                    setIsUserRegistered(true);
                    for (int i = 0; i < vehiclePark.getRegisteredUserList().size(); i++) {
                        System.out.println("Registered users are : " + vehiclePark.getRegisteredUserList().get(i));
                    }
                    saveFile();
                    MainMenu();
                    break;
                case 4:
                    //Continue as registered user: asks the id, and calls menu4.
                    if (getIsUserRegistered() == false) {
                        System.out.println("You must register in order to continue...");
                        vehiclePark.Register();
                        setIsUserRegistered(true);
                        MainMenu();
                    } else {
                        System.out.print("Enter your user ID : ");
                        int Id = A.nextInt();
                        for (int i = 0; i < vehiclePark.getRegisteredUserList().size(); i++) {
                            if (Id == vehiclePark.getRegisteredUserList().get(i).getID()) {
                                System.out.println("User : " + vehiclePark.getRegisteredUserList().get(i).getName());
                                RegisteredUserMenu();
                            }
                        }
                    }
                    break;
                case 5:
                    // Continue as admin: asks userName, and calls menu5.
                    System.out.print("Enter your user ID : ");
                    int ıd = A.nextInt();
                    System.out.print("Enter your userName : ");
                    String userNam = A.next();

                    if (ıd == admin.getID() && userNam.equals(admin.getUserName())) {
                        AdminMenu();
                    } else {
                        System.out.println("Wrong ID or userName. Please enter your informations correctly.");
                        MainMenu();
                    }
                    break;
                case 6:
                    //updateFile();
                    System.out.println("Quitting from the program...");
                    System.exit(0);

                default:
                    System.out.println("Wrong option...");
                    break;
            }
        }
    }

    public static void RegisteredUserMenu() {
        System.out.println("\n***Registered user***");
        System.out.println("***********************");
        System.out.println("Vehicle Hiring System");
        System.out.println("***********************");
        System.out.println("1)Display all vehicles\n"
                + "2)Display available vehicles\n"
                + "3)Display available vehicles by type\n"
                + "4)Book vehicle\n"
                + "5)Cancel my booking\n"
                + "6)Rent vehicle\n"
                + "7)Load vehicle\n"
                + "8)Drop vehicle\n"
                + "9)Main menu");

        while (true) {

            System.out.print("Choose an option : ");
            int option = A.nextInt();

            switch (option) {
                case 1:
                    vehiclePark.displayVehicles(registeredUser); // registeredUser.displayVehicles(registeredUser);
                    RegisteredUserMenu();
                    //Display all vehicles
                    break;
                case 2:
                    vehiclePark.displayAvailableVehicles(registeredUser);
                    RegisteredUserMenu();
                    //Display available vehicles: asks the dates, returns to the Menu4
                    break;
                case 3:
                    vehiclePark.searchVehicleByType(registeredUser);
                    RegisteredUserMenu();
                    //Display available vehicles by type: asks the dates, the vehicle type, returns to the Menu4
                    break;
                case 4:
                    vehiclePark.bookVehicle(registeredUser);
                    RegisteredUserMenu();
                    //Book Vehicle-returns to Menu4.
                    break;
                case 5:
                    vehiclePark.cancelBooking(registeredUser);
                    RegisteredUserMenu();
                    //cancel my booking -returns to Menu4.
                    break;
                case 6:
                    vehiclePark.rentAVehicle(registeredUser);
                    RegisteredUserMenu();
                    //rent vehicle -returns to Menu4.
                    break;
                case 7:
                    vehiclePark.loadVehicles(registeredUser);
                    RegisteredUserMenu();
                case 8:
                    vehiclePark.dropVehicle(registeredUser);
                    RegisteredUserMenu();
                    break;
                case 9:
                    System.out.println("Returning to the main menu...\n");
                    MainMenu();
                    break;
                default:
                    System.out.println("Wrong option...");
                    break;
            }

        }
    }

    public static void AdminMenu() {
        System.out.println("\n***Admin***");
        System.out.println("***********************");
        System.out.println("Vehicle Hiring System");
        System.out.println("***********************");
        System.out.println("1)Display all vehicles\n"
                + "2)Display available vehicles\n"
                + "3)Add a new vehicle to the system\n"
                + "4)Remove vehicle\n"
                + "5)Daily Report\n"
                + "6)Main menu");

        while (true) {

            System.out.print("Choose an option : ");
            int option = A.nextInt();

            switch (option) {
                case 1:
                    //Display all vehicles
                    vehiclePark.displayVehicles(admin); // admin.displayVehicles(admin);
                    AdminMenu();
                    break;
                case 2:
                    //Display available vehicles: asks the dates, returns to the Menu5
                    vehiclePark.displayAvailableVehicles(admin);
                    AdminMenu();
                    break;
                case 3:
                    //Add a new vehicle to the system: asks the necessary attribute values, and adds the item into inventory. Returns to Menu5  
                    vehiclePark.addVehicle(admin);
                    AdminMenu();
                    break;
                case 4:
                    //Remove vehicle: asks which item to be removed, removes from the inventory. Returns to Menu5.
                    vehiclePark.removeVehicle(admin);
                    AdminMenu();
                    break;
                case 5:
                    //Reports: creates daily reports. Returns to Menu5.
                    vehiclePark.dailyReport(admin);
                    AdminMenu();
                    break;
                case 6:
                    System.out.println("Returning to the main menu...\n");
                    MainMenu();

                default:
                    System.out.println("Wrong option...");
                    break;
            }
        }
    }

    public static void saveFile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Users.txt"); // WRITE INTO A FILE.
            try (PrintWriter printWriter = new PrintWriter(fos)) {
                for (int i = 0; i < vehiclePark.getRegisteredUserList().size(); i++) {
                    printWriter.print(vehiclePark.getRegisteredUserList().get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void loadFile() {
        try {
            FileInputStream fis = new FileInputStream("Users.txt");
            Scanner B = new Scanner(fis);
            if (new File("D:\\Netbeans Projects\\Vehicle Hiring System\\Users.txt") != null) {
                System.out.println("\nRegistered Users' file has been loaded successfuly. Registered Users Are ");
                System.out.println("*********************************");
                while (B.hasNext()) {
                    System.out.println(B.nextLine());
                }
                System.out.println("\n*********************************");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException.\nTotal Registered user : " + vehiclePark.getRegisteredUserList().size());
        }
    }

    public static void updateFile() {
        File file = new File("D:\\Netbeans Projects\\Vehicle Hiring System\\Users.txt");

        if (file != null) {
            for (int i = 0; i < vehiclePark.getRegisteredUserList().size(); i++) {
                try {
                    if (vehiclePark.getRegisteredUserList().get(i) != null) {
                        writeFile(vehiclePark.getRegisteredUserList().set(i, registeredUser).toString(), file);
                    } else {
                        throw new IOException();
                    }

                } catch (IOException ex) {
                    System.out.println("IOException.");
                }
            }
        }
    }

    public static void writeFile(String s, File f) throws IOException {
        FileWriter fw = new FileWriter(f);
        fw.write(s);
        fw.close();
    }

    public static boolean getIsUserRegistered() {
        return isUserRegistered;
    }

    public static void setIsUserRegistered(boolean isUserRegistered) {
        TestClass.isUserRegistered = isUserRegistered;
    }

}


/*
// ACCORDING TO THE INTERNET RESEARCH IT IS WRITING THE INFORMATIONS INTO A FILE (CORRECTLY WORKING) HOWEVER I COULD NOT LOAD IT WHEN THE APP IS RUN.
    public static void createFile() throws IOException { 
        try (FileWriter writer = new FileWriter("registeredUserList.txt")) {
            for (RegisteredUser ru : registeredUserList) {
                writer.write(ru + System.lineSeparator());
            }
        }
        try {
            createFile();
        } catch (IOException ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 */
