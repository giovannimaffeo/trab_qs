package com.mycompany.myapp.process.choosePizzaProcess;

import com.mycompany.myapp.service.dto.ChoosePizzaProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class ChooseType1ContextDTO {

    private ChoosePizzaProcessDTO choosePizzaProcess;
    private TaskInstanceDTO taskInstance;

    public ChoosePizzaProcessDTO getChoosePizzaProcess() {
        return choosePizzaProcess;
    }

    public void setChoosePizzaProcess(ChoosePizzaProcessDTO choosePizzaProcess) {
        this.choosePizzaProcess = choosePizzaProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
