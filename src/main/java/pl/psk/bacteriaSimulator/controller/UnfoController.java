package pl.psk.bacteriaSimulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnfoController {

    @GetMapping("/info")
    public String showInfoPage() {
        return "info";
    }
}
