package controller;

import panel_interface.MainPanel;

import java.awt.*;

public class ChooseWorkModeController {

    public ChooseWorkModeController(MainPanel panelView) {
        panelView.getChooseWorkModePanel().getCheckBox("Parallel drawing").addItemListener(e -> {
            panelView.getPanel().removeAll();
            panelView.getPanel().add(panelView.getProcessPanel().getPanel(), BorderLayout.SOUTH);
            panelView.getPanel().add(panelView.getDrawingPanel().getPanel(), BorderLayout.CENTER);
            panelView.getFunctionBPanel().getPanel().remove(panelView.getFunctionBPanel().getParamsPanel());
            FunctionBController functionBController = new FunctionBController(panelView);
            panelView.getPanel().add(panelView.getChooseWorkModePanel().getPanel(), BorderLayout.LINE_END);
            panelView.updatePanel();
        });

        panelView.getChooseWorkModePanel().getCheckBox("Selective drawing").addItemListener(e -> {
            panelView.getDrawingPanel().getModePanel().getScale().setText("1/1");
            panelView.getPanel().removeAll();
            if (panelView.getFunctionBPanel().getParamsPanel().getParent() != panelView.getFunctionBPanel().getPanel()) {
                panelView.getFunctionBPanel().getPanel().add(panelView.getFunctionBPanel().getParamsPanel(), BorderLayout.SOUTH);
            }
            panelView.getPanel().removeAll();
            panelView.getPanel().add(panelView.getChoosePanel().getPanel(), BorderLayout.PAGE_START);
            panelView.getPanel().add(panelView.getChooseWorkModePanel().getPanel(), BorderLayout.LINE_END);
            panelView.updatePanel();
        });
    }
}
