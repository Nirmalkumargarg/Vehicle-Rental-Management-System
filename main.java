import java.util.Scanner;     

class Vehicle {
    int id;
    String name;
    double rent;
    boolean available;

    Vehicle(int id, String name, double rent) {
        this.id = id;
        this.name = name;
        this.rent = rent;
        this.available = true;
    }

    void display() {
        System.out.println(id + ". " + name
                + " - Rs. " + rent
                + " per day - "
                + (available ? "Available" : "Rented"));
    }
}

public class VehicleRentalManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehicle v1 = new Vehicle(1, "Maruti Swift", 2000);
        Vehicle v2 = new Vehicle(2, "Hyundai i10", 1800);
        Vehicle v3 = new Vehicle(3, "Honda Activa", 500);

        int choice;

        do {
            System.out.println("\n===== VEHICLE RENTAL SYSTEM =====");
            System.out.println("1. View Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                v1.display();
                v2.display();
                v3.display();
            }

            else if (choice == 2) {
                System.out.print("Enter vehicle ID: ");
                int id = sc.nextInt();

                Vehicle selected = null;

                if (id == 1) {
                    selected = v1;
                } else if (id == 2) {
                    selected = v2;
                } else if (id == 3) {
                    selected = v3;
                }

                if (selected == null) {
                    System.out.println("Invalid vehicle ID.");
                } else if (!selected.available) {
                    System.out.println("Vehicle is already rented.");
                } else {
                    System.out.print("Enter rental days: ");
                    int days = sc.nextInt();

                    if (days <= 0) {
                        System.out.println("Enter valid rental days.");
                    } else {
                        double total = selected.rent * days;
                        selected.available = false;

                        System.out.println("Vehicle rented successfully!");
                        System.out.println("Total Rent: Rs. " + total);
                    }
                }
            }

            else if (choice == 3) {
                System.out.print("Enter vehicle ID: ");
                int id = sc.nextInt();

                Vehicle selected = null;

                if (id == 1) {
                    selected = v1;
                } else if (id == 2) {
                    selected = v2;
                } else if (id == 3) {
                    selected = v3;
                }

                if (selected == null) {
                    System.out.println("Invalid vehicle ID.");
                } else if (selected.available) {
                    System.out.println("This vehicle is not rented.");
                } else {
                    selected.available = true;
                    System.out.println("Vehicle returned successfully!");
                }
            }

            else if (choice == 4) {
                System.out.println("Thank you for using the system!");
            }

            else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
