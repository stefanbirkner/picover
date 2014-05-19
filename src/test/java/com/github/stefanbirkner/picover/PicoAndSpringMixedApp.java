package com.github.stefanbirkner.picover;

import com.github.stefanbirkner.picover.components.CarSupplier;
import com.github.stefanbirkner.picover.components.ColoredCarSupplier;
import com.github.stefanbirkner.picover.components.Description;
import com.github.stefanbirkner.picover.components.LocationSupplier;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PicoAndSpringMixedApp implements App {
    @Override
    public String run() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context-color-supplier.xml");
        SpringPicoContainer springPicoContainer = new SpringPicoContainer(applicationContext);
        MutablePicoContainer pico = new DefaultPicoContainer(springPicoContainer);
        pico.addComponent(Description.class);
        pico.addComponent(LocationSupplier.class);
        pico.addComponent(ColoredCarSupplier.class);
        pico.addComponent(CarSupplier.class);
        Description description = pico.getComponent(Description.class);
        return description.getDescription();
    }
}
