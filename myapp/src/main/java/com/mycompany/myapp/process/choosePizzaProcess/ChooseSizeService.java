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
public class ChooseSizeService {

    private final TaskInstanceService taskInstanceService;

    private final ChoosePizzaService choosePizzaService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ChoosePizzaProcessRepository choosePizzaProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ChooseSizeMapper chooseSizeMapper;

    private final ChoosePizzaProcessMapper choosePizzaProcessMapper;

    public ChooseSizeService(
        TaskInstanceService taskInstanceService,
        ChoosePizzaService choosePizzaService,
        TaskInstanceRepository taskInstanceRepository,
        ChoosePizzaProcessRepository choosePizzaProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ChooseSizeMapper chooseSizeMapper,
        ChoosePizzaProcessMapper choosePizzaProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.choosePizzaService = choosePizzaService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.choosePizzaProcessRepository = choosePizzaProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.chooseSizeMapper = chooseSizeMapper;
        this.choosePizzaProcessMapper = choosePizzaProcessMapper;
    }

    public ChooseSizeContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(chooseSizeMapper::toChoosePizzaProcessDTO)
            .orElseThrow();

        ChooseSizeContextDTO chooseSizeContext = new ChooseSizeContextDTO();
        chooseSizeContext.setTaskInstance(taskInstanceDTO);
        chooseSizeContext.setChoosePizzaProcess(choosePizzaProcess);

        return chooseSizeContext;
    }

    public ChooseSizeContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ChooseSizeContextDTO chooseSizeContext) {
        ChoosePizzaDTO choosePizzaDTO = choosePizzaService
            .findOne(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getId())
            .orElseThrow();
        choosePizzaDTO.setCustomerName(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getCustomerName());
        choosePizzaDTO.setCustomerAddress(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getCustomerAddress());
        choosePizzaDTO.setCustomerPhone(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getCustomerPhone());
        choosePizzaDTO.setCustomerEmail(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getCustomerEmail());
        choosePizzaDTO.setPizzaSize(chooseSizeContext.getChoosePizzaProcess().getChoosePizza().getPizzaSize());
        choosePizzaService.save(choosePizzaDTO);
    }

    public void complete(ChooseSizeContextDTO chooseSizeContext) {
        save(chooseSizeContext);
        ChoosePizzaProcessDTO choosePizzaProcess = choosePizzaProcessRepository
            .findByProcessInstanceId(chooseSizeContext.getChoosePizzaProcess().getProcessInstance().getId())
            .map(choosePizzaProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(chooseSizeContext.getTaskInstance(), choosePizzaProcess);
    }
}
