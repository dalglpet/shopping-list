package main;

public class Items {
    private String name;
    private String department;
    private float cost;

    // Constructor
    public Items(String name, String department, float cost) {
        this.name       = name;
        this.department = department;
        this.cost       = cost;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public float getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    
    // Show item as "Name - Department - $cost"
    public String toString() {
        return name + " - " + department + " - $" + cost;
    }

}
