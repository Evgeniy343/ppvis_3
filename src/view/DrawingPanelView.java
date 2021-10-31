package view;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import panel_interface.DrawingPanel;
import panel_interface.ModePanel;
import panel_interface.ScalePanel;

import javax.swing.*;
import java.awt.*;

public class DrawingPanelView extends ApplicationFrame implements DrawingPanel {
    private JPanel drawingPanel;
    private ChartPanel chartPanel;
    private XYPlot plot;
    private JScrollPane jScrollPane;
    private int indexPoint;
    private XYSeries XYdDataA;
    private XYSeries XYdDataB;
    private XYSeriesCollection dataset;
    private ModePanel modePanel;
    private ScalePanel scalePanel;
    private XYLineAndShapeRenderer renderer;
    private double rightPartScale;
    private double leftPartScale;

    public DrawingPanelView(String applicationTitle) {
        super(applicationTitle);
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        rightPartScale = 1;
        leftPartScale = 1;
        scalePanel = new ScalePanelView();
        modePanel = new ModePanelView();
        drawingPanel = new JPanel();
        XYdDataA = new XYSeries("f(x) = 4x - 3");
        XYdDataB = new XYSeries("((2k)! + |x|) / (k^2)!");
        dataset = new XYSeriesCollection();
        indexPoint = 0;
        setDataset();
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Functions",
                "X",
                "Y",
                new XYSeriesCollection(),
                PlotOrientation.VERTICAL,
                true, true, false);
        chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new Dimension(900, 500));
        jScrollPane = new JScrollPane(chartPanel);
        plot = xylineChart.getXYPlot();
    }

    public void setDataset() {
        dataset.addSeries(XYdDataA);
        dataset.addSeries(XYdDataB);
    }

    @Override
    public void setPanel() {
        chartPanel.setZoomTriggerDistance(Integer.MAX_VALUE);
        chartPanel.setFillZoomRectangle(false);
        chartPanel.setZoomAroundAnchor(true);
        plot.getDomainAxis().setPositiveArrowVisible(true);
        plot.getRangeAxis().setPositiveArrowVisible(true);
        renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesPaint(1, Color.YELLOW);
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesLinesVisible(1, false);
        plot.setRenderer(renderer);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        LegendItemCollection legend = new LegendItemCollection();
        Shape shape = new Rectangle(10, 10);
        legend.add(new LegendItem("f(x) = 4x - 3", null, null, null, shape, Color.GREEN));
        legend.add(new LegendItem("((2k)! + |x|) / (k^2)!", null, null, null, shape, Color.YELLOW));
        plot.setFixedLegendItems(legend);
        drawingPanel.setLayout(new BorderLayout());
        drawingPanel.add(jScrollPane, BorderLayout.CENTER);
        drawingPanel.add(modePanel.getPanel(), BorderLayout.SOUTH);
        drawingPanel.add(scalePanel.getPanel(), BorderLayout.NORTH);
    }

    @Override
    public JPanel getPanel() {
        return drawingPanel;
    }

    @Override
    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    @Override
    public XYPlot getXYPlot() {
        return plot;
    }

    @Override
    public int getIndexPoint() {
        return indexPoint;
    }

    @Override
    public void setIndexPoint(int indexPoint) {
        this.indexPoint = indexPoint;
    }

    @Override
    public XYSeriesCollection getDataset() {
        return dataset;
    }

    @Override
    public ModePanel getModePanel() {
        return modePanel;
    }

    @Override
    public ScalePanel getScalePanel() {
        return scalePanel;
    }

    @Override
    public XYLineAndShapeRenderer getRenderer() {
        return renderer;
    }

    @Override
    public double getRightPartScale() {
        return rightPartScale;
    }

    @Override
    public double getLeftPartScale() {
        return leftPartScale;
    }

    @Override
    public void setRightPartScale(double scale) {
        rightPartScale = scale;
    }

    @Override
    public void setLeftPartScale(double scale) {
        leftPartScale = scale;
    }
}
