window.onload  = cleaninput();
function  cleaninput() {
    var usertxt = document.getElementsByClassName("text")[0];
    usertxt.onfocus = function () {
        usertxt.value = "";
    };
    usertxt.onblur = function () {
        if (usertxt.value == ""){
            usertxt.value = "用户名";
        }
    };
    var pass = document.getElementById("password");
    pass.onfocus = function () {
        pass.value = "";
    }
    pass.onblur = function () {
        if (pass.value == ""){
            pass.value = "..........";
        }
    }
}
var loginForm = document.getElementById("login");
loginForm.addEventListener('click', function () {
    var usertxt = document.getElementsByClassName("text")[0];
    var pass = document.getElementById("password");
    ajax({
        url:"login",
        type:'POST',
        data:{
            username:'username',
            password:'password'
        },
        dataType:'json',
        timeout:600000,
        contentType:"application/json",
        success:function(data){
            console.log(data);
        },
        //异常处理
        error:function(e){
            console.log(e);
        }

    });
})

