package com.jdkd.academy.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.utils.graphics.Assets;
import com.jdkd.academy.utils.input.SingletonMultiplexer;

public abstract class StageBasedScreen extends ScreenAdapter {

    private AcademyGame game;
    private Stage stage;
    private Skin skin;

    public StageBasedScreen(AcademyGame game) {
        this.game = game;
        this.stage = new Stage();
        this.skin = Assets.getSkin();
    }

    @Override
    public void show() {
        super.show();
        setupStage();
        SingletonMultiplexer.getInstance().addProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void hide() {
        super.hide();
        SingletonMultiplexer.getInstance().removeProcessor(stage);
    }

    public AcademyGame getGame() {
        return game;
    }

    public Stage getStage() {
        return stage;
    }

    public Skin getSkin() {
        return skin;
    }

    protected abstract void setupStage();
}