import Units.*;
import Vehicles.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
public class Main {
    private static final List<Army> armies = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int w = 20;
        System.out.println(ConsoleColors.RED + ConsoleColors.BLACK_BACKGROUND + StringUtils.rightPad("+", w - 1, "-") + "+" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + ConsoleColors.BLACK_BACKGROUND + StringUtils.center(StringUtils.center("Army Maker", w - 2), w, "|") + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + ConsoleColors.BLACK_BACKGROUND + StringUtils.rightPad("+", w - 1, "-") + "+" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.RESET);
        while (true) {
            System.out.println("1. Create Army");
            System.out.println("2. Create Group");
            System.out.println("3. Add Units to Group");
            System.out.println("4. Add Vehicles to Group");
            System.out.println("5. Display Armies");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createArmy();
                    break;
                case 2:
                    createGroup();
                    break;
                case 3:
                    addUnitsToGroup();
                    break;
                case 4:
                    addVehiclesToGroup();
                    break;
                case 5:
                    displayArmies();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createArmy() {
        System.out.print("Enter army name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faction name: ");
        String faction = scanner.nextLine();
        System.out.print("Enter number of points: ");
        int points = scanner.nextInt();
        Army army = new Army(name,faction,points);
        armies.add(army);
        System.out.println("Army created.");
    }

    private static void createGroup() {
        Army army = selectArmy();
        if (army == null) return;

        System.out.print("Enter group name: ");
        String name = scanner.nextLine();
        army.addGroup(name);
        System.out.println("Group created.");
    }

    private static void addUnitsToGroup() {
        Army army = selectArmy();
        if (army == null) return;

        Group group = selectGroup(army);
        if (group == null) return;

        System.out.println("Select unit type:");
        System.out.println("1. Chief");
        System.out.println("2. Heavy");
        System.out.println("3. Soldier");
        System.out.println("4. Special");
        System.out.print("Choose an option: ");
        System.out.print("5.Exit");
        int unitType = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if(unitType == 5) {
            return;
        }

        System.out.print("Enter name of unit: ");
        String name = scanner.nextLine();
        System.out.print("Enter cost of unit: ");
        int cost = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of units: ");
        int nbUnits = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Units unit;
        switch (unitType) {
            case 1:
                unit = new Chief(name,cost);
                break;
            case 2:
                unit = new Heavy(name,cost);
                break;
            case 3:
                unit = new Soldier(name,cost);
                break;
            case 4:
                unit = new Special(name,cost);
                break;

            default:
                System.out.println("Invalid unit type.");
                return;
        }
        int totalCost = cost * nbUnits;
        if (army.deductPoints(totalCost)) {
            group.addUnit(unit, nbUnits);
            System.out.println("Units added.");
        }
    }

    private static void addVehiclesToGroup() {
        Army army = selectArmy();
        if (army == null) return;

        Group group = selectGroup(army);
        if (group == null) return;

        System.out.println("Select vehicle type:");
        System.out.println("1. Tank");
        System.out.println("2. Transport");
        int vehicleType = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter name of vehicle: ");
        String name = scanner.nextLine();
        System.out.print("Enter capacity of vehicle: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter cost of vehicle: ");
        int cost = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of vehicles: ");
        int nbVehicles = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Vehicles vehicle;
        switch (vehicleType) {
            case 1:
                vehicle = new Tank(name,cost,capacity);
                break;
            case 2:
                vehicle = new Transport(name,cost,capacity);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        int totalCost = cost * nbVehicles;
        if (army.deductPoints(totalCost)) {
            group.addVehicle(vehicle, nbVehicles);
            System.out.println("Vehicles added.");
        }
    }

    private static Army selectArmy() {
        if (armies.isEmpty()) {
            System.out.println("No armies available. Please create an army first.");
            return null;
        }

        System.out.println("Select an army:");
        for (int i = 0; i < armies.size(); i++) {
            System.out.println((i + 1) + ". " + armies.get(i).getArmyName());
        }
        int armyIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        if (armyIndex < 0 || armyIndex >= armies.size()) {
            System.out.println("Invalid army selection.");
            return null;
        }

        return armies.get(armyIndex);
    }

    private static Group selectGroup(Army army) {
        if (army.getArmy().isEmpty()) {
            System.out.println("No groups available. Please create a group first.");
            return null;
        }

        System.out.println("Select a group:");
        for (int i = 0; i < army.getArmy().size(); i++) {
            System.out.println((i + 1) + ". " + army.getArmy().get(i).getName());
        }
        int groupIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        if (groupIndex < 0 || groupIndex >= army.getArmy().size()) {
            System.out.println("Invalid group selection.");
            return null;
        }

        return army.getArmy().get(groupIndex);
    }

    private static void displayArmies() {
        if (armies.isEmpty()) {
            System.out.println("No armies available.");
            return;
        }

        for (Army army : armies) {
            army.print();
        }
    }
}