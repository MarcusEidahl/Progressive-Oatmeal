package com.mygdx.game.Levels;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Entities.NPCs.HomingEnemy;
import com.mygdx.game.Entities.NPCs.SliderEnemy;
import com.mygdx.game.Entities.NPCs.SniperEnemy;
import com.mygdx.game.Entities.Players.Player;
import com.mygdx.game.GalacticDash;

public class Level_3 extends Level {

    private Music rainMusic;


    public Level_3(final GalacticDash game) {
        super(game);
        fontScale = 1;
        game.font.getData().setScale(fontScale, fontScale);
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);
        rainMusic.play();
        addMobs();
    }

    private void addMobs() {

        //Add player controlled units
        player = new Player(240, 100, this);
        entities.add(player);

        //Add NPCs
        addEntity(new SliderEnemy(200, 400, this, -1));
        addEntity(new SliderEnemy(300, 400, this, 1));
        addEntity(new SliderEnemy(100, 500, this, -1));
        addEntity(new SliderEnemy(400, 500, this, 1));

        addEntity(new SniperEnemy(100, 600, this, player));
        addEntity(new SniperEnemy(400, 600, this, player));

        addEntity(new HomingEnemy(240, 700, this, player));

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
            game.setScreen(new TransitionScreen(game, new Level_4(game), "GG", "You made to the final level", 5));
        }
        else if(player.isRemoved) {
            int shots = Integer.parseInt(game.prefs.getString("shots"));
            shots += player.shotsFired;
            game.prefs.putString("shots", shots + "");
            game.prefs.flush();
            dispose();
            game.setScreen(new TransitionScreen(game, new Level_3(game), "YOU DIED", "LOL", 5));
        }
    }

    @Override
    protected void drawText() {
        game.font.draw(game.batch, "LEVEL 3", 10, Level.HEIGHT - 10);
    }

    public void dispose() {
        rainMusic.dispose();
    }
}
