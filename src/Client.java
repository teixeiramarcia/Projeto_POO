import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Clients.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190325
 */

public class Client extends User {
    private List<Rental> rentals;
    private int rating;
    private int drivingSkill;

    public Client() {
        super();
        this.rentals = new ArrayList<>();
        this.rating = -1;
        this.drivingSkill = -1;
    }

    public Client(String email, String password, String address, String birthDate, Point location,
                  List<Rental> rentals, int rating, int drivingSkill) {
        super(email, password, address, birthDate, location);
        this.rentals = rentals;
        this.rating = rating;
        this.drivingSkill = drivingSkill;
    }

    public Client(Client client) {
        super(client);
        this.rentals = client.getRentals();
        this.rating = client.getRating();
        this.drivingSkill = client.getDrivingSkill();
    }


    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDrivingSkill() {
        return drivingSkill;
    }

    public void setDrivingSkill(int drivingSkill) {
        this.drivingSkill = drivingSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return rating == client.rating &&
                drivingSkill == client.drivingSkill &&
                Objects.equals(rentals, client.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentals, rating, drivingSkill);
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                ", rentals=" + rentals +
                ", rating=" + rating +
                ", drivingSkill=" + drivingSkill +
                '}';
    }

    public Client clone() {
        Client newClient = (Client) super.clone();
        newClient.setRentals(this.rentals);
        newClient.setRating(this.rating);
        newClient.setDrivingSkill(this.drivingSkill);
        return newClient;
    }
}
