import { Component, Vue, Inject } from 'vue-property-decorator';
import { IChoosePizzaProcess } from '@/shared/model/choose-pizza-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import ChoosePizzaProcessService from './choose-pizza-process.service';

@Component
export default class ChoosePizzaProcessListComponent extends Vue {
  @Inject('choosePizzaProcessService') private choosePizzaProcessService: () => ChoosePizzaProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PizzaFlowProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public choosePizzaProcessList: IChoosePizzaProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.choosePizzaProcessService()
      .retrieve()
      .then(
        res => {
          this.choosePizzaProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
