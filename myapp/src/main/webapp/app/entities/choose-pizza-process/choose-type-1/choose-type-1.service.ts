import axios from 'axios';
import { ChooseType1Context } from './choose-type-1.model';

const baseApiUrl = 'api/choose-pizza-process/choose-type-1';

export default class ChooseType1Service {
  public loadContext(taskId: number): Promise<ChooseType1Context> {
    return new Promise<ChooseType1Context>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<ChooseType1Context> {
    return new Promise<ChooseType1Context>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(chooseType1Context: ChooseType1Context): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, chooseType1Context)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
