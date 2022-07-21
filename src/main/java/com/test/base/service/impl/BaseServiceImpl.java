package com.test.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建时间：2018年12月27日 14:36
 * 用途：
 *
 * @author hele
 */
@Transactional(readOnly = true)
@Slf4j
public abstract class BaseServiceImpl<Dao extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>, T> extends ServiceImpl<Dao, T> implements BaseService<T> {



    /**
     * 新增
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    /**
     * 修改
     *
     * @param t
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T t) {
        return baseMapper.updateById(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        return insert(entity) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateById(T entity) {
        return update(entity) > 0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(String id) {
        return baseMapper.deleteById(id);
    }

    /**
     * 根据ID获取对象
     *
     * @param id
     * @return
     */
    @Override
    public T get(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public PageInfo<T> page(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> list = list();
        return new PageInfo<>(list);
    }

    @Override
    public boolean exists(String id) {
        return baseMapper.selectCount(new QueryWrapper<T>().eq("id", id)) > 0;
    }

    @Override
    public boolean existsWithName(String name) {
        return baseMapper.selectCount(new QueryWrapper<T>().eq("name", name)) > 0;
    }

    @Override
    public boolean existsColumn(String columnKey, String columnValue) {
        return baseMapper.selectCount(new QueryWrapper<T>().eq(columnKey, columnValue)) > 0;
    }

    @Override
    public boolean existsColumnWithOutOwnId(String ownId, String columnKey, String columnValue) {
        return baseMapper.selectCount(new QueryWrapper<T>().eq(columnKey, columnValue).ne("id", ownId)) > 0;
    }

    @Override
    public boolean existsColumnWithOwnId(String ownId, String columnKey, String columnValue) {
        return baseMapper.selectCount(new QueryWrapper<T>().eq(columnKey, columnValue).eq("id", ownId)) > 0;
    }

}
