<template>
  <div>
    <q-item-label header class="text-white">My App</q-item-label>
    <q-separator dark></q-separator>
    <q-list>
      <q-item clickable to="login" v-if="!isLogined">
        <q-item-section avatar><q-icon name="login"/></q-item-section>
        <q-item-section>Login</q-item-section>
      </q-item>
      <q-item v-if="isLogined">
        <q-item-section avatar><q-icon name="logout"/></q-item-section>
        <q-item-section>Logout</q-item-section>
      </q-item>
      <q-item>
        <q-item-section avatar><q-icon name="home"/></q-item-section>
        <q-item-section>Main</q-item-section>
      </q-item>
    </q-list>
    <q-separator dark></q-separator>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'
  export default {
    name: "Drawer",
    data () {
      return {

      }
    },
    computed:{
      ...mapGetters(['isLogined'])
    }
  }
</script>

<style scoped>

</style>
