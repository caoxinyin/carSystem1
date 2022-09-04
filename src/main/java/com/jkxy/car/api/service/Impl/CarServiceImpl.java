package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.config.BuyException;
import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public String buyCar(Car car) {
        Car carbuy= carDao.findStockById(car);
        if (carbuy == null) {
            throw new BuyException("未找到车辆信息");
        }
        if (car.getQuantity() > carbuy.getQuantity()) {
            throw new BuyException("库存不够");
        }
        carDao.buyCar(car);
        return car.getCarName() + "购买成功: " + car.getQuantity() + "辆";
    }

    @Override
    public List<Car> findPage(Integer pageNo, Integer pageSize, String carSeries) {
        return carDao.selectPage(pageNo,pageSize,carSeries);
    }
}
