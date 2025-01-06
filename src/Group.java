import Units.Units;
import Vehicles.Vehicles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    String name;
    List<Units> units = new ArrayList<Units>();
    List<Vehicles> vehicles = new ArrayList<Vehicles>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Units> getUnits() {
        return units;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setUnits(List<Units> units) {
        this.units = units;
    }

    private void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public void print(){

        System.out.println(this.name);

        Set<Class<?>> printedTypes = new HashSet<Class<?>>();

        for (Units u : units) {
            if(printedTypes.add(u.getClass())){
                u.print();
            }
        }

        for (Vehicles v : vehicles) {
            if(printedTypes.add(v.getClass())){
                v.print();
            }
        }

    }

    public void addUnit(Units unit, int nbUnits){
        for( int i = 0; i < nbUnits; i++){
            units.add(unit);
        }
    }

    public void addVehicle(Vehicles vehicle, int nbVehicles){
        for( int i = 0; i < nbVehicles; i++){
            vehicles.add(vehicle);
        }
    }

}
