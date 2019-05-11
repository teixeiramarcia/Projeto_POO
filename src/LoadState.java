import java.awt.geom.Point2D;
import java.util.Map;

/**
 * Write a description of class LoadState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoadState {
    private Map<String, Proprietary> allProprietaries;
    private Map<String, Client> allClients;
    private Map<String, FuelCar> fuelCars;
    private Map<String, ElectricCar> electricCars;
    private Map<String, HybridCar> hybridCars;

    public LoadState(Map<String, Proprietary> allProprietaries, Map<String, Client> allClients,
                     Map<String, FuelCar> fuelCars, Map<String, ElectricCar> electricCars,
                     Map<String, HybridCar> hybridCars) {
        this.allProprietaries = allProprietaries;
        this.allClients = allClients;
        this.fuelCars = fuelCars;
        this.electricCars = electricCars;
        this.hybridCars = hybridCars;
    }

    public Car createCar(String newCar) throws CarTypeDoesNotExistException {
        String[] parts = newCar.split(",");

        Car car;

        switch (parts[0]) {
            case "Hibrido":
                car = new HybridCar();
                setHybridCarAutonomy(parts, (HybridCar) car);
                break;
            case "Electrico":
                car = new ElectricCar();
                setElectricCarAutonomy(parts, (ElectricCar) car);
                break;
            case "Gasolina":
                car = new FuelCar();
                setFuelCarAutonomy(parts, (FuelCar) car);
                break;
            default:
                throw new CarTypeDoesNotExistException(parts[0]);
        }

        car.setBrand(parts[1]);
        car.setLicensePlate(parts[2]);
        car.setProprietary(allProprietaries.get(parts[3]));
        car.setMediumSpeed(Integer.parseInt(parts[4]));
        car.setPriceKm(Integer.parseInt(parts[5]));
        car.setConsumeKm(Double.parseDouble(parts[6]));
        Point2D.Double newPoint = new Point2D.Double((Double.parseDouble(parts[8])), (Double.parseDouble(parts[9])));
        car.setLocation(newPoint);
        return car;
    }

    private void setHybridCarAutonomy(String[] parts, HybridCar car) {
        double autonomy, fuelAutonomy, batteryAutonomy;
        autonomy = Double.parseDouble(parts[7]);
        fuelAutonomy = batteryAutonomy = autonomy / 2;
        car.setCurrentBatteryAutonomy(batteryAutonomy);
        car.setCurrentFuelAutonomy(fuelAutonomy);
    }

    private void setElectricCarAutonomy(String[] parts, ElectricCar car) {
        double autonomy = Double.parseDouble(parts[7]);
        car.setCurrentBatteryAutonomy(autonomy);
    }

    private void setFuelCarAutonomy(String[] parts, FuelCar car) {
        double autonomy = Double.parseDouble(parts[7]);
        car.setCurrentFuelAutonomy(autonomy);
    }

    public RentalRequest createRentalRequest(String newRentalRequest) {
        String[] parts = newRentalRequest.split(",");

        RentalRequest rentalRequest = new RentalRequest();

        rentalRequest.setClient(allClients.get(parts[0]));
        Point2D.Double newPoint = new Point2D.Double((Double.parseDouble(parts[1])), (Double.parseDouble(parts[2])));
        rentalRequest.setDestiny(newPoint);
        rentalRequest.setFuelType(parts[3]);
        rentalRequest.setPreference(parts[4]);
        return rentalRequest;
    }

    public void updateRating(String newRating) throws LicensePlateDoesNotExistException, NifDoesNotExistException {
        // EI-19-73,80 ou 174433477,47
        String[] parts = newRating.split(",");

        String identifier = parts[0];

        if (identifier.charAt(2) == '-') {
            updateCarRating(parts[0], Integer.parseInt(parts[1]));
        } else if (identifier.charAt(2) != '-') {
            updateClientRating(parts[2], Integer.parseInt(parts[1]));
        }
    }

    public void updateCarRating(String plate, int rating) throws LicensePlateDoesNotExistException {
        if (fuelCars.containsKey(plate)) {
            fuelCars.get(plate).setRating(rating);
        } else if (electricCars.containsKey(plate)) {
            electricCars.get(plate).setRating(rating);
        } else if (hybridCars.containsKey(plate)) {
            hybridCars.get(plate).setRating(rating);
        } else {
            throw new LicensePlateDoesNotExistException(plate);
        }
    }

    public void updateClientRating(String nif, int rating) throws NifDoesNotExistException {
        if (allClients.containsKey(nif)) {
            allClients.get(nif).setRating(rating);
        } else if (allProprietaries.containsKey(nif)) {
            allProprietaries.get(nif).setRating(rating);
        } else throw new NifDoesNotExistException(nif);
    }

}
