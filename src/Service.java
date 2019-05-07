import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Write a description of class Service here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190417
 */

public class Service {
    private Map<String,FuelCar> fuelCars;
    private Map<String,ElectricCar> electricCars;
    private Map<String,HybridCar> hybridCars;
    private Map<String,Client> allClients;

    /**
     * Devolve a listagem de Carros a Combustível que o serviço possui.
     *
     * @return lista de Carros a Combustível
     */
    public List<FuelCar> getFuelCars() {

        return new ArrayList<>(fuelCars.values());
    }

    /**
     * Atribui ao serviço uma listagem de Carros a Combustível.
     *
     * @param fuelCars lista de Carros a Combustível
     */
    public void setFuelCars(Map<String,FuelCar> fuelCars) {
        this.fuelCars = fuelCars;
    }

    /**
     * Devolve a listagem de Carros Elétricos que o serviço possui.
     *
     * @return lista de Carros Elétricos
     */
    public List<ElectricCar> getElectricCars() {
        return new ArrayList<>(electricCars.values());
    }

    /**
     * Atribui ao serviço uma listagem de Carros Elétricos.
     *
     * @param electricCars lista de Carros Elétricos
     */
    public void setElectricCars(Map<String,ElectricCar> electricCars) {
        this.electricCars = electricCars;
    }

    /**
     * Devolve uma listagem de Carros Híbridos que o serviço possui.
     *
     * @return lista de Carros Híbridos
     */
    public List<HybridCar> getHybridCars() {
        return new ArrayList<>(hybridCars.values());
    }

    /**
     * Atribui ao serviço uma listagem de Carros Híbridos.
     *
     * @param hybridCars lista de Carros Híbridos
     */
    public void setHybridCars(Map<String,HybridCar> hybridCars) {
        this.hybridCars = hybridCars;
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
    public double canMakeTrip(Point start, Point finish, Car car) {
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
    public static double distance(Point start, Point finish) {
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
            autonomy = ((ElectricCar) car).getAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getAutonomy();
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
            autonomy = ((ElectricCar) car).getTotalAutonomy();
        } else if (car.getClass().equals(HybridCar.class)) {
            autonomy = ((HybridCar) car).getTotalAutonomy();
        } else if (car.getClass().equals(FuelCar.class)) {
            autonomy = ((FuelCar) car).getTotalAutonomy();
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
     * Devolve um alguer no seu estado inicial, com o estado em "Pendente".
     * Adiciona o novo aluguer à lista de alugueres passados do carro em questão.
     * Adiciona o novo aluguer à lista de alugueres efetuados anteriormente pelo cliente em questão.
     * Adiciona o novo aluguer à lista de alugueres efetuados ao proprietário do carro em causa.
     *
     * @param rentedCar    carro alugado
     * @param client       cliente que pretende alugar o carro
     * @param finalPos     posição final do carro alugado
     * @param useStartDate data de início de uso do carro alugado
     * @return novo aluguer do carro
     */
    public Rental createRental(Car rentedCar, Client client, Point finalPos, LocalDateTime useStartDate) {
        Rental rental = new Rental(rentedCar, client, rentedCar.getLocation(), finalPos, "Pendente",
                LocalDateTime.now(), useStartDate, null, -1);

        rentedCar.getPastRents().add(rental);
        client.getRentals().add(rental);
        rentedCar.getProprietary().getRented().add(rental);

        return rental;
    }

    /**
     * Muda o estado do aluguer para "Aceite".
     *
     * @param rental aluguer em processo
     */
    public void setStatusToAccepted(Rental rental) {
        rental.setRentalStatus("Accepted");
    }

    /**
     * Muda o estado do aluguer para "Rejeitado".
     *
     * @param rental aluguer em processo
     */
    public void setStatusToDenied(Rental rental) {
        rental.setRentalStatus("Denied");

    }

    /**
     * Calcula o tempo estimado de viagem tendo em conta as possíveis penalizações feitas ao tempo de viagem.
     *
     * @param rental        aluguer do carro em questão
     * @param weatherStatus metereologia prevista para o dia/hora da viagem (possível penalização).
     * @param car           carro alugado
     * @param client        cliente que efetuou o aluguer do carro
     * @return tempo estimado de viagem com possíveis penalizações
     */
    public double tripTime(Rental rental, WeatherStatus weatherStatus, Car car, Client client) {
        double t = distance(rental.getInitialPosCar(), rental.getFinalPos()) / car.getMediumSpeed();
        double p = 0;
        p = penalty(weatherStatus.getTripTimePenalty(), t);
        p += penalty(car.getLiability(), t);
        p += penalty(client.getDrivingSkill(), t);
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
     * Coloca a posição final do carro alugado, como posição inicial do mesmo para um próximo aluguer.
     *
     * @param lastRental ultimo aluguer efetuado
     */
    public void waitingForNewRental(Rental lastRental) {
        Car car = lastRental.getRentedCar();
        car.setLocation(lastRental.getFinalPos());
    }

    /**
     * Atualiza a bateria e/ou combustível do carro alugado no final da viagem efetuadoa.
     *
     * @param rented carro alugado
     */
    public void updateCarPower(Rental rented) {
        Point posInit = rented.getInitialPosCar();
        Point posFinal = rented.getFinalPos();
        double dist = distance(posInit, posFinal);
        Car car = rented.getRentedCar();
        if (car.getClass().equals(ElectricCar.class)) {
            ((ElectricCar) car).decreaseBattery(dist);
        } else if (car.getClass().equals(FuelCar.class)) {
            ((FuelCar) car).decreaseFuel(dist);
        } else if (car.getClass().equals(HybridCar.class)) {
            ((HybridCar) car).decreasePower(dist);
        }
    }
}