package com.oliverbos1.minesweeper;

import com.almasb.fxgl.app.CursorInfo;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import java.util.Random;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getEventBus;

public class MineSweeperApp extends GameApplication {

    MineSweeperSettings mineSweeperSettings = new MineSweeperSettings(16, Difficulty.EASY);

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setFileSystemWriteAllowed(false);
        gameSettings.setDefaultCursor(new CursorInfo("aero_arrow.png", 7.0, 6.0));
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
        gameLogic.initialize(mineSweeperSettings);
    }

    @Override
    protected void initUI() {
        GameDisplay gameDisplay = new GameDisplay(mineSweeperSettings);
        gameDisplay.initialize();
    }

    public static void main(String[] args) {
        launch(args);
    }
}