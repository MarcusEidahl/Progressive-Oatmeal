package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GalacticDash;


public class TransitionScreen extends Level {

    private static final float FONT_SCALE = 2f;
    private static final int TOUCHES_TO_SKIP = 2;

    private float duration;
    private float timeAlive;
    private Level nextLevel;
    private String from;
    private String to;
    private int touchCount;
    private boolean isTouched;


    public TransitionScreen(final GalacticDash game, Level nextLevel, String from, String to, float duration) {
        super(game);
        this.duration = duration;
        this.nextLevel = nextLevel;
        this.from = from;
        this.to = to;
        timeAlive = 0;
        touchCount = 0;
        isTouched = Gdx.input.isTouched();
        game.font.getData().setScale(FONT_SCALE, FONT_SCALE);
    }

    public void update(float delta) {
        super.update(delta);

        if(Gdx.input.isTouched() && !isTouched) {
            touchCount++;
            isTouched = true;
        }
        else if(!Gdx.input.isTouched()) {
            isTouched = false;
        }


        if(timeAlive >= duration || touchCount > TOUCHES_TO_SKIP) {
            dispose();
            game.setScreen(nextLevel);

        }
        timeAlive += delta;
    }

    protected void drawText() {
        game.font.draw(game.batch, from, 20, 700);
        game.font.draw(game.batch, "Time until next level", 20, 500);
        game.font.draw(game.batch, String.format(java.util.Locale.US, "%.1f", duration - timeAlive) + " Seconds", 20, 400);
        game.font.draw(game.batch, to, 20, 200);
    }

    public void dispose() {
        game.font.getData().setScale(nextLevel.fontScale, nextLevel.fontScale);
    }
}
