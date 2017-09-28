package com.jdkd.academy.screens.components.popups.exposition;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.jdkd.academy.screens.components.buttons.dialog.AdvanceConversationButtonClick;
import com.jdkd.academy.utils.graphics.Assets;


public class CloseableConversation extends Window {

    private Dialog dialog;
    private Label conversationLabel;

    public CloseableConversation(Dialog dialog) {
        super(dialog.getSpeaker(), Assets.getSkin());
        this.dialog = dialog;
        this.conversationLabel = new Label(this.dialog.getNextText(), Assets.getSkin());
        this.conversationLabel.setWrap(true);
        this.conversationLabel.setAlignment(Align.center);

        add(conversationLabel).center().growX().height(Value.percentHeight(0.6f, this)).row();
        TextButton advanceButton = new TextButton("Ok", Assets.getSkin());
        advanceButton.addListener(new AdvanceConversationButtonClick(this));

        add(advanceButton).height(Value.percentHeight(0.2f, this)).right();

        setDebug(true);
        setModal(true);
    }

    public void advanceDialog(){
        if(this.dialog.hasMoreText()){
            conversationLabel.setText(this.dialog.getNextText());
        }

        if(!this.dialog.hasMoreText()){
            this.addAction(Actions.sequence(Actions.fadeOut(0.2F, Interpolation.fade), Actions.removeActor()));
        }
    }
}
