package panel_interface;

public interface MainPanel extends Panel {
    ChoosePanel getChoosePanel();
    FunctionAPanel getFunctionAPanel();
    FunctionBPanel getFunctionBPanel();
    ProcessPanel getProcessPanel();
    DrawingPanel getDrawingPanel();
    ChoosePanel getChooseWorkModePanel();
    void addPanelA();
    void addPanelB();
    void updatePanel();
}
