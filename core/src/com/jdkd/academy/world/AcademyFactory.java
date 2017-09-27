package com.jdkd.academy.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdkd.academy.world.entities.Player;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        Player player = new Player();
        player.setX(300);
        player.setY(300);
        academy.setPlayer(player);

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

    public void saveAcademy(Academy academy){
        FileHandle saveDir = Gdx.files.local(SAVE_LOC + academy.getName());

        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        FileHandle saveFile = Gdx.files.local(getSaveFileName(academy.getName()));
        try {
            new ObjectMapper().writeValue(saveFile.file(), academy);
        } catch (IOException e) {
            Gdx.app.exit();
        }
    }

    public String getSaveFileName(String name){
        return SAVE_LOC + name + "/" + name + ".json";
    }

    public List<Academy> loadAllAcademies(){
        FileHandle saveDir = Gdx.files.local(SAVE_LOC);
        String[] fileExtensions = new String[] {"json"};
        Collection<File> saves = FileUtils.listFiles(saveDir.file(), fileExtensions, true);

        List<Academy> academies = new ArrayList<>();

        for(File file : saves){
            academies.add(loadAcademyFromSave(file.getName().split("\\.")[0]));
        }

        return academies;
    }
}
