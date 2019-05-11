import java.awt.geom.Point2D;
import java.util.Objects;

/**
 * Write a description of class RentalRequest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RentalRequest {
    private Client client;
    private Point2D.Double destiny;
    private String fuelType;
    private String preference;

    public RentalRequest() {
        this.client = null;
        this.destiny = null;
        this.fuelType = "N/A";
        this.preference = "N/A";
    }

    public RentalRequest(Client client, Point2D.Double destiny, String fuelType, String preference) {
        this.client = client;
        this.destiny = destiny;
        this.fuelType = fuelType;
        this.preference = preference;
    }

    public RentalRequest(RentalRequest rentalRequest) {
        this.client = rentalRequest.getClient();
        this.destiny = rentalRequest.getDestiny();
        this.fuelType = rentalRequest.getFuelType();
        this.preference = rentalRequest.getPreference();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Point2D.Double getDestiny() {
        return destiny;
    }

    public void setDestiny(Point2D.Double destiny) {
        this.destiny = destiny;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalRequest that = (RentalRequest) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(destiny, that.destiny) &&
                Objects.equals(fuelType, that.fuelType) &&
                Objects.equals(preference, that.preference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, destiny, fuelType, preference);
    }

    @Override
    public String toString() {
        return "RentalRequest{" +
                "client=" + client +
                ", destiny=" + destiny.toString() +
                ", fuelType='" + fuelType + '\'' +
                ", preference='" + preference + '\'' +
                '}';
    }

    public RentalRequest clone() {
        RentalRequest newRentalRequest = new RentalRequest();
        newRentalRequest.setClient(this.client);
        newRentalRequest.setDestiny(this.destiny);
        newRentalRequest.setFuelType(this.fuelType);
        newRentalRequest.setPreference(this.preference);
        return newRentalRequest;
    }
}
