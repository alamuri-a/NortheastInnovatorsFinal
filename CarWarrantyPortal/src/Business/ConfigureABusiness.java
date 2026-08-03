/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Ecosystem.Ecosystem;
import Business.Ecosystem.Network;
import Business.Enterprise.DealershipEnterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.Organization.ProductionOrganization;
import Business.Organization.QualityAssuranceOrganization;
import Business.Organization.SalesOrganization;
import Business.Organization.ServiceOrganization;
import Business.Organization.WarehousingOrganization;
import Business.People.Employee;
import Business.People.Person;
import Business.Roles.Admin;
import Business.Roles.CustomerServiceRepresentative;
import Business.Roles.LogisticsCoordinator;
import Business.Roles.ProductionManager;
import Business.Roles.QualityInspector;
import Business.Roles.SalesRepresentative;
import Business.Roles.ServiceManager;
import Business.Roles.ServiceTechnician;
import Business.Roles.SuperAdmin;
import Business.Roles.WarehouseClerk;
import Business.User.User;
import Business.Vehicle.Automobile;
import Business.Vehicle.CustomVehicleOrder;
import Business.Vehicle.Part;
import Business.WorkTaskQueue.BuildCarTask;
import Business.WorkTaskQueue.BuildPartTask;
import Business.WorkTaskQueue.GetPartTask;
import Business.WorkTaskQueue.InspectCarBuildTask;
import Business.WorkTaskQueue.InspectPartTask;
import Business.WorkTaskQueue.ProcessShipmentTask;
import Business.WorkTaskQueue.SellVehicleTask;
import Business.WorkTaskQueue.SendShipmentTask;
import Business.WorkTaskQueue.VehicleDeliveryTask;
import com.github.javafaker.Faker;
/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 * @author Nicholas Woodward
 */
public class ConfigureABusiness {
    
    public static Ecosystem configure() {

        Ecosystem system = Ecosystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account
        return system;
    }
    
    public static Ecosystem initialize() {
        // Create Demo data
        
        // Ecosystem (1)
        Ecosystem system = new Ecosystem("Car Warranty Ecosystem");
        
        // Network (1)
        Network network = system.createNetwork("DemoNet");
        
        // Enterprises (3)
        ManufacturerEnterprise mfe = network.getEnterprises().createManufacturerEnterprise("Toyota Manufacturer");
        SupplierEnterprise se = network.getEnterprises().createSupplierEnterprise("Toyota Supplier");
        DealershipEnterprise de = network.getEnterprises().createDealershipEnterprise("Toyota Dealership");
        
        // Organizations (9)
        AdminOrganization mfeAdminOrg = mfe.getAdmins();
        AdminOrganization seAdminOrg = se.getAdmins();
        AdminOrganization deAdminOrg = de.getAdmins();
        
        ProductionOrganization pOrg;
        QualityAssuranceOrganization qaOrg;

        LogisticsOrganization lOrg;
        WarehousingOrganization wOrg;

        ServiceOrganization servOrg;
        SalesOrganization saleOrg;
        try {
            pOrg = mfe.getOrganizations().createProductionOrganization("Toyota Production");
            qaOrg = mfe.getOrganizations().createQualityAssuranceOrganization("Toyota QA");
            
            lOrg = se.getOrganizations().createLogisticsOrganization("Toyota Logistics");
            wOrg = se.getOrganizations().createWarehousingOrganization("Toyota Warehouse");
            
            servOrg = de.getOrganizations().createServiceOrganization("Toyota Servicing");
            saleOrg = de.getOrganizations().createSalesOrganization("Toyota Sales");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
        // Person, Employee, User (12)
        Person person01 = new Person("Super Admin");
        Employee employee01 = new Employee(person01);
        User superAdmin = system.getSuperAdmins().createUser(employee01, "superadmin", "superadmin", new SuperAdmin());

        
        Person person02 = new Person("Manufacturer Admin");
        Employee employee02 = mfeAdminOrg.getEmployees().createEmployee(person02);
        User mfeAdmin = mfeAdminOrg.getUsers().createUser(employee02, "mfeadmin", "mfeadmin", new Admin());
        
        Person person03 = new Person("Supplier Admin");
        Employee employee03 = seAdminOrg.getEmployees().createEmployee(person03);
        User seAdmin = seAdminOrg.getUsers().createUser(employee03, "seadmin", "seadmin", new Admin());
        
        Person person04 = new Person("Dealership Admin");
        Employee employee04 = deAdminOrg.getEmployees().createEmployee(person04);
        User deAdmin = deAdminOrg.getUsers().createUser(employee04, "deadmin", "deadmin", new Admin());
        
        
        Person person05 = new Person("Production Manager");
        Employee employee05 = pOrg.getEmployees().createEmployee(person05);
        User pm = pOrg.getUsers().createUser(employee05, "production", "production", new ProductionManager());
        
        Person person06 = new Person("Quality Inspector");
        Employee employee06 = qaOrg.getEmployees().createEmployee(person06);
        User qi = qaOrg.getUsers().createUser(employee06, "quality", "quality", new QualityInspector());
        
        
        Person person07 = new Person("Logistics Coordinator");
        Employee employee07 = lOrg.getEmployees().createEmployee(person07);
        User lc = lOrg.getUsers().createUser(employee07, "logistics", "logistics", new LogisticsCoordinator());
        
        Person person08 = new Person("Warehouse Clerk");
        Employee employee08 = wOrg.getEmployees().createEmployee(person08);
        User wc = wOrg.getUsers().createUser(employee08, "warehouse", "warehouse", new WarehouseClerk());
        
        
        Person person09 = new Person("Service Technician");
        Employee employee09 = servOrg.getEmployees().createEmployee(person09);
        User st = servOrg.getUsers().createUser(employee09, "technician", "technician", new ServiceTechnician());
        
        Person person10 = new Person("Service Manager");
        Employee employee10 = servOrg.getEmployees().createEmployee(person10);
        User sm = servOrg.getUsers().createUser(employee10, "manager", "manager", new ServiceManager());
        
        Person person11 = new Person("Customer Service Representative");
        Employee employee11 = saleOrg.getEmployees().createEmployee(person11);
        User csr = saleOrg.getUsers().createUser(employee11, "customer", "customer", new CustomerServiceRepresentative());
        
        Person person12 = new Person("Sales Representative");
        Employee employee12 = saleOrg.getEmployees().createEmployee(person12);
        User sr = saleOrg.getUsers().createUser(employee12, "sales", "sales", new SalesRepresentative());
        seedDealershipCustomOrders(de, saleOrg, sr, pOrg, lOrg, pm);
        seedSupplier(se, de);
        seedManufacturer(mfe, de);
        
        // Return demo ecosystem
        return system;
    }
/**
 * Creates Faker dealership orders with workflow records matching each
 * displayed lifecycle stage.
 *
 * New-vehicle workflow:
 * Sales -> Production -> Logistics -> Dealership
 *
 * @param dealership dealership receiving completed vehicles
 * @param salesOrganization organization that creates vehicle orders
 * @param salesRepresentative user creating the sales requests
 * @param productionOrganization organization building vehicles
 * @param logisticsOrganization organization delivering completed vehicles
 * @param productionManager user releasing completed vehicles
 */
private static void seedDealershipCustomOrders(
        DealershipEnterprise dealership,
        SalesOrganization salesOrganization,
        User salesRepresentative,
        ProductionOrganization productionOrganization,
        LogisticsOrganization logisticsOrganization,
        User productionManager) {

    Faker faker = new Faker();

    String[] models = {"Camry", "RAV4", "Highlander", "Prius"};
    String[] trims = {"LE", "XLE", "SE", "Limited"};
    String[] supplierRegions = {
        "Mexico",
        "Asia",
        "Mexico and Asia"
    };

    for (int orderIndex = 0; orderIndex < 6; orderIndex++) {
        double totalPrice =
                faker.number().numberBetween(45000, 85001);
        double depositPaid = totalPrice * 0.15;

        CustomVehicleOrder customOrder = new CustomVehicleOrder(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                "Toyota",
                models[orderIndex % models.length],
                trims[orderIndex % trims.length],
                faker.color().name(),
                supplierRegions[orderIndex % supplierRegions.length],
                totalPrice,
                depositPaid);

        SellVehicleTask salesTask = new SellVehicleTask(
                salesRepresentative,
                customOrder);

        salesOrganization.getOutTasks().pushTask(salesTask);
        dealership.addSalesRecord(salesTask);

        if (orderIndex == 1) {
            // A validated order has not yet been sent to Production.
            salesTask.advanceStatus();

        } else if (orderIndex == 2 || orderIndex == 5) {
            // An active Production order has a real incoming build task.
            salesTask.advanceStatus();
            salesTask.markInProduction();

            BuildCarTask buildTask = new BuildCarTask(
                    salesRepresentative,
                    customOrder);

            productionOrganization.getInTasks().pushTask(buildTask);
            salesOrganization.getOutTasks().pushTask(buildTask);

        } else if (orderIndex == 3) {
            // The completed build is retained in Production history.
            salesTask.advanceStatus();
            salesTask.markInTransit();

            BuildCarTask buildTask = new BuildCarTask(
                    salesRepresentative,
                    customOrder);
            buildTask.Complete();
            productionOrganization.getOutTasks().pushTask(buildTask);

            VehicleDeliveryTask deliveryTask = new VehicleDeliveryTask(
                    productionManager,
                    customOrder,
                    dealership);

            productionOrganization.getOutTasks().pushTask(deliveryTask);
            logisticsOrganization.getInTasks().pushTask(deliveryTask);

        } else if (orderIndex == 4) {
            // A delivered order retains completed Production and Logistics
            // records and creates the actual dealership vehicle.
            salesTask.advanceStatus();
            salesTask.markDelivered();

            BuildCarTask buildTask = new BuildCarTask(
                    salesRepresentative,
                    customOrder);
            buildTask.Complete();
            productionOrganization.getOutTasks().pushTask(buildTask);

            VehicleDeliveryTask deliveryTask = new VehicleDeliveryTask(
                    productionManager,
                    customOrder,
                    dealership);
            deliveryTask.Complete();

            productionOrganization.getOutTasks().pushTask(deliveryTask);
            logisticsOrganization.getOutTasks().pushTask(deliveryTask);

            dealership.addAutomobile(new Automobile(
                    customOrder.getVehicleVin(),
                    customOrder.getMake(),
                    customOrder.getModel(),
                    null));
        }
    }
}
    
    private static void seedSupplier(SupplierEnterprise se, DealershipEnterprise de) {
        LogisticsOrganization lOrg = null;
        WarehousingOrganization wOrg = null;
        for (Organization o : se.getOrganizations().getOrganizations()) {
            if (o instanceof LogisticsOrganization l) lOrg = l;
            if (o instanceof WarehousingOrganization w) wOrg = w;
        }
        
        if (lOrg == null || wOrg == null) return;
        
        Faker faker = new Faker();
        for (int i = 1; i < 11; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Person p = new Person(firstName + " " + lastName);
            Employee emp = lOrg.getEmployees().createEmployee(p);
            User user = lOrg.getUsers().createUser(emp, lastName.toLowerCase() + firstName.toLowerCase(), firstName.toUpperCase(), new LogisticsCoordinator());
        }
        for (int i = 1; i < 11; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Person p = new Person(firstName + " " + lastName);
            Employee emp = wOrg.getEmployees().createEmployee(p);
            User user = wOrg.getUsers().createUser(emp, lastName.toLowerCase() + firstName.toLowerCase(), firstName.toUpperCase(), new WarehouseClerk());
        }
        for (User u : lOrg.getUsers().getUsers()) {
            seedSendShipmentTasks(de, lOrg, u);
            seedProcessShipmentTasks(se, lOrg, u);
            seedGetPartTasks(wOrg, u);
        }
    }
    
    private static void seedSendShipmentTasks(DealershipEnterprise de, LogisticsOrganization lOrg, User lc) {
        Faker faker = new Faker();
        for (int i = 1; i < 2; i++) {
            Part part = new Part(faker.number().numberBetween(10000000, 10000010));
            try {
                SendShipmentTask sstask = lOrg.getInTasks().createSendShipmentTask(lc, de, part, faker.number().numberBetween(1, 20));
            } catch (Exception e) {
                System.out.println("Failed to create SendShipment tasks for logistics.");
            }
        }
    }
    
    private static void seedProcessShipmentTasks(SupplierEnterprise se, LogisticsOrganization lOrg, User lc) {
        Faker faker = new Faker();
        for (int i = 1; i < 5; i++) {
            Part part = new Part(faker.number().numberBetween(10000000, 10000010));
            try {
                ProcessShipmentTask pstask = lOrg.getInTasks().createProcessShipmentTask(lc, part);
                if (faker.random().nextInt(0, 10) < 3) {
                    pstask.setAssignee(lc);
                    ((LogisticsCoordinator) lc.getRole()).completeTask();
                    
                    lOrg.getOutTasks().pushTask(lOrg.getInTasks().popTask(pstask));
                    
                    se.setPartQuantity(part, faker.number().numberBetween(5, 20));
                }
            } catch (Exception e) {
                System.out.println("Failed to create ProcessShipment tasks for logistics.");
            }
        }
    }
    
    private static void seedGetPartTasks(WarehousingOrganization wOrg, User lc) {
        Faker faker = new Faker();
        for (int i = 1; i < 2; i++) {
            Part part = new Part(faker.number().numberBetween(10000000, 10000010));
            try {
                GetPartTask gptask = wOrg.getInTasks().createGetPartTask(lc, part, faker.number().numberBetween(1, 20));
            } catch (Exception e) {
                System.out.println("Failed to create SendShipment tasks for logistics.");
            }
        }
    }

        private static void seedManufacturer(ManufacturerEnterprise mfe, DealershipEnterprise de) {
        ProductionOrganization pOrg = null;
        QualityAssuranceOrganization qaOrg = null;

        Faker faker = new Faker();
        String[] models = {"Camry", "RAV4", "Highlander", "Prius"};
        String[] trims = {"LE", "XLE", "SE", "Limited"};
        String[] supplierRegions = {
        "Mexico",
        "Asia",
        "Mexico and Asia"};
        Part part = new Part(faker.number().numberBetween(10000000, 10000010));

        for (Organization o : mfe.getOrganizations().getOrganizations()) {
            if (o instanceof ProductionOrganization p) pOrg = p;
            if (o instanceof QualityAssuranceOrganization qa) qaOrg = qa;
        }

        if (pOrg == null || qaOrg == null) return;

       //Seed Production Employees
        for (int i = 1; i < 11; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Person p = new Person(firstName + " " + lastName);
            Employee emp = pOrg.getEmployees().createEmployee(p);
            User user = pOrg.getUsers().createUser(emp, lastName.toLowerCase() + firstName.toLowerCase(), firstName.toUpperCase(), new ProductionManager());
        }
        //Seed QA Employees
        for (int i = 1; i < 11; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Person p = new Person(firstName + " " + lastName);
            Employee emp = qaOrg.getEmployees().createEmployee(p);
            User user = qaOrg.getUsers().createUser(emp, lastName.toLowerCase() + firstName.toLowerCase(), firstName.toUpperCase(), new QualityInspector());
        }
    // Complete the loop and call the child seeding methods safely
    for (User u : qaOrg.getUsers().getUsers()) {
        seedInspectPartTasks(mfe, qaOrg, u);
        seedInspectCarBuildTasks(mfe, qaOrg, u, models, trims);
        seedBuildPartTasks(pOrg, u, part);
           }
        }


    private static void seedInspectPartTasks (ManufacturerEnterprise mfe, QualityAssuranceOrganization qaOrg, User qi) {
     Faker faker = new Faker();

    for (int i = 0; i < 5; i++) {
        // Pick random attributes using Faker's options feature
        Part part = new Part(faker.number().numberBetween(10000000, 10000010));
     
        try{
        
        InspectPartTask iptask = qaOrg.getInTasks().createInspectPartTask(qi,part);
        }
        catch (Exception e) {
                System.out.println("Failed to create Inspect Part tasks for QA.");
            }
    }
}

private static void seedInspectCarBuildTasks(
    ManufacturerEnterprise mfe,
    QualityAssuranceOrganization qaOrg,
    User qi,
    String[] models,
    String[] trims

) {
    Faker faker = new Faker();

    for (int i = 0; i < 5; i++) {
        String model = faker.options().option(models);
        String trim = faker.options().option(trims);
        String color = faker.color().name();

        try {
            InspectCarBuildTask cbtask = qaOrg.getInTasks().createInspectCarBuildTask(qi, model, trim);
        } catch (Exception ex) {
            System.out.println("Failed to create Inspect Car Build tasks for QA.");
        }
    }
}

private static void seedBuildPartTasks(ProductionOrganization pOrg, User pm,Part part) {
    Faker faker = new Faker();
     
    for (int i = 0; i < 5; i++) {
        String partId = faker.idNumber().valid();
         int quantityRequested = faker.number().numberBetween(10, 100);

        try {
            BuildPartTask bptask = pOrg.getInTasks().createBuildPartTask(pm,part);
        } catch (Exception ex) {
             System.out.println("Failed to create Build Part tasks for Prod.");
        }

    }
}

}
