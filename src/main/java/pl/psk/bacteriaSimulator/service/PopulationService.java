package pl.psk.bacteriaSimulator.service;

import org.springframework.stereotype.Service;
import pl.psk.bacteriaSimulator.model.Bacteria;
import pl.psk.bacteriaSimulator.model.Environment;
import pl.psk.bacteriaSimulator.model.Population;

@Service
public class PopulationService {
    private Population population;

    public void initializePopulation(Bacteria bacteria, Environment environment, int time) {
        bacteria.setLifeLength(0);
        bacteria.setToNextReproduction(bacteria.getReproductionTime());
        population = new Population(bacteria, environment);
        population.setTimer(0);
        population.setSimulationLength(time);
    }

    private void makeStep() {
        population.goToNextStep();
    }

    public void runSimulation() {
        while(population.getTimer() != population.getSimulationLength()) {
            population.setTimer(population.getTimer() + 1);
            logPopulationState();
            makeStep();
        }
    }

    private void logPopulationState() {
        System.out.println("Step " + population.getTimer());
        System.out.println("Population:" + countPopulation());
    }

    private int countPopulation() {
        int populationSize = 0;
        for (Bacteria bacteria: population.getAllBacteria()) {
            populationSize = populationSize + bacteria.getNumber();
        }
        return populationSize;
    }
}
