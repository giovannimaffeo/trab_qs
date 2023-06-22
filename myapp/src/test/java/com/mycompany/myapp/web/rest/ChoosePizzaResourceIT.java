package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.ChoosePizza;
import com.mycompany.myapp.repository.ChoosePizzaRepository;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import com.mycompany.myapp.service.mapper.ChoosePizzaMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ChoosePizzaResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ChoosePizzaResourceIT {

    private static final String DEFAULT_PIZZA_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PIZZA_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PIZZA_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_PIZZA_SIZE = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_PHONE = "BBBBBBBBBB";

    private static final Double DEFAULT_PIZZA_PRICE = 1D;
    private static final Double UPDATED_PIZZA_PRICE = 2D;

    private static final String ENTITY_API_URL = "/api/choose-pizzas";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ChoosePizzaRepository choosePizzaRepository;

    @Autowired
    private ChoosePizzaMapper choosePizzaMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restChoosePizzaMockMvc;

    private ChoosePizza choosePizza;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ChoosePizza createEntity(EntityManager em) {
        ChoosePizza choosePizza = new ChoosePizza()
            .pizzaType(DEFAULT_PIZZA_TYPE)
            .pizzaSize(DEFAULT_PIZZA_SIZE)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .customerAddress(DEFAULT_CUSTOMER_ADDRESS)
            .customerPhone(DEFAULT_CUSTOMER_PHONE)
            .pizzaPrice(DEFAULT_PIZZA_PRICE);
        return choosePizza;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ChoosePizza createUpdatedEntity(EntityManager em) {
        ChoosePizza choosePizza = new ChoosePizza()
            .pizzaType(UPDATED_PIZZA_TYPE)
            .pizzaSize(UPDATED_PIZZA_SIZE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .customerAddress(UPDATED_CUSTOMER_ADDRESS)
            .customerPhone(UPDATED_CUSTOMER_PHONE)
            .pizzaPrice(UPDATED_PIZZA_PRICE);
        return choosePizza;
    }

    @BeforeEach
    public void initTest() {
        choosePizza = createEntity(em);
    }

    @Test
    @Transactional
    void getAllChoosePizzas() throws Exception {
        // Initialize the database
        choosePizzaRepository.saveAndFlush(choosePizza);

        // Get all the choosePizzaList
        restChoosePizzaMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(choosePizza.getId().intValue())))
            .andExpect(jsonPath("$.[*].pizzaType").value(hasItem(DEFAULT_PIZZA_TYPE)))
            .andExpect(jsonPath("$.[*].pizzaSize").value(hasItem(DEFAULT_PIZZA_SIZE)))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].customerAddress").value(hasItem(DEFAULT_CUSTOMER_ADDRESS)))
            .andExpect(jsonPath("$.[*].customerPhone").value(hasItem(DEFAULT_CUSTOMER_PHONE)))
            .andExpect(jsonPath("$.[*].pizzaPrice").value(hasItem(DEFAULT_PIZZA_PRICE.doubleValue())));
    }

    @Test
    @Transactional
    void getChoosePizza() throws Exception {
        // Initialize the database
        choosePizzaRepository.saveAndFlush(choosePizza);

        // Get the choosePizza
        restChoosePizzaMockMvc
            .perform(get(ENTITY_API_URL_ID, choosePizza.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(choosePizza.getId().intValue()))
            .andExpect(jsonPath("$.pizzaType").value(DEFAULT_PIZZA_TYPE))
            .andExpect(jsonPath("$.pizzaSize").value(DEFAULT_PIZZA_SIZE))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.customerAddress").value(DEFAULT_CUSTOMER_ADDRESS))
            .andExpect(jsonPath("$.customerPhone").value(DEFAULT_CUSTOMER_PHONE))
            .andExpect(jsonPath("$.pizzaPrice").value(DEFAULT_PIZZA_PRICE.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingChoosePizza() throws Exception {
        // Get the choosePizza
        restChoosePizzaMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
