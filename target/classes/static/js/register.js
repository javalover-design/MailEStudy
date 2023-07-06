let code=null;
let layer=null;
layui.use('layer',function () {
        layer=layui.layer;
})


$("#login").click(function () {
    let user=document.getElementById("user").value;
    let pwd=document.getElementById("pwd").value;
    let trueName=document.getElementById("name").value;
    let email=document.getElementById("email").value;
    let phone=document.getElementById("phone").value;
    let verifyCode=document.getElementById("identifyCode").value;

    let transformData={
        "phone":phone,
        "password":pwd,
        "email":email,
        "username":user,
        "trueName":trueName,
        }

        if (code=== +verifyCode) {
            console.log("进入到ajax请求了")
            $.ajax({
                url: '/toRegister',
                type: 'get',
                data: transformData,
                async: true,
                cache: false,
                dataType: 'text',
                success(data) {
                    if (data === 'success') {
                    layer.confirm("成功注册",{icon:1,btn:['好的，去登陆','暂时不了']},function () {
                        window.location.href = "/login";
                    },function () {
                        layer.closeAll();
                    })
                    }
                },
                error() {
                        layer.alert("出错了，可能是网络原因或者是没有输入验证码,请重新试一次！",{icon:2,title:'错误',btn: ['确定']})
                }
            })
        }else{
            layer.msg("验证码不太正确哦，重新试试！",{icon:2},3000);
        }
})

$("#identify").bind('click',function () {
        $.ajax({
            type:'post',
            url:'/getIdentify',
            async: true,
            cache: false,
            dataType: 'text',
            success(data) {
                layer.alert(`验证码为：${data}`,{icon: 1,title:'提示信息', btn:['知道了']})

                code= +data;
               // alert("code赋值完毕，为："+code)
            },
            error() {
               layer.msg("出了点问题，请重新尝试一次",{icon:2},2000);



            }
        })
})