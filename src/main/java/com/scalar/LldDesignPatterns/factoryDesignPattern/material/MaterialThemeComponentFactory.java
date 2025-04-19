package com.scalar.LldDesignPatterns.factoryDesignPattern.material;

import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Button;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.Menu;
import com.scalar.LldDesignPatterns.factoryDesignPattern.base.ThemeComponentFactory;

import java.awt.*;

public class MaterialThemeComponentFactory implements ThemeComponentFactory {

    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public Menu createMenu() {
        return new MaterialMenu();
    }
}
