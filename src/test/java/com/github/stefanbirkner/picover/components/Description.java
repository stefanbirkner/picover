package com.github.stefanbirkner.picover.components;

public class Description {
    private final ColoredCarSupplier coloredCarSupplier;
    private final LocationSupplier locationSupplier;

    public Description(ColoredCarSupplier coloredCarSupplier, LocationSupplier locationSupplier) {
        this.coloredCarSupplier = coloredCarSupplier;
        this.locationSupplier = locationSupplier;
    }

    public String getDescription() {
        return coloredCarSupplier.getColoredCar() + " at " + locationSupplier.getLocation();
    }
}
