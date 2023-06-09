package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ChoosePizza} entity.
 */
public class ChoosePizzaDTO implements Serializable {

    private Long id;

    private String pizzaType1;

    private String pizzaType2;

    private String pizzaSize;

    private String customerName;

    private String customerAddress;

    private String customerPhone;

    private String customerEmail;

    private Double pizzaPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaType1() {
        return pizzaType1;
    }

    public void setPizzaType1(String pizzaType1) {
        this.pizzaType1 = pizzaType1;
    }

    public String getPizzaType2() {
        return pizzaType2;
    }

    public void setPizzaType2(String pizzaType2) {
        this.pizzaType2 = pizzaType2;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(Double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChoosePizzaDTO)) {
            return false;
        }

        ChoosePizzaDTO choosePizzaDTO = (ChoosePizzaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, choosePizzaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ChoosePizzaDTO{" +
            "id=" + getId() +
            ", pizzaType1='" + getPizzaType1() + "'" +
            ", pizzaType2='" + getPizzaType2() + "'" +
            ", pizzaSize='" + getPizzaSize() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerAddress='" + getCustomerAddress() + "'" +
            ", customerPhone='" + getCustomerPhone() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            ", pizzaPrice=" + getPizzaPrice() +
            "}";
    }
}
