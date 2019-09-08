package com.erp.controller;

import com.erp.pojo.Warehouse;
import com.erp.service.WarehouseService;
import com.erp.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/8/31 22:26
 * @description:
 */
@RestController
/*@RequestMapping("/warehouseController")*/
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;


    @RequestMapping("/queryWarehouse")
    public Result queryWarehouse(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
       List<Warehouse> warehouseList= warehouseService.getAll();
        PageInfo pageInfo=new PageInfo(warehouseList);
        return new Result(200,"查询成功",pageInfo,null);
    }

}
