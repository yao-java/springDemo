package com.test.handler;



import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 自动填充模型数据
 *
 * @author 陈兴波
 */
public class ModelMetaObjectHandler implements MetaObjectHandler {

    private final static String USER_ID = "0";

    /**
     * metaObject是页面传递过来的参数的包装对象，不是从数据库取的持久化对象，因此页面传过来哪些值，metaObject里就有哪些值。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        Object createTime = this.getFieldValByName("createTime", metaObject);
        if (null == createTime) {
            this.setFieldValByName("createTime", now, metaObject);
        }

        Object lastModifyTime = this.getFieldValByName("updateTime", metaObject);
        if (null == lastModifyTime) {
            this.setFieldValByName("updateTime", now, metaObject);
        }



        Object createId = this.getFieldValByName("createId", metaObject);

        // TODO

        if (null == createId) {
            this.setFieldValByName("createId", "0", metaObject);
        }
        Object lastModifyId = this.getFieldValByName("updateId", metaObject);
        if (null == lastModifyId) {
            this.setFieldValByName("updateId","0", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        this.setFieldValByName("updateTime", now, metaObject);


        // TODO

        this.setFieldValByName("updateId", "0", metaObject);
    }
}
