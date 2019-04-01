import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Write a description of class Service here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190401
 */

public class Service {
    private List<FuelCar> fuelCars;
    private List<ElectricCar> electricCars;
    private List<HybridCar> hybridCars;

    public List<FuelCar> getFuelCars() {
        return fuelCars;
    }

    public void setFuelCars(List<FuelCar> fuelCars) {
        this.fuelCars = fuelCars;
    }

    public List<ElectricCar> getElectricCars() {
        return electricCars;
    }

    public void setElectricCars(List<ElectricCar> electricCars) {
        this.electricCars = electricCars;
    }

    public List<HybridCar> getHybridCars() {
        return hybridCars;
    }

    public void setHybridCars(List<HybridCar> hybridCars) {
        this.hybridCars = hybridCars;
    }

    /**
     * Returns estimated cost for the trip or -1 if it doesn't have autonomy.
     *
     * @param start
     * @param finish
     * @param car
     * @return
     */
    public double canMakeTrip(Point start, Point finish, Car car) {
        double distance = distance(start, finish);
        double autonomyNow = getCurrentAutonomy(car);
        double autonomyTotal = getTotalAutonomy(car);

        if (autonomyNow < (autonomyTotal * 0.1) || autonomyNow < distance) {
            return -1;
        }

        return tripCost(distance, car);
    }

    private double distance(Point start, Point finish) {
        double coordX = Math.pow(Math.abs(start.getX() - finish.getX()), 2);
        double coordY = Math.pow(Math.abs(start.getY() - finish.getY()), 2);

        return (Math.sqrt(coordX + coordY));
    }

    private double getCurrentAutonomy(Car car) {
        double autonomy = 0;

        if (car.getClass().equals(ElectricCar.class)) {
            autonomy = ((ElectricCar) car).getAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getAutonomy();
        }

        return autonomy;
    }

    private double getTotalAutonomy(Car car) {
        double autonomy = 0;

        if (car.getClass().equals(ElectricCar.class)) {
            autonomy = ((ElectricCar) car).getTotalAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getTotalAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getTotalAutonomy();
        }

        return autonomy;
    }

    private double tripCost(double distance, Car car) {
        return car.getPriceKm() * distance;
    }

    private double timeClientToCar(Client client, Car car) {
        double dist = distance(client.getLocation(), car.getLocation());

        return (dist * 60) / 4;
    }

    public Rental createRental(Car rentedCar, Client client, Point finalPos, LocalDateTime useStartDate) {
        Rental rental = new Rental(rentedCar, client, rentedCar.getLocation(), finalPos, "Pendente",
                LocalDateTime.now(), useStartDate, null, -1);

        rentedCar.getPastRents().add(rental);
        client.getRentals().add(rental);
        rentedCar.getProprietary().getRented().add(rental);

        return rental;
    }
}
