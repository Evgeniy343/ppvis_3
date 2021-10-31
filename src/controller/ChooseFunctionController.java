package controller;

import panel_interface.MainPanel;

import java.awt.*;

public class ChooseFunctionController {
    ChooseFunctionController(MainPanel panelView) {
        panelView.getChoosePanel().getCheckBox("f(x) = 4x - 3").addItemListener(e -> {
            panelView.getPanel().add(panelView.getProcessPanel().getPanel(), BorderLayout.SOUTH);
            panelView.getPanel().add(panelView.getDrawingPanel().getPanel(), BorderLayout.CENTER);
            FunctionAController functionAController = new FunctionAController(panelView);
        });

        panelView.getChoosePanel().getCheckBox("((2k)! + |x|) / (k^2)!").addItemListener(e -> {
            panelView.getPanel().add(panelView.getProcessPanel().getPanel(), BorderLayout.SOUTH);
            panelView.getPanel().add(panelView.getDrawingPanel().getPanel(), BorderLayout.CENTER);
            FunctionBController functionBController = new FunctionBController(panelView);
        });

    }
}
