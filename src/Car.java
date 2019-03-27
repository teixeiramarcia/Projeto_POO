import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Car here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 *
 * @version 20190326
 */
public class Car {
    private int mediumSpeed;
    private double priceKm;
    private double consumeKm;
    private List<Rental> pastRents;
    private int rating;
    private Point location;
    private Proprietary proprietary;
    private String licensePlate;
    private double autonomyATM;

    public Car (){
        this.mediumSpeed = 0;
        this.priceKm = 0;
        this.consumeKm = 0;
        this.pastRents = new ArrayList<>();
        this.rating = 0;
        this.location = new Point(0,0);
        this.proprietary = new Proprietary();
        this.licensePlate = "";
        this.autonomyATM = 0;
    }

    public Car (int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents, int rating, Point location,
                Proprietary proprietary, String licensePlate, double autonomyATM){
        this.mediumSpeed = mediumSpeed;
        this.priceKm = priceKm;
        this.consumeKm = consumeKm;
        this.pastRents = pastRents;
        this.rating = rating;
        this.location = location;
        this.proprietary = proprietary;
        this.licensePlate = licensePlate;
        this.autonomyATM = autonomyATM;
    }

    public Car (Car car){
        this.mediumSpeed = car.getMediumSpeed();
        this.priceKm = car.getPriceKm();
        this.consumeKm = car.getConsumeKm();
        this.pastRents = car.getPastRents();
        this.rating = car.getRating();
        this.location = car.getLocation();
        this.proprietary = car.getProprietary();
        this.licensePlate = car.getLicensePlate();
        this.autonomyATM = car.getAutonomyATM();
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

    public double getAutonomyATM() {
        return autonomyATM;
    }

    public void setAutonomyATM(double autonomyATM) {
        this.autonomyATM = autonomyATM;
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
                Double.compare(car.autonomyATM, autonomyATM) == 0 &&
                Objects.equals(pastRents, car.pastRents) &&
                Objects.equals(location, car.location) &&
                Objects.equals(proprietary, car.proprietary) &&
                Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediumSpeed, priceKm, consumeKm, pastRents, rating, location, proprietary, licensePlate, autonomyATM);
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
                ", proprietary=" + proprietary +
                ", licensePlate='" + licensePlate + '\'' +
                ", autonomyATM=" + autonomyATM +
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
        newCar.setProprietary(this.proprietary);
        newCar.setLicensePlate(this.licensePlate);
        newCar.setAutonomyATM(this.autonomyATM);
        return newCar;
    }
}
