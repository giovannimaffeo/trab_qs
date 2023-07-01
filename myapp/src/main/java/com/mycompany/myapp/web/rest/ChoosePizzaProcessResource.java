package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ChoosePizzaProcessService;
import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ChoosePizzaProcess}.
 */
@RestController
@RequestMapping("/api")
public class ChoosePizzaProcessResource {

    private final Logger log = LoggerFactory.getLogger(ChoosePizzaProcessResource.class);

    private static final String ENTITY_NAME = "choosePizzaProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ChoosePizzaProcessService choosePizzaProcessService;

    public ChoosePizzaProcessResource(ChoosePizzaProcessService choosePizzaProcessService) {
        this.choosePizzaProcessService = choosePizzaProcessService;
    }

    /**
     * {@code POST  /choose-pizza-processes} : Create a new choosePizzaProcess.
     *
     * @param choosePizzaProcessDTO the choosePizzaProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new choosePizzaProcessDTO, or with status {@code 400 (Bad Request)} if the choosePizzaProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/choose-pizza-processes")
    public ResponseEntity<ChoosePizzaProcessDTO> create(@RequestBody ChoosePizzaProcessDTO choosePizzaProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save ChoosePizzaProcess : {}", choosePizzaProcessDTO);
        if (choosePizzaProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new choosePizzaProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ChoosePizzaProcessDTO result = choosePizzaProcessService.create(choosePizzaProcessDTO);
        return ResponseEntity
            .created(new URI("/api/choose-pizza-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /choose-pizza-processes} : get all the choosePizzaProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of choosePizzaProcesss in body.
     */
    @GetMapping("/choose-pizza-processes")
    public List<ChoosePizzaProcessDTO> getAllChoosePizzaProcesss() {
        log.debug("REST request to get all ChoosePizzaProcesss");
        return choosePizzaProcessService.findAll();
    }

    /**
     * {@code GET  /choose-pizza-processes/:id} : get the "id" choosePizzaProcess.
     *
     * @param processInstanceId the id of the choosePizzaProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the choosePizzaProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/choose-pizza-processes/{processInstanceId}")
    public ResponseEntity<ChoosePizzaProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get ChoosePizzaProcess by processInstanceId : {}", processInstanceId);
        Optional<ChoosePizzaProcessDTO> choosePizzaProcessDTO = choosePizzaProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(choosePizzaProcessDTO);
    }
}
