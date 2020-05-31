package com.udacity.pricing.domain.price;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    @Id
    @Min(message = "Vehicle Id cannot be negative", value = 0)
    private Long vehicleId;

    private String currency;
    @Min(message = "Cannot be negative", value = 0)
    private BigDecimal price;


    public Price() {
    }

    public Price(String currency, BigDecimal price, Long vehicleId) {
        this.currency = currency;
        this.price = price;
        this.vehicleId = vehicleId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
