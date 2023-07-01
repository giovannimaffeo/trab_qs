import axios from 'axios';
import { ChooseSizeContext } from './choose-size.model';

const baseApiUrl = 'api/choose-pizza-process/choose-size';

export default class ChooseSizeService {
  public loadContext(taskId: number): Promise<ChooseSizeContext> {
    return new Promise<ChooseSizeContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<ChooseSizeContext> {
    return new Promise<ChooseSizeContext>((resolve, reject) => {
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

  public complete(chooseSizeContext: ChooseSizeContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, chooseSizeContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
