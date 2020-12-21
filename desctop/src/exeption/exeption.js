export default class {
  constructor(exception,message) {
    this.exception = exception
    if(!message){
      this.message = ''
    }else {
      this.message = message
    }

  }
}
