package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.ChoosePizzaRepository;
import com.mycompany.myapp.service.ChoosePizzaService;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ChoosePizza}.
 */
@RestController
@RequestMapping("/api")
public class ChoosePizzaResource {

    private final Logger log = LoggerFactory.getLogger(ChoosePizzaResource.class);

    private final ChoosePizzaService choosePizzaService;

    private final ChoosePizzaRepository choosePizzaRepository;

    public ChoosePizzaResource(ChoosePizzaService choosePizzaService, ChoosePizzaRepository choosePizzaRepository) {
        this.choosePizzaService = choosePizzaService;
        this.choosePizzaRepository = choosePizzaRepository;
    }

    /**
     * {@code GET  /choose-pizzas} : get all the choosePizzas.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of choosePizzas in body.
     */
    @GetMapping("/choose-pizzas")
    public List<ChoosePizzaDTO> getAllChoosePizzas() {
        log.debug("REST request to get all ChoosePizzas");
        return choosePizzaService.findAll();
    }

    /**
     * {@code GET  /choose-pizzas/:id} : get the "id" choosePizza.
     *
     * @param id the id of the choosePizzaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the choosePizzaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/choose-pizzas/{id}")
    public ResponseEntity<ChoosePizzaDTO> getChoosePizza(@PathVariable Long id) {
        log.debug("REST request to get ChoosePizza : {}", id);
        Optional<ChoosePizzaDTO> choosePizzaDTO = choosePizzaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(choosePizzaDTO);
    }
}
