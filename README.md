![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/1681e8e1-1419-45dd-ab86-594ffe1122e7)# Cab-Booking-App

## Project Overview
This project is a comprehensive cab booking application developed using Java, MySQL, and Scene Builder JavaFXML for an OOP project. The application provides a seamless interface for both customers and riders, offering functionalities like user registration, ride booking, and trip history management.

## Features:
* **User Authentication**: Separate login and signup options for customers and riders.
* **Profile Management**: View and edit personal details for both customers and riders.
* **Ride Booking**: Customers can book rides by selecting vehicle type, pickup, and destination locations.
* **Ride Matching**: The system searches for available riders in the customer's pickup location.
* **Real-time Updates**: Refresh functionalities to check for ride acceptance or new ride requests.
* **Trip History**: Both customers and riders can view their previous rides.

### Customer
When customers login, they have the following options:

**Profile**: View and edit personal details.
**My Trips**: View previous rides information.
**Logout**: Return to the login page.
**Book Now**: Go to the book ride page to select a vehicle type, pickup, and destination location. If no rider is in the pickup location, it will return 'Sorry, no riders found'. If there is a rider, it will display 'Searching for riders' until a rider accepts the ride.
**Refresh**: Refresh the page to check if the ride is accepted. If accepted, a message will pop up with the rider information.
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/b359b3b0-67d0-4655-943e-b180a26e59af)
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/2080a7c8-5fea-4fbe-bd05-49af28e13d29)



### Rider
When riders login, they have the following options:

**Profile**: View and edit personal details.
**My Trips**: View previous rides information.
**Logout**: Return to the login page.
**Current Location**: Change current location to get rides more easily near their close location.
**Refresh**: Refresh the page to check if someone requested a ride near their location. If a ride is requested, a message will pop up with the customer information and destination location, then the rider can choose to accept or not.

![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/221f6c83-5ad0-4c5a-a2c3-9ddff3bea750)
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/6eb2fc53-a647-4bdf-9e33-5f193e4fb4e4)
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/4ed00d3b-ef1c-46b3-ac3d-5af0a6c64503)


## Database
The database consists of four tables:

**Customer**: Stores customer information.
**Rider**: Stores rider information.
**Ride_Book**: A temporary table that stores data when a customer requests a ride. When a rider accepts the ride, the data is deleted.
**History**: Stores all ride information, including customer and rider details, pickup and destination locations, and the time the ride was booked.

## Technical Details

**Java**: Core programming language used for developing the application logic.
**MySQL**: Database management system used for storing user and ride information.
**Scene Builder JavaFXML**: Used for designing the graphical user interface (GUI).
**OOP Principles**: The project is designed following Object-Oriented Programming principles to ensure modularity, reusability, and maintainability of the codebase.

## Setup and Installation
**1. Clone the Repository:**
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/70cc2d75-acf8-4683-8081-7e50636456cc)

**2. Database Setup:**
* Install MySQL and create a database named cab.
* Import the provided SQL file to create necessary tables
![image](https://github.com/Ashar18/Cab-Booking-App/assets/64865488/6f543cb5-503e-42a3-a80a-d0cfb2c279c6)

**3. Build the Project:**
Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
Ensure all necessary dependencies are included.
Build and run the project.
