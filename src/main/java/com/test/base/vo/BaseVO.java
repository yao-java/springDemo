package com.test.base.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 何乐
 * @date 2020/05/14 14:14
 * @desc 基础VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("基础VO")
public class BaseVO extends BaseIdNameVO {

    private static final long serialVersionUID = 1598804289557868702L;

    @ExcelIgnore
    @ApiModelProperty(value = "创建人id")
    private String createId;

    @ExcelIgnore
    @ApiModelProperty(value = "最近更新人id")
    private String lastModifyId;

    @ExcelIgnore
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date createTime;

    @ExcelIgnore
    @ApiModelProperty(value = "最近更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date lastModifyTime;

    @ExcelIgnore
    @ApiModelProperty(value = "创建人Label")
    private String createLabel;

    @ExcelIgnore
    @ApiModelProperty(value = "最近更新人Label")
    private String lastModifyLabel;
}
