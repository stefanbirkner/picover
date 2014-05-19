package com.github.stefanbirkner.picover;

import com.github.stefanbirkner.picover.components.Description;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringOnlyApp implements App {
    @Override
    public String run() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        Description description = applicationContext.getBean(Description.class);
        return description.getDescription();
    }
}
