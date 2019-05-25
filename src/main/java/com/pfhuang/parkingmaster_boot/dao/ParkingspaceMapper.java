package com.pfhuang.parkingmaster_boot.dao;

import com.pfhuang.parkingmaster_boot.entity.Parkingspace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ParkingspaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkingspace record);

    int insertSelective(Parkingspace record);

    Parkingspace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkingspace record);

    int updateByPrimaryKey(Parkingspace record);

    Parkingspace selectByParkingSpaceIdAndParkinglotId(@Param("parkingSpaceId") Integer parkingSpaceId, @Param("parkinglotId") Integer parkinglotId);
}