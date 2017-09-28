package com.jdkd.academy.screens.components.popups.exposition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DialogFactory {

    public static Dialog loadDialog(String dialogName) {
        FileHandle dialogSaveFile = Gdx.files.local("dialog/" + dialogName + "_dialog.json");

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(dialogSaveFile.file(), BasicDialog.class);
        } catch (IOException e) {
            Gdx.app.exit();
        }

        return null;
    }

}
