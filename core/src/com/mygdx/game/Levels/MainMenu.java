package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.GalacticDash;


public class MainMenu extends Level implements Screen{

    private String totalShots;
    private String levelsCleared;

    public MainMenu(final GalacticDash game) {
        super(game);
        fontScale = 1.5f;
        game.font.getData().setScale(fontScale, fontScale);
        totalShots = game.prefs.getString("shots");
        levelsCleared = game.prefs.getString("levelsCleared");
    }

    protected void drawText() {
        game.font.draw(game.batch, "Welcome to Galactic Dash!", 100, 500);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 300);
        game.font.draw(game.batch, "Shots: " + totalShots, 100, 200);
        game.font.draw(game.batch, "Levels Cleared: " + levelsCleared, 100, 125);
    }

    public void update(float delta){
        super.update(delta);
        if(Gdx.input.isTouched()) {
            dispose();
            game.setScreen(new TransitionScreen(game, new Level_1(game), "Here we go!", "Level 1 ahead", 5));
        }
    }

    public void dispose() {
        game.font.getData().setScale(1, 1);
    }




}
