package com.zbx.rilsy.config.validator;

import org.hibernate.validator.BaseHibernateValidatorConfiguration;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @日期 2022/6/20
 * @作者 zbx
 * @描述 配置参数校验模式
 */

@Configuration(proxyBeanMethods = false)
public class ValidatorConfiguration {

    @Bean
    @ConditionalOnMissingBean(Validator.class)
    public LocalValidatorFactoryBean validator(AutowireCapableBeanFactory springFactory) {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        // 快速失败
        factoryBean.getValidationPropertyMap().put(BaseHibernateValidatorConfiguration.FAIL_FAST, Boolean.TRUE.toString());
        return factoryBean;
    }

}
