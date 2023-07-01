<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="choosePizzaProcessDetailsHeading">
      <span v-text="$t('myapp3App.choosePizzaProcess.home.title')">ChoosePizzaProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myapp3App.choosePizzaProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/PizzaFlowProcess/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('myapp3App.choosePizzaProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && choosePizzaProcessList && choosePizzaProcessList.length === 0">
      <span v-text="$t('myapp3App.choosePizzaProcess.home.notFound')">No choosePizzaProcess found</span>
    </div>
    <div class="table-responsive" v-if="choosePizzaProcessList && choosePizzaProcessList.length > 0">
      <table class="table table-striped" aria-describedby="choosePizzaProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span>Process Instance</span></th>
            <th scope="row"><span>Choose Pizza</span></th>
            <th scope="row"><span>Status</span></th>
            <th scope="row"><span>Start Date</span></th>
            <th scope="row"><span>End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="choosePizzaProcess in choosePizzaProcessList" :key="choosePizzaProcess.id" data-cy="entityTable">
            <td>{{ choosePizzaProcess.id }}</td>
            <td>
              <div v-if="choosePizzaProcess.processInstance">
                <router-link :to="`/process-definition/PizzaFlowProcess/instance/${choosePizzaProcess.processInstance.id}/view`">
                  {{ choosePizzaProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="choosePizzaProcess.choosePizza">
                <router-link :to="{ name: 'ChoosePizzaView', params: { choosePizzaId: choosePizzaProcess.choosePizza.id } }">{{
                  choosePizzaProcess.choosePizza.id
                }}</router-link>
              </div>
            </td>
            <td>
              <akip-show-process-instance-status :status="choosePizzaProcess.processInstance.status"></akip-show-process-instance-status>
            </td>
            <td>
              {{
                choosePizzaProcess.processInstance.startDate ? $d(Date.parse(choosePizzaProcess.processInstance.startDate), 'short') : ''
              }}
            </td>
            <td>
              {{ choosePizzaProcess.processInstance.endDate ? $d(Date.parse(choosePizzaProcess.processInstance.endDate), 'short') : '' }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/PizzaFlowProcess/instance/${choosePizzaProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./choose-pizza-process-list.component.ts"></script>
