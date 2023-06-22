<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="choosePizzaProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="choosePizzaProcessDetailsHeading">
          <span v-text="$t('myappApp.choosePizzaProcess.detail.title')">ChoosePizzaProcess</span> {{ choosePizzaProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="choosePizzaProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('myappApp.choosePizzaProcess.detail.title')">ChoosePizzaProcess</span> #{{ choosePizzaProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="choosePizzaProcess.choosePizza">
              <h5 class="card-header">
                <span class="title"> Choose Pizza #{{ choosePizzaProcess.choosePizza.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.pizzaType')">pizzaType</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="pizzaType"
                    id="choose-pizza-pizzaType"
                    data-cy="pizzaType"
                    v-model="choosePizzaProcess.choosePizza.pizzaType"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.pizzaSize')">pizzaSize</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="pizzaSize"
                    id="choose-pizza-pizzaSize"
                    data-cy="pizzaSize"
                    v-model="choosePizzaProcess.choosePizza.pizzaSize"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.customerName')">customerName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerName"
                    id="choose-pizza-customerName"
                    data-cy="customerName"
                    v-model="choosePizzaProcess.choosePizza.customerName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.customerAddress')">customerAddress</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerAddress"
                    id="choose-pizza-customerAddress"
                    data-cy="customerAddress"
                    v-model="choosePizzaProcess.choosePizza.customerAddress"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.customerPhone')">customerPhone</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerPhone"
                    id="choose-pizza-customerPhone"
                    data-cy="customerPhone"
                    v-model="choosePizzaProcess.choosePizza.customerPhone"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.choosePizzaProcess.pizzaPrice')">pizzaPrice</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="pizzaPrice"
                    id="choose-pizza-pizzaPrice"
                    data-cy="pizzaPrice"
                    v-model="choosePizzaProcess.choosePizza.pizzaPrice"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./choose-pizza-process-details.component.ts"></script>
