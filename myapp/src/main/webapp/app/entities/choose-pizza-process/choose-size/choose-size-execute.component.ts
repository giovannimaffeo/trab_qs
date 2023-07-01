import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseSizeService from './choose-size.service';
import { ChooseSizeContext } from './choose-size.model';

const validations: any = {
  taskContext: {
    choosePizzaProcess: {
      choosePizza: {
        customerName: {},
        customerAddress: {},
        customerPhone: {},
        customerEmail: {},
        pizzaSize: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ChooseSizeExecuteComponent extends Vue {
  private chooseSizeService: ChooseSizeService = new ChooseSizeService();
  private taskContext: ChooseSizeContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.chooseSizeService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.chooseSizeService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
