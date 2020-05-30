package pl.psk.bacteriaSimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.psk.bacteriaSimulator.service.RandomPopulationService;

@Controller
public class randomVariablesController {
    @Autowired
    RandomPopulationService randomPopulationService;

    @GetMapping("/normalRandom")
    public String makeNormalRandomSimulation(Model model) {
        model.addAttribute(randomPopulationService.createNormalPoupulation());
        return "/form";
    }

    @GetMapping("/flatRandom")
    public String makeFlatRandomSimulation(Model model) {
        model.addAttribute(randomPopulationService.createFlatPopulation());
        return "/form";
    }
}
