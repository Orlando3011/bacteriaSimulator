package pl.psk.bacteriaSimulator.model;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private Bacteria bacteria;
    private Environment environment;
    private int simulationLength;
    private int timer;

    private List<Bacteria> allBacteria;

    public Population(Bacteria bacteria, Environment environment) {
        allBacteria = new ArrayList<>();
        this.bacteria = bacteria;
        this.environment = environment;
    }

    private void removeOldGeneration() {
        allBacteria.removeIf(bacteria -> (bacteria.getLifeLength() == bacteria.getLifeSpan()));
    }

    public void goToNextStep() {
        List<Bacteria> newGenerations = new  ArrayList<>();
            for (Bacteria bacteria : allBacteria) {
                bacteria.setLifeLength(bacteria.getLifeLength() + 1);
                bacteria.setToNextReproduction(bacteria.getToNextReproduction() - 1);
                if(bacteria.getToNextReproduction() == 0) {
                    newGenerations.add(bacteria.multiply());
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
}
