package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries},quantity=#{quantity} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries,quantity) values(#{carName},#{carType},#{price},#{carSeries},#{quantity})")
    void insertCar(Car car);

    @Update("update carMessage set quantity=quantity - #{quantity} where id = #{id}")
    void buyCar(Car car);

    @Select("select * from carMessage where id = #{id}")
    Car findStockById(Car id);

    @Select("select * from carMessage where carSeries like #{carSeries} limit #{pageNo},#{pageSize}")
    List<Car> selectPage(Integer pageNo, Integer pageSize, String carSeries);
}
