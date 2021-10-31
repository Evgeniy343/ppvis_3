package panel_interface;

import javax.swing.*;

public interface ModePanel extends Panel{
    JCheckBox getModeLineA();
    JCheckBox getModeLineB();
    JLabel getScale();
    void setScale(JLabel scale);
}
