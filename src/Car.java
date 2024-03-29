import java.awt.geom.Point2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Atores do sistema que interagem com a aplicação.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */

public class Car implements Serializable {
    private String brand;
    private int mediumSpeed;
    private double priceKm;
    private double consumeKm;
    private List<Rental> pastRents;
    private int rating;
    private Point2D.Double location;
    private Proprietary proprietary;
    private String licensePlate;
    private int liability;

    /**
     * Construtor por omissão.
     */
    public Car() {
        this.brand = "N/A";
        this.mediumSpeed = 0;
        this.priceKm = 0;
        this.consumeKm = 0;
        this.pastRents = new ArrayList<>();
        this.rating = -1;
        this.location = new Point2D.Double(-1, -1);
        this.proprietary = new Proprietary();
        this.licensePlate = "N/A";
        this.liability = -1;
    }

    /**
     * Construtor parametrizado.
     *
     * @param brand        marca do carro
     * @param mediumSpeed  velocidade média do carro
     * @param priceKm      preço por quilómetro de viagem do carro
     * @param consumeKm    consumo por kilómetro
     * @param pastRents    listagem dos arrendamentos anteriores do carro
     * @param rating       avaliação do carro
     * @param location     localização atual do carro
     * @param proprietary  proprietário do carro
     * @param licensePlate matrícula do carro
     * @param liability    fiabilidade do carro
     */
    public Car(String brand, int mediumSpeed, double priceKm, double consumeKm, List<Rental> pastRents, int rating,
               Point2D.Double location, Proprietary proprietary, String licensePlate, int liability) {
        this.brand = brand;
        this.mediumSpeed = mediumSpeed;
        this.priceKm = priceKm;
        this.consumeKm = consumeKm;
        this.pastRents = pastRents;
        this.rating = rating;
        this.location = location;
        this.proprietary = proprietary;
        this.licensePlate = licensePlate;
        this.liability = liability;
    }

    /**
     * Construtor cópia
     */
    public Car(Car car) {
        this.brand = car.getBrand();
        this.mediumSpeed = car.getMediumSpeed();
        this.priceKm = car.getPriceKm();
        this.consumeKm = car.getConsumeKm();
        this.pastRents = car.getPastRents();
        this.rating = car.getRating();
        this.location = car.getLocation();
        this.proprietary = car.getProprietary();
        this.licensePlate = car.getLicensePlate();
        this.liability = car.getLiability();
    }

    /**
     * Devolve a marca do carro.
     *
     * @return marca do carro
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Atribui ao carro uma marca.
     *
     * @param brand marca
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Devolve a velocidade média do carro.
     *
     * @return velocidade média do carro
     */
    public int getMediumSpeed() {
        return mediumSpeed;
    }

    /**
     * Atribui ao carro uma velocidade média.
     *
     * @param mediumSpeed velocidade média
     */
    public void setMediumSpeed(int mediumSpeed) {
        this.mediumSpeed = mediumSpeed;
    }

    /**
     * Devolve o preço por quilómetro de viagem do carro.
     *
     * @return preço por quilómetro de viagem
     */
    public double getPriceKm() {
        return priceKm;
    }

    public String getPriceKmString() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(priceKm);
    }

    /**
     * Atribui ao carro um preço por quilómetro de viagem.
     *
     * @param priceKm preço por quilómetro de viagem
     */
    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    /**
     * Devolve o consumo por quilómetro de viagem do carro.
     *
     * @return consumo por quilómetro de viagem
     */
    public double getConsumeKm() {
        return consumeKm;
    }

    /**
     * Atribui ao carro um consumo por quilómetro de viagem.
     *
     * @param consumeKm consumo por quilómetro de viagem
     */
    public void setConsumeKm(double consumeKm) {
        this.consumeKm = consumeKm;
    }

    /**
     * Devolve uma listagem dos arrendamentos anteriores do carro.
     *
     * @return arrendamentos anteriores do carro
     */
    public List<Rental> getPastRents() {
        return pastRents;
    }

    /**
     * Atribui ao carro uma listagem de arrendamentos anteriores.
     *
     * @param pastRents arrendamentos anteriores do carro
     */
    public void setPastRents(List<Rental> pastRents) {
        this.pastRents = pastRents;
    }

    /**
     * Devolve a avaliação que foi atribuída ao carro.
     *
     * @return avaliação do carro
     */
    public int getRating() {
        return rating;
    }

    /**
     * Atribui uma avaliação ao carro.
     *
     * @param rating avaliação do carro
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Devolve a localização atual do carro.
     *
     * @return localização do carro
     */
    public Point2D.Double getLocation() {
        return location;
    }

    public String getLocationString() {
        DecimalFormat xy = new DecimalFormat("#.##");
        return "(" + xy.format(location.x) + "," + xy.format(location.y) + ")";
    }

    /**
     * Atribui ao carro uma localização.
     *
     * @param location localização do carro
     */
    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    /**
     * Devolve o proprietário do carro.
     *
     * @return proprietário do carro
     */
    public Proprietary getProprietary() {
        return proprietary;
    }

    /**
     * Atribui ao carro um proprietário.
     *
     * @param proprietary proprietário do carro
     */
    public void setProprietary(Proprietary proprietary) {
        this.proprietary = proprietary;
    }

    /**
     * Devolve a matrícula do carro.
     *
     * @return matrícula do carro
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Atribui ao carro uma matrícula.
     *
     * @param licensePlate matrícula do carro
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Devolve a fiabilidade do carro.
     *
     * @return fiabilidade do carro
     */
    public int getLiability() {
        return liability;
    }

    /**
     * Atribui ao carro uma fiabilidade.
     *
     * @param liability fiabilidade do carro
     */
    public void setLiability(int liability) {
        this.liability = liability;
    }

    /**
     * Método que verifica se dois Carros são iguais.
     *
     * @param o objeto a ser usado como termo de comparação
     * @return Booleano indicativo de se os objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mediumSpeed == car.mediumSpeed &&
                Double.compare(car.priceKm, priceKm) == 0 &&
                rating == car.rating &&
                liability == car.liability &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(pastRents, car.pastRents) &&
                Objects.equals(location, car.location) &&
                Objects.equals(proprietary, car.proprietary) &&
                Objects.equals(licensePlate, car.licensePlate);
    }

    /**
     * Devolve o valor de hash.
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, mediumSpeed, priceKm, consumeKm, pastRents, rating, location, proprietary,
                licensePlate, liability);
    }

    /**
     * Método que devolve a representação em String do Carro.
     *
     * @return String que representa o Carro
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", mediumSpeed=" + mediumSpeed +
                ", priceKm=" + priceKm +
                ", consumekm" + consumeKm +
                ", pastRents=" + pastRents.toString() +
                ", rating=" + rating +
                ", location=" + location.toString() +
                ", proprietary=" + proprietary +
                ", licensePlate='" + licensePlate + '\'' +
                ", liability=" + liability +
                '}';
    }

    /**
     * Método que faz uma cópia do Carro, invocando para tal o construtor cópia.
     *
     * @return cópia do Carro.
     */
    public Car clone() {
        Car newCar = new Car();
        newCar.setMediumSpeed(this.mediumSpeed);
        newCar.setPriceKm(this.priceKm);
        newCar.setConsumeKm(this.consumeKm);
        newCar.setPastRents(this.pastRents);
        newCar.setRating(this.rating);
        newCar.setLocation(this.location);
        newCar.setProprietary(this.proprietary);
        newCar.setLicensePlate(this.licensePlate);
        newCar.setLiability(this.liability);
        return newCar;
    }
}