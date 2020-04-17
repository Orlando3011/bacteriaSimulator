package pl.psk.bacteriaSimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.psk.bacteriaSimulator.model.Bacteria;
import pl.psk.bacteriaSimulator.model.Environment;
import pl.psk.bacteriaSimulator.service.PopulationService;

@Controller
public class HomeController {
    @Autowired
    PopulationService populationService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        Bacteria bacteria = new Bacteria();
        bacteria.setName("test");
        bacteria.setLifeSpan(5);
        bacteria.setReproductionTime(2);
        bacteria.setNumber(10);
        Environment environment = new Environment();
        populationService.initializePopulation(bacteria, environment, 30);
        populationService.runSimulation();
        return "home";
    }
}
