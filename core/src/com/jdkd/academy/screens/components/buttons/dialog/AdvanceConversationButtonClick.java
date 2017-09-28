package com.jdkd.academy.screens.components.buttons.dialog;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.jdkd.academy.screens.components.popups.exposition.CloseableConversation;

public class AdvanceConversationButtonClick extends ClickListener {

    private CloseableConversation conversation;

    public AdvanceConversationButtonClick(CloseableConversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        this.conversation.advanceDialog();
    }
}
