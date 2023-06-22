package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ChoosePizza} and its DTO {@link ChoosePizzaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ChoosePizzaMapper extends EntityMapper<ChoosePizzaDTO, ChoosePizza> {}
