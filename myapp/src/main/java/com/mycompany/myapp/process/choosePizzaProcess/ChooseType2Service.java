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
public class ChooseType2Service {

    private final TaskInstanceService taskInstanceService;

    private final ChoosePizzaService choosePizzaService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ChoosePizzaProcessRepository choosePizzaProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ChooseType2Mapper chooseType2Mapper;

    private final ChoosePizzaProcessMapper choosePizzaProcessMapper;

    public ChooseType2Service(
        TaskInstanceService taskInstanceService,
        ChoosePizzaService choosePizzaService,
        TaskInstanceRepository taskInstanceRepository,
        ChoosePizzaProcessRepository choosePizzaProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ChooseType2Mapper chooseType2Mapper,
        ChoosePizzaProcessMapper choosePizzaProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.choosePizzaService = choosePizzaService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.choosePizzaProcessRepository = choosePizzaProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.chooseType2Mapper = chooseType2Mapper;
        this.choosePizzaProcessMapper = choosePizzaProcessMapper;
    }

    public ChooseType2ContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(chooseType2Mapper::toChoosePizzaProcessDTO)
            .orElseThrow();

        ChooseType2ContextDTO chooseType2Context = new ChooseType2ContextDTO();
        chooseType2Context.setTaskInstance(taskInstanceDTO);
        chooseType2Context.setChoosePizzaProcess(choosePizzaProcess);

        return chooseType2Context;
    }

    public ChooseType2ContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ChooseType2ContextDTO chooseType2Context) {
        ChoosePizzaDTO choosePizzaDTO = choosePizzaService
            .findOne(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getId())
            .orElseThrow();
        choosePizzaDTO.setCustomerName(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getCustomerName());
        choosePizzaDTO.setCustomerAddress(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getCustomerAddress());
        choosePizzaDTO.setCustomerPhone(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getCustomerPhone());
        choosePizzaDTO.setCustomerEmail(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getCustomerEmail());
        choosePizzaDTO.setPizzaType2(chooseType2Context.getChoosePizzaProcess().getChoosePizza().getPizzaType2());
        choosePizzaService.save(choosePizzaDTO);
    }

    public void complete(ChooseType2ContextDTO chooseType2Context) {
        save(chooseType2Context);
        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(chooseType2Context.getChoosePizzaProcess().getProcessInstance().getId())
            .map(choosePizzaProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(chooseType2Context.getTaskInstance(), choosePizzaProcess);
    }
}
