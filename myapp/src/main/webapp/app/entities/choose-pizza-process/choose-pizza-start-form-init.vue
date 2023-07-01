<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="myapp3App.choosePizzaStartForm.home.createOrEditLabel"
          data-cy="ChoosePizzaStartFormCreateUpdateHeading"
          v-text="$t('myapp3App.choosePizzaStartForm.home.createOrEditLabel')"
        >
          Create or edit a ChoosePizzaStartForm
        </h2>
        <div v-if="choosePizzaProcess.processInstance">
          <akip-show-process-definition :processDefinition="choosePizzaProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="choosePizzaProcess.choosePizza">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myapp3App.choosePizzaStartForm.customerName')"
                    for="choose-pizza-start-form-customerName"
                    >Customer Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="customerName"
                    id="choose-pizza-start-form-customerName"
                    data-cy="customerName"
                    :class="{
                      valid: !$v.choosePizzaProcess.choosePizza.customerName.$invalid,
                      invalid: $v.choosePizzaProcess.choosePizza.customerName.$invalid,
                    }"
                    v-model="$v.choosePizzaProcess.choosePizza.customerName.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myapp3App.choosePizzaStartForm.customerAddress')"
                    for="choose-pizza-start-form-customerAddress"
                    >Customer Address</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="customerAddress"
                    id="choose-pizza-start-form-customerAddress"
                    data-cy="customerAddress"
                    :class="{
                      valid: !$v.choosePizzaProcess.choosePizza.customerAddress.$invalid,
                      invalid: $v.choosePizzaProcess.choosePizza.customerAddress.$invalid,
                    }"
                    v-model="$v.choosePizzaProcess.choosePizza.customerAddress.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myapp3App.choosePizzaStartForm.customerPhone')"
                    for="choose-pizza-start-form-customerPhone"
                    >Customer Phone</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="customerPhone"
                    id="choose-pizza-start-form-customerPhone"
                    data-cy="customerPhone"
                    :class="{
                      valid: !$v.choosePizzaProcess.choosePizza.customerPhone.$invalid,
                      invalid: $v.choosePizzaProcess.choosePizza.customerPhone.$invalid,
                    }"
                    v-model="$v.choosePizzaProcess.choosePizza.customerPhone.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myapp3App.choosePizzaStartForm.customerEmail')"
                    for="choose-pizza-start-form-customerEmail"
                    >Customer Email</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="customerEmail"
                    id="choose-pizza-start-form-customerEmail"
                    data-cy="customerEmail"
                    :class="{
                      valid: !$v.choosePizzaProcess.choosePizza.customerEmail.$invalid,
                      invalid: $v.choosePizzaProcess.choosePizza.customerEmail.$invalid,
                    }"
                    v-model="$v.choosePizzaProcess.choosePizza.customerEmail.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.choosePizzaProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./choose-pizza-start-form-init.component.ts"></script>
