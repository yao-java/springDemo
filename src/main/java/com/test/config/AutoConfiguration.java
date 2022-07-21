package com.test.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.test.handler.ModelMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yao
 * @description
 * @date 2022-06-30 14:53
 */
@Slf4j
@Configuration
public class AutoConfiguration {

    /**
     * 分页插件
     */
    @ConditionalOnMissingBean(MybatisPlusInterceptor.class)
    @Bean
    public MybatisPlusInterceptor  paginationInterceptor() {
        MybatisPlusInterceptor  interceptor = new MybatisPlusInterceptor ();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        log.info("PaginationInterceptor [{}]", interceptor);
        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean(ModelMetaObjectHandler.class)
    public ModelMetaObjectHandler modelMetaObjectHandler() {
        ModelMetaObjectHandler metaObjectHandler = new ModelMetaObjectHandler();
        log.info("ModelMetaObjectHandler [{}]", metaObjectHandler);
        return metaObjectHandler;
    }
}
