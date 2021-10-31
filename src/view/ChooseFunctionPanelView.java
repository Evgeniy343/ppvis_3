package view;

import panel_interface.ChoosePanel;

import javax.swing.*;

public class ChooseFunctionPanelView implements ChoosePanel {

    private JCheckBox[] functions;
    private JPanel choosePanel;

    public ChooseFunctionPanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        functions = new JCheckBox[]{new JCheckBox("f(x) = 4x - 3"), new JCheckBox("((2k)! + |x|) / (k^2)!")};
        ButtonGroup group = new ButtonGroup();
        group.add(functions[0]);
        group.add(functions[1]);
        choosePanel = new JPanel();
    }

    @Override
    public void setPanel() {
        choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.Y_AXIS));
        choosePanel.add(functions[0]);
        choosePanel.add(functions[1]);
    }

    @Override
    public JPanel getPanel() {
        return choosePanel;
    }

    @Override
    public JCheckBox getCheckBox(String checkBoxName) {
        if (checkBoxName.equals(functions[0].getText())) {
            return functions[0];
        }
        if (checkBoxName.equals(functions[1].getText())) {
            return functions[1];
        }
        return new JCheckBox("");
    }
}
