# MRP (Material Requirements Planning) Calculation System

## Overview

The Material Requirements Planning (MRP) Calculation System is designed to help manufacturers calculate the necessary materials for production orders. It takes into account the Bill of Materials (BOM) for the final product, the current inventory levels, and provides net material requirements as well as suggested procurement quantities. This ensures that production demands are met while optimizing material purchases and inventory management.

## Technologies Used

- **Frontend**: AngularJS (for capturing and displaying input/output data)
- **Backend**: Spring Boot (for handling the MRP calculation logic and serving data to the frontend)
- **Database**: MySQL (for storing BOM and inventory data)
- **Communication**: REST API (for exchanging data between the frontend and backend)

## Project Features

- Hierarchical BOM handling
- MRP calculation logic to determine material needs based on production orders
- Inventory net-off calculation
- Planned procurement order generation
- Simple, interactive UI for input and result visualization

## Requirements

1. **Bill of Materials (BOM)**: A hierarchical list of all the raw materials, components, and sub-assemblies required to manufacture a finished product.
2. **On-Hand Inventory Levels**: Current stock levels for all raw materials, components, and products.
3. **Production Demand**: The number of end-products that need to be manufactured.

The system uses these inputs to determine the net material requirements and generates procurement plans accordingly.

## Input

The inputs to the system are:

1. **BOM Structure**: A detailed breakdown of the materials and sub-assemblies required to produce the final product.
    - For example, to produce a bicycle, the following components are required:
      - 1 seat
      - 1 frame
      - 2 brake sets (each containing 1 brake paddle, 1 brake cable, 1 set of levers, and 2 brake shoes)
      - 1 handlebar
      - 2 wheels
      - 2 tires
      - 1 chain
      - 1 crank set
      - 2 pedals
2. **Inventory Levels**: Current stock levels for all materials.
    - Example:
      - Seat: 25 units
      - Frame: 35 units
3. **Production Requirement**: The number of finished products to be produced (e.g., 200 bicycles).

## Output

The system will provide two main outputs:

1. **Net Material Requirements**: This will be the total quantity of each material required after taking into account the available inventory.
   - For example, if you need 200 seats to assemble 200 bicycles but you already have 25 seats in stock, the net requirement will be 175 seats.
   
2. **Planned Procurement Orders**: Based on the net requirements, the system will generate a list of materials that need to be procured and in what quantities to meet the production target.
   - For example, 150 brake sets might need to be purchased if only 50 are currently available in the inventory and 200 are required for the production order.

## MRP Calculation Logic

1. **Recipe Explosion**: Breaks down the BOM structure to identify the total material requirements for the production order. 
   - Example: For 200 bicycles, you need 200 seats, 400 wheels, 200 crank sets, etc.
2. **Inventory Net-Off**: Subtracts the available stock from the total material requirements to determine the net requirements.
   - Example: If you need 200 seats but have 25 in stock, the net requirement will be 175 seats.
3. **Procurement Plan**: Based on the net requirements, the system will suggest planned purchase orders for any material that falls below the required level.

## Example Walkthrough

### Production Order: 200 Bicycles

- **BOM Structure**:
  - 1 seat per bicycle → 200 seats required
  - 2 wheels per bicycle → 400 wheels required
  - 1 frame per bicycle → 200 frames required
  - 2 tires per bicycle → 400 tires required
  - 2 brake sets per bicycle → 400 brake sets required

- **On-Hand Inventory**:
  - Seats: 25
  - Frames: 35
  - Wheels: 50

- **Net Material Requirements**:
  - Seats: 200 - 25 = 175
  - Frames: 200 - 35 = 165
  - Wheels: 400 - 50 = 350

- **Planned Procurement Orders**:
  - Seats: 175
  - Frames: 165
  - Wheels: 350

## UI Flow

1. **Input BOM & Inventory**: The user inputs the BOM structure and current inventory levels in the AngularJS UI.
2. **Run MRP Calculation**: The backend processes the input data using the MRP logic and calculates the net material requirements.
3. **Display Results**: The calculated net requirements and procurement plan are shown to the user in the UI.

## Screenshots
![image](https://github.com/user-attachments/assets/ec2e0283-1845-4c2f-bd3b-cc80f057ed3a)

![image](https://github.com/user-attachments/assets/a0782271-af6d-4266-bbdc-76bb95379098)

![image](https://github.com/user-attachments/assets/d86a621a-688e-4a73-8a66-ef40c8e59459)
