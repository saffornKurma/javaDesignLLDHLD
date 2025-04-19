package com.scalar.LldDesignPatterns.factoryDesignPattern.ios;

import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Button;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Menu;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.ThemeComponentFactory;



import java.awt.*;

public class IOSThemeComponentFactory implements ThemeComponentFactory {

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
