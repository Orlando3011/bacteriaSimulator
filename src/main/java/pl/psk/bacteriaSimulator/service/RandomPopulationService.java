package pl.psk.bacteriaSimulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psk.bacteriaSimulator.model.Bacteria;
import pl.psk.bacteriaSimulator.model.Environment;
import pl.psk.bacteriaSimulator.model.Population;

import java.util.Random;

@Service
public class RandomPopulationService {

    public Population createNormalPoupulation() {
        Random random = new Random();
        Population population = new Population(new Bacteria(), new Environment());
        population.getBacteria().setName("Bakteria z normalnej losowej populacji");
        population.setSimulationLength(20);

        population.getBacteria().setNumber(generateGaussianPopulationNumber());
        population.getBacteria().setReproductionTime(generateGaussianCyclesNumber());
        population.getBacteria().setLifeSpan(generateGaussianCyclesNumber());
        population.getBacteria().setToxicityTolerance(generateGaussian());
        population.getBacteria().setTemperatureTolerance(generateGaussian());
        population.getBacteria().setFoodTolerance(generateGaussian());
        population.getBacteria().setOptimalTemperature(generateGaussianTemperature());

        population.getEnvironment().setFoodAccessibility(generateGaussian());
        population.getEnvironment().setToxicity(generateGaussian());
        population.getEnvironment().setTemperature(generateGaussianTemperature());
        return population;
    }

    public Population createFlatPopulation() {
        Random random = new Random();
        Population population = new Population(new Bacteria(), new Environment());
        population.getBacteria().setName("Bakteria z równomiernej losowej populacji");
        population.setSimulationLength(20);

        population.getBacteria().setNumber(random.nextInt(1000000) + 1);
        population.getBacteria().setReproductionTime(random.nextInt(20) + 1);
        population.getBacteria().setLifeSpan(random.nextInt(20) + 1);
        population.getBacteria().setToxicityTolerance(random.nextDouble());
        population.getBacteria().setTemperatureTolerance(random.nextDouble());
        population.getBacteria().setFoodTolerance(random.nextDouble());
        population.getBacteria().setOptimalTemperature(random.nextInt(100) + 200);

        population.getEnvironment().setFoodAccessibility(random.nextDouble());
        population.getEnvironment().setToxicity(random.nextDouble());
        population.getEnvironment().setTemperature(random.nextInt(100) + 200);
        return population;
    }

    private double generateGaussian() {
        Random random = new Random();
        double tmp = random.nextGaussian()* 0.3 + 0.5;
        if(tmp < 0) tmp = -tmp;
        return tmp;
    }

    private int generateGaussianPopulationNumber() {
        Random random = new Random();
        int tmp = (int)(random.nextGaussian() * 100000 + 500000);
        if(tmp < 0) tmp = -tmp;
        return tmp;
    }

    private int generateGaussianTemperature() {
        Random random = new Random();
        int tmp = (int)(random.nextGaussian() * 20 + 273);
        if(tmp < 0) tmp = -tmp;
        return tmp;
    }

    private int generateGaussianCyclesNumber() {
        Random random = new Random();
        int tmp = (int)(random.nextGaussian() * 9 + 10);
        if(tmp < 0) tmp = -tmp;
        if(tmp == 0) tmp = 1;
        return tmp;
    }
}