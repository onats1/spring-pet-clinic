package com.onats.springpetclinic.bootstrap;

import com.onats.springpetclinic.model.Owner;
import com.onats.springpetclinic.model.Pet;
import com.onats.springpetclinic.model.PetType;
import com.onats.springpetclinic.model.Vet;
import com.onats.springpetclinic.services.OwnerService;
import com.onats.springpetclinic.services.PetTypeService;
import com.onats.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Onats");
        owner1.setLastName("Dami");
        owner1.setAddress("Obafalabi street, ojodu berger");
        owner1.setCity("Lagos");
        owner1.setTelephone("1234568849");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Precious");
        owner2.setLastName("Werey");
        owner2.setAddress("Obafalabi street, ojodu berger");
        owner2.setCity("Lagos");
        owner2.setTelephone("1234568849");

        ownerService.save(owner2);

        System.out.println("Loaded owners..............................");

        Pet onatsPet = new Pet();
        onatsPet.setPetType(savedDog);
        onatsPet.setOwner(owner1);
        onatsPet.setBirthDate(LocalDate.now());
        onatsPet.setName("Hendrix");
        owner1.getPets().add(onatsPet);

        Pet preciousPet = new Pet();
        preciousPet.setPetType(savedCat);
        preciousPet.setOwner(owner2);
        preciousPet.setBirthDate(LocalDate.now());
        preciousPet.setName("catarang");
        owner2.getPets().add(preciousPet);


        Vet vet1 = new Vet();
        vet1.setFirstName("Tomisin");
        vet1.setLastName("Onats");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bunmi");
        vet2.setLastName("Adesh");

        vetService.save(vet2);

        System.out.println("Loaded Vets.............................");
    }
}
