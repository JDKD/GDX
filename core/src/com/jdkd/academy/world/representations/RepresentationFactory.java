package com.jdkd.academy.world.representations;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jdkd.academy.world.Academy;
import com.jdkd.academy.world.entities.Player;

public class RepresentationFactory {

    public static AcademyRepresentation getRepresentation(Academy academy, Skin skin){
        return new AcademyRepresentation(academy, skin);
    }

    public static PlayerRepresentation getRepresentation(Player player){
        return new PlayerRepresentation(player);
    }

}
