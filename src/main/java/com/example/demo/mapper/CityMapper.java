package com.example.demo.mapper;

import com.example.demo.model.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    @Insert("insert into city(`name`,`state`,`country`) values(#{name},#{state},#{country})")//同xml方式
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);//通过xml方式插入
}
