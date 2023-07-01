import { Component, Vue, Inject } from 'vue-property-decorator';

import { IChoosePizza } from '@/shared/model/choose-pizza.model';
import ChoosePizzaService from './choose-pizza.service';

@Component
export default class ChoosePizzaDetails extends Vue {
  @Inject('choosePizzaService') private choosePizzaService: () => ChoosePizzaService;
  public choosePizza: IChoosePizza = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.choosePizzaId) {
        vm.retrieveChoosePizza(to.params.choosePizzaId);
      }
    });
  }

  public retrieveChoosePizza(choosePizzaId) {
    this.choosePizzaService()
      .find(choosePizzaId)
      .then(res => {
        this.choosePizza = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
