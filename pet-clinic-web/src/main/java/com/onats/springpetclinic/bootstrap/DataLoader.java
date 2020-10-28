package com.onats.springpetclinic.bootstrap;

import com.onats.springpetclinic.model.Owner;
import com.onats.springpetclinic.model.Vet;
import com.onats.springpetclinic.services.OwnerService;
import com.onats.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Onats");
        owner1.setLastName("Dami");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Precious");
        owner2.setLastName("Werey");

        ownerService.save(owner2);

        System.out.println("Loaded owners..............................");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tomisin");
        vet1.setId(1L);
        vet1.setLastName("Onats");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bunmi");
        vet2.setId(2L);
        vet2.setLastName("Adesh");

        vetService.save(vet2);

        System.out.println("Loaded Vets.............................");
    }
}
