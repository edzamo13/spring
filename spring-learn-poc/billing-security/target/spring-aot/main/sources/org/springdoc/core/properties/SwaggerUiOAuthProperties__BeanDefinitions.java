package org.springdoc.core.properties;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerUiOAuthProperties}.
 */
public class SwaggerUiOAuthProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'swaggerUiOAuthProperties'.
   */
  public static BeanDefinition getSwaggerUiOAuthPropertiesBeanDefinition() {
    Class<?> beanType = SwaggerUiOAuthProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SwaggerUiOAuthProperties::new);
    return beanDefinition;
  }
}
