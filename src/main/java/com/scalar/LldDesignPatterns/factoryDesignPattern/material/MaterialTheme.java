package com.scalar.LldDesignPatterns.factoryDesignPattern.material;


import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Theme;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.ThemeComponentFactory;
import com.scalar.LldDesignPatterns.factoryDesignPattern.ios.IOSThemeComponentFactory;

public class MaterialTheme extends Theme {
    @Override
    public ThemeComponentFactory getThemeComponentFactory() {
        return new MaterialThemeComponentFactory();
    }
}
