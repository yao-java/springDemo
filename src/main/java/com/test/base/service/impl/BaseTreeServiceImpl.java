package com.test.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.test.base.entity.BaseTreeDO;
import com.test.base.mapper.BaseTreeMapper;

import com.test.base.service.BaseTreeService;
import com.test.base.vo.BaseTreeVO;
import com.test.utils.TreeUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建时间：2019年01月11日 13:33
 * 用途：
 *
 * @author yangqian
 */
@Transactional(readOnly = true)
public abstract class BaseTreeServiceImpl<Dao extends BaseTreeMapper<T>, T extends BaseTreeDO> extends BaseServiceImpl<Dao, T> implements BaseTreeService<T> {
    @Override
    public List<BaseTreeVO> getTree() {
        List<BaseTreeVO> trees = baseMapper.selectList(new QueryWrapper<>()).stream().map(this::entityConvertToTree).collect(Collectors.toList());
        return TreeUtils.sortTrees(trees);
    }

    /**
     * 做一些转换
     *
     * @param t:
     * @return com.unicom.portal.server.mybatis.base.vo.BaseTreeVO<TR>
     * @author 何乐
     * @date 上午10:50 2021/3/12
     **/
    protected abstract <TR extends BaseTreeVO> BaseTreeVO<TR> entityConvertToTree(T t);


    /**
     * 插入或保存前，设置树形数据的属性
     *
     * @param t
     */
    private void saveTreeEntity(T t) {
        T parent = null;
        if (t.getParentId() != null) {
            parent = super.get(t.getParentId());
        }
        if (parent != null) {
            t.setParentIds(parent.getParentIds() + ",'" + t.getId() + "'");
        } else {
            t.setParentId("");
            t.setParentIds("'" + t.getId() + "'");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(T t) {
        baseMapper.insert(t);
        saveTreeEntity(t);
        return baseMapper.updateById(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(T t) {
        saveTreeEntity(t);
        return baseMapper.updateById(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(String id) {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("parent_ids", "'" + id + "'");
        return baseMapper.delete(updateWrapper);
    }
}
