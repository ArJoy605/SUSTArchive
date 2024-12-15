
package com.liverpool.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Card {
    private Icon icon;
    private String title;
    private String values;
    private String description;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model_Card() {
    }

    public Model_Card(Icon icon, String title, String values, String description) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = description;
    }
    
    public Model_Card(ModelWork work) {
        if (work.getType() == WorkType.PROJECT) {
            this.icon = new ImageIcon(getClass().getResource("/com/liverpool/icon/project.png"));
        } else if (work.getType() == WorkType.THESIS) {
            this.icon = new ImageIcon(getClass().getResource("/com/liverpool/icon/thesis.png"));
        } else {
            this.icon = new ImageIcon(getClass().getResource("/com/liverpool/icon/research.png"));
        }
        
        this.title = work.getName();
        this.values = "Views: " + work.getViews();
        this.description = work.getAuthor();
    }
    
    
}
