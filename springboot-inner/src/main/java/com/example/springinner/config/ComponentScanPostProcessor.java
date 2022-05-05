package com.example.springinner.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            ComponentScan componentScan = AnnotationUtils.findAnnotation(AppConfig.class, ComponentScan.class);
            if (componentScan != null) {
                for (String p : componentScan.basePackages()) {
                    String path = "classpath*:" + p.replace(".", "/") + "/**/*.class";
                    CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
                    for (Resource resource : resources) {
                        MetadataReader reader = factory.getMetadataReader(resource);
                        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
                        if (annotationMetadata.hasAnnotation(Component.class.getName()) ||
                                annotationMetadata.hasMetaAnnotation(Component.class.getName())) {
                            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                                    .genericBeanDefinition(reader.getClassMetadata().getClassName()).getBeanDefinition();
                            if(configurableListableBeanFactory instanceof DefaultListableBeanFactory ){
                                String name = generator.generateBeanName(beanDefinition, (DefaultListableBeanFactory)configurableListableBeanFactory);
                                ((DefaultListableBeanFactory) configurableListableBeanFactory).registerBeanDefinition(name, beanDefinition);
                            }
                        }

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
