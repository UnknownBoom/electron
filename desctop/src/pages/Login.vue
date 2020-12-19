<template>
  <q-page class="">
    <div class="full-width row wrap justify-center items-center content-center ">
      <div class="col">
        <div class="full-width column wrap justify-start items-center content-center ">
          <q-form class="q-gutter-y-md q-pa-md bg-dark q-mt-lg form-size full-width">
            <div class="col">
              <q-input
                filled
                v-model="user.username"
                label="Your username"
                lazy-rules
                dark
                :rules="[ val => val && val.length > 0 || 'Please type something']"
              />
            </div>
            <div class="col">
              <q-input
                filled
                type="password"
                v-model="user.password"
                label="Your password"
                dark
                lazy-rules
                :rules="[ val => val !== null && val !== '' || 'Please type your password',]"
              />
            </div>
            <div class="col">
              <q-btn label="Submit" type="submit" color="grey-9"/>
              <q-btn label="Reset" type="reset"  color="grey-7 " flat class="q-ml-sm" />

            </div>
          </q-form>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
  export default {
    name: "Login",
    data(){
      return{
        user:{
          username:'',
          password:''
        }
      }
    }
  }
</script>

<style scoped>
  .form-size{
    max-width: 400px;
  }
</style>
