export interface IChoosePizza {
  id?: number;
  pizzaType1?: string | null;
  pizzaType2?: string | null;
  pizzaSize?: string | null;
  customerName?: string | null;
  customerAddress?: string | null;
  customerPhone?: string | null;
  customerEmail?: string | null;
  pizzaPrice?: number | null;
}

export class ChoosePizza implements IChoosePizza {
  constructor(
    public id?: number,
    public pizzaType1?: string | null,
    public pizzaType2?: string | null,
    public pizzaSize?: string | null,
    public customerName?: string | null,
    public customerAddress?: string | null,
    public customerPhone?: string | null,
    public customerEmail?: string | null,
    public pizzaPrice?: number | null
  ) {}
}
