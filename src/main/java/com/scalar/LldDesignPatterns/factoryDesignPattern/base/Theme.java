package com.scalar.LldDesignPatterns.factoryDesignPattern.base;

public abstract class Theme
{
    public String color;
    public String name;
    public String effect;

    public abstract ThemeComponentFactory getThemeComponentFactory();

}
