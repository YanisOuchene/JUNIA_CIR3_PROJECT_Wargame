public abstract class Units {
    String name;
    int cost;

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
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void print() {
        System.out.println(getName() + " cost: " + getCost());
    }

}
