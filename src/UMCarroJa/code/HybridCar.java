package UMCarroJa.code;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de Car que contém as informações adicionais relativas ao HybridCar.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */

public class HybridCar extends Car implements Serializable {
    private double currentFuelAutonomy;
    private double totalBatteryAutonomy;
    private double currentBatteryAutonomy;
    private double totalFuelAutonomy;

    /**
     * Construtor por omissão.
     */
    public HybridCar() {
        super();
        this.currentFuelAutonomy = 0;
        this.currentBatteryAutonomy = 0;
        this.totalBatteryAutonomy = 0;
        this.totalFuelAutonomy = 0;
    }

    /**
     *
     * @param brand                marca do carro
     * @param mediumSpeed          velocidade média do carro
     * @param priceKm              preço médio por quilómetro
     * @param consumeKm            consumo de combustível+bateria por quilómetro
     * @param pastRents            listagem de arrendamentos anteriores do carro
     * @param rating               avaliação atual do carro
     * @param location             localização atual do carro
     * @param proprietary          proprietário do carro
     * @param licensePlate         matrícula do carro
     * @param liability            fiabilidade do carro.
     * @param currentFuelAutonomy  capacidade em km do combustivel atual do carro
     * @param batteryAutonomy      capacidade em km da bateria atual do carro
     * @param totalBatteryAutonomy bateria total do carro
     * @param totalFuelAutonomy    capacidade total (em km) de combustível do carro
     */
    public HybridCar(String brand, int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents,
                     int rating, Point2D.Double location, Proprietary proprietary, String licensePlate, int liability,
                     double currentFuelAutonomy, double batteryAutonomy, double totalBatteryAutonomy,
                     double totalFuelAutonomy) {
        super(brand, mediumSpeed, priceKm, consumeKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentFuelAutonomy = currentFuelAutonomy;
        this.currentBatteryAutonomy = batteryAutonomy;
        this.totalBatteryAutonomy = totalBatteryAutonomy;
        this.totalFuelAutonomy = totalFuelAutonomy;
    }

    /**
     * Construtor cópia.
     */
    public HybridCar(HybridCar hybridCar) {
        super(hybridCar);
        this.currentFuelAutonomy = hybridCar.getCurrentFuelAutonomy();
        this.currentBatteryAutonomy = hybridCar.getCurrentBatteryAutonomy();
        this.totalBatteryAutonomy = hybridCar.getTotalBatteryAutonomy();
        this.totalFuelAutonomy = hybridCar.getTotalFuelAutonomy();
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
     * @param currentFuel combustível atual do carro
     */
    public void setCurrentFuelAutonomy(double currentFuel) {
        this.currentFuelAutonomy = currentFuel;
    }

    /**
     * Devolve a bateria atual do carro.
     *
     * @return bateria atual do carro
     */
    public double getCurrentBatteryAutonomy() {
        return currentBatteryAutonomy;
    }

    /**
     * Atribui ao carro a bateria atual.
     *
     * @param currentBatteryAutonomy bateria atual do carro
     */
    public void setCurrentBatteryAutonomy(double currentBatteryAutonomy) {
        this.currentBatteryAutonomy = currentBatteryAutonomy;
    }

    /**
     * Devolve a bateria total do carro.
     *
     * @return bateria total do carro
     */
    public double getTotalBatteryAutonomy() {
        return totalBatteryAutonomy;
    }

    /**
     * Atribui ao carro a bateria total.
     *
     * @param totalBatteryAutonomy bateria total do carro
     */
    public void setTotalBatteryAutonomy(double totalBatteryAutonomy) {
        this.totalBatteryAutonomy = totalBatteryAutonomy;
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
     * Atribui a capacidade total de combustível do carro.
     *
     * @param totalFuelAutonomy capacidade total de combustível do carro
     */
    public void setTotalFuelAutonomy(double totalFuelAutonomy) {
        this.totalFuelAutonomy = totalFuelAutonomy;
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
        return Double.compare(hybridCar.currentFuelAutonomy, currentFuelAutonomy) == 0 &&
                Double.compare(hybridCar.currentBatteryAutonomy, currentBatteryAutonomy) == 0 &&
                Double.compare(hybridCar.totalBatteryAutonomy, totalBatteryAutonomy) == 0 &&
                Double.compare(hybridCar.totalFuelAutonomy, totalFuelAutonomy) == 0;
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFuelAutonomy, currentBatteryAutonomy, totalBatteryAutonomy, totalFuelAutonomy);
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
                ", currentFuel=" + currentFuelAutonomy +
                ", batteryAutonomy=" + currentBatteryAutonomy +
                ", totalBattery=" + totalBatteryAutonomy +
                ", totalFuel=" + totalFuelAutonomy +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro Híbrido, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro Híbrido
     */
    public HybridCar clone() {
        HybridCar newHybridCar = (HybridCar) super.clone();
        newHybridCar.setCurrentFuelAutonomy(this.currentFuelAutonomy);
        newHybridCar.setCurrentBatteryAutonomy(this.currentBatteryAutonomy);
        newHybridCar.setTotalBatteryAutonomy(this.totalBatteryAutonomy);
        newHybridCar.setTotalFuelAutonomy(this.totalFuelAutonomy);
        return newHybridCar;
    }


    /**
     * Método que calcula a autonomia atual do carro em causa.
     *
     * @return distância que a relação combustível atual e bateria atual-consumo permite que o carro percorra
     */
    public double getAutonomy() {
        return (currentFuelAutonomy + currentBatteryAutonomy) / this.getConsumeKm();
    }

    /**
     * Método que calcula a autonomia total do carro em causa.
     *
     * @return distância que a relação capacidade total de combustível e bateria total-consumo permite que o
     * carro percorra
     */
    public double getTotalAutonomy() {
        return (totalFuelAutonomy + totalBatteryAutonomy) / this.getConsumeKm();
    }

    /**
     * Método que faz a redução da bateria + combustível do carro, tendo em conta a distância que percorreu,
     * no final da viagem
     *
     * @param dist distância percorrida pelo carro
     */
    public void decreasePower(double dist) {
        double batteryNeeded = dist * this.getConsumeKm();
        if (batteryNeeded > currentBatteryAutonomy) {
            double distLeft = dist - (currentBatteryAutonomy / this.getConsumeKm());
            setCurrentBatteryAutonomy(0);
            double fuelNeeded = distLeft * this.getConsumeKm();
            setCurrentFuelAutonomy(currentFuelAutonomy - fuelNeeded);
        } else {
            setCurrentBatteryAutonomy(currentBatteryAutonomy - batteryNeeded);
        }
    }
}