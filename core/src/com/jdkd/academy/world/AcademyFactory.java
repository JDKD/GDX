package com.jdkd.academy.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AcademyFactory {

    private static final AcademyFactory instance = new AcademyFactory();
    private static final String SAVE_LOC = "saves/";

    private AcademyFactory() {
    }

    public static AcademyFactory getInstance() {
        return instance;
    }

    public Academy loadAcademy(String name) {

        Academy academy = loadAcademyFromSave(name);

        if (academy == null) {
            createAcademy(name);
        }

        return new Academy(name);
    }

    private Academy loadAcademyFromSave(String name) {
        FileHandle saveDir = Gdx.files.local(SAVE_LOC + name);
        Academy academy = null;

        if (saveDir.exists()) {
            FileHandle saveFile = Gdx.files.local(getSaveFileName(name));
            if (saveFile.exists()) {
                try {
                    academy = new ObjectMapper().readValue(saveFile.file(), Academy.class);
                    System.out.println("Found save file " + name);
                } catch (IOException e) {
                    System.out.println(e);
                    Gdx.app.exit();
                }
            }
        }

        return academy;
    }

    private Academy createAcademy(String name) {
        FileHandle saveDir = Gdx.files.local(SAVE_LOC + name);
        Academy academy = new Academy(name);

        if (!saveDir.exists()) {
            saveDir.mkdirs();
            FileHandle saveFile = Gdx.files.local(getSaveFileName(name));
            try {
                new ObjectMapper().writeValue(saveFile.file(), academy);
            } catch (IOException e) {
                Gdx.app.exit();
            }
        }

        return academy;
    }

    public String getSaveFileName(String name){
        return SAVE_LOC + name + "/" + name + ".json";
    }
}
