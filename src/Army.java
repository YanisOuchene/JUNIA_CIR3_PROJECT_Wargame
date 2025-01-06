import Units.Units;
import Vehicles.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private String armyName;
    private String armyFaction;
    private int armyPoints;

    List<Group> army = new ArrayList<Group>();

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

    public boolean deductPoints(int points) {
        if (this.armyPoints >= points) {
            this.armyPoints -= points;
            return true;
        } else {
            System.out.println("Not enough points.");
            return false;
        }
    }

    public List<Group> getArmy() {
        return army;
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

    public void addGroup(String groupName) {
        try {
            army.add(new Group(groupName));
        }
        catch (Exception e) {
            System.out.println("Please put a valid group name");
        }
    }
    public void addUnits(Units unit, int nbUnits, int indexGroup){
        if (nbUnits * unit.getCost() > getArmyPoints()){
            System.out.println("Unit points exceeds army points");
            return;
        }

        army.get(indexGroup).addUnit(unit,nbUnits);
        setArmyPoints( getArmyPoints() - (nbUnits * unit.getCost()) );
    }

    public void addVehicles(Vehicles vehicle, int nbVehicles, int indexGroup){
        if (nbVehicles * vehicle.getCost() > getArmyPoints()){
            System.out.println("Vehicle points exceeds army points");
            return;
        }

        army.get(indexGroup).addVehicle(vehicle,nbVehicles);
        setArmyPoints( getArmyPoints() - (nbVehicles * vehicle.getCost()) );
    }

    public void print(){
        System.out.println("Army Name: " + armyName);
        System.out.println("Army Faction: " + armyFaction);
        System.out.println("Army Points: " + armyPoints);

        for (Group group : army) {
            group.print();
        }

    }

}
