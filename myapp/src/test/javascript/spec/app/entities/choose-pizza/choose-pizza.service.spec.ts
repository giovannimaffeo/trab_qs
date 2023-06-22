/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import ChoosePizzaService from '@/entities/choose-pizza/choose-pizza.service';
import { ChoosePizza } from '@/shared/model/choose-pizza.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('ChoosePizza Service', () => {
    let service: ChoosePizzaService;
    let elemDefault;

    beforeEach(() => {
      service = new ChoosePizzaService();
      elemDefault = new ChoosePizza(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 0);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ChoosePizza', async () => {
        const returnedFromService = Object.assign(
          {
            pizzaType: 'BBBBBB',
            pizzaSize: 'BBBBBB',
            customerName: 'BBBBBB',
            customerAddress: 'BBBBBB',
            customerPhone: 'BBBBBB',
            pizzaPrice: 1,
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of ChoosePizza', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
