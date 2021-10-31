package view;

import panel_interface.FunctionAPanel;

import javax.swing.*;
import java.awt.*;

public class FunctionAPanelView extends JFrame implements FunctionAPanel {
    private JLabel labelX;
    private JTextField textFieldX;
    private JPanel functionPanelA;

    public FunctionAPanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        labelX = new JLabel("x");
        textFieldX = new JTextField("", 6);
        functionPanelA = new JPanel();
    }

    @Override
    public void setPanel() {
        functionPanelA.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addParamsOnPanel(constraints);
    }

    @Override
    public JPanel getPanel() {
        return functionPanelA;
    }

    public void addParamsOnPanel(GridBagConstraints constraints) {
        constraints.gridx = 0;
        constraints.gridy = 0;
        functionPanelA.add(labelX, constraints);
        constraints.gridy = 1;
        functionPanelA.add(textFieldX, constraints);
    }

    @Override
    public JTextField getTextFieldX() {
        return textFieldX;
    }

}
