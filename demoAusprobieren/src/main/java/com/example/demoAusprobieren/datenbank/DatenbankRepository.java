package com.example.demoausprobieren.datenbank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatenbankRepository extends JpaRepository<DatenbankEntity, Long> {}
