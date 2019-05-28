import java.awt.geom.Point2D;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a description of class UMCarroJa.Service here.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */

public class Service implements Serializable {
    private Map<String, FuelCar> fuelCars;
    private Map<String, ElectricCar> electricCars;
    private Map<String, HybridCar> hybridCars;
    private Map<String, Client> allClients;
    private Map<String, Proprietary> allProprietaries;
    private Map<String, List<Rental>> allRentals;
    private String loggedInUser;
    private Weather weather;
    private Rental ongoingRental;

    public Service() {
        this.fuelCars = new HashMap<>();
        this.electricCars = new HashMap<>();
        this.hybridCars = new HashMap<>();
        this.allClients = new HashMap<>();
        this.allProprietaries = new HashMap<>();
        this.allRentals = new HashMap<>();
        this.weather = new Weather();
        List<WeatherStatus> weathers = weather.getWeathers();
        weathers.add(new WeatherStatus("Sun", 5));
        weathers.add(new WeatherStatus("Rain", 3));
        weathers.add(new WeatherStatus("Snow", 1));
        ongoingRental = null;
    }

    /**
     * Devolve a metereologia.
     *
     * @return metereologia
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Atribui ao serviço a metereologia
     *
     * @param weather metereologia
     */
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    /**
     * Devolve a listagem de Carros a Combustível que o serviço possui.
     *
     * @return mapa de Carros a Combustível
     */
    public Map<String, FuelCar> getFuelCars() {
        return fuelCars;
    }

    /**
     * Atribui ao serviço uma listagem de Carros a Combustível.
     *
     * @param fuelCars mapa de Carros a Combustível
     */
    public void setFuelCars(Map<String, FuelCar> fuelCars) {
        this.fuelCars = fuelCars;
    }

    /**
     * Devolve a listagem de Carros Elétricos que o serviço possui.
     *
     * @return mapa de Carros Elétricos
     */
    public Map<String, ElectricCar> getElectricCars() {
        return electricCars;
    }

    /**
     * Atribui ao serviço uma listagem de Carros Elétricos.
     *
     * @param electricCars mapa de Carros Elétricos
     */
    public void setElectricCars(Map<String, ElectricCar> electricCars) {
        this.electricCars = electricCars;
    }

    /**
     * Devolve uma listagem de Carros Híbridos que o serviço possui.
     *
     * @return mapa de Carros Híbridos
     */
    public Map<String, HybridCar> getHybridCars() {
        return hybridCars;
    }

    /**
     * Atribui ao serviço uma listagem de Carros Híbridos.
     *
     * @param hybridCars mapa de Carros Híbridos
     */
    public void setHybridCars(Map<String, HybridCar> hybridCars) {
        this.hybridCars = hybridCars;
    }

    /**
     * Devolve uma listagem de todos os Clientes.
     *
     * @return mapa de Clientes
     */
    public Map<String, Client> getAllClients() {
        return allClients;
    }

    /**
     * Atribui ao serviço uma listagem de todos os Clientes.
     *
     * @param allClients mapa de Clientes
     */
    public void setAllClients(Map<String, Client> allClients) {
        this.allClients = allClients;
    }

    /**
     * Devolve uma listagem de todos os Proprietários.
     *
     * @return mapa de Proprietários
     */
    public Map<String, Proprietary> getAllProprietaries() {
        return allProprietaries;
    }

    /**
     * Atribui ao serviço uma listagem de Proprietários.
     *
     * @param allProprietaries mapa de Proprietários
     */
    public void setAllProprietaries(Map<String, Proprietary> allProprietaries) {
        this.allProprietaries = allProprietaries;
    }

    /**
     * Devolve uma listagem de Alugueres.
     *
     * @return mapa de alugueres
     */
    public Map<String, List<Rental>> getAllRentals() {
        return allRentals;
    }

    /**
     * Atribui ao serviço uma listagem de Alugueres.
     *
     * @param allRentals mapa de alugueres
     */
    public void setAllRentals(Map<String, List<Rental>> allRentals) {
        this.allRentals = allRentals;
    }

    /**
     * Devolve o aluguer que se encontra em andamento.
     *
     * @return aluguer em eandamento
     */
    public Rental getOngoingRental() {
        return ongoingRental;
    }

    /**
     * Atribui ao serviço o aluguer em andamento
     *
     * @param ongoingRental aluguer em andamento
     */
    public void setOngoingRental(Rental ongoingRental) {
        this.ongoingRental = ongoingRental;
    }

    /**
     * Devolve o gasto estimado da viagem ou -1 se o carro não possuir autonomia.
     * Se a autonomia se encontrar abaixo de 10% da autonomia total, mesmo que seja suficiente para efetuar a viagem,
     * esta não é pernmitida.
     * Caso a viagem seja permitida, utiliza como auxiliar, distance para calcular o custo da viagem.
     *
     * @param start  Ponto de partida do carro
     * @param finish Ponto de chegada do carro
     * @param car    carro requerido no serviço
     */
    public double canMakeTrip(Point2D.Double start, Point2D.Double finish, Car car) {
        double distance = distance(start, finish);
        double autonomyNow = getCurrentAutonomy(car);
        double autonomyTotal = getTotalAutonomy(car);

        if (autonomyNow < (autonomyTotal * 0.1) || autonomyNow < distance) {
            return -1;
        }

        return tripCost(distance, car);
    }

    /**
     * Calcula a distância entre o ponto de partida e o ponto de chegada da viagem a efetuar pelo carro.
     *
     * @param start  Ponto de partida do carro
     * @param finish Ponto de chegada do carro
     * @return disntância entre os dois pontos
     */
    public static double distance(Point2D.Double start, Point2D.Double finish) {
        double coordX = Math.pow(Math.abs(start.getX() - finish.getX()), 2);
        double coordY = Math.pow(Math.abs(start.getY() - finish.getY()), 2);

        return (Math.sqrt(coordX + coordY));
    }

    /**
     * Devolve a autonomia atual do carro requerido pelo serviço.
     *
     * @param car carro requerido pelo serviço
     * @return autonomia atual do carro em questão
     */
    private double getCurrentAutonomy(Car car) {
        double autonomy = 0;

        if (car.getClass().equals(ElectricCar.class)) {
            autonomy = ((ElectricCar) car).getCurrentBatteryAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getCurrentFuelAutonomy();
        }

        return autonomy;
    }

    /**
     * Devolve a autonomia total do carro requerido pelo serviço.
     *
     * @param car carro requerido pelo serviço
     * @return autonomia total do carro em questão
     */
    private double getTotalAutonomy(Car car) {
        double autonomy = 0;

        if (car.getClass().equals(ElectricCar.class)) {
            autonomy = ((ElectricCar) car).getTotalBatteryAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getTotalAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getTotalFuelAutonomy();
        }

        return autonomy;
    }

    /**
     * Calcula o custo estimado da viagem.
     *
     * @param distance distância a percorrer pelo carro requerido pelo serviço
     * @param car      carro em questão
     * @return custo estimado da viagem
     */
    public static double tripCost(double distance, Car car) {
        return car.getPriceKm() * distance;
    }

    /**
     * Calcula o tempo que o cliente demora até chegar ao carro pretendido.
     *
     * @param client cliente que pretende utilizar o serviço
     * @param car    carro requerido
     * @return tempo que o cliente leva a chegar ao carro
     */
    private double timeClientToCar(Client client, Car car) {
        double dist = distance(client.getLocation(), car.getLocation());

        return (dist * 60) / 4;
    }

    /**
     * Calcula o tempo estimado de viagem tendo em conta as possíveis penalizações feitas ao tempo de viagem.
     *
     * @param rental        aluguer do carro em questão
     * @param weatherStatus metereologia prevista para o dia/hora da viagem (possível penalização).
     * @return tempo estimado de viagem com possíveis penalizações
     */
    public double tripTime(Rental rental, WeatherStatus weatherStatus) {
        double t = distance(rental.getInitialPosCar(), rental.getFinalPos()) / rental.getRentedCar().getMediumSpeed();
        double p = 0;
        p = penalty(weatherStatus.getTripTimePenalty(), t);
        p += penalty(rental.getRentedCar().getLiability(), t);
        p += penalty(rental.getClient().getDrivingSkill(), t);
        return t + p;
    }

    /**
     * Possíveis penalizações feitas ao tempo de viagem (destreza de condução do cliente e metereologia).
     *
     * @param penalty possíveis penalizações efetuadas na viagem
     * @param time    tempo estimado de viagem sem penalizações
     * @return tempo real de viagem
     */
    public double penalty(int penalty, double time) {
        return (((5 - penalty) * 0.1) * time);
    }

    /**
     * Método que efetua o login a um utlilizador, quer Cliente quer Proprietário.
     *
     * @param email         email do utilizador
     * @param password      password do utilizador
     * @param isProprietary booleano que identifica se se trata de um Cliente ou Proprietário
     * @throws EmailDoesNotExistException
     * @throws IncorrectPasswordException
     */
    public void login(String email, String password, Boolean isProprietary) throws EmailDoesNotExistException,
            IncorrectPasswordException {
        if (isProprietary) {
            loginP(email, password);
        } else {
            loginC(email, password);
        }

        loggedInUser = email;
    }

    /**
     * Método que efetua o login de um Proprietário.
     *
     * @param email    email do Proprietário
     * @param password password do Proprietário
     * @throws EmailDoesNotExistException
     * @throws IncorrectPasswordException
     */
    private void loginP(String email, String password) throws EmailDoesNotExistException, IncorrectPasswordException {
        if (allProprietaries.containsKey(email)) {
            String pass = allProprietaries.get(email).getPassword();
            passTest(pass, password);
        } else {
            throw new EmailDoesNotExistException(email);
        }
    }

    /**
     * Método que efetua o login de um Cliente.
     *
     * @param email    email do Cliente
     * @param password password do Cliente
     * @throws EmailDoesNotExistException
     * @throws IncorrectPasswordException
     */
    private void loginC(String email, String password) throws EmailDoesNotExistException, IncorrectPasswordException {
        if (allClients.containsKey(email)) {
            String pass = allClients.get(email).getPassword();
            passTest(pass, password);
        } else {
            throw new EmailDoesNotExistException(email);
        }
    }

    /**
     * Método que verifica se a password a ser introduzida está correta.
     *
     * @param pass     password introduzida
     * @param password password correta
     * @throws IncorrectPasswordException
     */
    private void passTest(String pass, String password) throws IncorrectPasswordException {
        if (!pass.equals(password)) {
            throw new IncorrectPasswordException();
        }
    }

    /**
     * Método que devolve o User que está com o logim aberto.
     *
     * @param isProprietary booleano que identifica se se trata de um Cliente ou de um proprietário
     * @return User com login aberto
     */
    public User getLoggedInUser(Boolean isProprietary) {
        if (isProprietary) {
            return allProprietaries.get(loggedInUser);
        } else {
            return allClients.get(loggedInUser);
        }
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    /**
     * Método que adiciona um novo Cliente.
     *
     * @param newClient Cliente a ser adicionado
     * @throws EmailAlreadyExistsException
     */
    public void addNewClient(Client newClient) throws EmailAlreadyExistsException {
        if (allClients.containsKey(newClient.getEmail())) {
            throw new EmailAlreadyExistsException(newClient.getEmail());
        } else {
            loggedInUser = newClient.getEmail();
            allClients.put(newClient.getEmail(), newClient);
        }
    }

    /**
     * Método que adiciona um novo Proprietário.
     *
     * @param newProp Proprietário a ser adicionado
     * @throws EmailAlreadyExistsException
     */
    public void addNewProprietary(Proprietary newProp) throws EmailAlreadyExistsException {
        if (allProprietaries.containsKey(newProp.getEmail())) {
            throw new EmailAlreadyExistsException(newProp.getEmail());
        } else {
            loggedInUser = newProp.getEmail();
            allProprietaries.put(newProp.getEmail(), newProp);
        }
    }

    /**
     * Método que adiciona um novo Carro Elétrico.
     *
     * @param newCar Carro Elétrico a ser adicionado
     * @throws CarAlreadyExistsException
     */
    public void addNewElectricCar(Car newCar) throws CarAlreadyExistsException {
        if (electricCars.containsKey(newCar.getLicensePlate())) {
            throw new CarAlreadyExistsException(newCar.getLicensePlate());
        } else {
            electricCars.put(newCar.getLicensePlate(), (ElectricCar) newCar);
            newCar.getProprietary().getCars().add(newCar);
        }
    }

    /**
     * Método que adiciona um novo Carro Híbrido.
     *
     * @param newCar Carro Híbrido a ser adicionado
     * @throws CarAlreadyExistsException
     */
    public void addNewHybridCar(Car newCar) throws CarAlreadyExistsException {
        if (hybridCars.containsKey(newCar.getLicensePlate())) {
            throw new CarAlreadyExistsException(newCar.getLicensePlate());
        } else {
            hybridCars.put(newCar.getLicensePlate(), (HybridCar) newCar);
            newCar.getProprietary().getCars().add(newCar);
        }
    }

    /**
     * Método que adiciona um novo Carro a Combustível.
     *
     * @param newCar Carro a Combustível a ser adicionado
     * @throws CarAlreadyExistsException
     */
    public void addNewFuelCar(Car newCar) throws CarAlreadyExistsException {
        if (fuelCars.containsKey(newCar.getLicensePlate())) {
            throw new CarAlreadyExistsException(newCar.getLicensePlate());
        } else {
            fuelCars.put(newCar.getLicensePlate(), (FuelCar) newCar);
            newCar.getProprietary().getCars().add(newCar);
        }
    }

    /**
     * Método que devolve uma listagem  de Carros a Combustível que obedeçam aos pedidos do cliente podendo estes ser
     * que o carro se encontre mais perto, seja mais barato e seja capaz de efetuar a viagem requerida.
     *
     * @param isCloserCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                     mais próximos do cliente
     * @param isCheaperCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                      mais baratos (por quilómetro)
     * @param destination Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                    capazes de efetuar a viagem pretendida
     * @return lista de carros de entre os quais o cliente pode escolher2
     */
    @SuppressWarnings("Duplicates")
    public List<Car> getFuelCars(boolean isCloserCars, boolean isCheaperCars, Point2D.Double destination) {
        List<FuelCar> allFuelCars = new ArrayList<>(fuelCars.values());
        List<Car> resultado = new ArrayList<>();

        for (FuelCar fuelCar : allFuelCars) {
            Point2D.Double carPos = fuelCar.getLocation();
            Point2D.Double clientPos = ((Client) getLoggedInUser(false)).getLocation();

            double dist = distance(carPos, clientPos);
            double preco = fuelCar.getPriceKm();

            if (canMakeTrip(carPos, destination, fuelCar) != -1) {
                if (isCloserCars && dist <= 2) {
                    if (!isCheaperCars || preco <= 3) {
                        resultado.add(fuelCar);
                    }
                } else if (isCheaperCars && preco <= 3) {
                    resultado.add(fuelCar);
                }
            }
        }
        return resultado;
    }

    /**
     * Método que devolve uma listagem  de Carros Eléctricos que obedeçam aos pedidos do cliente podendo estes ser
     * que o carro se encontre mais perto, seja mais barato e seja capaz de efetuar a viagem requerida.
     *
     * @param isCloserCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                     mais próximos do cliente
     * @param isCheaperCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                      mais baratos (por quilómetro)
     * @param destination Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                    capazes de efetuar a viagem pretendida
     * @return lista de carros de entre os quais o cliente pode escolher2
     */
    @SuppressWarnings("Duplicates")
    public List<Car> getElectricCars(boolean isCloserCars, boolean isCheaperCars, Point2D.Double destination) {
        List<ElectricCar> allElectricCars = new ArrayList<>(electricCars.values());
        List<Car> resultado = new ArrayList<>();

        for (ElectricCar electricCar : allElectricCars) {
            Point2D.Double carPos = electricCar.getLocation();
            Point2D.Double clientPos = ((Client) getLoggedInUser(false)).getLocation();

            double dist = distance(carPos, clientPos);
            double preco = electricCar.getPriceKm();

            if (isCloserCars && dist <= 2) {
                if (!isCheaperCars || preco <= 3) {
                    resultado.add(electricCar);
                }
            } else if (isCheaperCars && preco <= 3) {
                resultado.add(electricCar);
            }
        }
        return resultado;
    }

    /**
     * Método que devolve uma listagem  de Carros Híbridos que obedeçam aos pedidos do cliente podendo estes ser
     * que o carro se encontre mais perto, seja mais barato e seja capaz de efetuar a viagem requerida.
     *
     * @param isCloserCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                     mais próximos do cliente
     * @param isCheaperCars Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                      mais baratos (por quilómetro)
     * @param destination Booleano que indica se se trata de um carro elegível para se encontrar na lista de carros
     *                    capazes de efetuar a viagem pretendida
     * @return lista de carros de entre os quais o cliente pode escolher2
     */
    @SuppressWarnings("Duplicates")
    public List<Car> getHybridCars(boolean isCloserCars, boolean isCheaperCars, Point2D.Double destination) {
        List<HybridCar> allHybridCars = new ArrayList<>(hybridCars.values());
        List<Car> resultado = new ArrayList<>();

        for (HybridCar hybridCar : allHybridCars) {
            Point2D.Double carPos = hybridCar.getLocation();
            Point2D.Double clientPos = ((Client) getLoggedInUser(false)).getLocation();

            double dist = distance(carPos, clientPos);
            double preco = hybridCar.getPriceKm();

            if (isCloserCars && dist <= 2) {
                if (!isCheaperCars || preco <= 3) {
                    resultado.add(hybridCar);
                }
            } else if (isCheaperCars && preco <= 3) {
                resultado.add(hybridCar);
            }
        }
        return resultado;
    }

    /**
     * Método que efetua a criação de um novo aluguer.
     *
     * @param car carro que o cliente pretende alugar
     * @param destinationX coordenada x do destino pretendido
     * @param destinationY coordenada y do destino pretendido
     *
     * @throws ClientAlreadyHasOngoingRentalException
     */
    //CLIENT
    public void createRental(Car car, Double destinationX, Double destinationY)
            throws ClientAlreadyHasOngoingRentalException {
        if (ongoingRental != null) {
            throw new ClientAlreadyHasOngoingRentalException();
        }

        Client client = (Client) getLoggedInUser(false);
        Point2D.Double initialPos = car.getLocation();
        Point2D.Double finalPos = new Point2D.Double(destinationX, destinationY);
        String rentalStatus = "Pendent";
        LocalDate rentalDate = LocalDate.now();
        LocalDate useStartDate = LocalDate.now();
        LocalDate useFinishDate = LocalDate.now();
        int rating = -1;
        Rental rentalRequest = new Rental(car, client, initialPos, finalPos, rentalStatus, rentalDate, useStartDate,
                useFinishDate, rating);

        if (allRentals.containsKey(car.getProprietary().getEmail())) {
            List<Rental> rs = allRentals.get(car.getProprietary().getEmail());
            rs.add(rentalRequest);
        } else {
            List<Rental> rs = new ArrayList<>();
            rs.add(rentalRequest);
            allRentals.put(car.getProprietary().getEmail(), rs);
        }
        car.getProprietary().getRented().add(rentalRequest);
        client.getRentals().add(rentalRequest);
        ongoingRental = rentalRequest;
    }


    /**
     * Método que devolve a listagem de pedidos de aluguer pendentes de um determinado Proprietário.
     *
     * @return lista de alugueres pendentes
     */
    public List<Rental> getPendentRequests() {
        if (allRentals.containsKey(loggedInUser)) {
            return allRentals.get(loggedInUser);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Método que atribui um estado a um aluguer.
     *
     * @param rental aluguer em efeito
     * @param newStatus estado atribuído ao aluguer
     */
    public void changeStatus(Rental rental, String newStatus) {
        rental.setRentalStatus(newStatus);
        allRentals.get(loggedInUser).remove(rental);
    }

    /**
     * Método que guarda o estado da aplicação num ficheiro binário.
     *
     * @param appState estado atual da aplicação
     *
     * @throws IOException
     */
    public void saveState(String appState) throws IOException {
        FileOutputStream fos = new FileOutputStream(appState);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Método que carrega o estado da aplicação para um ficheiro binário.
     *
     * @param appState estado atual da aplicação
     * @return serviço com a informação carregada
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Service chargeState(String appState) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(appState);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Service u = (Service) ois.readObject();
        ois.close();
        return u;
    }
}
