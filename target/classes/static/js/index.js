let layers;
layui.use('layer',function () {
       layers =layui.layer;


})
let headPage=document.getElementById("head");
console.log(headPage)


$(function () {
              //给输入框设置防抖
              let timer=null;
       //发送ajax的jsonp请求（jsonp请求能够进行跨域处理，一般的ajax不支持跨域）
       function send(keyword) {
              $.ajax({
                     url:'/search',
                     type:'get',
                     data:{"keyWord":keyword},
                     dataType:'JSONP',
                     async:true,
                     cache:false,
                     success:function (result) {
                            console.log("发送请求了")
                            return loadResult(result)
                     }

              })
       }

              function setTime(keyword){
                     timer=setTimeout(function () {
                       //发送请求
                       send(keyword);
                     },500)
              }

              //给输入框绑定事件
              $("#searchProblem").on('input',function () {
                     console.log("开始输入了")
                     clearTimeout(timer)
                     //获取输入到的关键词
                     let keyword=$(this).val().trim();
                     console.log("获取到关键词"+keyword)
                     if (keyword.length<0){
                            //如果关键词长度为0，即没有输入，则隐藏推荐
                           return  $("#searchSuggest").empty().hide();
                     }
                     //调用定时器，500ms后发起请求
                     setTime(keyword);
              })



       //将后台获取的所有数据渲染到页面中
       function loadResult(data) {
              console.log(`获取到对应的信息为:${data}`) //获取到对应的信息为:肉松面包,肉松
              console.log(typeof data)
              clearTimeout(timer);
              //清空所有的搜索
              $("#searchSuggest").empty();

              //判断后端传过来的结果
              if (data.length<0){
                     //
                     return $("#searchSuggest").empty().hide()
              }
              //转成数组
              let values = Object.values(data);
              console.log(`结果为：${values[0]}`)
              console.log(`结果为：${values[1]}`)
              //如果结果不为空，则遍历
              // values.forEach(item=>{
              //        $("#searchSuggest").append(`<div class="suggestItem">${item[0]}</div>`).show().css('border','1px')
              // })
              for (let i=0;i<values.length;i++){
                     $("#searchSuggest").append(`<div class="suggestItem">${values[i]}</div>`).show().css('border','1px');
              }




       }

       //点击外面隐藏提示框
       $(document).on('click',function (e) {
              if (e.target.id!=='searchProblem'){
                     return $("#searchSuggest").hide();
              }else{
                     //如果提示框里面没有就不展示
                     if ($('.suggestItem').length<0){
                            return  ;
                     }
                     $("#searchSuggest").show();
              }
       })
})

function loadGoodsData () {
       $.ajax({
              url:'/getGoodsData',
              type:'post',
              async:true,
              cache:false,
              success(datas){
                     //将json字符串对象转成json数组，否则就是undefined
                     console.log('datas的数据是：   '+datas)
                     let datae=JSON.parse(datas)
                     let data=[];
                     let itemNames={};
                     //对json对象进行去重
                     datae.forEach((item)=>{
                            if (!itemNames[item.goodsName]){
                                   itemNames[item.goodsName]=true; //通过设置布尔值来判断是否存在
                                   data.push(item)
                            }

                     })
                     itemNames={};

                     console.log(data)
                     console.log(data.length)
                     const div = document.querySelector('#first_line');
                     let childDiv = null

                     for (let i = 0; i < data.length; i++) {
                            console.log('执行第' + (i + 1) + '次')
                            childDiv = document.createElement("div");
                            childDiv.setAttribute("class", "layui-col-lg2")
                            childDiv.innerHTML = `  <ul>
                    <li><img src="${data[i].pictureUrl}" style="width: 200px;height:150px" alt="${data[i].goodsName}" title="${data[i].goodsName}" ></li>
                    <li ><a href="${data[i].details}" title="点击查看详情">${data[i].goodsName}</a></li>
                    <li><a href="javascript:void alert('商品的价格为：￥${data[i].goodsPrice}元')" style="color: red" title="查看详情"> ￥${data[i].goodsPrice}</a></li>
                </ul>`
                            div.appendChild(childDiv)

                     }



              },
              error(e){
                     layer.msg("商品出现了点问题，稍后再试试",{icon:5,time:3000})
              }

       })
}

