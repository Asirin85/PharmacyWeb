package com.serverapplication.services;

import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.modelsAPI.PharmacytAPI;

import java.util.List;

public interface PharmacytService {
    PharmacytAPI getById(Long id);

    List<PharmacytAPI> save(PharmacytAPI pharmacytAPI);

    List<PharmacytAPI> delete(Long id);

    List<PharmacytAPI> getAll();

    List<PharmacytAPI> update(PharmacytAPI pharmacytAPI);

    PharmacytAPI convertToAPI(Pharmacyt pharmacyt);

    Pharmacyt convertToEntity(PharmacytAPI pharmacytAPI);
}
