package com.jdkd.academy.screens.loadGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.screens.createGame.components.transitions.CreateGameClickListener;
import com.jdkd.academy.screens.loadGame.transitions.LoadGameClickListener;
import com.jdkd.academy.world.Academy;
import com.jdkd.academy.world.AcademyFactory;

import java.io.File;
import java.util.List;

public class LoadGameScreen extends StageBasedScreen {

    public LoadGameScreen(AcademyGame game) {
        super(game);
    }

    @Override
    protected void setupStage() {
        List<Academy> saves = AcademyFactory.getInstance().loadAllAcademies();

        Table rootTable = new Table();
        rootTable.defaults().pad(10f);

        for(Academy academy : saves){
            rootTable.add(new Label(academy.getName(), getSkin()));
            TextButton loadAcademy = new TextButton("Load", getSkin());
            loadAcademy.addListener(new LoadGameClickListener(getGame(), academy));
            rootTable.add(loadAcademy).row();
        }

        rootTable.setFillParent(true);
        rootTable.center();
        rootTable.pad(10f);
        getStage().addActor(rootTable);
    }
}
