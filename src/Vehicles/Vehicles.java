package Vehicles;

public abstract class Vehicles {
    String name;
    int cost;
    int capacity;
    public Vehicles(String name, int cost, int capacity) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setCost(int cost) {
        this.cost = cost;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(this.name + " cost: " + this.cost + " capacity: " + this.capacity);
    }
}




