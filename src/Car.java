import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Car here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190326
 */

public class Car {
    private int mediumSpeed;
    private double priceKm;
    private List<Rental> pastRents;
    private int rating;
    private Point location;
    private Proprietary proprietary;
    private String licensePlate;
    private int liability;

    public Car() {
        this.mediumSpeed = 0;
        this.priceKm = 0;
        this.pastRents = new ArrayList<>();
        this.rating = -1;
        this.location = new Point(-1, -1);
        this.proprietary = new Proprietary();
        this.licensePlate = "N/A";
        this.liability = -1;
    }

    public Car(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
               Proprietary proprietary, String licensePlate, int liability) {
        this.mediumSpeed = mediumSpeed;
        this.priceKm = priceKm;
        this.pastRents = pastRents;
        this.rating = rating;
        this.location = location;
        this.proprietary = proprietary;
        this.licensePlate = licensePlate;
        this.liability = liability;
    }

    public Car(Car car) {
        this.mediumSpeed = car.getMediumSpeed();
        this.priceKm = car.getPriceKm();
        this.pastRents = car.getPastRents();
        this.rating = car.getRating();
        this.location = car.getLocation();
        this.proprietary = car.getProprietary();
        this.licensePlate = car.getLicensePlate();
        this.liability = car.getLiability();
    }

    public int getMediumSpeed() {
        return mediumSpeed;
    }

    public void setMediumSpeed(int mediumSpeed) {
        this.mediumSpeed = mediumSpeed;
    }

    public double getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    public List<Rental> getPastRents() {
        return pastRents;
    }

    public void setPastRents(List<Rental> pastRents) {
        this.pastRents = pastRents;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Proprietary getProprietary() {
        return proprietary;
    }

    public void setProprietary(Proprietary proprietary) {
        this.proprietary = proprietary;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getLiability() {
        return liability;
    }

    public void setLiability(int liability) {
        this.liability = liability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mediumSpeed == car.mediumSpeed &&
                Double.compare(car.priceKm, priceKm) == 0 &&
                rating == car.rating &&
                Objects.equals(pastRents, car.pastRents) &&
                Objects.equals(location, car.location) &&
                Objects.equals(proprietary, car.proprietary) &&
                Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "mediumSpeed=" + mediumSpeed +
                ", priceKm=" + priceKm +
                ", pastRents=" + pastRents +
                ", rating=" + rating +
                ", location=" + location +
                ", proprietary=" + proprietary +
                ", licensePlate='" + licensePlate + '\'' +
                ", liability=" + liability +
                '}';
    }

    public Car clone() {
        Car newCar = new Car();
        newCar.setMediumSpeed(this.mediumSpeed);
        newCar.setPriceKm(this.priceKm);
        newCar.setPastRents(this.pastRents);
        newCar.setRating(this.rating);
        newCar.setLocation(this.location);
        newCar.setProprietary(this.proprietary);
        newCar.setLicensePlate(this.licensePlate);
        newCar.setLiability(this.liability);
        return newCar;
    }
}
