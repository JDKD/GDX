package com.jdkd.academy.screens.createGame;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.screens.createGame.components.transitions.CreateGameClickListener;

public class CreateGameScreen extends StageBasedScreen {

    public CreateGameScreen(AcademyGame game) {
        super(game);
    }

    @Override
    protected void setupStage() {
        Table rootTable = new Table();
        rootTable.defaults().pad(10f);

        rootTable.add(new Label("Enter the name of your Academy : ", getSkin()));
        TextField textField = new TextField("", getSkin());
        rootTable.add(textField).row();
        TextButton createAcademyButton = new TextButton("Create Academy", getSkin());
        createAcademyButton.addListener(new CreateGameClickListener(textField, getGame(), getStage(), getSkin()));
        rootTable.add(createAcademyButton).colspan(2).center();

        rootTable.setFillParent(true);
        rootTable.center();
        rootTable.pad(10f);
        getStage().addActor(rootTable);
    }
}
