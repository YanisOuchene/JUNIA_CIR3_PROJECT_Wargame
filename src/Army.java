import Units.*;
import Vehicles.*;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private String armyName;
    private String armyFaction;
    private int armyPoints;

    List<Units> units = new ArrayList<Units>();
    List<Vehicles> vehicles = new ArrayList<Vehicles>();

    public Army(String armyName, String armyFaction, int armyPoints) {
        this.armyName = armyName;
        this.armyFaction = armyFaction;
        this.armyPoints = armyPoints;
    }

    public String getArmyName() {
        return armyName;
    }

    public String getArmyFaction() {
        return armyFaction;
    }

    public int getArmyPoints() {
        return armyPoints;
    }

    private void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    private void setArmyFaction(String armyFaction) {
        this.armyFaction = armyFaction;
    }

    private void setArmyPoints(int armyPoints) {
        this.armyPoints = armyPoints;
    }

    public void addUnits(Units unit, int nbUnit){
        if (nbUnit * unit.getCost() > getArmyPoints()){
            System.out.println("Unit points exceeds army points");
            return;
        }
        units.add(unit);
    }

    public void addVehicles(Vehicles vehicle, int nbVehicle){
        if (nbVehicle * vehicle.getCost() > getArmyPoints()){
            System.out.println("Vehicle points exceeds army points");
            return;
        }
        vehicles.add(vehicle);
    }

    public String toString() {
        return getArmyName() + " \n Faction : " + getArmyFaction() + " \n Points : " + getArmyPoints();
    }

}
