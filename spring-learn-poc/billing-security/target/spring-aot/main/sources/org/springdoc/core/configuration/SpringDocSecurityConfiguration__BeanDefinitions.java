package org.springdoc.core.configuration;

import java.lang.Class;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link SpringDocSecurityConfiguration}.
 */
public class SpringDocSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocSecurityConfiguration'.
   */
  public static BeanDefinition getSpringDocSecurityConfigurationBeanDefinition() {
    Class<?> beanType = SpringDocSecurityConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocSecurityConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration}.
   */
  public static class SpringSecurityLoginEndpointConfiguration__BeanDefinitions {
    /**
     * Get the bean instance supplier for 'org.springdoc.core.configuration.SpringDocSecurityConfiguration$SpringSecurityLoginEndpointConfiguration'.
     */
    private static BeanInstanceSupplier<SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration> getSpringSecurityLoginEndpointConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration>forConstructor()
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocSecurityConfiguration.class).new SpringSecurityLoginEndpointConfiguration());
    }

    /**
     * Get the bean definition for 'springSecurityLoginEndpointConfiguration'.
     */
    public static BeanDefinition getSpringSecurityLoginEndpointConfigurationBeanDefinition() {
      Class<?> beanType = SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getSpringSecurityLoginEndpointConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'springSecurityLoginEndpointCustomiser'.
     */
    private static BeanInstanceSupplier<OpenApiCustomizer> getSpringSecurityLoginEndpointCustomiserInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<OpenApiCustomizer>forFactoryMethod(SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration.class, "springSecurityLoginEndpointCustomiser", ApplicationContext.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration.class).springSecurityLoginEndpointCustomiser(args.get(0)));
    }

    /**
     * Get the bean definition for 'springSecurityLoginEndpointCustomiser'.
     */
    public static BeanDefinition getSpringSecurityLoginEndpointCustomiserBeanDefinition() {
      Class<?> beanType = OpenApiCustomizer.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getSpringSecurityLoginEndpointCustomiserInstanceSupplier());
      return beanDefinition;
    }
  }
}
