package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ChoosePizzaProcess} entity.
 */
public class ChoosePizzaProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private ChoosePizzaDTO choosePizza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public ChoosePizzaDTO getChoosePizza() {
        return choosePizza;
    }

    public void setChoosePizza(ChoosePizzaDTO choosePizza) {
        this.choosePizza = choosePizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChoosePizzaProcessDTO)) {
            return false;
        }

        ChoosePizzaProcessDTO choosePizzaProcessDTO = (ChoosePizzaProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, choosePizzaProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ChoosePizzaProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", choosePizza=" + getChoosePizza() +
            "}";
    }
}
