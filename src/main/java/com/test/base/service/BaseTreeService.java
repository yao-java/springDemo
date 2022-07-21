package com.test.base.service;

import com.test.base.entity.BaseTreeDO;
import com.test.base.vo.BaseTreeVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建时间：2019年01月11日 13:33
 * 用途：
 *
 * @author hele
 */
@Transactional(readOnly = true)
public interface BaseTreeService<T extends BaseTreeDO> extends BaseService<T> {

    /**
     * 获取树形数据列表
     *
     * @return
     */
    List<BaseTreeVO> getTree();
}
