import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
         File f = new File("Car_Data.csv");
    System.out.println("Checking for file at: " + f.getAbsolutePath());
    if (f.exists()) {
        System.out.println("✅ File found!");
    } else {
        System.out.println("❌ File NOT found at this location.");
    }
    
        
        // 1. Load data once into the ArrayList
        ArrayList<Car> carList = loadCar("Car_Data.csv");
        Scanner input = new Scanner(System.in);
        int choice = 0;

        // 2. Menu System
        while (choice != 5) {
            System.out.println("\nMenu for Project A");
            System.out.println("1. Sort (by Brand)");
            System.out.println("2. Search by Brand (Exact Match)");
            System.out.println("3. Search by Fuel_Type");
            System.out.println("4. Show found car objects & stats");
            System.out.println("5. Exit");
            System.out.print("Selection: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Clear buffer // clear buffer 
            } else {
                input.nextLine();
                continue;
            }

            if (choice == 1) {
                selectionSort(carList);
                System.out.println("List sorted by Brand.");
            } else if (choice == 2) {
                System.out.print("Enter Brand to search: ");
                String target = input.nextLine();
                int index = binarySearch(carList, target);
                if (index != -1) {
                    System.out.println("Found: " + carList.get(index));
                } else {
                    System.out.println("Brand not found. (Note: List must be sorted first!)");
                }
            } else if (choice == 3) {
                System.out.print("Enter Fuel Type to search: ");
                String fuelType = input.nextLine();
                System.out.println("Cars with Fuel Type " + fuelType + ":");
                for (Car c : carList) {
                    if (c.getFuel_Type().equalsIgnoreCase(fuelType)) {
                        System.out.println(c);
                    }
                }
            } else if (choice == 4) {
                printStats(carList);
            }
        }
        input.close();
    }

    // Step 2 — Load the CSV logic
    public static ArrayList<Car> loadCar(String fileName) {
        ArrayList<Car> list = new ArrayList<>();
        int loadedCount = 2000;

        try (Scanner reader = new Scanner(new File(fileName))) {
            if (reader.hasNextLine()) reader.nextLine(); // Skip header

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");

                // Skips malformed rows safely (expects 7 columns)
                if (data.length >= 7) {
                    try {
                        String Car_id = data[0].trim();
                        String brand = data[1].trim();
                        String model = data[2].trim();
                        int year = Integer.parseInt(data[3].trim());
                        String fuel = data[4].trim();
                        String color = data[5].trim();
                        double mileage = Double.parseDouble(data[6].trim());

                        list.add(new Car(Car_id, brand, model,year, fuel, color, mileage));
                        loadedCount++;
                    } catch (NumberFormatException e) {
                        // Skip row if numbers are invalid
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + fileName + "' not found.");
        }

        System.out.println("Total cars loaded: " + loadedCount);
        return list;
    }

    public static void selectionSort(ArrayList<Car> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getBrand().compareToIgnoreCase(list.get(minIdx).getBrand()) < 0) {
                    minIdx = j;
                }
            }
            Collections.swap(list, i, minIdx);
        }
    }

    public static int binarySearch(ArrayList<Car> list, String target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = target.compareToIgnoreCase(list.get(mid).getBrand());
            if (res == 0) return mid;
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void printStats(ArrayList<Car> list) {
        System.out.println("\n--- Car Inventory ---");
        for (Car c : list) {
            System.out.println(c);
        }
        System.out.println("Total count: " + list.size());
    }
}