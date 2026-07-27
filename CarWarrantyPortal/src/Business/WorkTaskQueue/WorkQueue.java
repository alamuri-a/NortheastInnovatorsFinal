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
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class WorkQueue {
    
    // ATTRIBUTES
    ArrayList<WorkTask> tasks;
    Organization organization;
    
    // CONSTRUCTORS
    public WorkQueue(Organization org) {
        this.organization = org;
        this.tasks = new ArrayList();
    }
    
    // METHODS
    public WorkTask GetTask(int tID) {
        for (WorkTask task : tasks) {
            if (task.GetID() == tID) return task;
        }
        return null;
    }
    
    public BuildPartTask CreateBuildPartTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof ProductionOrganization) {
            BuildPartTask newTask = new BuildPartTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Build Part task can only be created for Production organizations.");
    }
    
    public BuildCarTask CreateBuildCarTask(User assigner, String make, String model) throws Exception {
        if (this.organization instanceof ProductionOrganization) {
            BuildCarTask newTask = new BuildCarTask(assigner, make, model);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Build Car task can only be created for Production organizations.");
    }
    
    public InspectPartTask CreateInspectPartTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof QualityAssuranceOrganization) {
            InspectPartTask newTask = new InspectPartTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Inspect Part task can only be created for QA organizations.");
    }
    
    public IssueRecallTask CreateIssueRecallTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof QualityAssuranceOrganization) {
            IssueRecallTask newTask = new IssueRecallTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Issue Recall task can only be created for QA organizations.");
    }
    
    public ProcessShipmentTask CreateProcessShipmentTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof LogisticsOrganization) {
            ProcessShipmentTask newTask = new ProcessShipmentTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Process Shipment task can only be created for Logistics organizations.");
    }
    
    public SendShipmentTask CreateSendShipmentTask(User assigner, DealershipEnterprise targetEnterprise, Part part) throws Exception {
        if (this.organization instanceof LogisticsOrganization) {
            SendShipmentTask newTask = new SendShipmentTask(assigner, targetEnterprise, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Send Shipment task can only be created for Logistics organizations.");
    }
    
    public GetPartTask CreateGetPartTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof WarehousingOrganization) {
            GetPartTask newTask = new GetPartTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Get Part task can only be created for Warehousing organizations.");
    }
    
    public ServiceTask CreateServiceTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            ServiceTask newTask = new ServiceTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Service task can only be created for Service organizations.");
    }
    
    public BackOrderTask CreateBackOrderTask(User assigner, Part part) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            BackOrderTask newTask = new BackOrderTask(assigner, part);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Back Order task can only be created for Service organizations.");
    }
    
    public TradeInTask CreateTradeInTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof ServiceOrganization) {
            TradeInTask newTask = new TradeInTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Trade In task can only be created for Service organizations.");
    }
    
    public ServiceAppointmentTask CreateServiceAppointmentTask(User assigner, int vin) throws Exception {
        if (this.organization instanceof SalesOrganization) {
            ServiceAppointmentTask newTask = new ServiceAppointmentTask(assigner, vin);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Service Appointment task can only be created for Sales organizations.");
    }
    
    public SellVehicleTask CreateSellVehicleTask(User assigner, String model) throws Exception {
        if (this.organization instanceof SalesOrganization) {
            SellVehicleTask newTask = new SellVehicleTask(assigner, this.organization.GetCompany().GetName(), model);
            this.tasks.add(newTask);
            return newTask;
        }
        throw new Exception("Sell Vehicle task can only be created for Sales organizations.");
    }
}
