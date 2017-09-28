package com.jdkd.academy.screens.components.popups.exposition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicDialog implements Dialog {

    @JsonProperty
    private String speaker;
    @JsonProperty
    private String[] conversation;

    @JsonIgnore
    private int currentPage;

    public BasicDialog(String speaker, String[] conversation) {
        this.speaker = speaker;
        this.conversation = conversation;
        this.currentPage = -1;
    }

    public BasicDialog() {
        this.currentPage = -1;
    }

    @Override
    public String getSpeaker() {
        return speaker;
    }

    @Override
    public boolean hasMoreText() {
        return this.currentPage < conversation.length;
    }

    @Override
    public String getNextText() {
        currentPage++;

        if(this.currentPage < this.conversation.length){
            return this.conversation[currentPage];
        }

        return null;
    }
}
