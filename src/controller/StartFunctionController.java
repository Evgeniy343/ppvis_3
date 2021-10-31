package controller;

import panel_interface.MainPanel;
import view.CorrectedDataView;

public class StartFunctionController {
    StartFunctionController(MainPanel panelView) {
        panelView.getProcessPanel().getStartButton().addActionListener((event) -> drawGraphic(panelView));
    }

    public void drawGraphic(MainPanel panelView) {
        CalculateAndDrawController calculateAndDrawController = new CalculateAndDrawController(panelView);
        if (panelView.getChooseWorkModePanel().getCheckBox("Parallel drawing").isSelected()) {
            CalculateAndDrawController.getExecutor().submit(new CalculateAndDrawController.FunctionACalculateThread());
            CalculateAndDrawController.getExecutor().submit(new CalculateAndDrawController.FunctionBCalculateThread());
            CalculateAndDrawController.getExecutor().submit(new CalculateAndDrawController.FunctionADrawThread());
            CalculateAndDrawController.getExecutor().submit(new CalculateAndDrawController.FunctionBDrawThread());
        }
        if (panelView.getChooseWorkModePanel().getCheckBox("Selective drawing").isSelected()) {
            if (panelView.getChoosePanel().getCheckBox("f(x) = 4x - 3").isSelected()) {
                if (!CorrectedDataView.printAMessage(panelView.getFunctionAPanel().getTextFieldX())) {
                    return;
                }
                CalculateAndDrawController.calculateGraphicA();
                CalculateAndDrawController.drawGraphicA();
            }
            if (panelView.getChoosePanel().getCheckBox("((2k)! + |x|) / (k^2)!").isSelected()) {
                if (!CorrectedDataView.printBMessage(panelView.getFunctionBPanel().getTextFieldParams())) {
                    return;
                }
                CalculateAndDrawController.calculateGraphicB();
                CalculateAndDrawController.drawGraphicB();
            }
        }
    }

}
