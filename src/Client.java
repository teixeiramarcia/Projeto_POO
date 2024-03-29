import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Clients.
 *
 * @author A85762
 * @author A81283
 * @author A80943
 * @version 20190525
 */

public class Client extends User {
    private Point2D.Double location;
    private List<Rental> rentals;
    private int rating;
    private int drivingSkill;

    /**
     * Construtor por omissão.
     */
    public Client() {
        super();
        this.location = null;
        this.rentals = new ArrayList<>();
        this.rating = -1;
        this.drivingSkill = -1;
    }

    /**
     * @param name         nome do cliente
     * @param email        email do cliente
     * @param password     password do cliente
     * @param address      morada do cliente
     * @param birthDate    data de nascimento do cliente
     * @param nif          número de identificação fiscal do cliente
     * @param location     localização atual do cliente
     * @param rentals      listagem de arrendamentos passados feitos pelo cliente
     * @param rating       avaliação do cliente
     * @param drivingSkill destreza de condução do cliente
     */
    public Client(String name, String email, String password, String address, LocalDate birthDate, String nif,
                  Point2D.Double location, List<Rental> rentals, int rating, int drivingSkill) {
        super(name, email, password, address, birthDate, nif);
        this.location = location;
        this.rentals = rentals;
        this.rating = rating;
        this.drivingSkill = drivingSkill;
    }

    /**
     * Construtor cópia.
     */
    public Client(Client client) {
        super(client);
        this.location = client.getLocation();
        this.rentals = client.getRentals();
        this.rating = client.getRating();
        this.drivingSkill = client.getDrivingSkill();
    }

    /**
     * Devolve a localização atual do cliente.
     *
     * @return localização atual do cliente
     */
    public Point2D.Double getLocation() {
        return location;
    }

    /**
     * Atribui ao cliente uma posição atual.
     *
     * @param location posição atual do cliente
     */
    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    /**
     * Devolve a listagem dos arrendamentos anteriores feitos pelo cliente.
     *
     * @return arrendamentos anteriores do cliente
     */
    public List<Rental> getRentals() {
        return rentals;
    }

    /**
     * Atribui uma listagem dos arrendamentos anteriores do cliente.
     *
     * @param rentals arrendamentos anteriores do cliente
     */
    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    /**
     * Devolve a avaliação do cliente.
     *
     * @return avaliação do cliente
     */
    public int getRating() {
        return rating;
    }

    /**
     * Atribui ao cliente uma avaliação.
     *
     * @param rating avaliação do cliente
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Devolve a destreza de condução do cliente.
     *
     * @return destreeza de consdução do cliente
     */
    public int getDrivingSkill() {
        return drivingSkill;
    }

    /**
     * Atribui ao cliente uma destreza de condução.
     *
     * @param drivingSkill destreza de condução do cliente
     */
    public void setDrivingSkill(int drivingSkill) {
        this.drivingSkill = drivingSkill;
    }

    /**
     * Método que verifica se dois clientes são iguais.
     *
     * @param o objeto a ser usado como termo de comparação
     * @return Booleano que indica se os dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return rating == client.rating &&
                drivingSkill == client.drivingSkill &&
                Objects.equals(location, client.location) &&
                Objects.equals(rentals, client.rentals);
    }

    /**
     * Devolve o valor de hash.
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location, rentals, rating, drivingSkill);
    }

    /**
     * Método que devolve a representação em String do cliente.
     *
     * @return String que representa um cliente
     */
    @Override
    public String toString() {
        return "Client{" +
                "location=" + location.toString() +
                ", rentals=" + rentals.toString() +
                ", rating=" + rating +
                ", drivingSkill=" + drivingSkill +
                '}';
    }

    /**
     * Método que faz uma cópia do cliente, invocando para tal o construtor cópia.
     *
     * @return cópia do cliente
     */
    public Client clone() {
        Client newClient = (Client) super.clone();
        newClient.setLocation(this.location);
        newClient.setRentals(this.rentals);
        newClient.setRating(this.rating);
        newClient.setDrivingSkill(this.drivingSkill);
        return newClient;
    }
}