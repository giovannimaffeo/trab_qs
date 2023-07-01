import axios from 'axios';
import { ChooseType2Context } from './choose-type-2.model';

const baseApiUrl = 'api/choose-pizza-process/choose-type-2';

export default class ChooseType2Service {
  public loadContext(taskId: number): Promise<ChooseType2Context> {
    return new Promise<ChooseType2Context>((resolve, reject) => {
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

  public claim(taskId: number): Promise<ChooseType2Context> {
    return new Promise<ChooseType2Context>((resolve, reject) => {
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

  public complete(chooseType2Context: ChooseType2Context): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, chooseType2Context)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
