package com.erp.service;
import  java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.InquiryOfferSheetDao;
import com.erp.mapper.SupllierOfferMapper;
import com.erp.pojo.*;
import com.erp.vo.FinancialStatisticsMo;
import com.erp.vo.InquiryOfferSheetMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/9/4 23:00
 * @description:
 */
@Service
public class InquiryOfferSheetService {
    @Autowired
    private InquiryOfferSheetDao inquiryOfferSheetDao;
    @Autowired
    private SupllierOfferMapper supllierOfferMapper;

    /*
    查询 操作
     */

    public List<InquiryOfferSheet> getinquiryOfferSheetAll(){
        List<InquiryOfferSheet> list =inquiryOfferSheetDao.selectAll();
        return list;
    }
    /*
    添加  操作
     */
    public Integer addInquiryOfferSheet(InquiryOfferSheet inquiryOfferSheet){
      return  inquiryOfferSheetDao.insert(inquiryOfferSheet);
    }

    /**
     * 根据利润统计id获取带有关联对象的 利润统计信息
     * @param id
     * @return
     */
    public InquiryOfferSheetMo findOneCacheById(Long id){
        InquiryOfferSheet logistics = inquiryOfferSheetDao.selectByPrimaryKey(new InquiryOfferSheet(id));
        InquiryOfferSheetMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(logistics), InquiryOfferSheetMo.class);
        SupllierOffer sup = supllierOfferMapper.selectByPrimaryKey(logistics.getSupllierOfferId());
        logisticsMo.setSupllierOffer(sup);
        Example exam=new Example(SupllierOffer.class);
        exam.createCriteria().andEqualTo("inquiryOfferSheetId",id);
        List<SupllierOffer> sups = supllierOfferMapper.selectByExample(exam);
        logisticsMo.setSupllierOfferList(sups);
        return logisticsMo;
    }
    /**
     * 根据订单id获取 全部的询价录入信息
     * @param orderId
     * @return
     */
    public List<InquiryOfferSheet> findAllByOrderId(Long orderId){
        Example emp=new Example(InquiryOfferSheet.class);
        emp.createCriteria().andEqualTo("orderId",orderId);
        return inquiryOfferSheetDao.selectByExample(emp);
    }
}
