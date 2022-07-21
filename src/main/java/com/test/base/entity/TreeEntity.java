package com.test.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 陈晓程
 * 创建时间：2019年01月11日 13:23
 * 用途：
 */
@Data
public abstract class TreeEntity extends BaseAuditDO {
    private static final long serialVersionUID = -6578656341064027894L;
    @TableField(value = "parent_id")
    private String parentId;
    @TableField(value = "parent_ids")
    private String parentIds;
}
