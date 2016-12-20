package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Graphics.SpriteCollection;
import com.mygdx.game.Levels.MainMenu;

import java.util.Random;


public class GalacticDash extends Game {

	//Preferences hold the users saved data. Look at libgdx Preferences for docs
	public Preferences prefs;
	//Spritebatch renders a list of sprites. Look at libgdx Spritebatch for docs
	public SpriteBatch batch;
	//Simple font. Look at libgdx BitmapFont for docs
	public BitmapFont font;
	//Class to hold one instance of each sprite, prevents holding the same sprite twice in RAM
	public SpriteCollection sprites;

	public Random rand;

	@Override
	public void create () {
		prefs = Gdx.app.getPreferences("my-prefs");
		if(!prefs.getString("isInit").equals("true")) initPreferences();
		sprites = new SpriteCollection();
		batch = new SpriteBatch();
		font = new BitmapFont();
		rand = new Random();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		sprites.dispose();
		batch.dispose();
		font.dispose();
	}

	private void initPreferences() {
		prefs.putString("isInit", "true");
		prefs.putString("shots", "0");
		prefs.putString("levelsCleared", "0");
		prefs.flush();
	}
}
