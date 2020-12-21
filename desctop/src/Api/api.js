
import axios from 'axios'
import Vue from "vue";


const resource = axios.create()

export default {
  login: user=>Vue.prototype.$axios.post("/api/auth",user),
  signup: user=>resource.post("/registration",user),
  update: (id,user)=>resource.put(`/api/${id}`,user),
}
