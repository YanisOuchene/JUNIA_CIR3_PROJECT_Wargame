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

private class Soldier implements Units{
    Soldier(String name, int cost) {
        super(name);
        super(cost);

    }
}

private class Heavy implements Units{
    Heavy(String name, int cost) {
        super(name);
        super(cost);
    }
}

private class Special implements Units{
    Special(String name, int cost) {
        super(name);
        super(cost);
    }
}

private class Chief implements Units{
    Chief(String name, int cost) {
        super(name);
        super(cost);
    }
}
