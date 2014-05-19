package com.github.stefanbirkner.picover;

import com.github.stefanbirkner.picover.components.*;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class PicoOnlyApp implements App {
    @Override
    public String run() {
        MutablePicoContainer pico = new DefaultPicoContainer();
        pico.addComponent(Description.class);
        pico.addComponent(LocationSupplier.class);
        pico.addComponent(ColoredCarSupplier.class);
        pico.addComponent(ColorSupplier.class);
        pico.addComponent(CarSupplier.class);
        Description description = pico.getComponent(Description.class);
        return description.getDescription();
    }
}
