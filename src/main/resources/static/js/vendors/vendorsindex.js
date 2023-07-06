firstData=null;
layui.use(['layer','form'],function () {
        const layer=layui.layer;
        const  form=layui.form;
})

layer.msg("欢迎登陆供应商主页")

layui.use('carousel',function () {
    let carousel=layui.carousel;
    carousel.render({
        elem: '#test1'
        ,width: '450px' //设置容器宽度
        ,arrow: 'always' ,//始终显示箭头
        autoplay:true,
    });

})
let vendorsId=null;
//
// document.querySelector('.hidden').classList.remove('hidden')
function getMessageSize(){
    //获取所有的信息
    const iTag = document.querySelector('i');
    let number=Math.floor(Math.random()*10)
    if (number===0){
        document.querySelector('i').classList.remove("layui-badge layui-bg-orange")
        return;
    }
    iTag.innerHTML=number

}

//获取后台所有的商品信息(页面一加载就读取后台数据)
function loadGoodsData () {
    getMessageSize()
    //获取cookie
    let cookies = document.cookie.split(';');
    for (let i=0;i<cookies.length;i++){
        let cookie=cookies[i].trim().split('=');
        if (cookie[0]==="vendorsId"){
                    vendorsId=cookie[1];
        }


    }
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
window.onload=loadGoodsData();




