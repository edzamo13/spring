package com.paymentchain.billing.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link InvoiceRestController}.
 */
public class InvoiceRestController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static InvoiceRestController apply(RegisteredBean registeredBean,
      InvoiceRestController instance) {
    instance.billingRepository = AutowiredFieldValueResolver.forRequiredField("billingRepository").resolve(registeredBean);
    instance.irm = AutowiredFieldValueResolver.forRequiredField("irm").resolve(registeredBean);
    instance.irspm = AutowiredFieldValueResolver.forRequiredField("irspm").resolve(registeredBean);
    return instance;
  }
}
