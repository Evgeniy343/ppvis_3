package controller;

import panel_interface.MainPanel;

public class ZoomController {
    private double upperX;
    private double upperY;
    private double lowerX;
    private double lowerY;

    ZoomController(MainPanel panelView) {
        ChangeScaleController.initParts(panelView);
        panelView.getDrawingPanel().getChartPanel().addMouseWheelListener(e -> {
            if (e.isControlDown()) {
                increase(panelView);
                ChangeScaleController.updateScaleAfterIncrease(panelView);
            }
        });
        panelView.getDrawingPanel().getChartPanel().addMouseWheelListener(e ->{
            if(!e.isControlDown()) {
                decrease(panelView);
                ChangeScaleController.updateScaleAfterDecrease(panelView);
            }
        });
    }

    private void increase(MainPanel panelView) {
        getXY(panelView);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setUpperBound(upperX - upperX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setUpperBound(upperY - upperY * 0.2);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setLowerBound(lowerX - lowerX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setLowerBound(lowerY - lowerY * 0.2);
    }

    private void decrease(MainPanel panelView) {
        getXY(panelView);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setUpperBound(upperX + upperX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setUpperBound(upperY + upperY * 0.2);
        panelView.getDrawingPanel().getXYPlot().getDomainAxis().setLowerBound(lowerX + lowerX * 0.2);
        panelView.getDrawingPanel().getXYPlot().getRangeAxis().setLowerBound(lowerY + lowerY * 0.2);
    }

    private void getXY(MainPanel panelView) {
        upperY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getUpperBound();
        upperX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getUpperBound();
        lowerY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getLowerBound();
        lowerX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getLowerBound();
    }
}
