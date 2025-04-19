package com.scalar.LldDesignPatterns.factoryDesignPattern.base;

import com.scalar.LldDesignPatterns.factoryDesignPattern.ios.IOSTheme;
import com.scalar.LldDesignPatterns.factoryDesignPattern.material.MaterialTheme;

public class ThemeFactory {
    static Theme getThemeAbstractFactory(THEME_TYPE type) {
        if (THEME_TYPE.IOS_THEME.equals(type))
            return new IOSTheme();
        else if (THEME_TYPE.MATERIAL_THEME.equals(type)) {
            return new MaterialTheme();
        } else {
            return null;
        }
    }


}
