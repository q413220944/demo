package com.djfy.demo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.djfy.demo.dao.AdminMapper;
import com.djfy.demo.model.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    void contextLoads() {
        Admin admin = new Admin();
        admin.setAge(1);
        admin.setName("2");
        //adminMapper.insert(admin);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","2");
        adminMapper.delete(queryWrapper);
    }

}
