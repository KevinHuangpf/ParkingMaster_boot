package com.pfhuang.parkingmaster_boot.dao;

import com.pfhuang.parkingmaster_boot.entity.Parkinglot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ParkinglotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkinglot record);

    int insertSelective(Parkinglot record);

    Parkinglot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkinglot record);

    int updateByPrimaryKey(Parkinglot record);

    Parkinglot selectByParkinglotIdAndZoneId(@Param("parkinglotId")Integer parkinglotId, @Param("zoneId") Integer zoneId);

}