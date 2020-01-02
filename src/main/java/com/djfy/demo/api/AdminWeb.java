package com.djfy.demo.api;

import com.djfy.demo.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QuinPluto
 */
@Api(value = "demo接口",tags = "demo接口")
@RestController
@RequestMapping("/web")
public class AdminWeb {

    @ApiOperation(value = "测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "测试字段 ", dataType = "string", paramType = "query")
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
