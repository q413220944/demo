package com.djfy.demo.api;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.djfy.demo.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author QuinPluto
 */
@Api(value = "demo接口",tags = "demo接口")
@RestController
@RequestMapping("/web")
public class AdminWeb {

    @ApiOperation(value = "ceshi接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "aceshi ", dataType = "string", paramType = "query")
    })
    @PostMapping("/admin/a")
    public Object registered(String a){
        try {
            System.out.println(a);
            return Result.buildOk(a);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.buildError(e.getMessage());
        }
    }



}
