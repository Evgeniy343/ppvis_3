package view;

import panel_interface.ScalePanel;

import javax.swing.*;
import java.awt.*;

public class ScalePanelView implements ScalePanel {
    private JPanel scalePanel;
    private JButton increase;
    private JButton decrease;

    ScalePanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        scalePanel = new JPanel();
        increase = new JButton("+");
        decrease = new JButton("-");
    }

    @Override
    public void setPanel() {
        scalePanel.setLayout(new FlowLayout());
        scalePanel.add(increase);
        scalePanel.add(decrease);
    }

    @Override
    public JPanel getPanel() {
        return scalePanel;
    }

    @Override
    public JButton getIncrease() {
        return increase;
    }

    @Override
    public JButton getDecrease() {
        return decrease;
    }
}
