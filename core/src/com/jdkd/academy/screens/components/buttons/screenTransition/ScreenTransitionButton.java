package com.jdkd.academy.screens.components.buttons.screenTransition;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jdkd.academy.utils.graphics.Assets;

public class ScreenTransitionButton extends TextButton{

    private Game game;
    private Screen moveTo;

    public ScreenTransitionButton(String text, Game game, Screen moveTo) {
        super(text, Assets.getSkin());
        this.game = game;
        this.moveTo = moveTo;

        addListener(new ScreenTransitionClickListener(game, moveTo));
    }
}
