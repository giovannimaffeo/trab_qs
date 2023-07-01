package com.mycompany.myapp.process.choosePizzaProcess;

import com.mycompany.myapp.repository.ChoosePizzaProcessRepository;
import com.mycompany.myapp.service.ChoosePizzaService;
import com.mycompany.myapp.service.dto.ChoosePizzaDTO;
import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import com.mycompany.myapp.service.mapper.ChoosePizzaProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class ChooseType1Service {

    private final TaskInstanceService taskInstanceService;

    private final ChoosePizzaService choosePizzaService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ChoosePizzaProcessRepository choosePizzaProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ChooseType1Mapper chooseType1Mapper;

    private final ChoosePizzaProcessMapper choosePizzaProcessMapper;

    public ChooseType1Service(
        TaskInstanceService taskInstanceService,
        ChoosePizzaService choosePizzaService,
        TaskInstanceRepository taskInstanceRepository,
        ChoosePizzaProcessRepository choosePizzaProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ChooseType1Mapper chooseType1Mapper,
        ChoosePizzaProcessMapper choosePizzaProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.choosePizzaService = choosePizzaService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.choosePizzaProcessRepository = choosePizzaProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.chooseType1Mapper = chooseType1Mapper;
        this.choosePizzaProcessMapper = choosePizzaProcessMapper;
    }

    public ChooseType1ContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(chooseType1Mapper::toChoosePizzaProcessDTO)
            .orElseThrow();

        ChooseType1ContextDTO chooseType1Context = new ChooseType1ContextDTO();
        chooseType1Context.setTaskInstance(taskInstanceDTO);
        chooseType1Context.setChoosePizzaProcess(choosePizzaProcess);

        return chooseType1Context;
    }

    public ChooseType1ContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ChooseType1ContextDTO chooseType1Context) {
        ChoosePizzaDTO choosePizzaDTO = choosePizzaService
            .findOne(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getId())
            .orElseThrow();
        choosePizzaDTO.setCustomerName(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getCustomerName());
        choosePizzaDTO.setCustomerAddress(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getCustomerAddress());
        choosePizzaDTO.setCustomerPhone(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getCustomerPhone());
        choosePizzaDTO.setCustomerEmail(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getCustomerEmail());
        choosePizzaDTO.setPizzaType1(chooseType1Context.getChoosePizzaProcess().getChoosePizza().getPizzaType1());
        choosePizzaService.save(choosePizzaDTO);
    }

    public void complete(ChooseType1ContextDTO chooseType1Context) {
        save(chooseType1Context);
        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(chooseType1Context.getChoosePizzaProcess().getProcessInstance().getId())
            .map(choosePizzaProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(chooseType1Context.getTaskInstance(), choosePizzaProcess);
    }
}
