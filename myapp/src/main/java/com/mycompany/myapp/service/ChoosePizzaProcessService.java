package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ChoosePizzaProcess;
import com.mycompany.myapp.repository.ChoosePizzaProcessRepository;
import com.mycompany.myapp.repository.ChoosePizzaRepository;
import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import com.mycompany.myapp.service.mapper.ChoosePizzaProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ChoosePizzaProcess}.
 */
@Service
@Transactional
public class ChoosePizzaProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "PizzaFlowProcess";

    private final Logger log = LoggerFactory.getLogger(ChoosePizzaProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final ChoosePizzaRepository choosePizzaRepository;

    private final ChoosePizzaProcessRepository choosePizzaProcessRepository;

    private final ChoosePizzaProcessMapper choosePizzaProcessMapper;

    public ChoosePizzaProcessService(
        ProcessInstanceService processInstanceService,
        ChoosePizzaRepository choosePizzaRepository,
        ChoosePizzaProcessRepository choosePizzaProcessRepository,
        ChoosePizzaProcessMapper choosePizzaProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.choosePizzaRepository = choosePizzaRepository;
        this.choosePizzaProcessRepository = choosePizzaProcessRepository;
        this.choosePizzaProcessMapper = choosePizzaProcessMapper;
    }

    /**
     * Save a choosePizzaProcess.
     *
     * @param choosePizzaProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public ChoosePizzaProcessDTO create(ChoosePizzaProcessDTO choosePizzaProcessDTO) {
        log.debug("Request to save ChoosePizzaProcess : {}", choosePizzaProcessDTO);

        ChoosePizzaProcess choosePizzaProcess = choosePizzaProcessMapper.toEntity(choosePizzaProcessDTO);

        //Saving the domainEntity
        choosePizzaRepository.save(choosePizzaProcess.getChoosePizza());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "ChoosePizza#" + choosePizzaProcess.getChoosePizza().getId(),
            choosePizzaProcess
        );
        choosePizzaProcess.setProcessInstance(processInstance);

        //Saving the process entity
        choosePizzaProcess = choosePizzaProcessRepository.save(choosePizzaProcess);
        return choosePizzaProcessMapper.toDto(choosePizzaProcess);
    }

    /**
     * Get all the choosePizzaProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ChoosePizzaProcessDTO> findAll() {
        log.debug("Request to get all ChoosePizzaProcesss");
        return choosePizzaProcessRepository
            .findAll()
            .stream()
            .map(choosePizzaProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one choosePizzaProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ChoosePizzaProcessDTO> findOne(Long id) {
        log.debug("Request to get ChoosePizzaProcess : {}", id);
        return choosePizzaProcessRepository.findById(id).map(choosePizzaProcessMapper::toDto);
    }

    /**
     * Get one choosePizzaProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ChoosePizzaProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get ChoosePizzaProcess by  processInstanceId: {}", processInstanceId);
        return choosePizzaProcessRepository.findByProcessInstanceId(processInstanceId).map(choosePizzaProcessMapper::toDto);
    }
}
