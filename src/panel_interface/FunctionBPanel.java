package panel_interface;

import javax.swing.*;

public interface FunctionBPanel extends Panel {
    JPanel getParamsPanel();
    JTextField[] getTextFieldParams();
    JTable getTableB();
}
