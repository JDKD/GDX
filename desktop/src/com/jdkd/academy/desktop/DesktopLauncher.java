package com.jdkd.academy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jdkd.academy.AcademyGame;
import com.jdkd.academy.utils.graphics.GFXConstants;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GFXConstants.SCREEN_WIDTH;
        config.height = GFXConstants.SCREEN_HEIGHT;
        new LwjglApplication(new AcademyGame(), config);
    }
}
