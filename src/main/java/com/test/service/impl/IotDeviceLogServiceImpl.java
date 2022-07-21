package com.test.service.impl;


import com.test.base.service.impl.BaseServiceImpl;
import com.test.mapper.IotDeviceLogMapper;
import com.test.model.entity.IotDeviceLog;
import com.test.service.IotDeviceLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author 麦光耀
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IotDeviceLogServiceImpl extends BaseServiceImpl<IotDeviceLogMapper, IotDeviceLog> implements IotDeviceLogService {



}
