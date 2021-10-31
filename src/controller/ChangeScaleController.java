package controller;

import panel_interface.MainPanel;

public class ChangeScaleController {
    private static double right;
    private static double left;

    public static void initParts(MainPanel panelView)
    {
        right = panelView.getDrawingPanel().getRightPartScale();
        left = panelView.getDrawingPanel().getLeftPartScale();
    }

    public static void updateScaleAfterIncrease(MainPanel panelView)
    {
        if(right > 1){ right -= 0.2; }
        else { left += 0.2; }
        updateScaleLabel(panelView);
    }

    public static void updateScaleAfterDecrease(MainPanel panelView)
    {
        if(left > 1){ left -= 0.2; }
        else { right += 0.2; }
        updateScaleLabel(panelView);
    }

    private static void updateScaleLabel(MainPanel panelView) {
        panelView.getDrawingPanel().getModePanel().getScale().setText(left + "/" + right);
        panelView.getDrawingPanel().getModePanel().getScale().paintImmediately(panelView.getDrawingPanel().getModePanel().getScale().getVisibleRect());
    }
}
