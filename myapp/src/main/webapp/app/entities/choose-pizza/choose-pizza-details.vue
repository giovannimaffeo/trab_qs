<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="choosePizza">
        <h2 class="jh-entity-heading" data-cy="choosePizzaDetailsHeading">
          <span v-text="$t('myapp3App.choosePizza.detail.title')">ChoosePizza</span> {{ choosePizza.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myapp3App.choosePizza.pizzaType1')">Pizza Type 1</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaType1 }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.pizzaType2')">Pizza Type 2</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaType2 }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.pizzaSize')">Pizza Size</span>
          </dt>
          <dd>
            <span>{{ choosePizza.pizzaSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.customerAddress')">Customer Address</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerAddress }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.customerPhone')">Customer Phone</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerPhone }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.customerEmail')">Customer Email</span>
          </dt>
          <dd>
            <span>{{ choosePizza.customerEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('myapp3App.choosePizza.pizzaPrice')">Pizza Price</span>
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
