import java.util.Objects;

/**
 * Write a description of class WeatherStatus here.
 *
 * @author A80943
 * @author A81283
 * @author A85762
 * @version 20190403
 */

public class WeatherStatus {
    private String weatherATM;
    private int tripTimePenalty;

    /**
     * Construtor por omissão.
     */
    public WeatherStatus() {
        this.weatherATM = "N/A";
        this.tripTimePenalty = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param weatherATM      estado metereológico atual
     * @param tripTimePenalty penalização do tipo de metereologia a aplicar no tempo de viagem
     */
    public WeatherStatus(String weatherATM, int tripTimePenalty) {
        this.weatherATM = weatherATM;
        this.tripTimePenalty = tripTimePenalty;
    }

    /**
     * Construtor cópia.
     */
    public WeatherStatus(WeatherStatus weatherStatus) {
        this.weatherATM = weatherStatus.getWeatherATM();
        this.tripTimePenalty = weatherStatus.getTripTimePenalty();
    }

    /**
     * Devolve o estado metereológico atual.
     *
     * @return estado metereológico atual
     */
    public String getWeatherATM() {
        return weatherATM;
    }

    /**
     * Atribui um estado metereológico atual.
     *
     * @param weatherATM estado metereológico atual
     */
    public void setWeatherATM(String weatherATM) {
        this.weatherATM = weatherATM;
    }

    /**
     * Devolve a penalização do tipo de metereologia a aplicar no tempo de viagem.
     *
     * @return penalização do tipo de metereologia a aplicar no tempo de viagem
     */
    public int getTripTimePenalty() {
        return tripTimePenalty;
    }

    /**
     * Atribui uma penalização do tipo de metereologia a aplicar no tempo de viagem.
     *
     * @param tripTimePenalty penalização do tipo de metereologia a aplicar no tempo de viage
     */
    public void setTripTimePenalty(int tripTimePenalty) {
        this.tripTimePenalty = tripTimePenalty;
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
        WeatherStatus that = (WeatherStatus) o;
        return Double.compare(that.tripTimePenalty, tripTimePenalty) == 0 &&
                Objects.equals(weatherATM, that.weatherATM);
    }

    /**
     * Devolve o valor de hash baseado em (...)
     *
     * @return valor de ash
     */
    @Override
    public int hashCode() {
        return Objects.hash(weatherATM, tripTimePenalty);
    }

    /**
     * Método que devolve a representação em String do estado atual da metereologia.
     *
     * @return String que representa o estado atual da metereologia
     */
    @Override
    public String toString() {
        return "WeatherStatus{" +
                "weatherATM='" + weatherATM + '\'' +
                ", tripTimePenalty=" + tripTimePenalty +
                '}';
    }

    /**
     * Método que faz uma cópia do Estado Metereológico atual, invocando para tal o construtor cópia.
     *
     * @return cópia do Estado Metereológico atual
     */
    public WeatherStatus clone() {
        WeatherStatus newWeatherStatus = new WeatherStatus();
        newWeatherStatus.setWeatherATM(this.weatherATM);
        newWeatherStatus.setTripTimePenalty(this.tripTimePenalty);
        return newWeatherStatus;
    }
}
