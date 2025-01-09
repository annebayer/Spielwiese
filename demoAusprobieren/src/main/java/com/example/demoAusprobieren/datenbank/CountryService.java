package com.example.demoausprobieren.datenbank;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    public final DatenbankRepository datenbankRepository;

    @Autowired
    public CountryService(DatenbankRepository datenbankRepository) {
        this.datenbankRepository = datenbankRepository;
    }


    @Transactional
    public DatenbankEntity addCountry(DatenbankEntity entity) {
        return datenbankRepository.save(entity);
    }

    public Optional<DatenbankEntity> getCountry(int id) {
        return datenbankRepository.findById((long) id);
    }

}
