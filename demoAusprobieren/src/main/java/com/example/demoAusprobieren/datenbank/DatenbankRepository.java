package com.example.demoAusprobieren.datenbank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatenbankRepository extends JpaRepository<DatenbankEntity, Long> {}
