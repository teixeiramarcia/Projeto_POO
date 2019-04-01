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

public class HybridCar extends Car {
    private double currentFuel;
    private double currentBattery;
    private double fuelConsumeKM;
    private double batteryConsumeKM;
    private double totalBattery;
    private double totalFuel;

    public HybridCar() {
        super();
        this.currentFuel = 0;
        this.currentBattery = 0;
        this.fuelConsumeKM = 0;
        this.batteryConsumeKM = 0;
        this.totalBattery = 0;
        this.totalFuel = 0;
    }

    public HybridCar(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                     Proprietary proprietary, String licensePlate, double currentFuel, double currentBattery,
                     double fuelConsumeKM, double batteryConsumeKM, double totalBattery, double totalFuel) {
        super(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate);
        this.currentFuel = currentFuel;
        this.currentBattery = currentBattery;
        this.fuelConsumeKM = fuelConsumeKM;
        this.batteryConsumeKM = batteryConsumeKM;
        this.totalBattery = totalBattery;
        this.totalFuel = totalFuel;
    }

    public HybridCar(HybridCar hybridCar) {
        super(hybridCar);
        this.currentFuel = hybridCar.getCurrentFuel();
        this.currentBattery = hybridCar.getCurrentBattery();
        this.fuelConsumeKM = hybridCar.getFuelConsumeKM();
        this.batteryConsumeKM = hybridCar.getBatteryConsumeKM();
        this.totalBattery = hybridCar.getTotalBattery();
        this.totalFuel = hybridCar.getTotalFuel();
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(double currentBattery) {
        this.currentBattery = currentBattery;
    }

    public double getFuelConsumeKM() {
        return fuelConsumeKM;
    }

    public void setFuelConsumeKM(double fuelConsumeKM) {
        this.fuelConsumeKM = fuelConsumeKM;
    }

    public double getBatteryConsumeKM() {
        return batteryConsumeKM;
    }

    public void setBatteryConsumeKM(double batteryConsumeKM) {
        this.batteryConsumeKM = batteryConsumeKM;
    }

    public double getTotalBattery() {
        return totalBattery;
    }

    public void setTotalBattery(double totalBattery) {
        this.totalBattery = totalBattery;
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
        HybridCar hybridCar = (HybridCar) o;
        return Double.compare(hybridCar.currentFuel, currentFuel) == 0 &&
                Double.compare(hybridCar.currentBattery, currentBattery) == 0 &&
                Double.compare(hybridCar.fuelConsumeKM, fuelConsumeKM) == 0 &&
                Double.compare(hybridCar.batteryConsumeKM, batteryConsumeKM) == 0 &&
                Double.compare(hybridCar.totalBattery, totalBattery) == 0 &&
                Double.compare(hybridCar.totalFuel, totalFuel) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuel, currentBattery, fuelConsumeKM, batteryConsumeKM, totalBattery, totalFuel);
    }

    @Override
    public String toString() {
        return "HybridCar{" +
                super.toString() +
                ", currentFuel=" + currentFuel +
                ", currentBattery=" + currentBattery +
                ", fuelConsumeKM=" + fuelConsumeKM +
                ", batteryConsumeKM=" + batteryConsumeKM +
                ", totalBattery=" + totalBattery +
                ", totalFuel=" + totalFuel +
                '}';
    }

    public HybridCar clone() {
        HybridCar newHybridCar = (HybridCar) super.clone();
        newHybridCar.setCurrentFuel(this.currentFuel);
        newHybridCar.setCurrentBattery(this.currentBattery);
        newHybridCar.setFuelConsumeKM(this.fuelConsumeKM);
        newHybridCar.setBatteryConsumeKM(this.batteryConsumeKM);
        newHybridCar.setTotalBattery(this.totalBattery);
        newHybridCar.setTotalFuel(this.totalFuel);
        return newHybridCar;
    }

    public double getAutonomy() {
        return (currentFuel * fuelConsumeKM) + (currentBattery * batteryConsumeKM);
    }

    public double getTotalAutonomy(){
        return (totalFuel * fuelConsumeKM) + (totalBattery * batteryConsumeKM);
    }
}
