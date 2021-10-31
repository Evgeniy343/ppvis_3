package controller;

import function_interface.FunctionA;
import function_interface.FunctionB;
import model.FunctionAModel;
import model.FunctionBModel;
import panel_interface.MainPanel;

import javax.swing.table.DefaultTableModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CalculateAndDrawController {
    private static MainPanel mainPanel;
    private static ScheduledExecutorService executor;
    private static FunctionA functionA;
    private static FunctionB functionB;

    public CalculateAndDrawController(MainPanel panelView) {
        mainPanel = panelView;
        if (mainPanel.getChooseWorkModePanel().getCheckBox("Parallel drawing").isSelected()) {
            executor = Executors.newScheduledThreadPool(4);
        }
    }

    public static synchronized void drawGraphicB() {
        mainPanel.getDrawingPanel().getDataset().getSeries(1).addOrUpdate(functionB.getX(), functionB.getY());
        mainPanel.getDrawingPanel().getXYPlot().setDataset(mainPanel.getDrawingPanel().getIndexPoint(), mainPanel.getDrawingPanel().getDataset());
        mainPanel.getDrawingPanel().setIndexPoint(mainPanel.getDrawingPanel().getIndexPoint() + 1);
    }

    public static synchronized void drawGraphicA() {
        mainPanel.getDrawingPanel().getDataset().getSeries(0).addOrUpdate(functionA.getX(), functionA.getY());
        mainPanel.getDrawingPanel().getXYPlot().setDataset(mainPanel.getDrawingPanel().getIndexPoint(), mainPanel.getDrawingPanel().getDataset());
        mainPanel.getDrawingPanel().setIndexPoint(mainPanel.getDrawingPanel().getIndexPoint() + 1);
    }

    public static synchronized void calculateGraphicA() {
        double x;
        if (mainPanel.getChooseWorkModePanel().getCheckBox("Parallel drawing").isSelected()) {
            x = Math.random() + 2;
            functionA = new FunctionAModel(x);
        }
        if (mainPanel.getChooseWorkModePanel().getCheckBox("Selective drawing").isSelected()) {
            x = Double.parseDouble(mainPanel.getFunctionAPanel().getTextFieldX().getText());
            functionA = new FunctionAModel(x);
        }
    }

    public static synchronized void calculateGraphicB() {
        double n = 0;
        double[] a = new double[2];
        if (mainPanel.getChooseWorkModePanel().getCheckBox("Parallel drawing").isSelected()) {
            n = 1 + Math.random() * 6;
            a = new double[]{Math.random(), Math.random() * 3};
            functionB = new FunctionBModel(n, a);
        }
        if (mainPanel.getChooseWorkModePanel().getCheckBox("Selective drawing").isSelected()) {
            n = Double.parseDouble(mainPanel.getFunctionBPanel().getTextFieldParams()[2].getText());
            a = new double[]{Double.parseDouble(mainPanel.getFunctionBPanel().getTextFieldParams()[0].getText()),
                    Double.parseDouble(mainPanel.getFunctionBPanel().getTextFieldParams()[1].getText())};
            functionB = new FunctionBModel(n, a);
        }
        setTable(Double.toString(functionB.getY()), Double.toString(functionB.getX())
                , Double.toString(a[0]), Double.toString(a[1]), Double.toString(n));
    }

    public static class FunctionADrawThread implements Runnable {
        @Override
        public void run() {
            try {
                while (!executor.isShutdown()) {
                    drawGraphicA();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class FunctionBDrawThread implements Runnable {
        @Override
        public void run() {
            try {
                while (!executor.isShutdown()) {
                    drawGraphicB();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class FunctionACalculateThread implements Runnable {
        @Override
        public void run() {
            try {
                while (!executor.isShutdown()) {
                    calculateGraphicA();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public static class FunctionBCalculateThread implements Runnable {
        @Override
        public void run() {
            try {
                while (!executor.isShutdown()) {
                    calculateGraphicB();
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    public static ExecutorService getExecutor() {
        return executor;
    }

    public static void setTable(String y, String x, String a, String b, String n) {
        DefaultTableModel model = (DefaultTableModel) mainPanel.getFunctionBPanel().getTableB().getModel();
        Object[] data = new Object[]{y, x, a, b, n};
        model.addRow(data);
    }
}
