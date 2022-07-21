package com.test.base.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.codec.binary.StringUtils;

import java.util.List;

/**
 * 创建时间：2019年01月21日 09:47
 * 用途：
 *
 * @author hele
 */
@Data
@ApiModel("树形结构数据")
public class BaseTreeVO<T> extends BaseIdNameVO implements Comparable<BaseTreeVO> {
    private static final long serialVersionUID = 4869777792519354316L;
    @ApiModelProperty("页面显示标签")
    public String label;
    @ApiModelProperty("页面显示标签的值")
    public String value;
    @ApiModelProperty("父级ID")
    public String parentId;
    @ApiModelProperty("类型")
    public String type;
    @ApiModelProperty("编号")
    public String code;
    @ApiModelProperty("下级树形数据")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<T> children;
    @ApiModelProperty("排序")
    public Integer sort;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            //地址相等
            return true;
        }

        if (obj == null) {
            //非空性：对于任意非空引用x，x.equals(null)应该返回false。
            return false;
        }

        if (obj instanceof BaseTreeVO) {
            BaseTreeVO other = (BaseTreeVO) obj;
            //需要比较的字段相等，则这两个对象相等
            if (StringUtils.equals(this.id, other.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(BaseTreeVO o) {
        if (this == o) {
            return 0;
        }
        if (this.getSort() == null) {
            return 1;
        }
        if (o.getSort() == null) {
            return -1;
        }
        return this.getSort() - o.getSort();
    }
}
