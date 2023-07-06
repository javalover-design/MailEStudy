//layui监听提交
layui.use(['form','layer'], function(){
    const form = layui.form;
    const layer=layui.layer;
    //监听提交
    form.on('submit(form)', function(data){
        layer.msg(data)
    });
});


