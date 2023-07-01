import { Component, Vue, Inject } from 'vue-property-decorator';

import { IChoosePizzaProcess } from '@/shared/model/choose-pizza-process.model';
import ChoosePizzaProcessService from './choose-pizza-process.service';

@Component
export default class ChoosePizzaProcessDetailsComponent extends Vue {
  @Inject('choosePizzaProcessService') private choosePizzaProcessService: () => ChoosePizzaProcessService;
  public choosePizzaProcess: IChoosePizzaProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveChoosePizzaProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveChoosePizzaProcess(choosePizzaProcessId) {
    this.isFetching = true;
    this.choosePizzaProcessService()
      .find(choosePizzaProcessId)
      .then(
        res => {
          this.choosePizzaProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
