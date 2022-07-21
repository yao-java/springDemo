package com.test.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * @author 陈晓程
 * 创建时间：2018年12月27日 14:36
 * 用途：
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 新增
     *
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据ID获取对象
     *
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 分页获取
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<T> page(int pageNo, int pageSize);

    /**
     * 判断是否存在
     *
     * @param id
     * @return
     */
    boolean exists(String id);

    /**
     * 判断是否存在
     *
     * @param name:
     * @return boolean
     * @author 何乐
     * @date 上午9:34 2021/2/22
     **/
    boolean existsWithName(String name);

    /**
     * 判断是否存在columnKey列值为columnValue的行记录
     *
     * @param columnKey:
     * @param columnValue:
     * @return boolean
     * @author 何乐
     * @date 上午9:36 2021/2/22
     **/
    boolean existsColumn(String columnKey, String columnValue);

    /**
     * 在排除ownId这条记录的情况下
     * 判断是否存在columnKey列值为columnValue的行记录
     *
     * @param columnKey:
     * @param columnValue:
     * @param ownId:
     * @return boolean
     * @author 何乐
     * @date 上午9:36 2021/2/22
     **/
    boolean existsColumnWithOutOwnId(String ownId, String columnKey, String columnValue);

    /**
     * 判断是否存在columnKey列值为columnValue的行记录,并且id=ownId
     *
     * @param columnKey:
     * @param columnValue:
     * @param ownId:
     * @return boolean
     * @author 何乐
     * @date 上午9:36 2021/2/22
     **/
    boolean existsColumnWithOwnId(String ownId, String columnKey, String columnValue);
}
