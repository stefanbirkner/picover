package com.github.stefanbirkner.picover;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.adapters.InstanceAdapter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A {@link org.picocontainer.PicoContainer} that makes it possible to use Spring managed beans. It is intended to be
 * used as a parent container.
 * <pre>
 *     BeanFactory beanFactory = getBeanFactory(); //e.g. the application context
 *     SpringPicoContainer springPicoContainer = new SpringPicoContainer(beanFactory);
 *     MutablePicoContainer pico = new DefaultPicoContainer(springPicoContainer);
 * </pre>
 */
public class SpringPicoContainer implements PicoContainer {
    private final BeanFactory beanFactory;

    /**
     * Creates a new {@code SpringPicoContainer}.
     *
     * @param beanFactory provides the Spring managed beans.
     */
    public SpringPicoContainer(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getComponent(Object componentKeyOrType) {
        if (componentKeyOrType instanceof Class) {
            return getComponent((Class) componentKeyOrType);
        } else {
            return null;
        }
    }

    @Override
    public Object getComponent(Object o, Type type) {
        return null;
    }

    @Override
    public <T> T getComponent(Class<T> type) {
        try {
            return beanFactory.getBean(type);
        } catch (NoSuchBeanDefinitionException e) {
            return null;
        }
    }

    @Override
    public <T> T getComponent(Class<T> tClass, Class<? extends Annotation> aClass) {
        return null;
    }

    @Override
    public List<Object> getComponents() {
        return null;
    }

    @Override
    public PicoContainer getParent() {
        return null;
    }

    @Override
    public ComponentAdapter<?> getComponentAdapter(Object o) {
        Object bean = getComponent(o);
        return (bean == null) ? null : new InstanceAdapter(o, bean);
    }

    @Override
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> tClass, NameBinding nameBinding) {
        return null;
    }

    @Override
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> tClass, Class<? extends Annotation> aClass) {
        return null;
    }

    @Override
    public Collection<ComponentAdapter<?>> getComponentAdapters() {
        return null;
    }

    @Override
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> tClass) {
        return null;
    }

    @Override
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> tClass, Class<? extends Annotation> aClass) {
        return null;
    }

    @Override
    public <T> List<T> getComponents(Class<T> type) {
        T component = getComponent(type);
        return (component == null) ? Collections.<T>emptyList() : Collections.singletonList(component);
    }

    @Override
    public void accept(PicoVisitor picoVisitor) {
    }
}
