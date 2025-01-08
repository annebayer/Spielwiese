package com.example.demoAusprobieren.datenbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class DatenbankH2Controller {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<DatenbankEntity> getCountry(@PathVariable int id) {
        return countryService.getCountry(id).map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DatenbankEntity> createCountry(@RequestBody DatenbankEntity country) {
        try {
            DatenbankEntity savedCountry = countryService.addCountry(country);
            return ResponseEntity.ok(savedCountry);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
