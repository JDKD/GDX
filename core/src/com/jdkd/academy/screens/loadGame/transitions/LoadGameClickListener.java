package com.jdkd.academy.screens.loadGame.transitions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.gameplay.OverWorldScreen;
import com.jdkd.academy.world.Academy;

public class LoadGameClickListener extends ClickListener {

    private AcademyGame game;
    private Academy academy;

    public LoadGameClickListener(AcademyGame game, Academy academy) {
        this.game = game;
        this.academy = academy;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        game.setScreen(new OverWorldScreen(game, academy));
    }
}
