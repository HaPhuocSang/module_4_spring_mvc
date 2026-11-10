package org.example.bai_tap2.service;

import org.example.bai_tap2.enity.HealthDeclaration;
import org.springframework.stereotype.Service;

@Service
public class HealthDeclarationService implements IHealthDeclarationService {
    private HealthDeclaration healthDeclaration =  new HealthDeclaration();
    private boolean data = false;

    @Override
    public void save(HealthDeclaration declaration) {
        this.healthDeclaration = declaration;
        this.data = true;
    }

    @Override
    public HealthDeclaration find() {
        return healthDeclaration;
    }

    @Override
    public boolean hasData() {
        return data;
    }
}
