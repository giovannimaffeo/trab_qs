<template>
  <div>
    <h2 id="page-heading" data-cy="ChoosePizzaHeading">
      <span v-text="$t('myappApp.choosePizza.home.title')" id="choose-pizza-heading">Choose Pizzas</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.choosePizza.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && choosePizzas && choosePizzas.length === 0">
      <span v-text="$t('myappApp.choosePizza.home.notFound')">No choosePizzas found</span>
    </div>
    <div class="table-responsive" v-if="choosePizzas && choosePizzas.length > 0">
      <table class="table table-striped" aria-describedby="choosePizzas">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.pizzaType')">Pizza Type</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.pizzaSize')">Pizza Size</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.customerName')">Customer Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.customerAddress')">Customer Address</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.customerPhone')">Customer Phone</span></th>
            <th scope="row"><span v-text="$t('myappApp.choosePizza.pizzaPrice')">Pizza Price</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="choosePizza in choosePizzas" :key="choosePizza.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ChoosePizzaView', params: { choosePizzaId: choosePizza.id } }">{{ choosePizza.id }}</router-link>
            </td>
            <td>{{ choosePizza.pizzaType }}</td>
            <td>{{ choosePizza.pizzaSize }}</td>
            <td>{{ choosePizza.customerName }}</td>
            <td>{{ choosePizza.customerAddress }}</td>
            <td>{{ choosePizza.customerPhone }}</td>
            <td>{{ choosePizza.pizzaPrice }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ChoosePizzaView', params: { choosePizzaId: choosePizza.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="myappApp.choosePizza.delete.question" data-cy="choosePizzaDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-choosePizza-heading" v-text="$t('myappApp.choosePizza.delete.question', { id: removeId })">
          Are you sure you want to delete this Choose Pizza?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-choosePizza"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeChoosePizza()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./choose-pizza.component.ts"></script>
