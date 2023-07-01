import { Component, Vue, Inject } from 'vue-property-decorator';

import { IChoosePizzaProcess, ChoosePizzaProcess } from '@/shared/model/choose-pizza-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { ChoosePizza } from '@/shared/model/choose-pizza.model';
import ChoosePizzaProcessService from './choose-pizza-process.service';

const validations: any = {
  choosePizzaProcess: {
    choosePizza: {
      customerName: {},
      customerAddress: {},
      customerPhone: {},
      customerEmail: {},
    },
  },
};

@Component({
  validations,
})
export default class ChoosePizzaStartFormInitComponent extends Vue {
  @Inject('choosePizzaProcessService') private choosePizzaProcessService: () => ChoosePizzaProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PizzaFlowProcess';
  public choosePizzaProcess: IChoosePizzaProcess = new ChoosePizzaProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initChoosePizzaStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.choosePizzaProcessService()
      .create(this.choosePizzaProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('myapp3App.choosePizzaStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initChoosePizzaStartForm(): void {
    this.choosePizzaProcess.choosePizza = new ChoosePizza();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.choosePizzaProcess.processInstance = new ProcessInstance();
      this.choosePizzaProcess.processInstance.processDefinition = res;
    });
  }
}
