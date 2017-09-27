package com.jdkd.academy.world.representations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jdkd.academy.world.entities.Player;

public class PlayerRepresentation extends Image {

    private Player player;

    public PlayerRepresentation(Player player) {
        super(new Texture("badlogic.jpg"));
        this.player = player;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(player.getX(), player.getY());
    }
}
