package com.erp.mapper;


import com.erp.pojo.InquiryOfferSheet;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/9/4 23:01
 * @description:
 */
public interface InquiryOfferSheetDao extends Mapper<InquiryOfferSheet> {

    List<InquiryOfferSheet> selectInquiryOfferSheetDao();

}
