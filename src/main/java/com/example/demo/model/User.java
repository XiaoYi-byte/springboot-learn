package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    /*
    所有属性都应该在数据库中
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //数据库中的属性
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
