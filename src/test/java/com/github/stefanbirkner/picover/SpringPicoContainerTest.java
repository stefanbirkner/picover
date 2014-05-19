package com.github.stefanbirkner.picover;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.injectors.AbstractInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import static org.junit.rules.ExpectedException.none;

public class SpringPicoContainerTest {
    @Rule
    public final ExpectedException thrown = none();

    @Test
    public void handlesUnsatisfiableDependencies() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        SpringPicoContainer springPicoContainer = new SpringPicoContainer(applicationContext);
        MutablePicoContainer pico = new DefaultPicoContainer(springPicoContainer);
        pico.addComponent(B.class);
        thrown.expect(AbstractInjector.UnsatisfiableDependenciesException.class);
        pico.getComponent(B.class);
    }

    public static class A {
    }

    public static class B {
        public B(A a) {
        }
    }

    @Configuration
    public static class Application {
    }
}