package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Entities.NPCs.SliderEnemy;
import com.mygdx.game.Entities.Players.Player;
import com.mygdx.game.GalacticDash;


public class Level_1 extends Level {

    private Music rainMusic;

    public Level_1(final GalacticDash game) {
        super(game);
        fontScale = 1;
        game.font.getData().setScale(fontScale, fontScale);
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);
        rainMusic.play();
        addMobs();
    }

    protected void drawText() {
        game.font.draw(game.batch, "LEVEL 1", 10, Level.HEIGHT - 10);
    }

    private void addMobs() {

        //Add player controlled units
        player = new Player(240, 100, this);
        addEntity(player);

        //Add NPCs
        addEntity(new SliderEnemy(180, 500, this, 0));
        addEntity(new SliderEnemy(240, 600, this, -1));
        addEntity(new SliderEnemy(300, 700, this, 1));

    }

    public void update(float delta) {
        super.update(delta);
        if(npcs.size() <= 0) {
            int shots = Integer.parseInt(game.prefs.getString("shots")) + player.shotsFired;
            int levelsCleared = Integer.parseInt(game.prefs.getString("levelsCleared")) + 1;
            game.prefs.putString("shots", shots + "");
            game.prefs.putString("levelsCleared", levelsCleared + "");
            game.prefs.flush();
            dispose();
            game.setScreen(new TransitionScreen(game, new Level_2(game), "Congratz", "Good luck on level 2", 5));
        }

        else if(player.isRemoved) {
            int shots = Integer.parseInt(game.prefs.getString("shots"));
            shots += player.shotsFired;
            game.prefs.putString("shots", shots + "");
            game.prefs.flush();
            dispose();
            game.setScreen(new TransitionScreen(game, new Level_1(game), "YOU DIED", "LOL", 5));
        }
    }

    public void dispose() {
        rainMusic.dispose();
    }

}
