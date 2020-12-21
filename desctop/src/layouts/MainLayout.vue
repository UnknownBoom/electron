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
      <Drawer/>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
  import Drawer from "components/Drawer";
  // import {mapGetters} from 'vuex'
  export default {
    components: {Drawer},
    data () {
      return {
        left: false
      }
    },
    computed:{
      // ...mapGetters(['isLogined'])
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
