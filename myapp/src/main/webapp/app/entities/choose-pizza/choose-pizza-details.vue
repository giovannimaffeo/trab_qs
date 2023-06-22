<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="choosePizza">
        <h2 class="jh-entity-heading" data-cy="choosePizzaDetailsHeading">
          <span v-text="$t('myappApp.choosePizza.detail.title')">ChoosePizza</span> {{ choosePizza.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myappApp.choosePizza.pizzaType')">Pizza Type</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaType }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.choosePizza.pizzaSize')">Pizza Size</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.choosePizza.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.choosePizza.customerAddress')">Customer Address</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerAddress }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.choosePizza.customerPhone')">Customer Phone</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerPhone }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.choosePizza.pizzaPrice')">Pizza Price</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaPrice }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./choose-pizza-details.component.ts"></script>
