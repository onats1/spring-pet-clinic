package com.onats.springpetclinic.bootstrap;

import com.onats.springpetclinic.model.Owner;
import com.onats.springpetclinic.model.Vet;
import com.onats.springpetclinic.services.maps.OwnerServiceMap;
import com.onats.springpetclinic.services.maps.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    public DataLoader() {
        ownerServiceMap = new OwnerServiceMap();
        vetServiceMap = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Onats");
        owner1.setLastName("Dami");

        ownerServiceMap.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Precious");
        owner2.setLastName("Werey");

        ownerServiceMap.save(owner2);

        System.out.println("Loaded owners..............................");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tomisin");
        vet1.setId(1L);
        vet1.setLastName("Onats");

        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tomisin");
        vet2.setId(1L);
        vet2.setLastName("Onats");

        vetServiceMap.save(vet2);

        System.out.println("Loaded Vets.............................");
    }
}
