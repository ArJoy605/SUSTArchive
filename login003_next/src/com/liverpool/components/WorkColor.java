
package com.liverpool.components;

import com.liverpool.model.WorkType;
import java.awt.Color;

public class WorkColor {
    
    public Color getColor1 (WorkType type) {
        if (type == WorkType.PROJECT) {
            return new Color (142, 142, 250);
        } else if (type == WorkType.THESIS) {
            return new Color (186, 123, 247);
        } else {
            return new Color (241, 208, 62);
        }
    }
    
    public Color getColor2 (WorkType type) {
        if (type == WorkType.PROJECT) {
            return new Color (123, 123, 250);
        } else if (type == WorkType.THESIS) {
            return new Color (167, 94, 236);
        } else {
            return new Color (211, 164, 61);
        }
    }
}
