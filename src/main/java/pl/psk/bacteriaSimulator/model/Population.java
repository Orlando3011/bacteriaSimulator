package pl.psk.bacteriaSimulator.model;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private Bacteria bacteria;
    private Environment environment;
    private int simulationLength;
    private int timer;
    private int toxicityCausalities;
    private int temperatureCausalities;
    private int foodCausalities;

    private List<Bacteria> allBacteria;

    public Population(Bacteria bacteria, Environment environment) {
        allBacteria = new ArrayList<>();
        toxicityCausalities = 0;
        temperatureCausalities = 0;
        foodCausalities = 0;
        this.bacteria = bacteria;
        this.environment = environment;
    }

    private void removeOldGeneration() {
        allBacteria.removeIf(bacteria -> (bacteria.getLifeLength() == bacteria.getLifeSpan()));
    }

    private void removeToxicityCausalities() {
        double impact = 1 - bacteria.getToxicityTolerance();
        double deathPercent = environment.getToxicity() * impact;
        for (Bacteria bacteria:allBacteria) {
            int deaths = (int)(bacteria.getNumber() * deathPercent);
            if(deathPercent > 0 && deaths == 0) deaths = 1;
            int survived = bacteria.getNumber() - deaths;
            toxicityCausalities = toxicityCausalities + deaths;
            bacteria.setNumber(survived);
            if(bacteria.getNumber() < 0) bacteria.setNumber(0);
        }
    }

    private void removeTemperatureCausalities() {
        double temperatureDifference = bacteria.getOptimalTemperature() - environment.getTemperature();
        if(temperatureDifference < 0) temperatureDifference = -temperatureDifference;
        if (temperatureDifference < 100) temperatureDifference = temperatureDifference / 100;
        else temperatureDifference = 1;
        double impact = 1 - bacteria.getTemperatureTolerance();
        double deathPercent = temperatureDifference * impact;
        for (Bacteria bacteria:allBacteria) {
            int deaths = (int)(bacteria.getNumber() * deathPercent);
            if(deathPercent > 0 && deaths == 0) deaths = 1;
            int survived = bacteria.getNumber() - deaths;
            temperatureCausalities = temperatureCausalities + deaths;
            bacteria.setNumber(survived);
            if(bacteria.getNumber() < 0) bacteria.setNumber(0);
        }
    }

    private void removeFoodCausalities(Bacteria bacteria) {
        double impact = 1 - bacteria.getFoodTolerance();
        double deathPercent = (1 - environment.getFoodAccessibility()) * impact;
        int finalPopulation = bacteria.getNumber() - (int)(bacteria.getNumber() * deathPercent);
        if(deathPercent > 0 && (int)(bacteria.getNumber() * deathPercent) == 0) finalPopulation = finalPopulation - 1;

        foodCausalities = foodCausalities + (int)(bacteria.getNumber() * deathPercent);
        bacteria.setNumber(finalPopulation);
        if(bacteria.getNumber() < 0) bacteria.setNumber(0);
    }

    public void goToNextStep() {
        removeToxicityCausalities();
        removeTemperatureCausalities();
        List<Bacteria> newGenerations = new  ArrayList<>();
            for (Bacteria bacteria : allBacteria) {
                bacteria.setLifeLength(bacteria.getLifeLength() + 1);
                bacteria.setToNextReproduction(bacteria.getToNextReproduction() - 1);
                if(bacteria.getToNextReproduction() == 0) {
                    Bacteria bacteria1 = bacteria.multiply();
                    removeFoodCausalities(bacteria1);
                    newGenerations.add(bacteria1);
                    bacteria.setToNextReproduction(bacteria.getReproductionTime());
                }
            }
        removeOldGeneration();
        allBacteria.addAll(newGenerations);
    }

    public List<Bacteria> getAllBacteria() {
        return allBacteria;
    }

    public void setAllBacteria(List<Bacteria> allBacteria) {
        this.allBacteria = allBacteria;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public int getSimulationLength() {
        return simulationLength;
    }

    public void setSimulationLength(int simulationLength) {
        this.simulationLength = simulationLength;
    }

    public Bacteria getBacteria() {
        return bacteria;
    }

    public void setBacteria(Bacteria bacteria) {
        this.bacteria = bacteria;
    }

    public int getToxicityCausalities() {
        return toxicityCausalities;
    }

    public void setToxicityCausalities(int toxicityCausalities) {
        this.toxicityCausalities = toxicityCausalities;
    }

    public int getTemperatureCausalities() {
        return temperatureCausalities;
    }

    public void setTemperatureCausalities(int temperatureCausalities) {
        this.temperatureCausalities = temperatureCausalities;
    }

    public int getFoodCausalities() {
        return foodCausalities;
    }

    public void setFoodCausalities(int foodCausalities) {
        this.foodCausalities = foodCausalities;
    }
}
