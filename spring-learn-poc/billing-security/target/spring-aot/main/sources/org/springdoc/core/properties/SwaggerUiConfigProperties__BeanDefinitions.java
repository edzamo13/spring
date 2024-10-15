package org.springdoc.core.properties;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerUiConfigProperties}.
 */
public class SwaggerUiConfigProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'swaggerUiConfigProperties'.
   */
  public static BeanDefinition getSwaggerUiConfigPropertiesBeanDefinition() {
    Class<?> beanType = SwaggerUiConfigProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SwaggerUiConfigProperties::new);
    return beanDefinition;
  }
}
