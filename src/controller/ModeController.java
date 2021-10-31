package controller;

import panel_interface.MainPanel;

public class ModeController {
    ModeController(MainPanel panelView) {
        panelView.getDrawingPanel().getModePanel().getModeLineA().addItemListener((event) -> modeLineA(panelView));
        panelView.getDrawingPanel().getModePanel().getModeLineB().addItemListener((event) -> modeLineB(panelView));
    }

    public void modeLineA(MainPanel panelView) {
        panelView.getDrawingPanel().getRenderer().setSeriesLinesVisible(0, panelView.getDrawingPanel().getModePanel().getModeLineA().isSelected());
    }

    public void modeLineB(MainPanel panelView) {
        panelView.getDrawingPanel().getRenderer().setSeriesLinesVisible(1, panelView.getDrawingPanel().getModePanel().getModeLineB().isSelected());
    }
}
