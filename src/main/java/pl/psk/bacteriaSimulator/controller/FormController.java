package pl.psk.bacteriaSimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.psk.bacteriaSimulator.model.Bacteria;
import pl.psk.bacteriaSimulator.model.Environment;
import pl.psk.bacteriaSimulator.model.Population;
import pl.psk.bacteriaSimulator.service.PopulationService;

import java.io.IOException;

@Controller
public class FormController {
    private final String chartPath = System.getProperty("user.home") + "\\Downloads\\chart.png";
    @Autowired
    PopulationService populationService;

    @GetMapping("/form")
    public String showFormPage(Model model) {
        Population population = new Population(new Bacteria(), new Environment());
        model.addAttribute(population);
        return "form";
    }

    @PostMapping("/form")
    public String showSimulationResults(@ModelAttribute("population") Population population, Model model) throws IOException {
        populationService.initializePopulation(population);
        populationService.runSimulation();
        model.addAttribute("steps", populationService.getSteps());

        model.addAttribute("toxicityDeaths", populationService.getPopulation().getToxicityCausalities());
        model.addAttribute("temperatureDeaths", populationService.getPopulation().getTemperatureCausalities());
        model.addAttribute("foodDeaths", populationService.getPopulation().getFoodCausalities());
        if(populationService.getSteps().size() > 0)
            model.addAttribute("finalCount", populationService.getSteps().get(populationService.getSteps().size() - 1));
        else model.addAttribute("finalCount", 0);
        return "results";
    }
}