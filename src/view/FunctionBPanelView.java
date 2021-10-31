package view;

import panel_interface.FunctionBPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FunctionBPanelView extends JFrame implements FunctionBPanel {
    private JLabel[] labelParams;
    private JTextField[] textFieldParams;
    private JTable tableB;
    private final Object[] headers = {"f(x)", "x", "a", "b", "n"};
    private JPanel functionPanelB;
    private JPanel paramsPanel;
    private JScrollPane scrollPane;

    public FunctionBPanelView() {
        initPanelComponents();
        setPanel();
    }


    @Override
    public void initPanelComponents() {
        labelParams = new JLabel[]{new JLabel("a"), new JLabel("b"), new JLabel("n")};
        textFieldParams = new JTextField[]{new JTextField("", 7), new JTextField("", 7), new JTextField("", 7)};
        DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
        tableB = new JTable(tableModel);
        functionPanelB = new JPanel();
        paramsPanel = new JPanel();
        scrollPane = new JScrollPane(tableB);
    }

    @Override
    public void setPanel() {
        functionPanelB.setLayout(new BorderLayout());
        paramsPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addLabelParamsOnPanel(constraints);
        addTextFieldParamsOnPanel(constraints);
        functionPanelB.add(scrollPane, BorderLayout.CENTER);
        functionPanelB.add(paramsPanel, BorderLayout.SOUTH);
    }

    public void addLabelParamsOnPanel(GridBagConstraints constraints) {
        constraints.gridx = 0;
        constraints.gridy = 0;
        for (JLabel labelParam : labelParams) {
            paramsPanel.add(labelParam, constraints);
            constraints.gridx++;
        }
    }

    public void addTextFieldParamsOnPanel(GridBagConstraints constraints) {
        constraints.gridx = 0;
        constraints.gridy = 1;
        for (JTextField textFieldParam : textFieldParams) {
            paramsPanel.add(textFieldParam, constraints);
            constraints.gridx++;
        }
    }

    @Override
    public JPanel getPanel() {
        return functionPanelB;
    }

    @Override
    public JPanel getParamsPanel() {
        return paramsPanel;
    }

    @Override
    public JTextField[] getTextFieldParams() {
        return textFieldParams;
    }

    @Override
    public JTable getTableB() {
        return tableB;
    }
}
