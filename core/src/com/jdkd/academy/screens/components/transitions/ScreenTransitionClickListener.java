package com.jdkd.academy.screens.components.transitions;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdkd.academy.AcademyGame;

public class ScreenTransitionClickListener extends ClickListener {

    private AcademyGame game;
    private Screen moveTo;

    public ScreenTransitionClickListener(AcademyGame game, Screen moveTo) {
        this.game = game;
        this.moveTo = moveTo;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        game.setScreen(moveTo);
    }
}
