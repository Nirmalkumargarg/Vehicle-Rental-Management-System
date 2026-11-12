import java.util.Scanner;
class Vehicle {
    int ID;
    String Name;
    double Rent;
    boolean Available;
    Vehicle(int ID, String Name, double Rent) {
        this.ID = ID;
        this.Name = Name;
        this.Rent = Rent;
        this.Available = true;
    }
    void display() {
        System.out.println(ID + ". " + Name + " - Rs. " + Rent + " per day - " + (Available ? "Available" : "Rented"));
         }
}
public class VRMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle v1 = new Vehicle(1, "Bmw X1", 25000);
        Vehicle v2 = new Vehicle(2, "Mahindra Thar", 12000);
        Vehicle v3 = new Vehicle(3, "Honda City", 2100);
        Vehicle v4 = new Vehicle(4, "Hyundai i20", 1800);
        int choice;
        do {
            System.out.println("\n======= Main Menu =======");
            System.out.println("1. Show Vehicles");
            System.out.println("2. Rent Now");
            System.out.println("3. Return Car");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                v1.display();
                v2.display();
                v3.display();
                v4.display();
            }
            else if (choice == 2) {
                System.out.print("Enter Vehicle ID: ");
                int id = sc.nextInt();
                Vehicle selected = null;
                if (id == 1) {
                    selected = v1;
                } else if (id == 2) {
                    selected = v2;
                } else if (id == 3) {
                    selected = v3;
                } else if (id == 4) {
                    selected = v4;
                }
                if (selected == null) {
                    System.out.println("Invalid Vehicle ID.");
                } else if (!selected.Available) {
                    System.out.println("Vehicle is already rented.");
                } else {
                    System.out.print("Enter rental days: ");
                    int days = sc.nextInt();

                    if (days <= 0) {
                        System.out.println("Enter valid rental days.");
                    } else {
                        double total = selected.Rent * days;
                        selected.Available = false;
                        System.out.println(
                                "Vehicle rented successfully.");
                        System.out.println(
                                "Total rent: Rs. " + total);
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
                } else if (id == 4) {
                    selected = v4;
                }
                if (selected == null) {
                    System.out.println("Invalid vehicle ID.");
                } else if (selected.Available) {
                    System.out.println(
                            "This vehicle is not rented.");
                } else {
                    selected.Available = true;
                    System.out.println(
                            "Vehicle returned successfully!");
                }
            }
            else if (choice == 4) {
                System.out.println(
                        "Thank you for using the system!");
            }
            else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}
