import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de Car que contém as informações adicionais relativas ao FuelCar.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */

public class FuelCar extends Car implements Serializable {
    private double currentFuelAutonomy;
    private double totalFuelAutonomy;

    /**
     * Construtor por omissão.
     */
    public FuelCar() {
        super();
        this.currentFuelAutonomy = 0;
        this.totalFuelAutonomy = 0;
    }

    /**
     * @param brand               marca do carro
     * @param mediumSpeed         velocidade média do carro
     * @param priceKm             preço médio por quilómetro
     * @param consumeKm           consumo de combustível por quilómetro
     * @param pastRents           listagem dos arrendamentos anteriores do carro
     * @param rating              avaliação do carro
     * @param location            localização atual do carro
     * @param proprietary         proprietário do carro
     * @param licensePlate        matrícula do carro
     * @param liability           fiabilidade do carro
     * @param currentFuelAutonomy combustível atual do carro
     * @param totalFuelAutonomy   capacidade total de combustível do carro
     */
    public FuelCar(String brand, int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents, int rating,
                   Point2D.Double location, Proprietary proprietary, String licensePlate, int liability,
                   double currentFuelAutonomy, double totalFuelAutonomy) {
        super(brand, mediumSpeed, priceKm, consumeKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentFuelAutonomy = currentFuelAutonomy;
        this.totalFuelAutonomy = totalFuelAutonomy;
    }

    /**
     * Construtor cópia.
     */
    public FuelCar(FuelCar fuelCar) {
        super(fuelCar);
        this.currentFuelAutonomy = fuelCar.getCurrentFuelAutonomy();
        this.totalFuelAutonomy = fuelCar.getTotalFuelAutonomy();
    }

    /**
     * Devolve o combustível atual do carro.
     *
     * @return combustível atual do carro
     */
    public double getCurrentFuelAutonomy() {
        return currentFuelAutonomy;
    }

    /**
     * Atribui ao carro o combustível atual.
     *
     * @param currentFuelAutonomy combustível atual
     */
    public void setCurrentFuelAutonomy(double currentFuelAutonomy) {
        this.currentFuelAutonomy = currentFuelAutonomy;
    }

    /**
     * Devolve a capacidade total de combustível do carro.
     *
     * @return capacidade total de combustível do carro
     */
    public double getTotalFuelAutonomy() {
        return totalFuelAutonomy;
    }

    /**
     * Atribui ao carro a capacidade total de combustível.
     *
     * @param totalFuelAutonomy capacidade total de combustível
     */
    public void setTotalFuelAutonomy(double totalFuelAutonomy) {
        this.totalFuelAutonomy = totalFuelAutonomy;
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
        return Double.compare(fuelCar.currentFuelAutonomy, currentFuelAutonomy) == 0 &&
                Double.compare(fuelCar.totalFuelAutonomy, totalFuelAutonomy) == 0;
    }

    /**
     * Devolve o valor de hash.
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuelAutonomy, totalFuelAutonomy);
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
                ", currentFuel=" + currentFuelAutonomy +
                ", totalFuel=" + totalFuelAutonomy +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro a Combustível, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro a Combustível
     */
    public FuelCar clone() {
        FuelCar newFuelCar = (FuelCar) super.clone();
        newFuelCar.setCurrentFuelAutonomy(this.currentFuelAutonomy);
        newFuelCar.setTotalFuelAutonomy(this.totalFuelAutonomy);
        return newFuelCar;
    }

    /**
     * Método que faz a redução do combustível do carro, tendo em conta a distância que percorreu, no final da viagem.
     *
     * @param dist distância percorrida pelo carro
     */
    public void decreaseFuel(double dist) {
        double fuelAfterTrip = currentFuelAutonomy - (dist * this.getConsumeKm());
        setCurrentFuelAutonomy(fuelAfterTrip);
    }
}