package com.babymakingjuice.minesweeper;

import com.almasb.fxgl.app.CursorInfo;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import java.util.Random;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getEventBus;

public class MineSweeperApp extends GameApplication {

    private final GameDisplay gameDisplay = new GameDisplay();

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setFileSystemWriteAllowed(false);
        CursorInfo CursorInfo = new CursorInfo("aero_arrow.png", 7.0, 6.0);
        gameSettings.setDefaultCursor(CursorInfo);
        gameSettings.setWidth(1000);
        gameSettings.setHeight(1100);
        gameSettings.setTitle("Mine Sweeper");
        gameSettings.setVersion("v1.0");
        gameSettings.setGameMenuEnabled(false);
        gameSettings.setManualResizeEnabled(false);
        gameSettings.setPreserveResizeRatio(true);
        gameSettings.setAppIcon("tileMine.png");
    }

    @Override
    protected void initGame() {
        GameLogic gameLogic = new GameLogic(new Random(), getEventBus());
        gameLogic.initialize(10, 10, 20);
    }

    @Override
    protected void initUI() {
        gameDisplay.initialize();
    }

    public static void main(String[] args) {
        launch(args);
    }
}