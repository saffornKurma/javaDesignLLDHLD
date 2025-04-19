package com.scalar.LldDesignPatterns.factoryDesignPattern.base;


import com.scalar.LldDesignPatterns.factoryDesignPattern.ios.IOSTheme;
import com.scalar.LldDesignPatterns.factoryDesignPattern.ios.IOSThemeComponentFactory;

public class factoryDesignPatternMain {
    public static void main(String[] args) {
        Theme theme=ThemeFactory.getThemeAbstractFactory(THEME_TYPE.IOS_THEME);

        ThemeComponentFactory themeComponentFactory=theme.getThemeComponentFactory();
        if(themeComponentFactory instanceof IOSThemeComponentFactory){
            System.out.println("IOSThemeComponentFactory");
        }

        themeComponentFactory.createButton().click();
    }
}
