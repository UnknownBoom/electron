<template>
  <q-page class="">
    <div class="full-width row wrap justify-center items-center content-center ">
      <div class="col">
        <div class="full-width column wrap justify-start items-center content-center ">
          <q-form class="q-gutter-y-md q-pa-md bg-dark q-mt-lg form-size full-width"
                  @submit="submit">
            <vue-recaptcha
              ref="invisibleRecaptcha"
              size="invisible"
              @verify="onVerify"
              :sitekey="sitekey"
              @error="onError"
              >
            </vue-recaptcha>
            <div class="col text-center text-white text-h4" >Sign Up</div>
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
              <q-btn to="/login" class="q-ml-auto  text-blue-grey-2 " flat >Login</q-btn>
              <q-btn label="Submit" type="submit" class="float-right" color="grey-9"/>
            </div>
            <div class="col">
              <div class="text-red text-h5">
                {{error}}
              </div>
            </div>
          </q-form>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
  import VueRecaptcha from 'vue-recaptcha'
  export default {
    name: "SignUp",
    components:{ VueRecaptcha},
    data(){
      return{
        user:{
          username:'',
          password:''
        },
        error:'',
        sitekey:'6LdnRg4aAAAAAKlh9vYmhAzSsqI3e4u0lLVVU5re'
      }
    },
    methods:{
      onVerify(response){
        this.$refs.invisibleRecaptcha.reset()
        this.$axios.post('/registration',this.user)
          .then(t=>{
            this.error = ''
            console.log(t)
            this.$router.push("/")
          })
          .catch(e=>{
            console.log(e)
            this.error = e.response.data.message
          })
      },
      onError(){
        this.error = 'Captcha failed'
        this.$refs.invisibleRecaptcha.reset()
      },
      submit(){
        this.$refs.invisibleRecaptcha.execute()
      }
    }
  }
</script>

<style scoped>
  .form-size{
    max-width: 400px;
  }
</style>
