<template>
  <vue-recaptcha
    ref="invisibleRecaptcha"
    size="invisible"
    @verify="onVerify"
    @submit=""
    :sitekey="sitekey"
  >
  </vue-recaptcha>
</template>

<script>
  import VueRecaptcha from 'vue-recaptcha'
    export default {
      components:{VueRecaptcha},
        name: "Recaptcha",
      props:['onVerify'],
      data(){
        return{
          sitekey:'6LdnRg4aAAAAAKlh9vYmhAzSsqI3e4u0lLVVU5re',
        }
      },
      methods:{
        execute1(){
          console.log(this)
          this.$refs.invisibleRecaptcha.execute()
        }
      }
    }
</script>

<style scoped>

</style>
