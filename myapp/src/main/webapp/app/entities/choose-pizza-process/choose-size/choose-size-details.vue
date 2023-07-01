<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('myapp3App.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerName')">customerName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerName"
                id="choose-pizza-customerName"
                data-cy="customerName"
                v-model="taskContext.choosePizzaProcess.choosePizza.customerName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerAddress')">customerAddress</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerAddress"
                id="choose-pizza-customerAddress"
                data-cy="customerAddress"
                v-model="taskContext.choosePizzaProcess.choosePizza.customerAddress"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerPhone')">customerPhone</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerPhone"
                id="choose-pizza-customerPhone"
                data-cy="customerPhone"
                v-model="taskContext.choosePizzaProcess.choosePizza.customerPhone"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerEmail')">customerEmail</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerEmail"
                id="choose-pizza-customerEmail"
                data-cy="customerEmail"
                v-model="taskContext.choosePizzaProcess.choosePizza.customerEmail"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.pizzaSize')">pizzaSize</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="pizzaSize"
                id="choose-pizza-pizzaSize"
                data-cy="pizzaSize"
                v-model="taskContext.choosePizzaProcess.choosePizza.pizzaSize"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/PizzaFlowProcess/task/ChooseSize/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./choose-size-details.component.ts"></script>
