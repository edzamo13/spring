package com.paymentchain.billing.exception;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApiExceptionHandler}.
 */
public class ApiExceptionHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'apiExceptionHandler'.
   */
  public static BeanDefinition getApiExceptionHandlerBeanDefinition() {
    Class<?> beanType = ApiExceptionHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ApiExceptionHandler::new);
    return beanDefinition;
  }
}
