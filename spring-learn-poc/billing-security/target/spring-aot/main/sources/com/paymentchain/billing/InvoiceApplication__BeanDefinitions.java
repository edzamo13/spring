package com.paymentchain.billing;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link InvoiceApplication}.
 */
public class InvoiceApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'invoiceApplication'.
   */
  public static BeanDefinition getInvoiceApplicationBeanDefinition() {
    Class<?> beanType = InvoiceApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(InvoiceApplication.class);
    beanDefinition.setInstanceSupplier(InvoiceApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
