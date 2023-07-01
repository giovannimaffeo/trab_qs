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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType2.customerName')" for="choose-type-2-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="choose-type-2-customerName"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType2.customerAddress')" for="choose-type-2-customerAddress"
                >Customer Address</label
              >
              <input
                type="text"
                class="form-control"
                name="customerAddress"
                id="choose-type-2-customerAddress"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType2.customerPhone')" for="choose-type-2-customerPhone"
                >Customer Phone</label
              >
              <input
                type="text"
                class="form-control"
                name="customerPhone"
                id="choose-type-2-customerPhone"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType2.customerEmail')" for="choose-type-2-customerEmail"
                >Customer Email</label
              >
              <input
                type="text"
                class="form-control"
                name="customerEmail"
                id="choose-type-2-customerEmail"
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
              <label class="form-control-label" v-text="$t('myapp3App.chooseType2.pizzaType2')" for="choose-type-2-pizzaType2"
                >Pizza Type 2</label
              >
              <input
                type="text"
                class="form-control"
                name="pizzaType2"
                id="choose-type-2-pizzaType2"
                data-cy="pizzaType2"
                :class="{
                  valid: !$v.taskContext.choosePizzaProcess.choosePizza.pizzaType2.$invalid,
                  invalid: $v.taskContext.choosePizzaProcess.choosePizza.pizzaType2.$invalid,
                }"
                v-model="$v.taskContext.choosePizzaProcess.choosePizza.pizzaType2.$model"
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

<script lang="ts" src="./choose-type-2-execute.component.ts"></script>
