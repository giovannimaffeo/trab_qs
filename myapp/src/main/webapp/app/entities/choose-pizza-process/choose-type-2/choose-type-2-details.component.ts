import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseType2Service from './choose-type-2.service';
import { ChooseType2Context } from './choose-type-2.model';

@Component
export default class ChooseType2DetailsComponent extends Vue {
  private chooseType2Service: ChooseType2Service = new ChooseType2Service();
  private taskContext: ChooseType2Context = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.chooseType2Service.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
