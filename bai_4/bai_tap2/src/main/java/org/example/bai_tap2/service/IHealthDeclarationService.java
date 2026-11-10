package org.example.bai_tap2.service;


import org.example.bai_tap2.enity.HealthDeclaration;

public interface IHealthDeclarationService {
    void save(HealthDeclaration healthDeclaration);
    HealthDeclaration find();
    boolean hasData();
}
