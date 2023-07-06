let layer=null;
let form=null;
layui.use('form',function () {
    form = layui.form;
    loadCities();
    loadRegions();

})
layui.use('layer',function () {
     layer=layui.layer;
})

//页面开始就加载省份
function load() {
    $().ready(function () {
        $.ajax({
            type: 'post',
            url: '/getProvince',
            cache: false,
            async: true,
            //contentType:"application/json",
            dataType: 'json',
            success(data) {
                console.log(data)
               let selectProvince= document.getElementById("province");
                selectProvince.add(new Option("请选择对应的省份","0"))
                let option=null;
                for (let i = 0; i < data.length; i++) {
                    console.log(data[i].provinceId)
                    console.log(data[i].provinceName)

                  option = new Option(data[i].provinceName,data[i].provinceId);

                    selectProvince.add(option)
                }
                console.log("添加完毕！")
                form.render('select')
                form.render();
                // $("#province").html(options);
            },
            error() {
                console.log("进入了error")
                layer.confirm('省份加载暂时出现了点问题！', {icon: 2, btn: ['好的，回主页吧', '去登陆页'], title: '错误信息'}, function () {
                        window.location.href = '/main'
                    },
                    function () {
                        window.location.href = '/login'
                    })
            }
        })

    })
}

//选择城市
function loadCities() {
    form.on('select(changeProvince)', function () {
        $("#city").html('')
        //alert("改变方法执行了！")
        let provinceId = $("#province option:selected").val();
        //let provinceId = data.val();
        $.ajax({
            type: 'post',
            url: '/getCities',
            cache: false,
            async: true,
            data: {"provinceId": provinceId},
            //  contentType:"application/json",
            dataType: 'json',
            success(data) {
                console.log(data)
                let selectCities = document.getElementById("city");
                selectCities.add(new Option("请选择对应的城市", "0"));
                let option = null;
                for (let i = 0; i < data.length; i++) {
                    console.log(data[i].cityId);
                    console.log(data[i].cityName);
                    option = new Option(data[i].cityName, data[i].cityId);
                    selectCities.add(option)
                }
                form.render('select')
                form.render();
            },
            error() {
                console.log("进入了error")
                layer.confirm('市加载暂时出现了点问题！', {icon: 2, btn: ['好的，回主页吧', '去登陆页'], title: '错误信息'}, function () {
                        window.location.href = '/main'
                    },
                    function () {
                        window.location.href = '/login'
                    })
            }
        })
    })
}

//选择地区
function loadRegions () {
    form.on('select(changeCity)',function () {
        $("#region").html('');
        let cityId=$("#city option:selected").val();
        $.ajax({
            type:'post',
            url:'/getRegions',
            cache:false,
            async:true,
            data: {"cityId":cityId},
            dataType:'json',
            success(data){
                let selectRegions = document.getElementById("region");
                selectRegions.add(new Option("请选择对应的区",0))
                let option=null
                for (let i=0;i<data.length;i++){
                    console.log(data[i].regionId);
                    console.log(data[i].regionName);
                    option=new Option(data[i].regionName,data[i].regionId);
                    selectRegions.add(option);
                }
                form.render('select')
                form.render();

            },
            error() {
                console.log("进入了error")
                layer.confirm('区加载暂时出现了点问题！', {icon: 2, btn: ['好的，回主页吧', '去登陆页'], title: '错误信息'}, function () {
                        window.location.href = '/main'
                    },
                    function () {
                        window.location.href = '/login'
                    })
            }

        })
    })
}






