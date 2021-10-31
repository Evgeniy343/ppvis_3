package controller;

import controller_interface.MainProcess;
import panel_interface.MainPanel;
import view.MainPanelView;

public class MainController implements MainProcess {
    private ChooseWorkModeController chooseWorkModeController;
    private ChooseFunctionController chooseFunctionController;
    private StartFunctionController startFunctionController;
    private StopFunctionController stopFunctionController;
    private ScaleController scaleController;
    private ModeController modeController;
    private MovingController movingController;
    private ZoomController zoomController;

    public MainController() {
        MainPanel panelView = new MainPanelView();
        initControllers(panelView);
    }

    @Override
    public void initControllers(MainPanel panelView) {
        zoomController = new ZoomController(panelView);
        movingController = new MovingController(panelView);
        modeController = new ModeController(panelView);
        scaleController = new ScaleController(panelView);
        chooseFunctionController = new ChooseFunctionController(panelView);
        chooseWorkModeController = new ChooseWorkModeController(panelView);
        startFunctionController = new StartFunctionController(panelView);
        stopFunctionController = new StopFunctionController(panelView);
    }

    public ChooseFunctionController getChooseFunctionController() {
        return chooseFunctionController;
    }

    public StartFunctionController getStartFunctionController() {
        return startFunctionController;
    }

    public StopFunctionController getStopFunctionController() {
        return stopFunctionController;
    }

    public ScaleController getScaleController() {
        return scaleController;
    }

    public ModeController getModeController() {
        return modeController;
    }

    public MovingController getMovingController() {
        return movingController;
    }

    public ZoomController getZoomController() {
        return zoomController;
    }

    public ChooseWorkModeController getChooseWorkModeController() {
        return chooseWorkModeController;
    }
}
