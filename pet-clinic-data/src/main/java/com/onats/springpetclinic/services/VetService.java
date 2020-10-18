package com.onats.springpetclinic.services;

import com.onats.springpetclinic.model.Pet;
import com.onats.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
