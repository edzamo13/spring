package com.paymentchain.billing.common;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InvoiceRequestMapperImpl}.
 */
public class InvoiceRequestMapperImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'invoiceRequestMapperImpl'.
   */
  public static BeanDefinition getInvoiceRequestMapperImplBeanDefinition() {
    Class<?> beanType = InvoiceRequestMapperImpl.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(InvoiceRequestMapperImpl::new);
    return beanDefinition;
  }
}
