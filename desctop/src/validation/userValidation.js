import EXCEPTION from "src/exeption/exceptions";
import ExceptionClass from "src/exeption/exeption";

function validateUser(user) {
  if(!user || user == '' || user == null) throw new ExceptionClass(EXCEPTION.userNull,EXCEPTION.userNull)
  if(!user.username || user.username == '' || user.username == null) throw new ExceptionClass(EXCEPTION.usernameEmpty,EXCEPTION.usernameEmpty)
  if(!user.password || user.password == '' || user.password == null) throw new ExceptionClass(EXCEPTION.passwordEmpty,EXCEPTION.passwordEmpty)
}
export {validateUser}
