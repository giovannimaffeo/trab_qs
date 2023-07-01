import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseType2Service from './choose-type-2.service';
import { ChooseType2Context } from './choose-type-2.model';

const validations: any = {
  taskContext: {
    choosePizzaProcess: {
      choosePizza: {
        customerName: {},
        customerAddress: {},
        customerPhone: {},
        customerEmail: {},
        pizzaType2: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ChooseType2ExecuteComponent extends Vue {
  private chooseType2Service: ChooseType2Service = new ChooseType2Service();
  private taskContext: ChooseType2Context = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.chooseType2Service.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.chooseType2Service.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
