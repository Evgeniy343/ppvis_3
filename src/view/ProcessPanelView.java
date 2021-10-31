package view;

import panel_interface.ProcessPanel;

import javax.swing.*;

public class ProcessPanelView extends JFrame implements ProcessPanel {
    private JButton start;
    private JButton stop;
    private JPanel ProcessPanel;

    public ProcessPanelView() {
        initPanelComponents();
        setPanel();
    }

    @Override
    public void initPanelComponents() {
        start = new JButton("start");
        stop = new JButton("stop");
        ProcessPanel = new JPanel();
    }

    @Override
    public void setPanel() {
        ProcessPanel.setLayout(new BoxLayout(ProcessPanel, BoxLayout.Y_AXIS));
        ProcessPanel.add(start);
        ProcessPanel.add(stop);
    }

    @Override
    public JPanel getPanel() {
        return ProcessPanel;
    }

    @Override
    public JButton getStartButton() {
        return start;
    }

    @Override
    public JButton getStopButton() {
        return stop;
    }
}
