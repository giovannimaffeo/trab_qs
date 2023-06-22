package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChoosePizzaMapperTest {

    private ChoosePizzaMapper choosePizzaMapper;

    @BeforeEach
    public void setUp() {
        choosePizzaMapper = new ChoosePizzaMapperImpl();
    }
}
