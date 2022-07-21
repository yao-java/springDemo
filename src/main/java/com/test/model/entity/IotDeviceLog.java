package com.test.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.test.base.entity.BaseAuditDO;
import lombok.Data;


/**
 * 设备信息对象 iot_device
 *
 * @author iotssp
 * @date 2021-07-26
 */
@Data
@TableName(value = "iot_device_log")
public class IotDeviceLog extends BaseAuditDO {
    private static final long serialVersionUID = 1L;


    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 厂商名称
     */
    private String vendorName;

    /**
     * 设备具体地址
     */
    private String deviceLocation;

    /**
     * 运行状态 0：离线，1.在线
     */
    private String inline;



}
