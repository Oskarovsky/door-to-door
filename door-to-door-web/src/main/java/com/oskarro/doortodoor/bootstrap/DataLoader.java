package com.oskarro.doortodoor.bootstrap;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.services.CourierService;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.map.CourierServiceMap;
import com.oskarro.doortodoor.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Spring Boot specific way to initialise data - CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final CourierService courierService;
    //private final ProductService productService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        courierService = new CourierServiceMap();
        //productService = new ProductServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        // CREATING NEW OWNERS
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");


        // CREATING NEW COURIERS
        Courier courier1 = new Courier();
        courier1.setId(1L);
        courier1.setFirstName("David");
        courier1.setLastName("Beckham");
        courierService.save(courier1);

        Courier courier2 = new Courier();
        courier2.setId(1L);
        courier2.setFirstName("Meganne");
        courier2.setLastName(" Awsone");
        courierService.save(courier2);

        System.out.println("Loaded Couriers...");


    }
}
