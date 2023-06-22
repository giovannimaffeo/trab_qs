import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const ChoosePizza = () => import('@/entities/choose-pizza/choose-pizza.vue');
// prettier-ignore
const ChoosePizzaDetails = () => import('@/entities/choose-pizza/choose-pizza-details.vue');
// prettier-ignore
const ChoosePizzaProcessDetails = () => import('@/entities/choose-pizza-process/choose-pizza-process-details.vue');
// prettier-ignore
const ChoosePizzaProcessList = () => import('@/entities/choose-pizza-process/choose-pizza-process-list.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/choose-pizza',
    name: 'ChoosePizza',
    component: ChoosePizza,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/choose-pizza/:choosePizzaId/view',
    name: 'ChoosePizzaView',
    component: ChoosePizzaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/instance/:processInstanceId/view',
    name: 'ChoosePizzaProcessView',
    component: ChoosePizzaProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/instances',
    name: 'ChoosePizzaProcessList',
    component: ChoosePizzaProcessList,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
