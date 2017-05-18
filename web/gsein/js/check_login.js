/**
 * Created by G.Seinfeld on 2017/5/18.
 * 登陆检查
 */
$(function () {
    /*
     提交表单时进行格式检查
     */
    $("form").submit(function () {
        if (!isAccountFormatRight()) {
            return false;
        }
        if (!isPasswordFormatRight()) {
            return false;
        }

        $.ajax({
            url: "cmsLogin.do",
            type: "post",
            dataType: "json",
            data:$(this).serialize(),
            success:function (result) {
                console.log(result);
                if(result.code=="200"){
                    location.href = "toUserManager.do";
                }else{
                    alertError(result.message)
                }
            },
            error:function () {
                alertError("服务器发生错误");
            }
        });

        return false;
    });

    /*
     失去焦点时判断格式
     */
    $("input[name=userAccount]").blur(function () {
        isAccountFormatRight();
    });

    /*
     失去焦点时判断格式
     */
    $("input[name=password]").blur(function () {
        isPasswordFormatRight();
    });


});


/**
 * 判断账号格式是否正确(开头1位字母+5-20位字母、数字、下划线)
 * true:正确
 * false:不正确
 */
function isAccountFormatRight() {
    var account = $("input[name=userAccount]").val();
    var accountRegex = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
    if (accountRegex.test(account)) {
        return true;
    } else {
        alertError("用户名格式错误");
        return false;
    }
}

/**
 * 判断密码格式是否正确(8-20位字母、数字、下划线)
 * true:正确
 * false:不正确
 */
function isPasswordFormatRight() {
    var password = $("input[name=password]").val();
    var passwordRegex = /^[a-zA-Z0-9_]{8,20}$/;
    if (passwordRegex.test(password)) {
        return true;
    } else {
        alertError("密码格式错误");
        return false;
    }
}

function alertError(errorMessage) {
    if (!$("#loginError").length > 0) {
        var messageBox = '<div id="messageBox" class="alert alert-danger hide"><button data-dismiss="alert" class="close">×</button><label id="loginError" class="has-error"></label></div>';
        $(".login-heading").append(messageBox);
    }
    $("#messageBox").removeClass("hide");
    $("#loginError").html(errorMessage);
}
    

