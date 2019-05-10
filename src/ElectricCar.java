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


public class ElectricCar extends Car {
    private double currentBattery;
    private double batteryConsumeKM;
    private double totalBattery;

    /**
     * Construtor por omissão.
     */
    public ElectricCar() {
        super();
        this.currentBattery = 0;
        this.batteryConsumeKM = 0;
        this.totalBattery = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param mediumSpeed      velocidade média do carro
     * @param priceKm          preço médio por quilómetro
     * @param pastRents        lista dos arrendamentos anteriores
     * @param rating           classificação do carro
     * @param location         localização atual do carro
     * @param proprietary      proprietário do carro
     * @param licensePlate     matrícula do carro
     * @param liability        fiabilidade do carro
     * @param currentBattery   bateria atual do carro
     * @param batteryConsumeKM consumo médio de bateria por quilómetro
     * @param totalBattery     bateria total do carro
     */
    public ElectricCar(String brand, int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
                       Proprietary proprietary, String licensePlate, int liability, double currentBattery,
                       double batteryConsumeKM, double totalBattery) {
        super(brand, mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
        this.currentBattery = currentBattery;
        this.batteryConsumeKM = batteryConsumeKM;
        this.totalBattery = totalBattery;
    }

    /**
     * Construtor cópia.
     */
    public ElectricCar(ElectricCar electricCar) {
        super(electricCar);
        this.currentBattery = electricCar.getCurrentBattery();
        this.batteryConsumeKM = electricCar.getBatteryConsumeKM();
        this.totalBattery = electricCar.getTotalBattery();
    }

    /**
     * Devolve a bateria atual do carro.
     *
     * @return bateria atual
     */
    public double getCurrentBattery() {
        return currentBattery;
    }

    /**
     * Atribui uma bateria atual ao carro.
     *
     * @param currentBattery bateria atual
     */
    public void setCurrentBattery(double currentBattery) {
        this.currentBattery = currentBattery;
    }

    /**
     * Devolve o consumo médio por quilómetro de bateria do carro.
     *
     * @return consumo médio de bateria por quilómetro
     */
    public double getBatteryConsumeKM() {
        return batteryConsumeKM;
    }

    /**
     * Atribui um consumo médio de bateria por quilómetro ao carro.
     *
     * @param batteryConsumeKM consumo médio de bateria por quilómetro
     */
    public void setBatteryConsumeKM(double batteryConsumeKM) {
        this.batteryConsumeKM = batteryConsumeKM;
    }

    /**
     * Devolve a bateria total do carro
     *
     * @return bateria total do carro.
     */
    public double getTotalBattery() {
        return totalBattery;
    }

    /**
     * Atribui ao carro uma bateria total.
     *
     * @param totalBattery bateria total do carro.
     */
    public void setTotalBattery(double totalBattery) {
        this.totalBattery = totalBattery;
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
        return Double.compare(that.currentBattery, currentBattery) == 0 &&
                Double.compare(that.batteryConsumeKM, batteryConsumeKM) == 0;
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentBattery, batteryConsumeKM, totalBattery);
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
                ", currentBattery=" + currentBattery +
                ", batteryConsumeKM=" + batteryConsumeKM +
                ", totalBattery=" + totalBattery +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro Elétrico, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro Elétrico.
     */
    public ElectricCar clone() {
        ElectricCar newElectricCar = (ElectricCar) super.clone();
        newElectricCar.setCurrentBattery(this.currentBattery);
        newElectricCar.setBatteryConsumeKM(this.batteryConsumeKM);
        newElectricCar.setTotalBattery(this.totalBattery);
        return newElectricCar;
    }

    /**
     * Método que calcula a autonomia atual do carro em causa.
     *
     * @return distância que a relação bateria-consumo permite que o carro percorra.
     */
    public double getAutonomy() {
        return currentBattery / batteryConsumeKM;
    }

    /**
     * Método que calcula a autonomia do carro quando este se encontra totalmente carregado.
     *
     * @return distância que a relação bateria total-consumo permite que o carro percorra.
     */
    public double getTotalAutonomy() {
        return totalBattery / batteryConsumeKM;
    }

    /**
     * Método que faz a redução na bateria do carro, tendo em conta a distância que este percorreu, no final da viagem.
     *
     * @param dist distância total percorrida pelo carro.
     */
    public void decreaseBattery(double dist) {
        double batteryAfterTrip = currentBattery - (dist * batteryConsumeKM);
        setCurrentBattery(batteryAfterTrip);
    }
}