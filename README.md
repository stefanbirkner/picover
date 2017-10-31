# Picover

[![Build Status](https://secure.travis-ci.org/stefanbirkner/picover.png)](https://travis-ci.org/stefanbirkner/picover)

Picover brings a Pico container for a smooth migration from PicoContainer DI to Spring DI. With this container you can migrate your components one by one. The application is kept in a runnable state during the whole migration.

Picover is published under the
[MIT license](http://opensource.org/licenses/MIT).

## SpringPicoContainer

Picover provides `SpringPicoContainer`. This container doesn't manage components by itself but uses a `BeanFactory` that provides the components. It is intended to be used as a parent container.

    BeanFactory beanFactory = getBeanFactory(); //e.g. the application context
    SpringPicoContainer springPicoContainer = new SpringPicoContainer(beanFactory);
    MutablePicoContainer pico = new DefaultPicoContainer(springPicoContainer);

## Get Picover

Picover is available from Maven Central.

    <dependency>
      <groupId>com.github.stefanbirkner</groupId>
      <artifactId>picover</artifactId>
      <version>1.0.0</version>
    </dependency>
