package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.*;
import com.erp.pojo.*;
import com.erp.vo.SupllierOfferMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 23:54
 */
@Service
public class SupllierOfferService {
    @Autowired
    private InquiryOfferSheetMapper inquiryOfferSheetMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private SupllierOfferMapper supllierOfferMapper;

    /**
     * 根据供应商报价id获取带有关联对象的 供应商报价信息
     * @param id
     * @return
     */
    public SupllierOfferMo findOneCacheById(Long id){
        SupllierOffer logistics = supllierOfferMapper.selectByPrimaryKey(new SupllierOffer(id));
        SupllierOfferMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(logistics), SupllierOfferMo.class);
        InquiryOfferSheet pro = inquiryOfferSheetMapper.selectOneByExample(new InquiryOfferSheet(logistics.getInquiryOfferSheetId()));
        Supplier sup = supplierMapper.selectOneByExample(new Supplier(logistics.getSupplierId()));
        logisticsMo.setInquiryOfferSheet(pro);
        logisticsMo.setSupplier(sup);
        return logisticsMo;
    }

}
