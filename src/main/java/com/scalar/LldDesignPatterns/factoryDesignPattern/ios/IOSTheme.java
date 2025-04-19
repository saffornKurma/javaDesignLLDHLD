package com.scalar.LldDesignPatterns.factoryDesignPattern.ios;


import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Theme;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.ThemeComponentFactory;

public class IOSTheme extends Theme {
    @Override
    public ThemeComponentFactory getThemeComponentFactory() {
        return new IOSThemeComponentFactory();
    }
}
