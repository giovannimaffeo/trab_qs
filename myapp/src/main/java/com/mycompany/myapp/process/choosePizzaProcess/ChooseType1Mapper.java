package com.mycompany.myapp.process.choosePizzaProcess;

import com.mycompany.myapp.domain.ChoosePizza;
import com.mycompany.myapp.domain.ChoosePizzaProcess;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface ChooseType1Mapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    ChoosePizzaProcessDTO toChoosePizzaProcessDTO(ChoosePizzaProcess choosePizzaProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerAddress", source = "customerAddress")
    @Mapping(target = "customerPhone", source = "customerPhone")
    @Mapping(target = "customerEmail", source = "customerEmail")
    @Mapping(target = "pizzaType1", source = "pizzaType1")
    ChoosePizzaDTO toChoosePizzaDTO(ChoosePizza choosePizza);
}
