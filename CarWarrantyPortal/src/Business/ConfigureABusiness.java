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

/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 */
public class ConfigureABusiness  {

 public static Ecosystem configure(){

        Ecosystem system = Ecosystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account



public class ConfigureABusiness {
    
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
        
        // Return demo ecosystem
        return system;
    }
}
