package com.liverpool.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelMenu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menutype getType() {
        return type;
    }

    public void setType(Menutype type) {
        this.type = type;
    }

    public ModelMenu(String icon, String name, Menutype type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
      
    private String icon;
    private String name;
    private Menutype type;
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/com/liverpool/icon/" + icon+".png"));
    }
    
    
    public static enum Menutype{
        TITLE , MENU, EMPTY;
    }
}
