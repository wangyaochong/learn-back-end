package src.constant;

public class ConfigConstant {
    /**
     * 当有相同id/name的bean时，设置为false，则会抛出BeanDefinitionOverrideException
     */
    public static final boolean allowBeanDefinitionOverriding = false;

    /**
     * 当有循环依赖时，设置为false，则会抛出BeanCurrentlyInCreationException
     */
    public static final boolean allowCircularReferences = false;
}
