import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Clients.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 *
 * @version 20190325
 */
public class Client extends User {
    private Point location;
    private List<Rental> rentals;

    public Client (){
        super();
        this.location = new Point(0,0);
        this.rentals = new ArrayList<>();
    }

    public Client(String email, String password, String address, String birthDate, Point location, List<Rental> rentals) {
        super(email, password, address, birthDate);
        this.location = location;
        this.rentals = rentals;
    }

    public Client (Client client){
        super(client);
        this.location = client.getPoint();
        this.rentals = client.getRentals();
    }

    public Point getPoint() {
        return location;
    }

    public void setPoint(Point location) {
        this.location = location;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(location, client.location) &&
                Objects.equals(rentals, client.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location, rentals);
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                ", location=" + location.toString() +
                ", rentals=" + rentals.toString() +
                '}';
    }

    public Client clone() {
        Client newClient = (Client) super.clone();
        newClient.setPoint(this.location);
        newClient.setRentals(this.rentals);
        return newClient;
    }
}
