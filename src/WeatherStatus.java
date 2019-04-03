import java.util.Objects;

/**
 * Write a description of class WeatherStatus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeatherStatus {
    private String weatherATM;
    private int tripTimePenalty;

    public WeatherStatus() {
        this.weatherATM = "N/A";
        this.tripTimePenalty = 0;
    }

    public WeatherStatus(String weatherATM, int tripTimePenalty) {
        this.weatherATM = weatherATM;
        this.tripTimePenalty = tripTimePenalty;
    }

    public WeatherStatus(WeatherStatus weatherStatus) {
        this.weatherATM = weatherStatus.getWeatherATM();
        this.tripTimePenalty = weatherStatus.getTripTimePenalty();
    }

    public String getWeatherATM() {
        return weatherATM;
    }

    public void setWeatherATM(String weatherATM) {
        this.weatherATM = weatherATM;
    }

    public int getTripTimePenalty() {
        return tripTimePenalty;
    }

    public void setTripTimePenalty(int tripTimePenalty) {
        this.tripTimePenalty = tripTimePenalty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherStatus that = (WeatherStatus) o;
        return Double.compare(that.tripTimePenalty, tripTimePenalty) == 0 &&
                Objects.equals(weatherATM, that.weatherATM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherATM, tripTimePenalty);
    }

    @Override
    public String toString() {
        return "WeatherStatus{" +
                "weatherATM='" + weatherATM + '\'' +
                ", tripTimePenalty=" + tripTimePenalty +
                '}';
    }

    public WeatherStatus clone() {
        WeatherStatus newWeatherStatus = new WeatherStatus();
        newWeatherStatus.setWeatherATM(this.weatherATM);
        newWeatherStatus.setTripTimePenalty(this.tripTimePenalty);
        return newWeatherStatus;
    }
}
