package pl.psk.bacteriaSimulator.model;

public class Environment {
    private double temperature;
    private double toxicity;
    private double foodAccessibility;


    public Environment() {
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getToxicity() {
        return toxicity;
    }

    public void setToxicity(double toxicity) {
        this.toxicity = toxicity;
    }

    public double getFoodAccessibility() {
        return foodAccessibility;
    }

    public void setFoodAccessibility(double foodAccessibility) {
        this.foodAccessibility = foodAccessibility;
    }
}
