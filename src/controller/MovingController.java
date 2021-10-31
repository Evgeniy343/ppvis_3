package controller;


import panel_interface.MainPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

public class MovingController {
    private double mouseX;
    private double mouseY;
    double xMax;
    double xMin;
    double yMax;
    double yMin;
    double margin;
    Rectangle2D plotArea;

    MovingController(MainPanel panelView) {
        panelView.getDrawingPanel().getChartPanel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        panelView.getDrawingPanel().getChartPanel().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                margin = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getLowerMargin();
                plotArea = panelView.getDrawingPanel().getChartPanel().getChartRenderingInfo().getPlotInfo().getDataArea();
                xMax = plotArea.getMaxX();
                xMin = plotArea.getMinX();
                yMax = plotArea.getMaxY();
                yMin = plotArea.getMinY();
                final double mouseDeltaX = mouseX - e.getX();
                final double mouseDeltaY = mouseY - e.getY();


                double moveX = (panelView.getDrawingPanel().getXYPlot().getDomainAxis().getUpperBound() * Math.abs(mouseDeltaX)) / xMax;
                double moveY = (Math.abs(mouseDeltaY) * margin) /
                        ((yMax - yMin) / (panelView.getDrawingPanel().getXYPlot().getRangeAxis().getUpperBound() / margin));

                double newUpperX;
                double newLowerX;
                if (mouseDeltaX < 0) {
                    newUpperX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getUpperBound() - moveX;
                    newLowerX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getLowerBound() - moveX;
                } else {
                    newUpperX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getUpperBound() + moveX;
                    newLowerX = panelView.getDrawingPanel().getXYPlot().getDomainAxis().getLowerBound() + moveX;
                }
                double newUpperY;
                double newLowerY;
                if (mouseDeltaY < 0) {
                    newUpperY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getUpperBound() + moveY;
                    newLowerY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getLowerBound() + moveY;
                } else {
                    newUpperY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getUpperBound() - moveY;
                    newLowerY = panelView.getDrawingPanel().getXYPlot().getRangeAxis().getLowerBound() - moveY;
                }
                panelView.getDrawingPanel().getXYPlot().getDomainAxis().setUpperBound(newUpperX);
                panelView.getDrawingPanel().getXYPlot().getDomainAxis().setLowerBound(newLowerX);
                panelView.getDrawingPanel().getXYPlot().getRangeAxis().setUpperBound(newUpperY);
                panelView.getDrawingPanel().getXYPlot().getRangeAxis().setLowerBound(newLowerY);

            }
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
}
