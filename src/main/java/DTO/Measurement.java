package DTO;

public class Measurement {
    private Double temperature;
    private Boolean rain;
    private Sensor owner;

    public Measurement() {
    }

    public Measurement(Double temperature, Boolean rain, Sensor owner) {
        this.temperature = temperature;
        this.rain = rain;
        this.owner = owner;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Boolean getRain() {
        return rain;
    }

    public void setRain(Boolean rain) {
        this.rain = rain;
    }

    public Sensor getOwner() {
        return owner;
    }

    public void setOwner(Sensor owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{" +
                "temperature :" + temperature +
                ", rain :" + rain +
                ", owner :" + owner.getName() +
                '}';
    }
}
