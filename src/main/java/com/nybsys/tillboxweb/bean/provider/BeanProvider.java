package com.nybsys.tillboxweb.bean.provider;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProvider implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /*@Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MqttSubscribePublished mqttSubscribePublished() {
        return new MqttSubscribePublished();
    }
*/
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
