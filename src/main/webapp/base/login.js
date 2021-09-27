$(function () {
    $("input#submit").click(function () {
        // flush()

        var userName = $("input#userName").val();
        var password = $("input#password").val();
        var code = $("input#code").val().toLowerCase();

        reg_userName = /^[a-z0-9A-Z\u2E80-\u9FFF_-]{1,10}$/;
        reg_password = /^[a-z0-9A-Z]{6,10}$/;
        reg_email = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if (userName.length > 10) {
            alert("用户名字符长度不能大于10！");
            return false;
        }

        if (!reg_userName.test(userName)) {
            alert("用户名只能包含中文、英文字符、数字、-和_");
            return false;
        }

        if (password.length > 10 || password.length < 6) {
            alert("密码应为6-10个字符");
            return false;
        }

        if (!reg_password.test(password)) {
            alert("密码只能包含英文字符、数字、-和_");
            return false;
        }

        if (code !== relCode) {
            console.log("js从session中获取到的是:" + relCode);
            alert("验证码不正确！");
            changeVarCode();
            return false;
        }

        // 根据后端返回的结果做出判断
        var nameSpan = $("#userNameSpan");
        var nameI = nameSpan.children("li")[0];

        var pwdSpan = $("#userPwdSpan");
        var pwdI = pwdSpan.children("li")[0];
        if(sessionUserName){
            if(sessionUserPwd){
                return true;
            }else{
                nameSpan.addClass("success");
                pwdSpan.addClass("error");
                pwdI.addClass("error_icon");
                pwdI.innerText = "密码错误";
            }
        }else{
            nameSpan.addClass("error");
            nameI.addClass("error_icon");
            nameI.innerText = "用户名不存在";
        }

    });  // 当登录按钮被点击时

    // 当点击验证码图片时就切换验证码
    $("#code_img").click(changeVarCode);


});

function changeVarCode(){
    const codeImg = $("#code_img");
    const src = jQuery(codeImg).attr("src");
    jQuery(codeImg).attr("src", chgUrl(src));
    return 0;
}

// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
    const timestamp = (new Date()).valueOf();
    url = String(url);
    if(url.indexOf("?timestamp=") !== -1){
        url = url.substring(0, url.indexOf("?timestamp=")+12);
        url = url + timestamp;
    }else{
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}


function addClearAllSpan(){
    var inputs = $("input#userName,input#password").click(function (){
        clear();
    });
}

function clear(){
    $("span#userNameSpan, span#userPwdSpan").removeClass("success error");
    $("span#userNameSpan>li, span#userPwdSpan>li").removeClass("success_icon error_icon").text("")
}