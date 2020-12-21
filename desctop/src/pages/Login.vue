<template>
  <q-page class="">
    <div class="full-width row wrap justify-center items-center content-center ">
      <div class="col">
        <div class="full-width column wrap justify-start items-center content-center ">
          <q-form class="q-gutter-y-md q-pa-md bg-dark q-mt-lg form-size full-width"
                  @submit="onVerify">
<!--            <vue-recaptcha-->
<!--              ref="invisibleRecaptcha"-->
<!--              size="invisible"-->
<!--              @verify="onVerify"-->
<!--              :sitekey="sitekey"-->
<!--              @error="onError"-->
<!--            >-->
<!--            </vue-recaptcha>-->
            <div class="col text-center text-white text-h4" >Authorization</div>
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
              <q-btn to="/signup" class="q-ml-auto  text-blue-grey-2 " flat >Registration</q-btn>
              <q-btn label="Submit" type="submit" class="float-right" color="grey-9"/>
            </div>
            <div class="col">
              <div class="text-h5" :class="{'text-green': !isError, 'text-red':isError}">
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
  import {mapActions,mapGetters} from 'vuex'
  export default {
    name: "Login",
    components:{ VueRecaptcha},
    data(){
      return{
        user:{
          username:'',
          password:''
        },
        error:'',
        isError:true,
        sitekey:'6LdnRg4aAAAAAKlh9vYmhAzSsqI3e4u0lLVVU5re'
      }
    },
    computed:{
      ...mapGetters(['isLogined'])
    },
    methods:{
      ...mapActions(['LoginAction']),
      onVerify(response){
        // this.$refs.invisibleRecaptcha.reset()
        // this.$axios.post('/auth',this.user)
        //   .then(t=>{
        //     this.error = ''
        //     console.log(t.data)
        //     this.LoginAction(t)
        //
        //   })
        //   .catch(e=>{
        //     console.log(e)
        //     this.error = e.response.data.message
        //   })
        this.LoginAction(this.user)
          .then(t=>{
            this.isError = false
            this.error = t
            this.$router.push("/")
        })
          .catch(t=>{
            this.isError = true
            this.error = t
          })
      },
      onError(){
        this.error = 'Captcha failed'
        this.$refs.invisibleRecaptcha.reset()
      },
      submit(){
        this.$refs.invisibleRecaptcha.execute()
      }
    },
    beforeMount() {
      if(this.isLogined) this.$router.push("/")
    }
  }
</script>

<style scoped>
  .form-size{
    max-width: 400px;
  }
</style>
