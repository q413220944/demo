package com.djfy.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djfy.demo.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author QuinPluto
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin checkWhat (@Param("a") Admin a);

}