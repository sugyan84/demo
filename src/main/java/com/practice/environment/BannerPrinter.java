package com.practice.environment;

import java.io.PrintStream;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;


public class BannerPrinter implements Banner {

    @Override public void printBanner(final Environment environment, final Class<?> sourceClass,
            final PrintStream out) {

        out.println("Sugyan's implemented Banner");
    }
}
