package view;

import panel_interface.*;

import javax.swing.*;
import java.awt.*;

public class MainPanelView extends JFrame implements MainPanel {
    private JPanel contentPanel;
    private ChoosePanel choosePanel;
    private FunctionAPanel functionAPanel;
    private FunctionBPanel functionBPanel;
    private ProcessPanel ProcessPanel;
    private DrawingPanel drawingPanel;
    private ChoosePanel chooseWorkModePanel;

    public MainPanelView() {
        initPanelComponents();
        setPanel();
        showWindow();
    }

    @Override
    public void initPanelComponents() {
        contentPanel = new JPanel();
        chooseWorkModePanel = new ChooseWorkModePanelView();
        choosePanel = new ChooseFunctionPanelView();
        functionAPanel = new FunctionAPanelView();
        functionBPanel = new FunctionBPanelView();
        ProcessPanel = new ProcessPanelView();
        drawingPanel = new DrawingPanelView("");
    }

    @Override
    public void setPanel() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(chooseWorkModePanel.getPanel(), BorderLayout.LINE_END);
        this.add(contentPanel);
    }

    private void showWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - 1200) / 2;
        int locationY = (screenSize.height - 700) / 2;
        this.setBounds(locationX, locationY, 1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public JPanel getPanel() {
        return contentPanel;
    }

    @Override
    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }

    @Override
    public FunctionAPanel getFunctionAPanel() {
        return functionAPanel;
    }

    @Override
    public FunctionBPanel getFunctionBPanel() {
        return functionBPanel;
    }

    @Override
    public ProcessPanel getProcessPanel() {
        return ProcessPanel;
    }

    @Override
    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    @Override
    public ChoosePanel getChooseWorkModePanel() {
        return chooseWorkModePanel;
    }

    @Override
    public void addPanelA() {
        contentPanel.remove(functionBPanel.getPanel());
        contentPanel.add(functionAPanel.getPanel(), BorderLayout.WEST);
        updatePanel();
    }

    @Override
    public void addPanelB() {
        contentPanel.remove(functionAPanel.getPanel());
        contentPanel.add(functionBPanel.getPanel(), BorderLayout.WEST);
        updatePanel();
    }

    @Override
    public void updatePanel() {
        this.repaint();
        this.revalidate();
    }


}
