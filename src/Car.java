import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Atores do sistema que interagem com a aplicação.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190326
 */

public class Car {
    private int mediumSpeed;
    private double priceKm;
    private List<Rental> pastRents;
    private int rating;
    private Point location;
    private Proprietary proprietary;
    private String licensePlate;
    private int liability;

    /**
     * Construtor por omissão.
     */
    public Car() {
        this.mediumSpeed = 0;
        this.priceKm = 0;
        this.pastRents = new ArrayList<>();
        this.rating = -1;
        this.location = new Point(-1, -1);
        this.proprietary = new Proprietary();
        this.licensePlate = "N/A";
        this.liability = -1;
    }

    /**
     * Construtor parametrizado.
     *
     * @param mediumSpeed  velocidade média do carro
     * @param priceKm      preço por quilómetro de viagem do carro
     * @param pastRents    listagem dos arrendamentos anteriores do carro
     * @param rating       avaliação do carro
     * @param location     localização atual do carro
     * @param proprietary  proprietário do carro
     * @param licensePlate matrícula do carro
     * @param liability    fiabilidade do carro
     */
    public Car(int mediumSpeed, double priceKm, List<Rental> pastRents, int rating, Point location,
               Proprietary proprietary, String licensePlate, int liability) {
        this.mediumSpeed = mediumSpeed;
        this.priceKm = priceKm;
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
        this.mediumSpeed = car.getMediumSpeed();
        this.priceKm = car.getPriceKm();
        this.pastRents = car.getPastRents();
        this.rating = car.getRating();
        this.location = car.getLocation();
        this.proprietary = car.getProprietary();
        this.licensePlate = car.getLicensePlate();
        this.liability = car.getLiability();
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

    /**
     * Atribui ao carro um preço por quilómetro de viagem.
     *
     * @param priceKm preço por quilómetro de viagem
     */
    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
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
    public Point getLocation() {
        return location;
    }

    /**
     * Atribui ao carro uma localização.
     *
     * @param location localização do carro
     */
    public void setLocation(Point location) {
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
                Objects.equals(pastRents, car.pastRents) &&
                Objects.equals(location, car.location) &&
                Objects.equals(proprietary, car.proprietary) &&
                Objects.equals(licensePlate, car.licensePlate);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(mediumSpeed, priceKm, pastRents, rating, location, proprietary, licensePlate, liability);
    }

    /**
     * Método que devolve a representação em String do Carro.
     *
     * @return String que representa o Carro
     */
    @Override
    public String toString() {
        return "Car{" +
                "mediumSpeed=" + mediumSpeed +
                ", priceKm=" + priceKm +
                ", pastRents=" + pastRents +
                ", rating=" + rating +
                ", location=" + location +
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
        newCar.setPastRents(this.pastRents);
        newCar.setRating(this.rating);
        newCar.setLocation(this.location);
        newCar.setProprietary(this.proprietary);
        newCar.setLicensePlate(this.licensePlate);
        newCar.setLiability(this.liability);
        return newCar;
    }

    /**
     * Método que devolve o montante total faturado entre duas datas.
     *
     * @param pastRents listagem dos arrendamentos anteriores do carro em causa
     * @return total faturado entre duas datas
     */
    public double getCarProfitBetweenDates(List<Rental> pastRents) {
        double profit = 0;
        for (Rental rental : pastRents) {
            Point initPos = rental.getInitialPosCar();
            Point finalPos = rental.getFinalPos();
            double dist = Service.distance(initPos, finalPos);
            profit = +Service.tripCost(dist, rental.getRentedCar());
        }
        return profit;
    }

}