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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType1.customerName')" for="choose-type-1-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="choose-type-1-customerName"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType1.customerAddress')" for="choose-type-1-customerAddress"
                >Customer Address</label
              >
              <input
                type="text"
                class="form-control"
                name="customerAddress"
                id="choose-type-1-customerAddress"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType1.customerPhone')" for="choose-type-1-customerPhone"
                >Customer Phone</label
              >
              <input
                type="text"
                class="form-control"
                name="customerPhone"
                id="choose-type-1-customerPhone"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType1.customerEmail')" for="choose-type-1-customerEmail"
                >Customer Email</label
              >
              <input
                type="text"
                class="form-control"
                name="customerEmail"
                id="choose-type-1-customerEmail"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType1.pizzaType1')" for="choose-type-1-pizzaType1"
                >Pizza Type 1</label
              >
              <input
                type="text"
                class="form-control"
                name="pizzaType1"
                id="choose-type-1-pizzaType1"
                data-cy="pizzaType1"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.pizzaType1.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.pizzaType1.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.pizzaType1.$model"
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

<script lang="ts" src="./choose-type-1-execute.component.ts"></script>
