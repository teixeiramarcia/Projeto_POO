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

public class ElectricCar extends Car {
    private double currentBattery;
    private double batteryConsumeKM;
    private double totalBattery;

    public ElectricCar() {
        super();
        this.currentBattery = 0;
        this.batteryConsumeKM = 0;
        this.totalBattery = 0;
    }

    public ElectricCar(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                       Proprietary proprietary, String licensePlate, double currentBattery, double batteryConsumeKM,
                       double totalBattery) {
        super(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate);
        this.currentBattery = currentBattery;
        this.batteryConsumeKM = batteryConsumeKM;
        this.totalBattery = totalBattery;
    }

    public ElectricCar(ElectricCar electricCar) {
        super(electricCar);
        this.currentBattery = electricCar.getCurrentBattery();
        this.batteryConsumeKM = electricCar.getBatteryConsumeKM();
        this.totalBattery = electricCar.getTotalBattery();
    }

    public double getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(double currentBattery) {
        this.currentBattery = currentBattery;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return Double.compare(that.currentBattery, currentBattery) == 0 &&
                Double.compare(that.batteryConsumeKM, batteryConsumeKM) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentBattery, batteryConsumeKM, totalBattery);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                super.toString() +
                ", currentBattery=" + currentBattery +
                ", batteryConsumeKM=" + batteryConsumeKM +
                ", totalBattery=" + totalBattery +
                '}';
    }

    public ElectricCar clone() {
        ElectricCar newElectricCar = (ElectricCar) super.clone();
        newElectricCar.setCurrentBattery(this.currentBattery);
        newElectricCar.setBatteryConsumeKM(this.batteryConsumeKM);
        newElectricCar.setTotalBattery(this.totalBattery);
        return newElectricCar;
    }

    public double getAutonomy() {
        return currentBattery * batteryConsumeKM;
    }

    public double getTotalAutonomy() {
        return totalBattery * batteryConsumeKM;
    }
}
