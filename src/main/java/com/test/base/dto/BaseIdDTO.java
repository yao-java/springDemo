package com.test.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建时间：2019年12月05日 11:34
 * 用途：
 *
 * @author hele
 */
@Data
@ApiModel("id")
public class BaseIdDTO implements Serializable {
    private static final long serialVersionUID = -5424997995729634535L;
    @ApiModelProperty("id")
    private String id;
}
