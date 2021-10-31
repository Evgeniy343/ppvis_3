package controller;

import panel_interface.MainPanel;

public class ScaleController {
    private double upperX;
    private double upperY;
    private double lowerX;
    private double lowerY;

    ScaleController(MainPanel panelView) {
        ChangeScaleController.initParts(panelView);
        panelView.getDrawingPanel().getScalePanel().getIncrease().addActionListener((event) -> {
            increaseScale(panelView);
            ChangeScaleController.updateScaleAfterIncrease(panelView);
        });
        panelView.getDrawingPanel().getScalePanel().getDecrease().addActionListener((event) -> {
            decreaseScale(panelView);
            ChangeScaleController.updateScaleAfterDecrease(panelView);
        });
    }

    private void increaseScale(MainPanel panelView) {
        getUpperXY(panelView);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setUpperBound(upperX - upperX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setUpperBound(upperY - upperY * 0.2);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setLowerBound(lowerX - lowerX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setLowerBound(lowerY - lowerY * 0.2);
    }

    private void decreaseScale(MainPanel panelView) {
        getUpperXY(panelView);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setUpperBound(upperX + upperX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setUpperBound(upperY + upperY * 0.2);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setLowerBound(lowerX + lowerX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setLowerBound(lowerY + lowerY * 0.2);
    }

    private void getUpperXY(MainPanel panelView) {
        upperY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getUpperBound();
        upperX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getUpperBound();
        lowerY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getLowerBound();
        lowerX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getLowerBound();
    }
}
