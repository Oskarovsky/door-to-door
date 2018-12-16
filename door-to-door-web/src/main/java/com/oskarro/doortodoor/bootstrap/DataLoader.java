package com.oskarro.doortodoor.bootstrap;

import com.oskarro.doortodoor.model.*;
import com.oskarro.doortodoor.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Spring Boot specific way to initialise data - CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final CourierService courierService;
    private final ProductTypeService productTypeService;
    private final SpecialityService specialityService;
    private final DeliveryService deliveryService;


    // from Spring 4.2 @Autowired isn't necessary
    public DataLoader(OwnerService ownerService, CourierService courierService,
                      ProductTypeService productTypeService, SpecialityService specialityService, DeliveryService deliveryService) {
        this.ownerService = ownerService;
        this.courierService = courierService;
        this.productTypeService = productTypeService;
        this.specialityService = specialityService;
        this.deliveryService = deliveryService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = productTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        // CREATING PRODUCT TYPES
        ProductType food = new ProductType();
        food.setName("Food");
        ProductType savedFoodProductType = productTypeService.save(food);

        ProductType animal = new ProductType();
        animal.setName("Animal");
        ProductType savedAnimalProductType = productTypeService.save(animal);

        // CREATING SPECIALITIES
        Speciality localProvider = new Speciality();
        localProvider.setDescription("Local Provider");
        Speciality savedLocalProvider = specialityService.save(localProvider);

        Speciality domesticProvider = new Speciality();
        localProvider.setDescription("Domestic Provider");
        Speciality savedDomesticProvider = specialityService.save(domesticProvider);

        Speciality internationalProvider = new Speciality();
        localProvider.setDescription("International Provider");
        Speciality savedInternationalProvider = specialityService.save(internationalProvider);

        // CREATING NEW OWNERS
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("St. Etienne Street, 290/15");
        owner1.setCity("New York");
        owner1.setTelephone("700-482-011");

        // creating pet for the owner
        Product mikesProduct = new Product();
        mikesProduct.setProductType(savedFoodProductType);
        mikesProduct.setOwner(owner1);
        mikesProduct.setName("McChicken collection");
        mikesProduct.setDescription("McChicken, double french fries, cola zero");
        mikesProduct.setSize("small");
        mikesProduct.setPrice("13.99$");
        mikesProduct.setImageUrl("http://website.com");
        mikesProduct.setEndLocalization("Warsaw, Polaka Street, 3/60");
        mikesProduct.setStartLocalization("McDonald, Warsaw, Rzeczki Street, 11/94");
        owner1.getProducts().add(mikesProduct);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenne");
        owner2.setAddress("Lylianna Street, 199/2A");
        owner2.setTelephone("666-391-301");
        owner2.setCity("Chicago");

        // creating pet for the owner
        Product fionasProduct = new Product();
        fionasProduct.setProductType(savedAnimalProductType);
        fionasProduct.setOwner(owner2);
        fionasProduct.setName("Husky Dog");
        fionasProduct.setDescription("The big one, 2 years, white");
        fionasProduct.setSize("18kg, 40x90cm");
        fionasProduct.setPrice("null");
        fionasProduct.setImageUrl("http://dogphoto");
        fionasProduct.setEndLocalization("Katowice, Nowogrodzka Street, 11/75F");
        fionasProduct.setStartLocalization("Gdańsk, Warmia Street, 3/10");
        owner2.getProducts().add(fionasProduct);
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
        courier1.getSpecialities().add(savedDomesticProvider);

        Courier courier2 = new Courier();
        courier2.setFirstName("Meganne");
        courier2.setLastName(" Awsone");
        courier2.setEquipment("Bike RM-30 Holland");
        courier2.setCompany("UBER Eats");
        courierService.save(courier2);
        courier2.getSpecialities().add(savedInternationalProvider);

        Courier courier3 = new Courier();
        courier3.setFirstName("John");
        courier3.setLastName("Starridge");
        courier3.setEquipment("Seat Leoan 1.9 TD");
        courier3.setCompany("Koliber SCO");
        courierService.save(courier3);
        courier3.getSpecialities().add(savedInternationalProvider);

        System.out.println("Loaded Couriers...");


        Delivery dogDelivery = new Delivery();
        dogDelivery.setCourier(courier1);
        dogDelivery.setDate(LocalDate.now());
        dogDelivery.setCost("150$");
        dogDelivery.setDescription("Fast delivery. No problem with transport.");
        deliveryService.save(dogDelivery);

    }
}
