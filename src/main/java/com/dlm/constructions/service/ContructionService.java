package com.dlm.constructions.service;

import com.dlm.constructions.views.ConstructionView;

import java.util.List;

public interface ContructionService {
    void addConstruction(ConstructionView view);

    ConstructionView findById(Long id);

    List<ConstructionView> searchContructions(Long rowVersion);

    void deleteConstruction(Long id);
    void updateConstruction(ConstructionView view);
}