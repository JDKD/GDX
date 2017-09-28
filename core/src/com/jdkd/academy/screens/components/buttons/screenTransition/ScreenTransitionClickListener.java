package com.jdkd.academy.screens.components.buttons.screenTransition;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScreenTransitionClickListener extends ClickListener {

    private Game game;
    private Screen moveTo;

    public ScreenTransitionClickListener(Game game, Screen moveTo) {
        this.game = game;
        this.moveTo = moveTo;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        game.setScreen(moveTo);
    }
}
