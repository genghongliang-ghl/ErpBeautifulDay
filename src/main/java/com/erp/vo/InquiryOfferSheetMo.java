package com.erp.vo;

import com.erp.pojo.*;
import lombok.Data;

import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 21:24
 */
@Data
public class InquiryOfferSheetMo extends InquiryOfferSheet {
    private Customer customer;//客戶/需求方（客户表）
    private OrderItem orderItem;   //关联订单项表
    private Product product;//关联产品表
    private Logistics logistics;//关联一个物流信息
    private SupllierOffer supllierOffer;//关联一个供应商报价信息(最终确认的供应商)
    private List<SupllierOffer> supllierOfferList;//关联一个供应商报价信息(所有待选的供应商)
}
