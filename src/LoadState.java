import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Classe que faz o carregamento inicial de dados para a aplicação.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */
public class LoadState implements Serializable {
    private Map<String, Proprietary> allProprietaries;
    private Map<String, Client> allClients;
    private Map<String, FuelCar> fuelCars;
    private Map<String, ElectricCar> electricCars;
    private Map<String, HybridCar> hybridCars;
    private Map<String, List<Rental>> rentals;

    /**
     * Construtor parametrizado.
     *
     * @param allProprietaries mapeamento de todos os proprietários no sistema
     * @param allClients       mapeamento de todos os clientes no sistema
     * @param fuelCars         mapeamento de todos os carros a combustível no sistema
     * @param electricCars     mapeamento de todos os carros elétricos no sistema
     * @param hybridCars       mapeamento de todos os carros híbridos no sistema
     */
    public LoadState(Map<String, Proprietary> allProprietaries, Map<String, Client> allClients,
                     Map<String, FuelCar> fuelCars, Map<String, ElectricCar> electricCars,
                     Map<String, HybridCar> hybridCars, Map<String, List<Rental>> rentals) {
        this.allProprietaries = allProprietaries;
        this.allClients = allClients;
        this.fuelCars = fuelCars;
        this.electricCars = electricCars;
        this.hybridCars = hybridCars;
        this.rentals = rentals;
    }

    /**
     * Método que a partir do carregamento inicial de dados do sistema faz a criação de carros.
     *
     * @param newCar novo carro a ser adicionado ao sistema
     * @throws CarTypeDoesNotExistException
     */
    public void createCar(String newCar) throws CarTypeDoesNotExistException {
        String[] parts = newCar.split(",");

        Car car;

        switch (parts[0]) {
            case "Hibrido":
                car = new HybridCar();
                hybridCars.put(parts[2], (HybridCar) car);
                setHybridCarAutonomy(parts, (HybridCar) car);
                break;
            case "Electrico":
                car = new ElectricCar();
                electricCars.put(parts[2], (ElectricCar) car);
                setElectricCarAutonomy(parts, (ElectricCar) car);
                break;
            case "Gasolina":
                car = new FuelCar();
                fuelCars.put(parts[2], (FuelCar) car);
                setFuelCarAutonomy(parts, (FuelCar) car);
                break;
            default:
                throw new CarTypeDoesNotExistException(parts[0]);
        }

        car.setBrand(parts[1]);
        car.setLicensePlate(parts[2]);

        Proprietary proprietary = allProprietaries.get(parts[3]);
        car.setProprietary(proprietary);
        proprietary.getCars().add(car);

        car.setMediumSpeed(Integer.parseInt(parts[4]));
        car.setPriceKm(Double.parseDouble(parts[5]));
        car.setConsumeKm(Double.parseDouble(parts[6]));
        Point2D.Double newPoint = new Point2D.Double((Double.parseDouble(parts[8])), (Double.parseDouble(parts[9])));
        car.setLocation(newPoint);
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece no carro Híbrido a sua autonomia.
     *
     * @param parts string com substrings que correspondem a cada componente do carro a ser registado
     * @param car   carro a ser registado
     */
    private void setHybridCarAutonomy(String[] parts, HybridCar car) {
        double autonomy, fuelAutonomy, batteryAutonomy;
        autonomy = Double.parseDouble(parts[7]);
        fuelAutonomy = batteryAutonomy = autonomy / 2;
        car.setCurrentBatteryAutonomy(batteryAutonomy);
        car.setCurrentFuelAutonomy(fuelAutonomy);
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece no carro Elétrico a sua autonomia.
     *
     * @param parts string com substrings que correspondem a cada componente do carro a ser registado
     * @param car   carro a ser registado
     */
    private void setElectricCarAutonomy(String[] parts, ElectricCar car) {
        double autonomy = Double.parseDouble(parts[7]);
        car.setCurrentBatteryAutonomy(autonomy);
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece no carro a Combustível a sua autonomia.
     *
     * @param parts string com substrings que correspondem a cada componente do carro a ser registado
     * @param car   carro a ser registado
     */
    private void setFuelCarAutonomy(String[] parts, FuelCar car) {
        double autonomy = Double.parseDouble(parts[7]);
        car.setCurrentFuelAutonomy(autonomy);
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece um pedido de aluguer.
     *
     * @param newRental novo pedido de aluguer a ser registado
     */
    private void createRental(String newRental) throws UserDoesNotExistException,
            NoCarsAvailableToPerformThisTripException {
        String[] parts = newRental.split(",");

        Client client = UMCarroJa.getService().getAllClients().get(parts[0]);
        if (client == null) {
            throw new UserDoesNotExistException(parts[0]);
        }

        UMCarroJa.getService().setLoggedInUser(client.getNif());

        List<Car> cars = new ArrayList<>();
        Point2D.Double destination = new Point2D.Double(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
        boolean perto = parts[2].equals("MaisPerto");
        boolean barato = parts[2].equals("MaisBarato");

        switch (parts[3]) {
            case "Electrico":
                cars = UMCarroJa.getService().getElectricCars(perto, barato, destination);
                break;
            case "Hibrido":
                cars = UMCarroJa.getService().getHybridCars(perto, barato, destination);
                break;
            case "Gasolina":
                cars = UMCarroJa.getService().getFuelCars(perto, barato, destination);
                break;
        }

        if (cars.size() == 0) {
            throw new NoCarsAvailableToPerformThisTripException();
        }
        Car car = cars.get(0);

        Rental rental = new Rental(car, client, car.getLocation(), destination, "Accepted", LocalDate.now(),
                LocalDate.now(), LocalDate.now(), -1);

        client.getRentals().add(rental);
        Proprietary proprietary = car.getProprietary();
        proprietary.getRented().add(rental);

        if (rentals.containsKey(client.getEmail())) {
            rentals.get(client.getEmail()).add(rental);
        } else {
            List<Rental> rs = new ArrayList<>();
            rs.add(rental);
            rentals.put(proprietary.getEmail(), rs);
        }
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece a avaliação atribuída, seja um carro ou um cliente,
     * chamando respetivamente os métodos auxiliares de cada um respetivamente.
     *
     * @param newRating avaliação a ser atribuída
     */
    private void updateRating(String newRating) throws LicensePlateDoesNotExistException, EmailDoesNotExistException {
        String[] parts = newRating.split(",");

        String identifier = parts[0];

        if (identifier.charAt(2) == '-') {
            updateCarRating(parts[0], Integer.parseInt(parts[1]));
        } else if (identifier.charAt(2) != '-') {
            updateClientRating(parts[0], Integer.parseInt(parts[1]));
        }
    }

    /**
     * Método que a partir do ficheiro fornecido estabelece no carro respetivo a sua avaliação.
     *
     * @param plate  matrícula do carro a avaliar
     * @param rating avaliação a atribuir
     */
    private void updateCarRating(String plate, int rating) throws LicensePlateDoesNotExistException {
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

    /**
     * Método que recebendo um nif associado a um cliente ou proprietário e uma avaliação procura o respetivo utilizador
     * a quem pertence o nif e atribui a avaliação dada.
     *
     * @param nif    número de identificação fiscal de um utilizador
     * @param rating avaliação a ser atribuída
     */
    private void updateClientRating(String nif, int rating) throws EmailDoesNotExistException {
        if (allClients.containsKey(nif)) {
            allClients.get(nif).setRating(rating);
        } else if (allProprietaries.containsKey(nif)) {
            allProprietaries.get(nif).setRating(rating);
        } else throw new EmailDoesNotExistException(nif);
    }

    /**
     * Método que cria um novo proprietário.
     *
     * @param newProp novo proprietário a ser criado
     */
    private void createNewProp(String newProp) {
        String[] parts = newProp.split(",");

        Proprietary prop = new Proprietary();
        allProprietaries.put(parts[1], prop);
        setUserData(prop, parts);
    }

    /**
     * Método que cria um novo proprietário.
     *
     * @param newClient novo cliente a ser criado
     */
    private void createNewClient(String newClient) {
        String[] parts = newClient.split(",");

        Client client = new Client();
        allClients.put(parts[1], client);
        setUserData(client, parts);
        client.setLocation(new Point2D.Double(Double.parseDouble(parts[4]), Double.parseDouble(parts[5])));
    }

    /**
     * Método que preenche os campos comuns a proprietários e clientes.
     *
     * @param newUser utilizador cujos dados vão ser atribuídos
     * @param parts   string com substrings que contêm as informações a atribuir
     */
    private void setUserData(User newUser, String[] parts) {
        newUser.setName(parts[0]);
        newUser.setEmail(parts[2]);
        newUser.setPassword("123456");
        newUser.setAddress(parts[3]);
        newUser.setNif(parts[1]);
    }

    /**
     * Método que irá ler o ficheiro do carregamento inicial de dados e aplicar todas as funções descritas anteriormente.
     *
     * @param fileName nome do ficheiro que contém os dados para carregamento inicial
     * @return List of errors
     * @throws IOException
     */
    public List<String> readFile(String fileName) throws IOException {
        List<String> errors = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEachOrdered(s -> {
                String[] parts = s.split(":");

                try {
                    switch (parts[0]) {
                        case "NovoCarro":
                            createCar(parts[1]);
                            break;
                        case "Aluguer":
                            try {
                                createRental(parts[1]);
                            } catch (UserDoesNotExistException | NoCarsAvailableToPerformThisTripException e) {
                                errors.add(e.getClass() + " " + parts[1]);
                            }
                            break;
                        case "Classificar":
                            updateRating(parts[1]);
                            break;
                        case "NovoProp":
                            createNewProp(parts[1]);
                            break;
                        case "NovoCliente":
                            createNewClient(parts[1]);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        @SuppressWarnings("Duplicates")
        Map<String, Proprietary> finalMap = new HashMap<>();
        allProprietaries.values().forEach(p -> finalMap.put(p.getEmail(), p));
        allProprietaries.clear();
        allProprietaries.putAll(finalMap);

        Map<String, Client> finalMapC = new HashMap<>();
        allClients.values().forEach(p -> finalMapC.put(p.getEmail(), p));
        allClients.clear();
        allClients.putAll(finalMapC);

        return errors;
    }
}
