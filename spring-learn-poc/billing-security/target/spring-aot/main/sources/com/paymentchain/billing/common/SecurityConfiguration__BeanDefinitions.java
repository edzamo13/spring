package com.paymentchain.billing.common;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Bean definitions for {@link SecurityConfiguration}.
 */
public class SecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'securityConfiguration'.
   */
  public static BeanDefinition getSecurityConfigurationBeanDefinition() {
    Class<?> beanType = SecurityConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfiguration.class);
    beanDefinition.setInstanceSupplier(SecurityConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'users'.
   */
  private static BeanInstanceSupplier<UserDetailsService> getUsersInstanceSupplier() {
    return BeanInstanceSupplier.<UserDetailsService>forFactoryMethod(SecurityConfiguration.class, "users")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).users());
  }

  /**
   * Get the bean definition for 'users'.
   */
  public static BeanDefinition getUsersBeanDefinition() {
    Class<?> beanType = UserDetailsService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getUsersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfiguration.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    Class<?> beanType = PasswordEncoder.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfiguration.class, "filterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).filterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'filterChain'.
   */
  public static BeanDefinition getFilterChainBeanDefinition() {
    Class<?> beanType = SecurityFilterChain.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getFilterChainInstanceSupplier());
    return beanDefinition;
  }
}
