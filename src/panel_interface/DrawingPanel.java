package panel_interface;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;

public interface DrawingPanel extends Panel {
    ChartPanel getChartPanel();
    XYPlot getXYPlot();
    int getIndexPoint();
    void setIndexPoint(int indexPoint);
    XYSeriesCollection getDataset();
    ModePanel getModePanel();
    ScalePanel getScalePanel();
    XYLineAndShapeRenderer getRenderer();
    double getRightPartScale();
    double getLeftPartScale();
    void setRightPartScale(double scale);
    void setLeftPartScale(double scale);
}
