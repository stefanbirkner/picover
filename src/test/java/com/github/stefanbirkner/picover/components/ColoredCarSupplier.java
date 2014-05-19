package com.github.stefanbirkner.picover.components;

public class ColoredCarSupplier {
    private final CarSupplier carSupplier;
    private final ColorSupplier colorSupplier;

    public ColoredCarSupplier(CarSupplier carSupplier, ColorSupplier colorSupplier) {
        this.carSupplier = carSupplier;
        this.colorSupplier = colorSupplier;
    }

    public String getColoredCar() {
        return colorSupplier.getColor() + " " + carSupplier.getCar();
    }
}
