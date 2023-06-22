package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ChoosePizzaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ChoosePizza.class);
        ChoosePizza choosePizza1 = new ChoosePizza();
        choosePizza1.setId(1L);
        ChoosePizza choosePizza2 = new ChoosePizza();
        choosePizza2.setId(choosePizza1.getId());
        assertThat(choosePizza1).isEqualTo(choosePizza2);
        choosePizza2.setId(2L);
        assertThat(choosePizza1).isNotEqualTo(choosePizza2);
        choosePizza1.setId(null);
        assertThat(choosePizza1).isNotEqualTo(choosePizza2);
    }
}
