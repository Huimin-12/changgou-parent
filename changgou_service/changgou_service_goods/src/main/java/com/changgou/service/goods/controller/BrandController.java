package com.changgou.service.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;
    //查询所有
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findList();
        return new Result(true, StatusCode.OK,"查询所有成功",brandList);
    }

    //根据id进行品牌查询
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id){
        try {
            Brand brand = brandService.findById(id);
            return new Result(true,StatusCode.OK,"查询成功",brand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
    }


    //根据id进行品牌的删除
    @DeleteMapping("/delete/{id}")
    public Result deleteId(@PathVariable("id") Integer id){
        brandService.delById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    //添加品牌信息
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    //修改品牌信息
    @PutMapping()
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改成功");
    }
}
