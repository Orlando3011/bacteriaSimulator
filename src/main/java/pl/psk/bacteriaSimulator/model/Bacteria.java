package pl.psk.bacteriaSimulator.model;

public class Bacteria {
    private String name;
    private int number;
    private int initialNumber;

    private int reproductionTime;
    private int toNextReproduction;

    private int lifeSpan;
    private int lifeLength;

    private int generation;

    private double optimalTemperature;

    private double temperatureTolerance;
    private double toxicityTolerance;
    private double foodTolerance;

    public Bacteria() {
    }

    public Bacteria multiply() {
        Bacteria newInstance = new Bacteria();
        newInstance.setNumber(number);

        newInstance.setReproductionTime(reproductionTime);
        newInstance.setToNextReproduction(reproductionTime);

        newInstance.setLifeLength(0);
        newInstance.setLifeSpan(lifeSpan);

        newInstance.setGeneration(generation + 1);

        newInstance.setOptimalTemperature(optimalTemperature);

        newInstance.setTemperatureTolerance(temperatureTolerance);
        newInstance.setFoodTolerance(foodTolerance);
        newInstance.setToxicityTolerance(toxicityTolerance);

        return newInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReproductionTime() {
        return reproductionTime;
    }

    public void setReproductionTime(int reproductionTime) {
        this.reproductionTime = reproductionTime;
    }

    public int getLifeLength() {
        return lifeLength;
    }

    public void setLifeLength(int lifeLength) {
        this.lifeLength = lifeLength;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public double getOptimalTemperature() {
        return optimalTemperature;
    }

    public void setOptimalTemperature(double optimalTemperature) {
        this.optimalTemperature = optimalTemperature;
    }

    public double getTemperatureTolerance() {
        return temperatureTolerance;
    }

    public void setTemperatureTolerance(double temperatureTolerance) {
        this.temperatureTolerance = temperatureTolerance;
    }

    public double getToxicityTolerance() {
        return toxicityTolerance;
    }

    public void setToxicityTolerance(double toxicityTolerance) {
        this.toxicityTolerance = toxicityTolerance;
    }

    public double getFoodTolerance() {
        return foodTolerance;
    }

    public void setFoodTolerance(double foodTolerance) {
        this.foodTolerance = foodTolerance;
    }

    public int getToNextReproduction() {
        return toNextReproduction;
    }

    public void setToNextReproduction(int toNextReproduction) {
        this.toNextReproduction = toNextReproduction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
    }
}
