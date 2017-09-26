package com.jdkd.academy.screens.gameplay;

import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.world.Academy;
import com.jdkd.academy.world.entities.Player;

public class OverWorldScreen extends StageBasedScreen {

    private Academy academy;
    private Player player;

    public OverWorldScreen(AcademyGame game, Academy academy) {
        super(game);
        this.academy = academy;
        this.player = new Player();
        this.player.setPosition(300, 300);
    }

    @Override
    protected void setupStage() {
        System.out.println(academy.getName());
        getStage().addActor(player);
    }
}
