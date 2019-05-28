import java.awt.geom.Point2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Atores do sistema que interagem com a aplicação.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */

public class Rental implements Serializable {
    private Car rentedCar;
    private Client client;
    private Point2D.Double initialPosCar;
    private Point2D.Double finalPos;
    private String rentalStatus;
    private LocalDate rentalDate;
    private LocalDate useStartDate;
    private LocalDate useFinishDate;
    private int rating;

    /**
     * Construtor por omissão.
     */
    public Rental() {
        this.rentedCar = new Car();
        this.client = new Client();
        this.initialPosCar = null;
        this.finalPos = null;
        this.rentalStatus = "N/A";
        this.rentalDate = null;
        this.useStartDate = null;
        this.useFinishDate = null;
        this.rating = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param rentedCar     carro alugado
     * @param client        cliente que alugou o carro
     * @param initialPosCar posição inicial do carro alugado
     * @param finalPos      posição final do carro alugado após a viagem
     * @param rentalStatus  estado do aluguer do carro
     * @param rentalDate    data de aluguer do carro
     * @param useStartDate  data do inicio de uso do carro alugado
     * @param useFinishDate data de fim de uso do carro alugado
     * @param rating        avaliação atribuída ao aluguer do carro
     */
    public Rental(Car rentedCar, Client client, Point2D.Double initialPosCar, Point2D.Double finalPos,
                  String rentalStatus, LocalDate rentalDate, LocalDate useStartDate,
                  LocalDate useFinishDate, int rating) {
        this.rentedCar = rentedCar;
        this.client = client;
        this.initialPosCar = initialPosCar;
        this.finalPos = finalPos;
        this.rentalStatus = rentalStatus;
        this.rentalDate = rentalDate;
        this.useStartDate = useStartDate;
        this.useFinishDate = useFinishDate;
        this.rating = rating;
    }

    /**
     * Construtor cópia.
     */
    public Rental(Rental rental) {
        this.rentedCar = rental.getRentedCar();
        this.client = rental.getClient();
        this.initialPosCar = rental.getInitialPosCar();
        this.finalPos = rental.getFinalPos();
        this.rentalStatus = rental.getRentalStatus();
        this.rentalDate = rental.getRentalDate();
        this.useStartDate = rental.getUseStartDate();
        this.useFinishDate = rental.getUseFinishDate();
        this.rating = rental.getRating();
    }

    /**
     * Devolve o carro que está a ser alugado.
     *
     * @return carro alugado
     */
    public Car getRentedCar() {
        return rentedCar;
    }

    public String getCar() {
        return rentedCar.getLicensePlate();
    }

    /**
     * Atribui ao aluguer o carro a ser alugado.
     *
     * @param rentedCar carro alugado
     */
    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    /**
     * Devolve o cliente que está a fazer o aluguer do carro.
     *
     * @return cliente que alugou o carro
     */
    public Client getClient() {
        return client;
    }

    /**
     * Atribui ao aluguer um cliente.
     *
     * @param client cliente que alugou o carro
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Devolve a posição inicial do carro alugado.
     *
     * @return posição inicial do carro alugado
     */
    public Point2D.Double getInitialPosCar() {
        return initialPosCar;
    }

    /**
     * Atribui ao aluguer a posição inicial do carro
     *
     * @param initialPosCar posição do carro alugado
     */
    public void setInitialPosCar(Point2D.Double initialPosCar) {
        this.initialPosCar = initialPosCar;
    }

    /**
     * Devolve a posição final do carro após o término do aluguer.
     *
     * @return posição final do carro alugado após a viagem
     */
    public Point2D.Double getFinalPos() {
        return finalPos;
    }

    /**
     * Atribui ao aluguer a posição final do carro.
     *
     * @param finalPos posição final do carro após a viagem
     */
    public void setFinalPos(Point2D.Double finalPos) {
        this.finalPos = finalPos;
    }

    /**
     * Devolve o estado atual do aluguer do carro.
     *
     * @return estado do aluguer do carro
     */
    public String getRentalStatus() {
        return rentalStatus;
    }

    /**
     * Atribui ao aluguer do carro um estado.
     *
     * @param rentalStatus estado do aluguer do carro
     */
    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    /**
     * Devolve a data de aluguer do carro.
     *
     * @return data de aluguer do carro
     */
    public LocalDate getRentalDate() {
        return rentalDate;
    }

    /**
     * Atribui ao aluguer do carro uma data de aluguer.
     *
     * @param rentalDate data de aluguer do carro
     */
    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    /**
     * Devolve a data de início de uso do carro alugado.
     *
     * @return data de início de uso do carro alugado
     */
    public LocalDate getUseStartDate() {
        return useStartDate;
    }

    /**
     * Atribui ao aluguer do carro uma data de início de uso.
     *
     * @param useStartDate data de início de uso do carro alugado
     */
    public void setUseStartDate(LocalDate useStartDate) {
        this.useStartDate = useStartDate;
    }

    /**
     * Devolve a data de término de uso do carro alugado.
     *
     * @return data de fim de uso do carro alugado
     */
    public LocalDate getUseFinishDate() {
        return useFinishDate;
    }

    /**
     * Atribui ao aluguer do carro uma data de término de uso.
     *
     * @param useFinishDate data de fim de uso do carro alugado
     */
    public void setUseFinishDate(LocalDate useFinishDate) {
        this.useFinishDate = useFinishDate;
    }

    /**
     * Devolve a avaliação do aluguer do carro.
     *
     * @return avaliação do aluguer do carro
     */
    public int getRating() {
        return rating;
    }

    /**
     * Atribui ao aluguer do carro uma avaliação.
     *
     * @param rating avaliação do alguer do carro
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Método que verifica se dois alugueres são iguais.
     *
     * @param o Objeto a ser usado como termo de comparação
     * @return Booleano que indica se os dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return rating == rental.rating &&
                Objects.equals(rentedCar, rental.rentedCar) &&
                Objects.equals(client, rental.client) &&
                Objects.equals(initialPosCar, rental.initialPosCar) &&
                Objects.equals(finalPos, rental.finalPos) &&
                Objects.equals(rentalStatus, rental.rentalStatus) &&
                Objects.equals(rentalDate, rental.rentalDate) &&
                Objects.equals(useStartDate, rental.useStartDate) &&
                Objects.equals(useFinishDate, rental.useFinishDate);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(rentedCar, client, initialPosCar, finalPos, rentalStatus, rentalDate, useStartDate,
                useFinishDate, rating);
    }

    /**
     * Método que devolve a representação em String do Aluguer.
     *
     * @return String que representa o Aluguer
     */
    @Override
    public String toString() {
        return "Rental{" +
                "rentedCar=" + rentedCar.getLicensePlate() +
                ", client=" + client.getEmail() +
                ", initialPosCar=" + initialPosCar.toString() +
                ", finalPos=" + finalPos.toString() +
                ", rentalStatus='" + rentalStatus + '\'' +
                ", rentalDate=" + rentalDate.toString() +
                ", useStartDate=" + useStartDate.toString() +
                ", useFinishDate=" + useFinishDate.toString() +
                ", rating=" + rating +
                '}';
    }

    /**
     * Método que faz uma cópia do Aluguer, invocando para tal o construtor cópia.
     *
     * @return cópia do Aluguer
     */
    public Rental clone() {
        Rental newRental = new Rental();
        newRental.setRentedCar(this.rentedCar);
        newRental.setClient(this.client);
        newRental.setInitialPosCar(this.initialPosCar);
        newRental.setFinalPos(this.finalPos);
        newRental.setRentalStatus(this.rentalStatus);
        newRental.setRentalDate(this.rentalDate);
        newRental.setUseStartDate(this.useStartDate);
        newRental.setUseFinishDate(this.useFinishDate);
        newRental.setRating(this.rating);
        return newRental;
    }

    public String getCarBrand() {
        return rentedCar.getBrand();
    }

    public String getDistance() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(Service.distance(initialPosCar, finalPos));
    }

    public String getPrice() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(Service.tripCost(Service.distance(initialPosCar, finalPos), rentedCar));
    }
}