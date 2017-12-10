package com.loyaltyone.portal.postportal.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

/**
 * @author Amirreza Soudi
 * @since 2017-12-10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // do not serialize null fields (omit them)
@JsonPropertyOrder({"name, latitude, longitude, temperature"})
public class CityModel {
    String name;
    BigDecimal latitude;
    BigDecimal longitude;
    double temperature;

    public CityModel() {
    }

    @JsonCreator
    public CityModel(@JsonProperty("name") String name,
                     @JsonProperty("latitude") BigDecimal latitude,
                     @JsonProperty("longitude") BigDecimal longitude,
                     @JsonProperty("temperature") double temperature) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityModel cityModel = (CityModel) o;

        if (Double.compare(cityModel.temperature, temperature) != 0) return false;
        if (name != null ? !name.equals(cityModel.name) : cityModel.name != null) return false;
        if (latitude != null ? !latitude.equals(cityModel.latitude) : cityModel.latitude != null) return false;
        return longitude != null ? longitude.equals(cityModel.longitude) : cityModel.longitude == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(latitude)
                .append(longitude)
                .append(temperature)
                .toString();
    }
}
