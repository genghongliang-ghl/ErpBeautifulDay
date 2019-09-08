package com.erp.service;

import com.erp.mapper.WarehouseDao;
import com.erp.pojo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/8/31 22:17
 * @description:
 */
@Service
public class WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;
    /*
    仓库存储查询全部
     */
    public List<Warehouse> getAll(){
      List<Warehouse> list=  warehouseDao.selectAll();
        return list;

    }



}
