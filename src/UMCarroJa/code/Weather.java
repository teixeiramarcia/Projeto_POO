package UMCarroJa.code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que contém todos os tipos de metereologia possíveis.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190519
 */

public class Weather implements Serializable {
    private List<WeatherStatus> weathers;

    /**
     * Construtor por omissão.
     */
    public Weather() {
        this.weathers = new ArrayList<>();
    }

    /**
     * Construtor parametrizado
     *
     * @param weathers listagem de possíveis estados da metereologia
     */
    public Weather(List<WeatherStatus> weathers) {
        this.weathers = weathers;
    }

    /**
     * Construtor cópia.
     */
    public Weather(Weather weathers) {
        this.weathers = weathers.getWeathers();
    }

    /**
     * Devolve a listagem de possíveis estados de metereologia.
     *
     * @return lista de possíveis estados de metereologia
     */
    public List<WeatherStatus> getWeathers() {
        return weathers;
    }

    /**
     * Atribui uma listagem de possíveis estados de metereologia.
     *
     * @param weathers lista de possíveis estados de metereologia
     */
    public void setWeathers(List<WeatherStatus> weathers) {
        this.weathers = weathers;
    }

    /**
     * Método que verifica se dois Weathers são iguais.
     *
     * @param o Objeto a ser usado como termo de comparação
     * @return Booleano que indica se os dois objetos são iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(weathers, weather.weathers);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(weathers);
    }

    /**
     * Método que devolve a representação em String do Weather.
     *
     * @return String que representa o Weather
     */
    @Override
    public String toString() {
        return "Weather{" +
                "weathers=" + weathers +
                '}';
    }

    /**
     * Método que faz uma cópia do Weather, invocando para tal o construtor cópia.
     *
     * @return cópia do Weather
     */
    public Weather clone() {
        Weather newWeathers = new Weather();
        newWeathers.setWeathers(this.weathers);
        return newWeathers;
    }
}