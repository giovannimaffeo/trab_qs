import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseType1Service from './choose-type-1.service';
import { ChooseType1Context } from './choose-type-1.model';

@Component
export default class ChooseType1DetailsComponent extends Vue {
  private chooseType1Service: ChooseType1Service = new ChooseType1Service();
  private taskContext: ChooseType1Context = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.chooseType1Service.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
