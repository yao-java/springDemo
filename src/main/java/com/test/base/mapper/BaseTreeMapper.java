package com.test.base.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.base.entity.BaseTreeDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 创建时间：2019年01月11日 13:13
 * 用途：
 *
 * @author yangqian
 */
public interface BaseTreeMapper<T extends BaseTreeDO> extends BaseMapper<T> {
    /**
     * 查找所有与父级ID关联的的子数据
     *
     * @param parentId
     * @return
     */
    List<T> findAllByParentId(@Param("parentId") String parentId);

    /**
     * 查找所有parentIds包含父级ID的的子数据
     *
     * @param parentId
     * @return
     */
    List<T> findAllByParentIdsLike(@Param("parentId") String parentId);
}
