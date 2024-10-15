package org.springdoc.core.properties;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocConfigProperties}.
 */
public class SpringDocConfigProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocConfigProperties'.
   */
  public static BeanDefinition getSpringDocConfigPropertiesBeanDefinition() {
    Class<?> beanType = SpringDocConfigProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocConfigProperties::new);
    return beanDefinition;
  }
}
