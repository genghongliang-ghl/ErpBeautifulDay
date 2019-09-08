package com.erp.controller;

import com.erp.pojo.InquiryOfferSheet;
import com.erp.service.InquiryOfferSheetService;
import com.erp.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/9/4 22:59
 * @description: 查询
 */
@Controller
public class InquiryOfferSheetController {
    @Autowired
 private InquiryOfferSheetService inquiryOfferSheetService;
    @RequestMapping("/queryInquiryOfferSheetAll")
    @ResponseBody
    public Result queryInquiryOfferSheetAll(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<InquiryOfferSheet> list= inquiryOfferSheetService.getinquiryOfferSheetAll();
        if(list.size()>0){
            return new Result(200,"查询成功", list);
        }else{
            return new Result(500,"暂无数据", null);
        }

    }
    @RequestMapping("/insertInquiryOfferSheet")
    public Result insertInquiryOfferSheet(InquiryOfferSheet inquiryOfferSheet){
        System.out.print("tianjia");
      int result=  inquiryOfferSheetService.addInquiryOfferSheet(inquiryOfferSheet);
        if(result>0){
            return new Result(200,"添加成功",null);
        }else{
            return new Result(500,"添加失败",null);
        }
    }
@RequestMapping("/getBaoJiaAll")
@ResponseBody
 public Result getBaoJiaAll(){
   List<InquiryOfferSheet> list= inquiryOfferSheetService.getinquiryOfferSheetAll();
   System.err.print(list.toString());
    return new Result(200,"查询成功",list);
 }


}
