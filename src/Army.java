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

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public void setArmyFaction(String armyFaction) {
        this.armyFaction = armyFaction;
    }

    public void setArmyPoints(int armyPoints) {
        this.armyPoints = armyPoints;
    }

}
