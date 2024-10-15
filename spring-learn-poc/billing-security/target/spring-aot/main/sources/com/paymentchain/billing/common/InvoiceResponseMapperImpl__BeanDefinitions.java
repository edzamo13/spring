package com.paymentchain.billing.common;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InvoiceResponseMapperImpl}.
 */
public class InvoiceResponseMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'invoiceResponseMapperImpl'.
   */
  public static BeanDefinition getInvoiceResponseMapperImplBeanDefinition() {
    Class<?> beanType = InvoiceResponseMapperImpl.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(InvoiceResponseMapperImpl::new);
    return beanDefinition;
  }
}
