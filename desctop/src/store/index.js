import Vue from 'vue'
import Vuex from 'vuex'
import {validateUser} from '../validation/userValidation'
import createPersistedState from "vuex-persistedstate";

import Api from '../Api/api'

// import example from './module-example'

Vue.use(Vuex)

export default new Vuex.Store({
    getters: {
      isLogined: state=>{
        return !(!state.currentUser || state.currentUser == '');
      }},
    mutations: {
      setCurrentUserMutation(state, user) {
        state.currentUser = user
      }
    },
    actions: {
      async LoginAction({commit}, user) {
        try{
          validateUser(user)
          const response  = await Vue.prototype.$axios.post("/api/auth",user)
          const data = response.data
          commit('setCurrentUserMutation',data)
          // console.log(user)
          return 'Successful'
        }catch (e) {
          // console.log(e.response.data.message)
          if(e.response.status==400) throw 'User not exists'
          if(e.response.status==401) throw 'Invalid password'
          return 'Error'
        }
      }
    },
    state: {
      currentUser: null
    },
    strict: process.env.DEBUGGING,
    plugins: [createPersistedState()]
  })
