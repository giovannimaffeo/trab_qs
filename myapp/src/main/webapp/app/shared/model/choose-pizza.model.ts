export interface IChoosePizza {
  id?: number;
  pizzaType?: string | null;
  pizzaSize?: string | null;
  customerName?: string | null;
  customerAddress?: string | null;
  customerPhone?: string | null;
  pizzaPrice?: number | null;
}

export class ChoosePizza implements IChoosePizza {
  constructor(
    public id?: number,
    public pizzaType?: string | null,
    public pizzaSize?: string | null,
    public customerName?: string | null,
    public customerAddress?: string | null,
    public customerPhone?: string | null,
    public pizzaPrice?: number | null
  ) {}
}
