package view;

import panel_interface.ChoosePanel;

import javax.swing.*;

public class ChooseWorkModePanelView implements ChoosePanel {
    private JCheckBox[] modes;
    private JPanel choosePanel;

    public ChooseWorkModePanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        modes = new JCheckBox[]{new JCheckBox("Parallel drawing"), new JCheckBox("Selective drawing")};
        ButtonGroup group = new ButtonGroup();
        group.add(modes[0]);
        group.add(modes[1]);
        choosePanel = new JPanel();
    }

    @Override
    public void setPanel() {
        choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.Y_AXIS));
        choosePanel.add(modes[0]);
        choosePanel.add(modes[1]);
    }

    @Override
    public JPanel getPanel() {
        return choosePanel;
    }


    @Override
    public JCheckBox getCheckBox(String checkBoxName) {
        if (checkBoxName.equals(modes[0].getText())) {
            return modes[0];
        }
        if (checkBoxName.equals(modes[1].getText())) {
            return modes[1];
        }
        return new JCheckBox("");
    }
}
