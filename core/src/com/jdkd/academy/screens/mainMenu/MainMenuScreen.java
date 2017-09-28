package com.jdkd.academy.screens.mainMenu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.screens.components.buttons.ExitGameButton;
import com.jdkd.academy.screens.components.buttons.screenTransition.ScreenTransitionButton;
import com.jdkd.academy.screens.createGame.CreateGameScreen;

public class MainMenuScreen extends StageBasedScreen {

    public MainMenuScreen(AcademyGame game) {
        super(game);
    }

    @Override
    protected void setupStage() {
        Table rootTable = new Table();

        Value topHeight = Value.percentHeight(0.7f, rootTable);
        Value buttonHeight = Value.percentHeight(0.3f, rootTable);
        Value buttonWidth = Value.percentWidth(0.3f, rootTable);
        Value buttonGap = Value.percentWidth(0.025f, rootTable);

        TextButton closeButton = new ExitGameButton();
        TextButton startButton = new ScreenTransitionButton("Start", getGame(), new CreateGameScreen(getGame()));
        TextButton optionsButton = new TextButton("Options", getSkin());
        TextButton loadButton = new TextButton("Load", getSkin());

        rootTable.add().height(topHeight);
        rootTable.add();
        rootTable.add(closeButton).right().top().width(buttonGap).height(buttonGap).row();

        rootTable.add(startButton).center().padRight(buttonGap).padLeft(buttonGap).width(buttonWidth).height(buttonHeight);
        rootTable.add(loadButton).center().width(buttonWidth).height(buttonHeight);
        rootTable.add(optionsButton).center().padLeft(buttonGap).padRight(buttonGap).width(buttonWidth).height(buttonHeight);

        rootTable.pack();
        rootTable.bottom();
        rootTable.setFillParent(true);
        getStage().addActor(rootTable);
    }
}
