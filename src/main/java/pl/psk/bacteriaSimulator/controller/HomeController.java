package pl.psk.bacteriaSimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.psk.bacteriaSimulator.service.PopulationService;

@Controller
public class HomeController {
    @Autowired
    PopulationService populationService;

    @GetMapping("")
    public String redirect() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}
