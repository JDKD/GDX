package com.jdkd.academy.screens.createGame;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.screens.components.popups.exposition.BasicDialog;
import com.jdkd.academy.screens.components.popups.exposition.CloseableConversation;
import com.jdkd.academy.screens.components.popups.exposition.Dialog;
import com.jdkd.academy.screens.components.popups.exposition.DialogFactory;

public class CreateGameScreen extends StageBasedScreen {

    public CreateGameScreen(AcademyGame game) {
        super(game);
    }

    @Override
    protected void setupStage() {
        Table rootTable = new Table();

        rootTable.add(new Label("Hello World!", getSkin())).center();

        Dialog openingDialog = DialogFactory.loadDialog("welcome");
        CloseableConversation conversation = new CloseableConversation(openingDialog);
        conversation.setWidth(getStage().getWidth() * 0.8f);
        conversation.setHeight(getStage().getHeight() * 0.2f);
        conversation.setPosition(getStage().getWidth() / 2 - conversation.getWidth() / 2, getStage().getHeight() * 0.01f);
        getStage().addActor(conversation);

        rootTable.setFillParent(true);
        getStage().addActor(rootTable);
    }
}
