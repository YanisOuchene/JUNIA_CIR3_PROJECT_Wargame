public class Army {
    private String armyName;
    private String armyFaction;
    private int armyPoints;

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

    public String toString() {
        System.out.println(armyName);
        System.out.println("=");
        System.out.println("Faction : " + armyFaction);
        System.out.println("=");
        System.out.println("Points : " + armyPoints);
    }

}
