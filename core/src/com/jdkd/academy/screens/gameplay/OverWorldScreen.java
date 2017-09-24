package com.jdkd.academy.screens.gameplay;

import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.world.Academy;

public class OverWorldScreen extends StageBasedScreen {

    private Academy academy;

    public OverWorldScreen(AcademyGame game, Academy academy) {
        super(game);
        this.academy = academy;
    }

    @Override
    protected void setupStage() {
        System.out.println(academy.getName());
    }
}
