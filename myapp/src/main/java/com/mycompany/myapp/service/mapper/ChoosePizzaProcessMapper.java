package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ChoosePizzaProcess} and its DTO {@link ChoosePizzaProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, ChoosePizzaMapper.class })
public interface ChoosePizzaProcessMapper extends EntityMapper<ChoosePizzaProcessDTO, ChoosePizzaProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "choosePizza", source = "choosePizza")
    ChoosePizzaProcessDTO toDto(ChoosePizzaProcess s);
}
