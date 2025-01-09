package com.example.demoausprobieren;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErsteSahneController {
    @GetMapping("/ersteSahne")
    public String ersteSahne(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "alter", defaultValue = "12") int alter) {
        return String.format("ersteSahne Name %s! Dein Alter ist %s", name, alter);
    }
}
