
public class Sports extends Car{
    private int HP;
    
    public Sports(String color, String seatingCap, int numOfDoors, String PlateNumber, int numberOfTires, String typeOfCar, int HP) {
        super(color, seatingCap, numOfDoors, PlateNumber, numberOfTires, typeOfCar);
        this.HP = HP;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nHorse power : " + HP ;
    }
    
}
