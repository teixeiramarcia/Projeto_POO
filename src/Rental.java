import java.awt.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Write a description of class Rental here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190326
 */

public class Rental {
    private Car rentedCar;
    private Client client;
    private Point initialPosCar;
    private Point finalPos;
    private String rentalStatus;
    private LocalDateTime rentalDate;
    private LocalDateTime useStartDate;
    private LocalDateTime useFinishDate;
    private int rating;

    public Rental() {
        this.rentedCar = new Car();
        this.client = new Client();
        this.initialPosCar = new Point(-1, -1);
        this.finalPos = new Point(-1, 1);
        this.rentalStatus = "N/A";
        this.rentalDate = null;
        this.useStartDate = null;
        this.useFinishDate = null;
        this.rating = 0;
    }

    public Rental(Car rentedCar, Client client, Point initialPosCar, Point finalPos, String rentalStatus,
                  LocalDateTime rentalDate, LocalDateTime useStartDate, LocalDateTime useFinishDate, int rating) {
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

    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Point getInitialPosCar() {
        return initialPosCar;
    }

    public void setInitialPosCar(Point initialPosCar) {
        this.initialPosCar = initialPosCar;
    }

    public Point getFinalPos() {
        return finalPos;
    }

    public void setFinalPos(Point finalPos) {
        this.finalPos = finalPos;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(LocalDateTime useStartDate) {
        this.useStartDate = useStartDate;
    }

    public LocalDateTime getUseFinishDate() {
        return useFinishDate;
    }

    public void setUseFinishDate(LocalDateTime useFinishDate) {
        this.useFinishDate = useFinishDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(rentedCar, client, initialPosCar, finalPos, rentalStatus, rentalDate, useStartDate,
                useFinishDate, rating);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentedCar=" + rentedCar.toString() +
                ", client=" + client.toString() +
                ", initialPosCar=" + initialPosCar.toString() +
                ", finalPos=" + finalPos.toString() +
                ", rentalStatus='" + rentalStatus + '\'' +
                ", rentalDate=" + rentalDate.toString() +
                ", useStartDate=" + useStartDate.toString() +
                ", useFinishDate=" + useFinishDate.toString() +
                ", rating=" + rating +
                '}';
    }

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
}