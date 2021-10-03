package PackFATPrep;

import java.util.Scanner;

class Passenger {
    String ID;
    String name;
    int age;
    String gender;
    boolean single;
    String source;
    String destn;
    double price;
    int category;

    void getMethod(Scanner scanner) {
        System.out.println("Enter details: ");
        ID = scanner.nextLine();
        name = scanner.nextLine();
        age = scanner.nextInt();
        gender = scanner.next();
        source = scanner.nextLine();
        destn = scanner.nextLine();
    }

    void discount() {
        double discount = 0;
        category = 4;
        if ((gender.equals("M") && age >= 60) || (gender.equals("F") && age >= 55)) {
            category = 1;
            discount = 0.2;
        } else if ((gender.equals("M") && age >= 55) || (gender.equals("F") && age >= 50)) {
            category = 2;
            discount = 0.15;
        }
        discount += single && age >= 50 ? 0.1 : 0;
        category = single && age >= 50 ? 3 : category;
        price -= discount * price;
    }
}

public class Passengers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of users: ");
        final int n = scanner.nextInt();
        Passenger[] users = new Passenger[n];
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < users.length; i++) {
                    users[i] = new Passenger();
                    users[i].getMethod(scanner);
                }
            }
        };

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread() {
            public void run() {
                int[] noOfPassengersInCategory = new int[4];
                for (int i = 0; i < users.length; i++) {
                    users[i].discount();
                    noOfPassengersInCategory[users[i].category]++;
                }
                System.out.println("Cat-1\t\tCat-2\t\tCat-3\t\tCat-4");
                for (int cat : noOfPassengersInCategory) {
                    System.out.println(cat + "\t\t");
                }
            }
        };
        thread2.start();
        scanner.close();
    }
}
