
let countLogin=0;
layui.use('layer',function () {
                let layer=layui.layer;
})
$("#login").bind('click',function () {
        layer.msg("即将开始验证账户以及密码")
        let username=$("#input_box").val()
        let password=$(".input_box").val()
        $.ajax({
                url:'/toLogin',
                type:'get',
                async:true,
                cache:false,
                data:{"username":username,"password":password},
                success(data){
                        if (data==='success'){
                                layer.msg("成功登陆！",{icon:1},3000);
                                window.location.href="/index"
                        }
                        if (data==='error'){
                                layer.confirm("您的账户或密码出现了点问题，您打算？",
                                    {icon:2,btn:['去重新输入','还没账号呢？去注册']},
                                    function () {
                                            layer.closeAll();
                                    },
                                    function () {
                                            window.location.href="/register"
                                    },
                                )
                        }
                },
                error(){
                                window.location.href="http://localhost:8848/e"

                }


        })
})

$("#reset").bind('click',function () {
    $("#input_box").val("")
    $(".input_box").val("")
})

