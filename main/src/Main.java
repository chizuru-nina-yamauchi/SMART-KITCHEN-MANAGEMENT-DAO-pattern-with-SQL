package src;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Instantiate ApplianceDaoImpl to interact with the database
        ApplianceDaoImpl applianceDao = new ApplianceDaoImpl();
        // Print the connection message
        ConnectionFactory.printConnectionMessage();

        System.out.println();

        System.out.println("Inserting a new appliance");
        // Create a new appliance
        Appliance panasonicFridge = new Appliance("Panasonic Fridge", "Refrigerator", "On", 10);
        Appliance samsungOven = new Appliance("Samsung Oven", "Oven", "Off", 5);
        Appliance lgMicrowave = new Appliance("LG Microwave", "Microwave", "On", 3);
        Appliance boschDishwasher = new Appliance("Bosch Dishwasher", "Dishwasher", "Off", 7);

        // Insert the appliance into the database
        panasonicFridge = applianceDao.insertAppliance(panasonicFridge);
        if (panasonicFridge != null) {
            System.out.println("Inserted appliance: " + panasonicFridge);
        }

        samsungOven = applianceDao.insertAppliance(samsungOven);
        if (samsungOven != null) {
            System.out.println("Inserted appliance: " + samsungOven);
        }

        lgMicrowave = applianceDao.insertAppliance(lgMicrowave);
        if (lgMicrowave != null) {
            System.out.println("Inserted appliance: " + lgMicrowave);
        }

        boschDishwasher = applianceDao.insertAppliance(boschDishwasher);
        if (boschDishwasher != null) {
            System.out.println("Inserted appliance: " + boschDishwasher);
        }

        System.out.println();
        // Get all appliances from the database
        System.out.println("Getting all appliances");
        // Get all appliances from the database
        Set<Appliance> appliances = applianceDao.getAllAppliances();
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }

        System.out.println();
        // Update an appliance
        System.out.println("Updating an appliance");
        // Update the status of the appliance
        if (panasonicFridge != null) {
            System.out.println("Updating appliance: " + panasonicFridge);
            panasonicFridge.setStatus("Off");
            applianceDao.updateAppliance(panasonicFridge);
            System.out.println("--------------------");
            System.out.println("Updated appliance: " + panasonicFridge);
        }

        System.out.println();
        // Delete an appliance
        System.out.println("Deleting an appliance");
        // Delete the appliance from the database
        if (samsungOven != null) {
            System.out.println("Deleting appliance: " + samsungOven);
            applianceDao.deleteAppliance(samsungOven.getId());
            System.out.println("--------------------");
            System.out.println("Deleted appliance: " + samsungOven);
        }


    }
}
