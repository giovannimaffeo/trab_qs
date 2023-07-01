import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseType1Service from './choose-type-1.service';
import { ChooseType1Context } from './choose-type-1.model';

const validations: any = {
  taskContext: {
    choosePizzaProcess: {
      choosePizza: {
        customerName: {},
        customerAddress: {},
        customerPhone: {},
        customerEmail: {},
        pizzaType1: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ChooseType1ExecuteComponent extends Vue {
  private chooseType1Service: ChooseType1Service = new ChooseType1Service();
  private taskContext: ChooseType1Context = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.chooseType1Service.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.chooseType1Service.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
