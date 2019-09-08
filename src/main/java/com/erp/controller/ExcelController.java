
package com.erp.controller;
import com.erp.mapper.CustomerMapper;
import com.erp.mapper.OrderMapper;
import com.erp.mapper.ProductMapper;
import com.erp.pojo.Customer;
import com.erp.pojo.InquiryOfferSheet;
import com.erp.pojo.Order;
import com.erp.pojo.Product;
import com.erp.service.InquiryOfferSheetService;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import com.erp.mapper.CustomerMapper;
import com.erp.mapper.OrderMapper;
import com.erp.mapper.ProductMapper;
import com.erp.pojo.Customer;
import com.erp.pojo.InquiryOfferSheet;
import com.erp.pojo.Order;
import com.erp.pojo.Product;
import com.erp.service.InquiryOfferSheetService;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/7  16:58
 */

import com.erp.mapper.CustomerMapper;
import com.erp.mapper.OrderMapper;
import com.erp.mapper.ProductMapper;
import com.erp.pojo.Customer;
import com.erp.pojo.InquiryOfferSheet;
import com.erp.pojo.Order;
import com.erp.pojo.Product;
import com.erp.service.InquiryOfferSheetService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller     //controller + ResponseBody
@CrossOrigin
@RequestMapping(value = "/excel")
public class ExcelController {
    private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
    @Autowired
    InquiryOfferSheetService inquiryOfferSheetService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    ProductMapper productMapper;

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/report/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public void loadFile(@PathVariable Long orderId, HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("file/report.xlsx");
        boolean isFile = resource.isFile();
        if(!isFile){     //如果不存在返回
            return;
        }
        Order order = orderMapper.selectByPrimaryKey(new Order(orderId));
        Customer customer = customerMapper.selectByPrimaryKey(new Customer(order.getCustomerId()));
        List<InquiryOfferSheet> reports = inquiryOfferSheetService.findAllByOrderId(orderId);
        if(order==null){
            logger.info("订单未查询到，orderId"+orderId);
            return;
        }
        if(customer==null){
            logger.info("客户未查询到，customerId"+order.getCustomerId());
            return;
        }
        if(CollectionUtils.isEmpty(reports)){
            logger.info("询价单未查询到，orderId"+orderId);
            return;
        }
        String path = resource.getFile().getPath();     //获取文件路径

/* 数据写入模板文件中 */

        //更改文件名编码
        String fileName = orderId+"_"+customer.getName()+".xlsx";
        String gFileName = URLEncoder.encode(fileName, "UTF-8");
        //如进行下载名为：文件（3）.txt，下载时显示名为：文件+（3）.txt --空格变为了+号
        //解决办法如下
        String dFileName = gFileName.replaceAll("\\+", "%20");
        InputStream in = null;
        Workbook exl = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(path);
            exl = WorkbookFactory.create(in);
            Sheet sheet1 = exl.getSheetAt(0);
            sheet1.setForceFormulaRecalculation(true);
            sheet1.getRow(5).getCell(5).setCellValue(customer.getName());//TO
            sheet1.getRow(6).getCell(5).setCellValue("");//Att:
            sheet1.getRow(7).getCell(5).setCellValue(customer.getEmail());//Client Ref:
            sheet1.getRow(8).getCell(5).setCellValue("");//Our Ref:
            sheet1.getRow(9).getCell(5).setCellValue(sdf.format(new Date()));//Date:
            BigDecimal sumAmount=BigDecimal.ZERO;
            for (int i = 0, y = reports.size(); i < y; ++i) {
                org.apache.poi.ss.usermodel.Row row = sheet1.createRow( i + 15 );
                InquiryOfferSheet ios = reports.get(i);
                Long productId = ios.getProductId();
                if(productId==null||productId==0){
                    logger.info("导出报价单，询价单中的产品id为空！询价单ID："+ios.getId());
                }
                Product product = productMapper.selectByPrimaryKey(new Product(productId));
                //PRODUCT	P/N	QTY.	UNIT PRICE	AMOUNT	REMARKS
                row.createCell(0).setCellValue(i + 1);  //序号
                row.createCell(1).setCellValue(product.getName());     //PRODUCT
                row.createCell(2).setCellValue(product.getPn());      //P/N
                row.createCell(3).setCellValue(ios.getOfferQTY().doubleValue()); //QTY
                row.createCell(4).setCellValue(ios.getOfferPrice().doubleValue());  //UNIT PRICE
                row.createCell(5).setCellValue(ios.getOfferAmount().doubleValue());//AMOUNT
                row.createCell(6).setCellValue(ios.getOfferRemark());//REMARKS
                sumAmount= sumAmount.add(ios.getOfferAmount());
            }
            sheet1.getRow(23).getCell(5).setCellValue(sumAmount.doubleValue());//TOTAL :

            //激活浏览器弹出窗口
            response.setContentType("application/x-msdownload");
            //浏览器弹出窗口显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + dFileName);
            exl.write(out);
            //in = new ByteArrayInputStream(out.toByteArray());
            response.getOutputStream().write(out.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (exl != null) {
                    exl.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

