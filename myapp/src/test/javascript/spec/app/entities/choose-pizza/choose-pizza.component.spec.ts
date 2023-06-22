/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ChoosePizzaComponent from '@/entities/choose-pizza/choose-pizza.vue';
import ChoosePizzaClass from '@/entities/choose-pizza/choose-pizza.component';
import ChoosePizzaService from '@/entities/choose-pizza/choose-pizza.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('ChoosePizza Management Component', () => {
    let wrapper: Wrapper<ChoosePizzaClass>;
    let comp: ChoosePizzaClass;
    let choosePizzaServiceStub: SinonStubbedInstance<ChoosePizzaService>;

    beforeEach(() => {
      choosePizzaServiceStub = sinon.createStubInstance<ChoosePizzaService>(ChoosePizzaService);
      choosePizzaServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ChoosePizzaClass>(ChoosePizzaComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          choosePizzaService: () => choosePizzaServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      choosePizzaServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllChoosePizzas();
      await comp.$nextTick();

      // THEN
      expect(choosePizzaServiceStub.retrieve.called).toBeTruthy();
      expect(comp.choosePizzas[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
