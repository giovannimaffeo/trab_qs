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
// prettier-ignore
const ChoosePizzaStartFormInit = () => import('@/entities/choose-pizza-process/choose-pizza-start-form-init.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseSizeDetails = () => import('@/entities/choose-pizza-process/choose-size/choose-size-details.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseSizeExecute = () => import('@/entities/choose-pizza-process/choose-size/choose-size-execute.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseType1Details = () => import('@/entities/choose-pizza-process/choose-type-1/choose-type-1-details.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseType1Execute = () => import('@/entities/choose-pizza-process/choose-type-1/choose-type-1-execute.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseType2Details = () => import('@/entities/choose-pizza-process/choose-type-2/choose-type-2-details.vue');
// prettier-ignore
const ChoosePizzaProcess_ChooseType2Execute = () => import('@/entities/choose-pizza-process/choose-type-2/choose-type-2-execute.vue');
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
  {
    path: '/process-definition/PizzaFlowProcess/init',
    name: 'ChoosePizzaStartFormInit',
    component: ChoosePizzaStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseSize/:taskInstanceId/view',
    name: 'ChoosePizzaProcess_ChooseSizeDetails',
    component: ChoosePizzaProcess_ChooseSizeDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseSize/:taskInstanceId/execute',
    name: 'ChoosePizzaProcess_ChooseSizeExecute',
    component: ChoosePizzaProcess_ChooseSizeExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseType1/:taskInstanceId/view',
    name: 'ChoosePizzaProcess_ChooseType1Details',
    component: ChoosePizzaProcess_ChooseType1Details,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseType1/:taskInstanceId/execute',
    name: 'ChoosePizzaProcess_ChooseType1Execute',
    component: ChoosePizzaProcess_ChooseType1Execute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseType2/:taskInstanceId/view',
    name: 'ChoosePizzaProcess_ChooseType2Details',
    component: ChoosePizzaProcess_ChooseType2Details,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PizzaFlowProcess/task/ChooseType2/:taskInstanceId/execute',
    name: 'ChoosePizzaProcess_ChooseType2Execute',
    component: ChoosePizzaProcess_ChooseType2Execute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
