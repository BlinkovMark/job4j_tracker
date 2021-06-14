package ru.job4j.stream;

public class Car {
    private String type;
    private String brand;
    private String model;
    private int maxSpeed;
    private double zeroToHundred;
    private int price;
    private boolean inMotion;

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", zeroToHundred=" + zeroToHundred +
                ", price=" + price +
                ", inMotion=" + inMotion +
                '}';
    }

    static class Builder {
        private String type;
        private String brand;
        private String model;
        private int maxSpeed;
        private double zeroToHundred;
        private int price;
        private boolean inMotion;

        Builder buildType(String type) {
            this.type = "Sedan";
            return this;
        }

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }
        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildZeroToHundred(double zeroToHundred) {
            this.zeroToHundred = zeroToHundred;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Builder buildInMotion(boolean inMotion) {
            this.inMotion = inMotion;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.type = type;
            car.brand = brand;
            car.model = model;
            car.maxSpeed = maxSpeed;
            car.zeroToHundred = zeroToHundred;
            car.price = price;
            car.inMotion = inMotion;
            return car;
        }
     }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildType("Sedan")
                .buildBrand("Tesla")
                .buildModel("Model S Plaid")
                .buildMaxSpeed(322)
                .buildZeroToHundred(2.1)
                .buildPrice(119990)
                .buildInMotion(true)
                .build();
        System.out.println(car);
    }
}