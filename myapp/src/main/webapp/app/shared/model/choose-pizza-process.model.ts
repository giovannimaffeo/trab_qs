import { IChoosePizza } from '@/shared/model/choose-pizza.model';

export interface IChoosePizzaProcess {
  id?: number;
  processInstance?: any | null;
  choosePizza?: IChoosePizza | null;
}

export class ChoosePizzaProcess implements IChoosePizzaProcess {
  constructor(public id?: number, public processInstance?: any | null, public choosePizza?: IChoosePizza | null) {}
}
