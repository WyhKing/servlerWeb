window.onload  = cleaninput();
function  cleaninput() {
    //清除账号输入框
    var usertxt = document.getElementsByClassName("text")[0];
    usertxt.onfocus = function () {
        usertxt.value = "";
    };
    usertxt.onblur = function () {
        if (usertxt.value == ""){
            usertxt.value = "用户名";
        }
    };
    //清除密码输入框
    var pass = document.getElementById("password");
    pass.onfocus = function () {
        pass.value = "";
    }
    pass.onblur = function () {
        if (pass.value == ""){
            pass.value = "..........";
        }
    }
    //清除验证码输入框
    var inputimg = document.getElementById("inputimg");
    inputimg.onfocus = function () {
        inputimg.value = "";
    }
    inputimg.onblur = function () {
        if (inputimg.value == ""){
            inputimg.value = "验证码";
        }
    }
    //刷新验证码
    getverify();

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
            window.location.href = "main.html";
        },
        //异常处理
        error:function(e){
            console.log(e);
        }

    });
});

var checkcode = document.getElementById("checkcode");
checkcode.addEventListener('click', getverify);
function getverify() {
    ajax({
        type:"POST",
        dataType:"json",
        url:"verify",
        data:{
        },
        timeout:600000,
        contentType:"application/json",
        success:function (data) {
            var json = JSON.parse(data);
            document.getElementById("checkcode").src='data:image/png;base64,' + json.codePic;
        },
        error:function () {
        }
    });
}


