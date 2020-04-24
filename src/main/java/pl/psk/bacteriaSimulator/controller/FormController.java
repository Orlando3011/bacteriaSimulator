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

@Controller
public class FormController {
    @Autowired
    PopulationService populationService;

    @GetMapping("/form")
    public String showFormPage(Model model) {
        Population population = new Population(new Bacteria(), new Environment());
        model.addAttribute(population);
        return "form";
    }

    @PostMapping("/form")
    public String showSimulationResults(@ModelAttribute("population") Population population) {
        return "redirect:/results";
    }
}