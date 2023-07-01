<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('myapp3App.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerName')" for="choose-size-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="choose-size-customerName"
                readonly
                data-cy="customerName"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.customerName.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.customerName.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.customerName.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerAddress')" for="choose-size-customerAddress"
                >Customer Address</label
              >
              <input
                type="text"
                class="form-control"
                name="customerAddress"
                id="choose-size-customerAddress"
                readonly
                data-cy="customerAddress"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.customerAddress.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.customerAddress.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.customerAddress.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerPhone')" for="choose-size-customerPhone"
                >Customer Phone</label
              >
              <input
                type="text"
                class="form-control"
                name="customerPhone"
                id="choose-size-customerPhone"
                readonly
                data-cy="customerPhone"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.customerPhone.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.customerPhone.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.customerPhone.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.customerEmail')" for="choose-size-customerEmail"
                >Customer Email</label
              >
              <input
                type="text"
                class="form-control"
                name="customerEmail"
                id="choose-size-customerEmail"
                readonly
                data-cy="customerEmail"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.customerEmail.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.customerEmail.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.customerEmail.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myapp3App.chooseSize.pizzaSize')" for="choose-size-pizzaSize">Pizza Size</label>
              <input
                type="text"
                class="form-control"
                name="pizzaSize"
                id="choose-size-pizzaSize"
                data-cy="pizzaSize"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.pizzaSize.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.pizzaSize.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.pizzaSize.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./choose-size-execute.component.ts"></script>
