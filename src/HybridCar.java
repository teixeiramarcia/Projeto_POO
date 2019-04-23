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

    /**
     * Construtor por omissão.
     */
    public HybridCar() {
        super();
        this.currentFuel = 0;
        this.currentBattery = 0;
        this.fuelConsumeKM = 0;
        this.batteryConsumeKM = 0;
        this.totalBattery = 0;
        this.totalFuel = 0;
    }

    /**
     * Construtor parametrizado
     *
     * @param mediumSpeed      velocidade média do carro
     * @param priceKm          preço médio por quilómetro
     * @param pastRents        listagem de arrendamentos anteriores do carro
     * @param rating           avaliação atual do carro
     * @param location         localização atual do carro
     * @param proprietary      proprietário do carro
     * @param licensePlate     matrícula do carro
     * @param liability        fiabilidade do carro.
     * @param currentFuel      combustível atual do carro
     * @param currentBattery   bateria atual do carro
     * @param fuelConsumeKM    consumo médio de combustível do carro por quilómetro
     * @param batteryConsumeKM consumo médio de bateria do carro por quilómetro
     * @param totalBattery     bateria total do carro
     * @param totalFuel        capacidade total de combustível do carro
     */
    public HybridCar(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                     Proprietary proprietary, String licensePlate, int liability, double currentFuel, double currentBattery,
                     double fuelConsumeKM, double batteryConsumeKM, double totalBattery, double totalFuel) {
        super(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentFuel = currentFuel;
        this.currentBattery = currentBattery;
        this.fuelConsumeKM = fuelConsumeKM;
        this.batteryConsumeKM = batteryConsumeKM;
        this.totalBattery = totalBattery;
        this.totalFuel = totalFuel;
    }

    /**
     * Construtor cópia.
     */
    public HybridCar(HybridCar hybridCar) {
        super(hybridCar);
        this.currentFuel = hybridCar.getCurrentFuel();
        this.currentBattery = hybridCar.getCurrentBattery();
        this.fuelConsumeKM = hybridCar.getFuelConsumeKM();
        this.batteryConsumeKM = hybridCar.getBatteryConsumeKM();
        this.totalBattery = hybridCar.getTotalBattery();
        this.totalFuel = hybridCar.getTotalFuel();
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
     * @param currentFuel combustível atual do carro
     */
    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    /**
     * Devolve a bateria atual do carro.
     *
     * @return bateria atual do carro
     */
    public double getCurrentBattery() {
        return currentBattery;
    }

    /**
     * Atribui ao carro a bateria atual.
     *
     * @param currentBattery bateria atual do carro
     */
    public void setCurrentBattery(double currentBattery) {
        this.currentBattery = currentBattery;
    }

    /**
     * Devolve o consumo médio de combustível do carro por quilómetro.
     *
     * @return consumo médio de combustível por quilómetro
     */
    public double getFuelConsumeKM() {
        return fuelConsumeKM;
    }

    /**
     * Atribui ao carro o consumo médio de combustível por quilómetro.
     *
     * @param fuelConsumeKM consumo médio de combustível por quilómetro
     */
    public void setFuelConsumeKM(double fuelConsumeKM) {
        this.fuelConsumeKM = fuelConsumeKM;
    }

    /**
     * Devolve o consumo médio de bateria por quilómetro do carro.
     *
     * @return consumo médio de bateria por quilómetro
     */
    public double getBatteryConsumeKM() {
        return batteryConsumeKM;
    }

    /**
     * Atribui ao carro o consumo médio de bateria por quilómetro.
     *
     * @param batteryConsumeKM consumo médio de bateria por quilómetro
     */
    public void setBatteryConsumeKM(double batteryConsumeKM) {
        this.batteryConsumeKM = batteryConsumeKM;
    }

    /**
     * Devolve a bateria total do carro.
     *
     * @return bateria total do carro
     */
    public double getTotalBattery() {
        return totalBattery;
    }

    /**
     * Atribui ao carro a bateria total.
     *
     * @param totalBattery bateria total do carro
     */
    public void setTotalBattery(double totalBattery) {
        this.totalBattery = totalBattery;
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
     * Atribui a capacidade total de combustível do carro.
     *
     * @param totalFuel capacidade total de combustível do carro
     */
    public void setTotalFuel(double totalFuel) {
        this.totalFuel = totalFuel;
    }

    /**
     * Método que verifica se dois Carros Híbridos são iguais.
     *
     * @param o objeto a ser usado como termo de comparação
     * @return Booleano que indica se os dois objetos são iguais
     */
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

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuel, currentBattery, fuelConsumeKM, batteryConsumeKM, totalBattery, totalFuel);
    }

    /**
     * Método que devolve a representação em String do Carro Híbrido.
     *
     * @return String que representa um Carro Híbrido
     */
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

    /**
     * Método que faz uma cópia do Carro Híbrido, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro Híbrido
     */
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

    /**
     * Método que calcula a autonomia atual do carro em causa.
     *
     * @return distância que a relação combustível atual e bateria atual-consumo permite que o carro percorra
     */
    public double getAutonomy() {
        return (currentFuel / fuelConsumeKM) + (currentBattery / batteryConsumeKM);
    }

    /**
     * Método que calcula a autonomia total do carro em causa.
     *
     * @return distância que a relação capacidade total de combustível e bateria total-consumo permite que o
     * carro percorra
     */
    public double getTotalAutonomy() {
        return (totalFuel / fuelConsumeKM) + (totalBattery / batteryConsumeKM);
    }

    /**
     * Método que faz a redução da bateria + combustível do carro, tendo em conta a distância que percorreu,
     * no final da viagem
     *
     * @param dist distância percorrida pelo carro
     */
    public void decreasePower(double dist) {
        double batteryNeeded = dist * batteryConsumeKM;
        if (batteryNeeded > currentBattery) {
            double distLeft = dist - (currentBattery / batteryConsumeKM);
            setCurrentBattery(0);
            double fuelNeeded = distLeft * fuelConsumeKM;
            setCurrentFuel(currentFuel - fuelNeeded);
        } else {
            setCurrentBattery(currentBattery - batteryNeeded);
        }
    }
}