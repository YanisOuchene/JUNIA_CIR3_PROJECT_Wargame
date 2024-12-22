package Units;

public abstract class Units {
    private String name;
    private int cost;

    public Units(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    private void setCost(int cost) {
        this.cost = cost;
    }
    private void setName(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println(getName() + " cost: " + getCost());
    }

}