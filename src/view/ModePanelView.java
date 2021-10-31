package view;

import panel_interface.ModePanel;

import javax.swing.*;
import java.awt.*;

public class ModePanelView implements ModePanel {
    private JPanel choosePanel;
    private JCheckBox modeLineA;
    private JCheckBox modeLineB;
    private JLabel scale;

    ModePanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        choosePanel = new JPanel();
        scale = new JLabel("1/1");
        modeLineA = new JCheckBox("FunctionA");
        modeLineB = new JCheckBox("FunctionB");
    }

    @Override
    public void setPanel() {
        choosePanel.setLayout(new FlowLayout());
        choosePanel.add(modeLineA);
        choosePanel.add(modeLineB);
        choosePanel.add(scale);
    }

    @Override
    public JPanel getPanel() {
        return choosePanel;
    }

    @Override
    public JCheckBox getModeLineA() {
        return modeLineA;
    }

    @Override
    public JCheckBox getModeLineB() {
        return modeLineB;
    }

    @Override
    public JLabel getScale() {
        return scale;
    }

    @Override
    public void setScale(JLabel scale) {
        this.scale = scale;
    }
}
