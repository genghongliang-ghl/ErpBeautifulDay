package com.erp.vo;

import com.erp.pojo.*;
import lombok.Data;
/**
 * @author : DongChenchen
 * @date : 2019/9/6 23:20
 */
@Data
public class SupllierOfferMo extends SupllierOffer {
    private InquiryOfferSheet inquiryOfferSheet;//关联询价单
    private Supplier supplier;//关联供应商
}
