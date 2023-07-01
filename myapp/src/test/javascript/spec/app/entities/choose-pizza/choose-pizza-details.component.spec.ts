/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ChoosePizzaDetailComponent from '@/entities/choose-pizza/choose-pizza-details.vue';
import ChoosePizzaClass from '@/entities/choose-pizza/choose-pizza-details.component';
import ChoosePizzaService from '@/entities/choose-pizza/choose-pizza.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('ChoosePizza Management Detail Component', () => {
    let wrapper: Wrapper<ChoosePizzaClass>;
    let comp: ChoosePizzaClass;
    let choosePizzaServiceStub: SinonStubbedInstance<ChoosePizzaService>;

    beforeEach(() => {
      choosePizzaServiceStub = sinon.createStubInstance<ChoosePizzaService>(ChoosePizzaService);

      wrapper = shallowMount<ChoosePizzaClass>(ChoosePizzaDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { choosePizzaService: () => choosePizzaServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundChoosePizza = { id: 123 };
        choosePizzaServiceStub.find.resolves(foundChoosePizza);

        // WHEN
        comp.retrieveChoosePizza(123);
        await comp.$nextTick();

        // THEN
        expect(comp.choosePizza).toBe(foundChoosePizza);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundChoosePizza = { id: 123 };
        choosePizzaServiceStub.find.resolves(foundChoosePizza);

        // WHEN
        comp.beforeRouteEnter({ params: { choosePizzaId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.choosePizza).toBe(foundChoosePizza);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
