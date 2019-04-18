import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Service here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190417
 */

public class FuelCar extends Car {
    private double currentFuel;
    private double fuelConsumeKM;
    private double totalFuel;

    /**
     * Construtor por omissão.
     */
    public FuelCar() {
        super();
        this.currentFuel = 0;
        this.fuelConsumeKM = 0;
        this.totalFuel = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param mediumSpeed   velocidade média do carro
     * @param priceKm       preço médio por kilómetro
     * @param pastRents     listagem dos arrendamentos anteriores do carro
     * @param rating        avaliação do carro
     * @param location      localização atual do carro
     * @param proprietary   proprietário do carro
     * @param licensePlate  matrícula do carro
     * @param liability     fiabilidade do carro
     * @param currentFuel   combustível atual do carro
     * @param fuelConsumeKM consumo médio de combustível por kilómetro
     * @param totalFuel     capacidade total de combustível do carro
     */
    public FuelCar(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                   Proprietary proprietary, String licensePlate, int liability, double currentFuel, double fuelConsumeKM,
                   double totalFuel) {
        super(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentFuel = currentFuel;
        this.fuelConsumeKM = fuelConsumeKM;
        this.totalFuel = totalFuel;
    }

    /**
     * Construtor cópia.
     */
    public FuelCar(FuelCar fuelCar) {
        super(fuelCar);
        this.currentFuel = fuelCar.getCurrentFuel();
        this.fuelConsumeKM = fuelCar.getFuelConsumeKM();
        this.totalFuel = fuelCar.getTotalFuel();
    }

    /**
     * Devolve o combustível atual do carro.
     *
     * @return combustível atual do carro
     */
    public double getCurrentFuel() {
        return currentFuel;
    }

    /**
     * Atribui ao carro o combustível atual.
     *
     * @param currentFuel combustível atual
     */
    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    /**
     * Devolve o consumo médio de combustível por kilómetro do carro.
     *
     * @return consumo médio de combustível por kilómetro
     */
    public double getFuelConsumeKM() {
        return fuelConsumeKM;
    }

    /**
     * Atribui ao carro o consumo médio de combustível por kilómetro.
     *
     * @param fuelConsumeKM consumo médio de combustível por kilómetro
     */
    public void setFuelConsumeKM(double fuelConsumeKM) {
        this.fuelConsumeKM = fuelConsumeKM;
    }

    /**
     * Devolve a capacidade total de combustível do carro.
     *
     * @return capacidade total de combustível do carro
     */
    public double getTotalFuel() {
        return totalFuel;
    }

    /**
     * Atribui ao carro a capacidade total de combustível.
     *
     * @param totalFuel capacidade total de combustível
     */
    public void setTotalFuel(double totalFuel) {
        this.totalFuel = totalFuel;
    }

    /**
     * Método que verifica se dois Carros a Combustível são iguais.
     *
     * @param o objeto a ser usado como termo de comparação
     * @return Booleano que indica se dois objetos são iguais
     */
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

    /**
     * Devolve o valor de ash baseado em (...)
     *
     * @return valor de ash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuel, fuelConsumeKM, totalFuel);
    }

    /**
     * Método que devolve a representação em String do Carro a Combustível.
     *
     * @return String que representa um Carro a Combustível
     */
    @Override
    public String toString() {
        return "FuelCar{" +
                super.toString() +
                ", currentFuel=" + currentFuel +
                ", fuelConsumeKM=" + fuelConsumeKM +
                ", totalFuel=" + totalFuel +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro a Combustível, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro a Combustível
     */
    public FuelCar clone() {
        FuelCar newFuelCar = (FuelCar) super.clone();
        newFuelCar.setCurrentFuel(this.currentFuel);
        newFuelCar.setFuelConsumeKM(this.fuelConsumeKM);
        newFuelCar.setTotalFuel(this.totalFuel);
        return newFuelCar;
    }

    /**
     * Método que calcula a autonomia atual do carro em causa.
     *
     * @return distância que a relação combustível-consumo permite que o carro percorra.
     */
    public double getAutonomy() {
        return currentFuel / fuelConsumeKM;
    }

    /**
     * Método que calcula a autonomia total do carro em causa.
     *
     * @return distância que a relação combustível total-consumo permite que o carro percorra
     */
    public double getTotalAutonomy() {
        return totalFuel / fuelConsumeKM;
    }

    /**
     * Método que faz a redução do combustível do carro, tendo em conta a distância que percorreu, no final da viagem.
     *
     * @param dist distância percorrida pelo carro
     */
    public void decreaseFuel(double dist) {
        double fuelAfterTrip = currentFuel - (dist * fuelConsumeKM);
        setCurrentFuel(fuelAfterTrip);
    }
}
