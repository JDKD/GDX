package com.jdkd.academy.world;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdkd.academy.world.entities.Player;

public class Academy {

    @JsonProperty
    private String name;

    @JsonProperty
    private Player player;

    public Academy(String name) {
        this.name = name;
        this.player = new Player();
    }

    public Academy() {
    }

    public void update(float delta){
        player.update(delta);
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
