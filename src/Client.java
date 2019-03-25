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
    private Point point;
    private List<Rental> rentals;

    public Client (){
        super();
        this.point = new Point(0,0);
        this.rentals = new ArrayList<>();
    }

    public Client(String email, String password, String address, String birthDate, Point point, List<Rental> rentals) {
        super(email, password, address, birthDate);
        this.point = point;
        this.rentals = rentals;
    }

    public Client (Client client){
        super(client);
        this.point = client.getPoint();
        this.rentals = client.getRentals();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
        return Objects.equals(point, client.point) &&
                Objects.equals(rentals, client.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), point, rentals);
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                ", point=" + point.toString() +
                ", rentals=" + rentals.toString() +
                '}';
    }

    public Client clone() {
        Client newClient = (Client) super.clone();
        newClient.setPoint(this.point);
        newClient.setRentals(this.rentals);
        return newClient;
    }
}
