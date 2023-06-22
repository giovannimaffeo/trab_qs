import axios from 'axios';

import { IChoosePizza } from '@/shared/model/choose-pizza.model';

const baseApiUrl = 'api/choose-pizzas';

export default class ChoosePizzaService {
  public find(id: number): Promise<IChoosePizza> {
    return new Promise<IChoosePizza>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
