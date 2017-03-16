/**
 * Created by yyy on 2017/3/15.
 */


function confirmPwd(){
    var password = document.getElementById("password");
    var confirmPwd = document.getElementById("passwordConfirm");
    if(password.value != confirmPwd.value){
        alert("两次密码不一致");
    }else{
        document.getElementById("reg-form").submit();
    }
}