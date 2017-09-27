package com.jdkd.academy.screens.gameplay;

import com.badlogic.gdx.Input;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.screens.StageBasedScreen;
import com.jdkd.academy.screens.mainMenu.MainMenuScreen;
import com.jdkd.academy.utils.input.events.keyboard.KeyChangeListener;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEvent;
import com.jdkd.academy.utils.input.events.keyboard.KeyStateChangedEventHandler;
import com.jdkd.academy.world.Academy;
import com.jdkd.academy.world.AcademyFactory;
import com.jdkd.academy.world.entities.Player;
import com.jdkd.academy.world.representations.AcademyRepresentation;
import com.jdkd.academy.world.representations.PlayerRepresentation;

public class OverWorldScreen extends StageBasedScreen implements KeyChangeListener {

    private Academy academy;

    public OverWorldScreen(AcademyGame game, Academy academy) {
        super(game);
        this.academy = academy;
    }

    @Override
    protected void setupStage() {
        getStage().addActor(new AcademyRepresentation(academy, getSkin()));
        getStage().addActor(new PlayerRepresentation(academy.getPlayer()));
    }

    @Override
    public void show() {
        super.show();
        KeyStateChangedEventHandler.getInstance().addListener(this);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        academy.update(delta);
    }

    @Override
    public void hide() {
        super.hide();
        KeyStateChangedEventHandler.getInstance().removeListener(this);
    }

    @Override
    public void onKeyStateChanged(KeyStateChangedEvent event) {
        if(!event.wasPressed()){
            if(event.getKeycode() == Input.Keys.ESCAPE){
                AcademyFactory.getInstance().saveAcademy(academy);
                getGame().setScreen(new MainMenuScreen(getGame()));
            }
        }
    }
}
