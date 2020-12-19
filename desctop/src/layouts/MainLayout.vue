<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-dark text-white " >
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="left = !left" />

        <q-toolbar-title>
          <q-avatar>
            <q-icon name="devices"></q-icon>
          </q-avatar>
          My App
        </q-toolbar-title>
        <q-space></q-space>
        <div>
          <q-btn icon="person" size="md" class="border" round>
          </q-btn>
        </div>

      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="left" side="left" bordered dark :width="175">
      <q-item-label header class="text-white">My App</q-item-label>
      <q-separator dark></q-separator>
      <q-list>
        <q-item clickable to="login">
          <q-item-section avatar><q-icon name="login"/></q-item-section>
          <q-item-section>Login</q-item-section>
        </q-item>
        <q-item>
          <q-item-section avatar><q-icon name="logout"/></q-item-section>
          <q-item-section>Logout</q-item-section>
        </q-item>
        <q-item>
          <q-item-section avatar><q-icon name="home"/></q-item-section>
          <q-item-section>Main</q-item-section>
        </q-item>
      </q-list>
      <q-separator dark></q-separator>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
  export default {
    data () {
      return {
        left: false
      }
    }
  }
</script>
<style>
  .q-layout{
    background-color: rgba(35, 37, 38, 1);
  }
  .border{
    border-width: 1px !important;
    border-color: #606266 !important;
    border-style: solid !important;
  }
</style>
