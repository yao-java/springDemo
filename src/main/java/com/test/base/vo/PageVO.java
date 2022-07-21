package com.test.base.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 创建时间：2019年01月21日 10:19
 * 用途：
 *
 * @author hele
 */
@Data
@ApiModel("分页参数")
@NoArgsConstructor
@AllArgsConstructor
public class PageVO implements Serializable {

    private static final long serialVersionUID = 2064853395148977561L;

    @NotNull(message = "页数不能为空")
    @ApiModelProperty(value = "页数", example = "1", required = true)
    private Integer pageNo;
    @NotNull(message = "每页数量不能为空")
    @ApiModelProperty(value = "每页数量", example = "10", required = true)
    private Integer pageSize;

    public Integer getPageNo() {
        if (Objects.isNull(pageNo) || pageNo <= 0) {
            pageNo = 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }
}
