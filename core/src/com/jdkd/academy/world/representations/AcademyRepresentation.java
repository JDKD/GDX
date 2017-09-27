package com.jdkd.academy.world.representations;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdkd.academy.world.Academy;

public class AcademyRepresentation extends Label {

    private Academy academy;

    public AcademyRepresentation(Academy academy, Skin skin) {
        super(academy.getName(), skin);
        this.academy = academy;
    }
}
