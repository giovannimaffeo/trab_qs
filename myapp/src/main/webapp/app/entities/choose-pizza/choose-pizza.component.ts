import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IChoosePizza } from '@/shared/model/choose-pizza.model';

import ChoosePizzaService from './choose-pizza.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class ChoosePizza extends Vue {
  @Inject('choosePizzaService') private choosePizzaService: () => ChoosePizzaService;
  private removeId: number = null;

  public choosePizzas: IChoosePizza[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllChoosePizzas();
  }

  public clear(): void {
    this.retrieveAllChoosePizzas();
  }

  public retrieveAllChoosePizzas(): void {
    this.isFetching = true;

    this.choosePizzaService()
      .retrieve()
      .then(
        res => {
          this.choosePizzas = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
