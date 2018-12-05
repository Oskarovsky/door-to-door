package com.oskarro.doortodoor.bootstrap;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.model.Owner;
import com.oskarro.doortodoor.model.ProductType;
import com.oskarro.doortodoor.services.CourierService;
import com.oskarro.doortodoor.services.OwnerService;
import com.oskarro.doortodoor.services.ProductTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Spring Boot specific way to initialise data - CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final CourierService courierService;
    private final ProductTypeService productTypeService;

    // from Spring 4.2 @Autowired isn't necessary
    public DataLoader(OwnerService ownerService, CourierService courierService, ProductTypeService productTypeService) {
        this.ownerService = ownerService;
        this.courierService = courierService;
        this.productTypeService = productTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // CREATING PRODUCT TYPES
        ProductType food = new ProductType();
        food.setName("Food");
        ProductType savedFoodProductType = productTypeService.save(food);

        ProductType car = new ProductType();
        food.setName("Car");
        ProductType savedCarProductType = productTypeService.save(car);

        ProductType animal = new ProductType();
        food.setName("Animal");
        ProductType savedAnimalProductType = productTypeService.save(animal);


        // CREATING NEW OWNERS
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("St. Etienne Street, 290/15");
        owner1.setCity("New York");
        owner1.setTelephone("700-482-011");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenne");
        owner2.setAddress("Lylianna Street, 199/2A");
        owner2.setTelephone("666-391-301");
        owner2.setCity("Chicago");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Andrew");
        owner3.setLastName("Darkflame");
        owner3.setAddress("Koszykowa Street, 33/1");
        owner3.setTelephone("601-005-661");
        owner3.setCity("Warsaw");
        ownerService.save(owner3);

        System.out.println("Loaded Owners...");


        // CREATING NEW COURIERS
        Courier courier1 = new Courier();
        courier1.setFirstName("David");
        courier1.setLastName("Beckham");
        courier1.setEquipment("Renault Megane 4X");
        courier1.setCompany("Koliber SCO");
        courierService.save(courier1);

        Courier courier2 = new Courier();
        courier2.setFirstName("Meganne");
        courier2.setLastName(" Awsone");
        courier2.setEquipment("Bike RM-30 Holland");
        courier2.setCompany("UBER Eats");
        courierService.save(courier2);

        Courier courier3 = new Courier();
        courier3.setFirstName("John");
        courier3.setLastName("Starridge");
        courier3.setEquipment("Seat Leoan 1.9 TD");
        courier3.setCompany("Koliber SCO");
        courierService.save(courier3);

        System.out.println("Loaded Couriers...");


    }
}
