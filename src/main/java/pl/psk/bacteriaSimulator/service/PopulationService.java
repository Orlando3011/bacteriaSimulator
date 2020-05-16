package pl.psk.bacteriaSimulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import pl.psk.bacteriaSimulator.model.Bacteria;
import pl.psk.bacteriaSimulator.model.Population;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationService {
    private Population population;
    private List<Long> steps;
    @Autowired
    private PlotService plotService;

    public void initializePopulation(Population entryPopulation) {
        this.population = entryPopulation;
        population.getBacteria().setLifeLength(0);
        population.getBacteria().setToNextReproduction(population.getBacteria().getReproductionTime());
        population.getAllBacteria().add(population.getBacteria());
        population.setTimer(0);
        steps = new ArrayList<>();
    }

    private void makeStep() {
        population.goToNextStep();
    }

    public void runSimulation() throws IOException {
        while(population.getTimer() != population.getSimulationLength()) {
            population.setTimer(population.getTimer() + 1);
            logPopulationState();
            makeStep();
        }

        plotService.savePlotAsPng(plotService.createXYPlot(steps));
    }

    private void logPopulationState() {
        steps.add(countPopulation());
    }

    private Long countPopulation() {
        long populationSize = 0;
        for (Bacteria bacteria: population.getAllBacteria()) {
            populationSize = populationSize + bacteria.getNumber();
        }
        return populationSize;
    }


    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public List<Long> getSteps() {
        return steps;
    }

    public void setSteps(List<Long> steps) {
        this.steps = steps;
    }
}
