package com.test.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.model.entity.IotDeviceLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author 麦光耀
 */
@Mapper
@Repository
public interface IotDeviceLogMapper extends BaseMapper<IotDeviceLog> {



}
