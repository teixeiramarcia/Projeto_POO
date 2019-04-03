import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Write a description of class Weather here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190402
 */

public class Weather {
    private List<WeatherStatus> weathers;

    public Weather() {
        this.weathers = new ArrayList<>();
    }

    public Weather(List<WeatherStatus> weathers) {
        this.weathers = weathers;
    }

    public Weather(Weather weathers) {
        this.weathers = weathers.getWeathers();
    }

    public List<WeatherStatus> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherStatus> weathers) {
        this.weathers = weathers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(weathers, weather.weathers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weathers);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weathers=" + weathers +
                '}';
    }

    public Weather clone() {
        Weather newWeathers = new Weather();
        newWeathers.setWeathers(this.weathers);
        return newWeathers;
    }
}
