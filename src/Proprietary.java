import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subclasse de User que representa a informação adicional dos Proprietaries.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190325
 */

public class Proprietary extends User {
    private List<Car> cars;
    private int rating;
    private List<Rental> rented;

    public Proprietary() {
        super();
        this.cars = new ArrayList<>();
        this.rating = -1;
        this.rented = new ArrayList<>();
    }

    public Proprietary(String email, String password, String address, String birthDate, Point location, List<Car> cars,
                       int rating, List<Rental> rented) {
        super(email, password, address, birthDate, location);
        this.cars = cars;
        this.rating = rating;
        this.rented = rented;
    }

    public Proprietary(Proprietary proprietary) {
        super(proprietary);
        this.cars = proprietary.getCars();
        this.rating = proprietary.getRating();
        this.rented = proprietary.getRented();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Rental> getRented() {
        return rented;
    }

    public void setRented(List<Rental> rented) {
        this.rented = rented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Proprietary that = (Proprietary) o;
        return rating == that.rating &&
                Objects.equals(cars, that.cars) &&
                Objects.equals(rented, that.rented);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cars, rating, rented);
    }

    @Override
    public String toString() {
        return "Proprietary{" +
                super.toString() +
                ", cars=" + cars.toString() +
                ", rating=" + rating +
                ", rented=" + rented.toString() +
                '}';
    }

    public Proprietary clone() {
        Proprietary newProprietary = (Proprietary) super.clone();
        newProprietary.setCars(this.cars);
        newProprietary.setRating(this.rating);
        newProprietary.setRented(this.rented);
        return newProprietary;
    }
}
