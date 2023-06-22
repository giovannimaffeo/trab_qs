import axios from 'axios';

import { IChoosePizzaProcess } from '@/shared/model/choose-pizza-process.model';

const baseApiUrl = 'api/choose-pizza-processes';

export default class ChoosePizzaProcessService {
  public find(id: number): Promise<IChoosePizzaProcess> {
    return new Promise<IChoosePizzaProcess>((resolve, reject) => {
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

  public create(entity: IChoosePizzaProcess): Promise<IChoosePizzaProcess> {
    return new Promise<IChoosePizzaProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
