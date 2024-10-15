package com.paymentchain.billing.controller;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InvoiceRestController}.
 */
public class InvoiceRestController__BeanDefinitions {
  /**
   * Get the bean definition for 'invoiceRestController'.
   */
  public static BeanDefinition getInvoiceRestControllerBeanDefinition() {
    Class<?> beanType = InvoiceRestController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<InvoiceRestController> instanceSupplier = InstanceSupplier.using(InvoiceRestController::new);
    instanceSupplier = instanceSupplier.andThen(InvoiceRestController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
