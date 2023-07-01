import { Component, Vue, Inject } from 'vue-property-decorator';

import ChooseSizeService from './choose-size.service';
import { ChooseSizeContext } from './choose-size.model';

@Component
export default class ChooseSizeDetailsComponent extends Vue {
  private chooseSizeService: ChooseSizeService = new ChooseSizeService();
  private taskContext: ChooseSizeContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.chooseSizeService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
