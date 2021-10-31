package controller;

import panel_interface.MainPanel;
import javax.swing.table.DefaultTableModel;

public class StopFunctionController {
    StopFunctionController(MainPanel panelView) {
        panelView.getProcessPanel().getStopButton().addActionListener((event) -> {
            panelView.getDrawingPanel().getDataset().getSeries(0).clear();
            panelView.getDrawingPanel().getDataset().getSeries(1).clear();
            for (int i = panelView.getFunctionBPanel().getTableB().getRowCount() - 1; i >= 0; i--) {
                DefaultTableModel model = (DefaultTableModel) panelView.getFunctionBPanel().getTableB().getModel();
                model.removeRow(i);
            }
            if (panelView.getChooseWorkModePanel().getCheckBox("Parallel drawing").isSelected()) {
                panelView.getFunctionBPanel().getTableB().removeAll();
                CalculateAndDrawController.getExecutor().shutdown();
            }
        });
    }
}
