package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ChoosePizza.
 */
@Entity
@Table(name = "choose_pizza")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ChoosePizza implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "pizza_type")
    private String pizzaType;

    @Column(name = "pizza_size")
    private String pizzaSize;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "pizza_price")
    private Double pizzaPrice;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChoosePizza id(Long id) {
        this.id = id;
        return this;
    }

    public String getPizzaType() {
        return this.pizzaType;
    }

    public ChoosePizza pizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
        return this;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaSize() {
        return this.pizzaSize;
    }

    public ChoosePizza pizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
        return this;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public ChoosePizza customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public ChoosePizza customerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public ChoosePizza customerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Double getPizzaPrice() {
        return this.pizzaPrice;
    }

    public ChoosePizza pizzaPrice(Double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
        return this;
    }

    public void setPizzaPrice(Double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChoosePizza)) {
            return false;
        }
        return id != null && id.equals(((ChoosePizza) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ChoosePizza{" +
            "id=" + getId() +
            ", pizzaType='" + getPizzaType() + "'" +
            ", pizzaSize='" + getPizzaSize() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerAddress='" + getCustomerAddress() + "'" +
            ", customerPhone='" + getCustomerPhone() + "'" +
            ", pizzaPrice=" + getPizzaPrice() +
            "}";
    }
}
