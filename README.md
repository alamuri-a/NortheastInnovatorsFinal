# NortheastInnovatorsFinal

## Team Information

| Team Member | NUID | Assigned Use Case | Responsibilities |
|-------------|------|-------------------|------------------|
| Nicholas Woodward | 002478780 | Custom Vehicle Order and Global Supply Chain Fulfillment | README, sales-order workflow, global order tracking, documentation |
| Meredith Molyneux | 003978998 | Cross-Border Regulatory and Compliance Management | VIN workflow, compliance tracking, quality reporting |
| Ajay Alamuri | 003915177 | Parts Supplier Enterprise | Parts Acquisition + Backordering, Shipment Processing + Routing, Admin Work Area + Responsibilities, Logistics Coordinator Work Area + Responsibilities, Warehouse Clerk Work Area + Responsibilities, Initial Application Structuring + Formatting, Application Testing |

## Project Overview

The purpose of this project is to build a Global Automotive Ecosystem that
connects dealerships, suppliers, manufacturers, logistics teams, quality
inspectors, service centers, and customers across national boundaries. The
application is being developed in Java Swing with object-oriented design
principles to make cross-enterprise automotive work visible, traceable, and
manageable in one system.

The system is centered on three connected use cases:

1. **Custom Vehicle Order and Global Supply Chain Fulfillment** - A customer
   order created in the United States is validated, supplied with components
   from Mexico and/or Asia, built in Germany, shipped, and delivered.
2. **Cross-Border Regulatory and Compliance Management** - A VIN is
   used as the common record to identify affected vehicles, notify owners and
   dealers, and document completed repairs.
3. **Post-Warranty Lifecycle, Parts Replenishment, and Trade-In** - Service
   teams request parts across borders, complete maintenance, preserve vehicle
   history, and support a vehicle's trade-in and resale lifecycle.

The project emphasizes role-based work areas, unique IDs, status management,
input validation, pre-populated analytics data, reporting, and a clear Swing
user interface. The ecosystem contains three enterprises, six organizations,
and eight operating roles so that the whole network delivers more value than
any individual enterprise could provide alone.

## Installation & Setup Instructions

### Prerequisites

Before running the project, make sure the following are installed:

- Java JDK 19
- Apache NetBeans IDE
- Git
- Apache Ant

### Setup Instructions

1. Clone the GitHub repository:

```bash
git clone https://github.com/alamuri-a/NortheastInnovatorsFinal.git
```

2. Open Apache NetBeans IDE.
3. Select **File -> Open Project**.
4. Browse to the cloned `NortheastInnovatorsFinal/CarWarrantyPortal` folder.
5. Click **Open Project**.
6. Right-click the project and select **Clean and Build**.
7. After the build completes successfully, right-click the project and select
   **Run**.
8. The application launches the Global Auto Ecosystem work area.

## Authentication & Access Control

The final system is designed to use role-based authentication and
authorization. Each user will authenticate with a username and password and
will be directed only to the work area associated with their assigned role.

The operating roles in the ecosystem are:

- Sales Representative
- Customer Service Representative
- Warehouse Clerk
- Logistics Coordinator
- Production Manager
- Quality Inspector
- Service Manager
- Service Technician

Ecosystem and enterprise administrators are responsible for managing networks and enterprises, and enterprise administrative duties respectively. Their administrative roles are separate from the eight operating roles required by the project rubric.

## Features Implemented

### Custom Vehicle Order and Global Supply Chain Fulfillment

The Sales Representative work area currently includes the following
functionality:

- Create a custom vehicle order for a customer
- Validate required customer, vehicle, supplier-region, price, and deposit
  fields
- Validate customer email format
- Generate a unique `CVO-` custom vehicle order ID
- Enforce a minimum 10% deposit before an order can be validated
- Advance an order through the following status lifecycle:
  - Draft
  - Validated
  - Sourcing Parts
  - Ready for Production
  - In Production
  - In Transit
  - Delivered
- Record cross-border supplier regions, including Mexico, Japan, and
  Japan/Mexico, with Germany as the manufacturing location
- Display seeded custom orders for a reliable demonstration and analytics view

### Regulatory and Compliance Management

The planned Quality Inspector and Compliance work areas will support:

- Identifying a defective part or manufacturing batch
- Locating all affected VINs
- Reporting compliance completion across the network

### Post-Warranty Lifecycle, Parts Replenishment, and Trade-In

The planned Service Manager, Service Technician, and Trade-In work areas will
support:

- Creating post-warranty service requests
- Replenishing needed parts from cross-border suppliers
- Assigning and completing service work
- Preserving vehicle maintenance history
- Assessing trade-in vehicles and transferring their history to the resale
  workflow

### Ecosystem and Work-Request Features

The project model includes three enterprise types and their organizations:

| Enterprise | Organizations | Contribution to the Ecosystem |
|------------|---------------|-------------------------------|
| Global Motors Manufacturing (Germany) | Production; Quality Assurance | Builds custom vehicles and manages production quality. |
| International Parts Supply (Mexico/Asia) | Warehousing; Logistics | Supplies components and manages international shipping. |
| United States Auto Retail | Sales; Service | Creates customer orders, performs maintenance, and manages trade-ins. |

## Usage Instructions

### Custom Vehicle Order Workflow

1. Launch the application from NetBeans.
2. Open the **Custom Vehicle Orders - Global Supply Chain** work area.
3. Enter the customer name, valid email, vehicle configuration, supplier
   region, vehicle price, and deposit.
4. Select **Create order**. The system creates a unique `CVO-` ID and adds the
   order to the lifecycle table.
5. Select the order and use **Advance selected order** to move it through each
   accountable handoff.
6. The system requires at least a 10% deposit before it accepts the first
   status transition from Draft to Validated.
7. Continue through sourcing, German production, shipment, and delivery.

### Compliance Workflow

1. The Quality Inspector identifies a defective part or batch.
2. The system uses the VIN to locate all affected vehicles.
3. Dealers, service centers, and vehicle owners receive recall notification.
4. Service teams record the repair against the affected VIN.
5. Compliance staff review completion reporting.

### Post-Warranty and Trade-In Workflow

1. A vehicle owner or service manager creates a service request.
2. The service team requests any needed replacement parts.
3. Suppliers and logistics teams replenish cross-border inventory.
4. The Service Technician completes the maintenance and updates vehicle
   history.
5. The Trade-In Manager uses that history to assess the vehicle for resale.

## Testing Guide

The following test cases define the expected behavior of the Global Automotive
Ecosystem. The custom-order workflow test is included in the project; the
remaining cases are the acceptance checks for the next two work areas.

| Test Case | Expected Result | Status |
|-----------|-----------------|--------|
| Create custom vehicle order | A unique `CVO-` order is created and displayed. | Implemented |
| Required-field validation | Missing customer or vehicle data displays a validation message. | Implemented |
| Email validation | Invalid customer email is rejected. | Implemented |
| Deposit validation | An order below the 10% deposit threshold cannot be validated. | Implemented |
| Order lifecycle | A valid order advances from Draft through Delivered in sequence. | Implemented |
| Seeded demo data | Pre-populated orders appear in the order table. | Implemented |
| Parts replenishment | Cross-border part requests are created and tracked. | Planned |
| Trade-in history transfer | Maintenance history is available during trade-in assessment. | Planned |
| Role-based authorization | Users access only their assigned work areas. | Implemented |

## Demo Data

The custom-order workflow includes pre-populated orders in different lifecycle
states so the team can demonstrate sourcing, production, and shipment without
creating every order from scratch.

## Challenges & Solutions

| Challenge | Solution |
|-----------|----------|
| One customer order crosses multiple countries and enterprises. | Created one unique custom-order record with supplier region, German production location, and visible lifecycle statuses. |
| The team needs to demonstrate a complete global workflow in a limited time. | Seeded orders at sourcing, production, and transit stages provide realistic demo scenarios. |
| Orders can be incorrectly released without a meaningful customer commitment. | Enforced a 10% deposit validation rule before the order can leave Draft status. |
| Different teammates are building separate workflows. | Defined three independent use cases with shared IDs, status management, and role-based work areas. |

## Future Enhancements

The following enhancements are planned for the completed Global Automotive
Ecosystem:

- Implement role-based login with securely hashed passwords.
- Add administrator CRUD screens for enterprises, organizations, employees,
  and user accounts.
- Integrate Java Faker for expanded randomized configuration data.
- Add a network reporting dashboard for open requests, cross-enterprise work,
  recall completion, and delivery performance.
- Implement the VIN-based recall and compliance workflow.
- Implement post-warranty service, parts replenishment, and trade-in workflows.
- Persist ecosystem data in a relational database.
- Add email or SMS notifications for recalls, order milestones, and service
  appointments.
- Add audit logging for status changes and administrator actions.

## Contribution Breakdown

| Team Member | Assigned Use Case | Current / Planned Coding Contributions | Documentation | Testing | Other Contributions |
|-------------|-------------------|----------------------|---------------|---------|---------------------|
| Nicholas Woodward | Custom Vehicle Order and Global Supply Chain Fulfillment | Custom-order model, validation, lifecycle work area, and order testing | README, use-case documentation | Tests order creation, deposit validation, and status transitions | Supports slides and project integration |
| Meredith Molyneux | Cross-Border Regulatory Recall and Compliance Management | VIN lookup, recall notification, and compliance repair tracking (in progress) | Recall use-case documentation | Recall identification and completion reporting tests (planned) | Supports quality and reporting design |
| Ajay Alamuri | Parts Supplier Enterprise | Parts Acquisition + Backordering, Shipment Processing + Routing, Admin Work Area + Responsibilities, Logistics Coordinator Work Area + Responsibilities, Warehouse Clerk Work Area + Responsibilities, Initial Application Structuring + Formatting  | Functional Comments, UML Diagram | Admin, Logistics Coordinator, Warehouse Clerk | GitHub Integration, Business Model Implementation, Application Testing |

Each team member contributes to planning, code review, integration testing,
documentation, and the final presentation. Update this section as individual
features and pull requests are completed.
