/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.Enterprise.DealershipEnterprise;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.Organization.ProductionOrganization;
import Business.Organization.QualityAssuranceOrganization;
import Business.Organization.SalesOrganization;
import Business.Organization.ServiceOrganization;
import Business.Organization.WarehousingOrganization;
import Business.User.User;
import Business.Vehicle.Part;
import Business.Vehicle.CustomVehicleOrder;
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 * @author Nicholas Woodward
 */
public class WorkQueue {
    
    // ATTRIBUTES
    private ArrayList<WorkTask> tasks;
    private Organization organization;
    
    // CONSTRUCTORS
    public WorkQueue(Organization org) {
        this.organization = org;
        this.tasks = new ArrayList();
    }
    
    // METHODS
    public ArrayList<WorkTask> getTasks() {
        return this.tasks;
    }
    
    public WorkTask getTask(int tID) {
        for (WorkTask task : tasks) {
            if (task.getID() == tID) return task;
        }
        return null;
    }
    
    public WorkTask popTask(WorkTask task) {
        int index = this.tasks.indexOf(task);
        return this.tasks.remove(index);
    }
    
    public boolean pushTask(WorkTask task) {
        return this.tasks.add(task);
    }
    
    /**
    * Create a new BuildPartTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part needing to be built
    * 
    * @return {@link BuildPartTask} the new BuildPartTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Production organization
    */
    public BuildPartTask createBuildPartTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof ProductionOrganization) {
            BuildPartTask newTask = new BuildPartTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Build Part task can only be created for Production organizations.");
    }
    
    /**
    * Create a new BuildCarTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param make the manufacturer of new vehicle
    * @param model the specific model of new vehicle
    * 
    * @return {@link BuildCarTask} the new BuildCarTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Production organization
    */
    public BuildCarTask createBuildCarTask(User assigner, String make, String model) throws Exception {
        if (this.organization instanceof ProductionOrganization) {
            BuildCarTask newTask = new BuildCarTask(assigner, make, model);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Build Car task can only be created for Production organizations.");
    }
    
    /**
    * Create a new InspectPartTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part being inspected
    * 
    * @return {@link InspectPartTask} the new InspectPartTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than QA organization
    */
    public InspectPartTask createInspectPartTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof QualityAssuranceOrganization) {
            InspectPartTask newTask = new InspectPartTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Inspect Part task can only be created for QA organizations.");
    }
    
    /**
    * Create a new IssueRecallTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part being recalled
    * 
    * @return {@link IssueRecallTask} the new IssueRecallTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than QA organization
    */
    public IssueRecallTask createIssueRecallTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof QualityAssuranceOrganization) {
            IssueRecallTask newTask = new IssueRecallTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Issue Recall task can only be created for QA organizations.");
    }
    
    /**
    * Create a new ProcessShipmentTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part coming in
    * 
    * @return {@link ProcessShipmentTask} the new ProcessShipmentTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Logistics organization
    */
    public ProcessShipmentTask createProcessShipmentTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof LogisticsOrganization) {
            ProcessShipmentTask newTask = new ProcessShipmentTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Process Shipment task can only be created for Logistics organizations.");
    }
    
    /**
    * Create a new SendShipmentTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param targetEnterprise DealershipEnterprise part is being sent to
    * @param part the part being sent out
    * @param quantity count of parts requested
    * 
    * @return {@link SendShipmentTask} the new SendShipmentTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Logistics organization
    */
    public SendShipmentTask createSendShipmentTask(User assigner, DealershipEnterprise targetEnterprise, Part part, int quantity) throws Exception {
        if (this.organization instanceof LogisticsOrganization) {
            SendShipmentTask newTask = new SendShipmentTask(assigner, targetEnterprise, part, quantity);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Send Shipment task can only be created for Logistics organizations.");
    }
    
    /**
    * Create a new GetPartTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part to be fetched
    * 
    * @return {@link GetPartTask} the new GetPartTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Warehousing organization
    */
    public GetPartTask createGetPartTask(User assigner, Part part, int quantity) throws Exception {
        if (this.organization instanceof WarehousingOrganization) {
            GetPartTask newTask = new GetPartTask(assigner, part, quantity);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Get Part task can only be created for Warehousing organizations.");
    }
        /**
     * Creates a Warehouse part request linked to a dealership custom order.
     *
     * @param assigner Sales Representative requesting components
     * @param part component required for the custom vehicle
     * @param quantity number of components requested
     * @param customOrder customer order requiring the components
     * @return created Warehouse retrieval task
     * @throws Exception when the queue does not belong to a Warehouse
     */
    public GetPartTask createGetPartTask(
            User assigner,
            Part part,
            int quantity,
            CustomVehicleOrder customOrder) throws Exception {

        if (this.organization instanceof WarehousingOrganization) {
            GetPartTask newTask = new GetPartTask(
                    assigner, part, quantity, customOrder);
            this.tasks.add(newTask);
            return newTask;
        }

        throw new Exception(
                "Get Part task can only be created for Warehousing organizations.");
    }
    
    /**
    * Create a new ServiceTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param vin ID of the car being serviced
    * 
    * @return {@link ServiceTask} the new ServiceTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Service organization
    */
    public ServiceTask createServiceTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            ServiceTask newTask = new ServiceTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Service task can only be created for Service organizations.");
    }
    
    /**
    * Create a new BackOrderTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param part the part to order
    * 
    * @return {@link BackOrderTask} the new BackOrderTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Service organization
    */
    public BackOrderTask createBackOrderTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            BackOrderTask newTask = new BackOrderTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Back Order task can only be created for Service organizations.");
    }
    
    /**
    * Create a new TradeInTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param vin ID of the car being traded in
    * 
    * @return {@link TradeInTask} the new TradeInTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Service organization
    */
    public TradeInTask createTradeInTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            TradeInTask newTask = new TradeInTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Trade In task can only be created for Service organizations.");
    }
    
    /**
    * Create a new ServiceAppointmentTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param vin ID of the car needing service
    * 
    * @return {@link ServiceAppointmentTask} the new ServiceAppointmentTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Sales organization
    */
    public ServiceAppointmentTask createServiceAppointmentTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof SalesOrganization) {
            ServiceAppointmentTask newTask = new ServiceAppointmentTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Service Appointment task can only be created for Sales organizations.");
    }
    
    /**
    * Create a new SellVehicleTask, add to internal list of tasks, then return task for modification
    * 
    * @param assigner the user creating request
    * @param model model of the car being sold
    * 
    * @return {@link SellVehicleTask} the new SellVehicleTask object created
    * 
    * @throws Exception If attempted to be instantiated for organization other than Sales organization
    */
    public SellVehicleTask createSellVehicleTask(User assigner, String model) throws Exception {
        if (this.organization instanceof SalesOrganization) {
            SellVehicleTask newTask = new SellVehicleTask(assigner, this.organization.getCompany().getName(), model);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Sell Vehicle task can only be created for Sales organizations.");
    }
}
