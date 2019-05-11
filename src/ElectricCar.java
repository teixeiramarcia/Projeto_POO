import java.awt.geom.Point2D;
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


public class ElectricCar extends Car {
    private double currentBatteryAutonomy;
    private double totalBatteryAutonomy;

    /**
     * Construtor por omissão.
     */
    public ElectricCar() {
        super();
        this.currentBatteryAutonomy = 0;
        this.totalBatteryAutonomy = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param mediumSpeed            velocidade média do carro
     * @param priceKm                preço médio por quilómetro
     * @param pastRents              lista dos arrendamentos anteriores
     * @param rating                 classificação do carro
     * @param location               localização atual do carro
     * @param proprietary            proprietário do carro
     * @param licensePlate           matrícula do carro
     * @param liability              fiabilidade do carro
     * @param currentBatteryAutonomy bateria atual do carro
     * @param totalBatteryAutonomy   bateria total do carro
     */
    public ElectricCar(String brand, int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents,
                       int rating, Point2D.Double location, Proprietary proprietary, String licensePlate, int liability,
                       double currentBatteryAutonomy, double totalBatteryAutonomy) {
        super(brand, mediumSpeed, priceKm, consumeKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentBatteryAutonomy = currentBatteryAutonomy;
        this.totalBatteryAutonomy = totalBatteryAutonomy;
    }

    /**
     * Construtor cópia.
     */
    public ElectricCar(ElectricCar electricCar) {
        super(electricCar);
        this.currentBatteryAutonomy = electricCar.getCurrentBatteryAutonomy();
        this.totalBatteryAutonomy = electricCar.getTotalBatteryAutonomy();
    }

    /**
     * Devolve a bateria atual do carro.
     *
     * @return bateria atual
     */
    public double getCurrentBatteryAutonomy() {
        return currentBatteryAutonomy;
    }

    /**
     * Atribui uma bateria atual ao carro.
     *
     * @param currentBatteryAutonomy bateria atual
     */
    public void setCurrentBatteryAutonomy(double currentBatteryAutonomy) {
        this.currentBatteryAutonomy = currentBatteryAutonomy;
    }

    /**
     * Devolve a bateria total do carro
     *
     * @return bateria total do carro.
     */
    public double getTotalBatteryAutonomy() {
        return totalBatteryAutonomy;
    }

    /**
     * Atribui ao carro uma bateria total.
     *
     * @param totalBattery bateria total do carro.
     */
    public void setTotalBattery(double totalBattery) {
        this.totalBatteryAutonomy = totalBattery;
    }

    /**
     * Método que verifica se dois Carros Elétricos são iguais.
     *
     * @param o Objeto a ser usado como termo de comparação
     * @return Booleano que indica se os dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return Double.compare(that.currentBatteryAutonomy, currentBatteryAutonomy) == 0 &&
                Double.compare(that.totalBatteryAutonomy, totalBatteryAutonomy) == 0;
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentBatteryAutonomy, totalBatteryAutonomy);
    }

    /**
     * Método que devolve a representação em String do Carro Elétrico.
     *
     * @return String que representa um Carro Elétrico
     */
    @Override
    public String toString() {
        return "ElectricCar{" +
                super.toString() +
                ", batteryAutonomy=" + currentBatteryAutonomy +
                ", totalBattery=" + totalBatteryAutonomy +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro Elétrico, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro Elétrico.
     */
    public ElectricCar clone() {
        ElectricCar newElectricCar = (ElectricCar) super.clone();
        newElectricCar.setCurrentBatteryAutonomy(this.currentBatteryAutonomy);
        newElectricCar.setTotalBattery(this.totalBatteryAutonomy);
        return newElectricCar;
    }

    /**
     * Método que faz a redução na bateria do carro, tendo em conta a distância que este percorreu, no final da viagem.
     *
     * @param dist distância total percorrida pelo carro.
     */
    public void decreaseBatteryAutonomy(double dist) {
        double batteryAfterTrip = currentBatteryAutonomy - (dist * this.getConsumeKm());
        setCurrentBatteryAutonomy(batteryAfterTrip);
    }
}