package com.jdkd.academy.utils.graphics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {

    private static AssetManager manager;

    public static void initialise(){
        manager = new AssetManager();

        SkinLoader.SkinParameter parameters = new SkinLoader.SkinParameter("skins/flat_earth/flat-earth-ui.atlas");
        manager.load("skins/flat_earth/flat-earth-ui.json", Skin.class, parameters);

        manager.finishLoading();
    }

    public static Skin getSkin(){
        manager.finishLoading();
        return manager.get("skins/flat_earth/flat-earth-ui.json");
    }

}
