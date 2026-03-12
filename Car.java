public class Car{
    private String car_ID;
    private String brand;
    private String model;
    private int year;
    private String Fuel_Type;
    private String color;
    private double mileage_kmpl;



    // Constructor
    public Car(String car_ID,String brand,String model,int year,String fuel_Type,String color,double mileage_kmpl) {
        this.car_ID = car_ID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.Fuel_Type =fuel_Type;
        this.color = color;
        this.mileage_kmpl = mileage_kmpl;
    }
    

    // Getters and setters
    public String getCar_ID() {return car_ID; }
    public void setCar_ID(String car_ID) { this.car_ID = car_ID; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) {this.brand = brand; }

    public String getModel() {return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getFuel_Type() { return Fuel_Type; }
    public void setFuel_Type(String fuel_Type) { this.Fuel_Type = fuel_Type; }

    public String getColor() { return color; }
    public void setcolor(String color) { this.color = color; }

    public double getMileage_kmpl() { return mileage_kmpl; }
    public void setMileage_kmpl(double mileage_kmpl) { this.mileage_kmpl = mileage_kmpl; }



    // Tostring method for printing car details
    @Override
    public String toString() {
        return "Car [car_ID =" + car_ID + ", Brand=" + brand + ", Models=" + model + ", Year=" + year + ", fuel=" + Fuel_Type + ", Color=" + color + ", Mileage=" + mileage_kmpl + "kmpl]";
    }
}