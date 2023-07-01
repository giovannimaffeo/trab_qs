package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ChoosePizzaDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ChoosePizzaDTO.class);
        ChoosePizzaDTO choosePizzaDTO1 = new ChoosePizzaDTO();
        choosePizzaDTO1.setId(1L);
        ChoosePizzaDTO choosePizzaDTO2 = new ChoosePizzaDTO();
        assertThat(choosePizzaDTO1).isNotEqualTo(choosePizzaDTO2);
        choosePizzaDTO2.setId(choosePizzaDTO1.getId());
        assertThat(choosePizzaDTO1).isEqualTo(choosePizzaDTO2);
        choosePizzaDTO2.setId(2L);
        assertThat(choosePizzaDTO1).isNotEqualTo(choosePizzaDTO2);
        choosePizzaDTO1.setId(null);
        assertThat(choosePizzaDTO1).isNotEqualTo(choosePizzaDTO2);
    }
}
