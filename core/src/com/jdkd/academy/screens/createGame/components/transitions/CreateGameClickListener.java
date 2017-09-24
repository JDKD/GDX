package com.jdkd.academy.screens.createGame.components.transitions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.utils.validators.FileValidator;
import com.jdkd.academy.utils.validators.StringValidator;
import com.jdkd.academy.screens.gameplay.OverWorldScreen;
import com.jdkd.academy.world.Academy;
import com.jdkd.academy.world.AcademyFactory;

public class CreateGameClickListener extends ClickListener {

    private TextField nameField;
    private AcademyGame game;
    private Stage stage;
    private Skin skin;

    public CreateGameClickListener(TextField nameField, AcademyGame game, Stage stage, Skin skin) {
        this.nameField = nameField;
        this.game = game;
        this.stage = stage;
        this.skin = skin;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        String academyName = nameField.getText().toLowerCase();
        boolean validName = StringValidator.validateStringContainsOnlyText(academyName);
        boolean saveAlreadyExits = FileValidator.doesFileExist(academyName);

        if (validName && !saveAlreadyExits) {
            Academy academy = AcademyFactory.getInstance().loadAcademy(academyName);
            game.setScreen(new OverWorldScreen(game, academy));
        } else {
            Dialog warning = new Dialog("Warning", skin);
            String text = "";
            if(!validName){
                text += "That academy name is not valid! ";
            }
            if(saveAlreadyExits){
                text += "That academy already exists! ";
            }
            warning.text(text);
            warning.button("OK", true);
            warning.pack();
            warning.setPosition(stage.getWidth() / 2 - warning.getWidth() / 2, stage.getHeight() / 2 - warning.getHeight() / 2);
            stage.addActor(warning);
        }



    }
}
