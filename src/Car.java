import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car {
    private int mediumSpeed;
    private double priceKm;
    private double consumeKm;
    private List<Rental> pastRents;
    private int rating;
    private Point location;

    public Car (){
        this.mediumSpeed = 0;
        this.priceKm = 0;
        this.consumeKm = 0;
        this.pastRents = new ArrayList<>();
        this.rating = 0;
        this.location = new Point(0,0);
    }

    public Car (int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents, int rating, Point location){
        this.mediumSpeed = mediumSpeed;
        this.priceKm = priceKm;
        this.consumeKm = consumeKm;
        this.pastRents = pastRents;
        this.rating = rating;
        this.location = location;
    }

    public Car (Car car){
        this.mediumSpeed = car.getMediumSpeed();
        this.priceKm = car.getPriceKm();
        this.consumeKm = car.getConsumeKm();
        this.pastRents = car.getPastRents();
        this.rating = car.getRating();
        this.location = car.getLocation();
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

    public double getConsumeKm() {
        return consumeKm;
    }

    public void setConsumeKm(double consumeKm) {
        this.consumeKm = consumeKm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mediumSpeed == car.mediumSpeed &&
                Double.compare(car.priceKm, priceKm) == 0 &&
                Double.compare(car.consumeKm, consumeKm) == 0 &&
                rating == car.rating &&
                Objects.equals(pastRents, car.pastRents) &&
                Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediumSpeed, priceKm, consumeKm, pastRents, rating, location);
    }

    @Override
    public String toString() {
        return "Car{" +
                "mediumSpeed=" + mediumSpeed +
                ", priceKm=" + priceKm +
                ", consumeKm=" + consumeKm +
                ", pastRents=" + pastRents.toString() +
                ", rating=" + rating +
                ", location=" + location.toString() +
                '}';
    }

    public Car clone(){
        Car newCar = new Car();
        newCar.setMediumSpeed(this.mediumSpeed);
        newCar.setPriceKm(this.priceKm);
        newCar.setConsumeKm(this.consumeKm);
        newCar.setPastRents(this.pastRents);
        newCar.setRating(this.rating);
        newCar.setLocation(this.location);
        return newCar;
    }
}
