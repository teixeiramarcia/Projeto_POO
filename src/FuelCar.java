import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Service here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190401
 */

public class FuelCar extends Car {
    private double currentFuel;
    private double fuelConsumeKM;
    private double totalFuel;

    public FuelCar() {
        super();
        this.currentFuel = 0;
        this.fuelConsumeKM = 0;
        this.totalFuel = 0;
    }

    public FuelCar(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                   Proprietary proprietary, String licensePlate, int liability, double currentFuel, double fuelConsumeKM,
                   double totalFuel) {
        super(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentFuel = currentFuel;
        this.fuelConsumeKM = fuelConsumeKM;
        this.totalFuel = totalFuel;
    }

    public FuelCar(FuelCar fuelCar) {
        super(fuelCar);
        this.currentFuel = fuelCar.getCurrentFuel();
        this.fuelConsumeKM = fuelCar.getFuelConsumeKM();
        this.totalFuel = fuelCar.getTotalFuel();
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getFuelConsumeKM() {
        return fuelConsumeKM;
    }

    public void setFuelConsumeKM(double fuelConsumeKM) {
        this.fuelConsumeKM = fuelConsumeKM;
    }

    public double getTotalFuel() {
        return totalFuel;
    }

    public void setTotalFuel(double totalFuel) {
        this.totalFuel = totalFuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FuelCar fuelCar = (FuelCar) o;
        return Double.compare(fuelCar.currentFuel, currentFuel) == 0 &&
                Double.compare(fuelCar.fuelConsumeKM, fuelConsumeKM) == 0 &&
                Double.compare(fuelCar.totalFuel, totalFuel) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuel, fuelConsumeKM, totalFuel);
    }

    @Override
    public String toString() {
        return "FuelCar{" +
                super.toString() +
                ", currentFuel=" + currentFuel +
                ", fuelConsumeKM=" + fuelConsumeKM +
                ", totalFuel=" + totalFuel +
                '}';
    }

    public FuelCar clone() {
        FuelCar newFuelCar = (FuelCar) super.clone();
        newFuelCar.setCurrentFuel(this.currentFuel);
        newFuelCar.setFuelConsumeKM(this.fuelConsumeKM);
        newFuelCar.setTotalFuel(this.totalFuel);
        return newFuelCar;
    }

    public double getAutonomy() {
        return currentFuel * fuelConsumeKM;
    }

    public double getTotalAutonomy() {
        return totalFuel * fuelConsumeKM;
    }

    public void decreaseFuel (double dist){
        double fuelAfterTrip = currentFuel -(dist * fuelConsumeKM);
        setCurrentFuel(fuelAfterTrip);
    }
}
