package com.example.mail.controller.vendors;
import com.example.mail.dao.vendorsDao.VendorsOperation;
import com.example.mail.entity.Goods;
import com.example.mail.entity.Vendors;
import com.example.mail.service.goodsservice.GoodsOperationService;
import com.example.mail.service.vendorsService.VendorsOperationService;
import com.example.mail.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Controller
public class VendorsOperationController {

    @Autowired
    private VendorsOperationService vendorsOperation;

    @Autowired
    private VendorsOperation operation;

    @Autowired
    private GoodsOperationService goodsOperationService;

    private String vendorsLoginVerifyCode;

    private String id;

    @RequestMapping("/registerVendors")
    public String  registerVendors(HttpServletRequest request){
        String vendorsId= VerifyCodeUtils.getRandomVerifyCode();
        String vendorsName = request.getParameter("vendorsName");
        String provinceId = request.getParameter("vendorsProvince");
        String cityId = request.getParameter("vendorsCity");
        String regionId = request.getParameter("vendorsRegion");
        String vendorsProvince=operation.convertProvince(provinceId);
        String vendorsCity=operation.convertCity(cityId);
        String vendorsRegion = operation.convertRegion(regionId);
        String vendorsAddress=vendorsProvince+"-"+vendorsCity+"-"+vendorsRegion;
        String vendorsPhone = request.getParameter("vendorsPhone");
        String vendorsDescription = request.getParameter("vendorsDescription");
        String vendorsZip = request.getParameter("vendorsZip");
        String goodsList = Arrays.toString(request.getParameterValues("goods"));
        Vendors vendors = new Vendors(vendorsId,vendorsName,vendorsAddress,vendorsPhone,vendorsDescription,vendorsZip,goodsList);
        boolean flag = vendorsOperation.register(vendors);
        if (!flag){
            return "html/404Error";
        }

        return "index";
    }


    @PostMapping("/getVendorsLoginCode")
    @ResponseBody
    public String getVendorsLoginVerifyCode(){
        vendorsLoginVerifyCode=VerifyCodeUtils.getRandomVerifyCode();
        return vendorsLoginVerifyCode;
    }

    @GetMapping("/vendorsLogin")
    @ResponseBody
    public String vendorsLogin(String vendorsName, String vendorsPhone, String verifyCode, HttpServletRequest request, HttpServletResponse response){
        if (vendorsName==null || vendorsPhone==null || verifyCode==null){
            return "fail";
        }
        Vendors vendors = vendorsOperation.vendorsLogin(vendorsName, vendorsPhone);

        if (vendors==null || !verifyCode.equals(vendorsLoginVerifyCode)){
            return "fail";
        }

        Cookie vendorsCookie = new Cookie("vendorsName", vendorsName);
        Cookie vendorsId=new Cookie("vendorsId",vendors.getVendorsId());
        response.addCookie(vendorsCookie);
        response.addCookie(vendorsId);
        HttpSession session = request.getSession(true);
        session.setAttribute("vendorsName",vendorsName);
        session.setAttribute("vendorsId",vendors.getVendorsId());
        id=vendors.getVendorsId();
        return "success";
    }


    @RequestMapping("/addProducts")
    public void addProducts(Goods goods,HttpServletResponse response) throws IOException {
        String goodsId= UUID.randomUUID().toString();
        String goodsName=goods.getGoodsName();
        String goodsDescription=goods.getGoodsDescription();
        Double goodsPrice=goods.getGoodsPrice();
        String pictureUrl=goods.getPictureUrl();
        String details="../404Error.html";
       boolean discount=false;
        Goods products = new Goods(goodsId,goodsName,goodsDescription,id,goodsPrice,discount,details,pictureUrl);
        goodsOperationService.addProduct(products);
        response.sendRedirect("/vendorsindex");
    }



}
