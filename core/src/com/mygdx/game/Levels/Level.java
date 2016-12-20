package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.NPCs.NPC;
import com.mygdx.game.Entities.Players.Player;
import com.mygdx.game.GalacticDash;
import java.util.ArrayList;


public abstract class Level implements Screen{

    public static final float WIDTH = 480;
    public static final float HEIGHT = 800;

    public GalacticDash game;
    public Player player;
    public float fontScale;

    protected OrthographicCamera camera;
    protected ArrayList<Entity> entities;
    protected ArrayList<NPC> npcs;

    public ArrayList<Entity> getEntities() { return entities; }

    protected Level(final GalacticDash game) {
        this.game = game;
        entities = new ArrayList<Entity>();
        npcs = new ArrayList<NPC>();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        update(Gdx.graphics.getDeltaTime());

        game.batch.begin();
        drawText();
        for(Entity e : entities) {
            game.batch.draw(e.sprite, e.x - e.sprite.getWidth() / 2, e.y - e.sprite.getHeight() / 2);
        }
        game.batch.end();
    }

    protected abstract void drawText();

    public void update(float delta) {

        //Remove the dead things
        for(int i = 0; i < entities.size(); i++) {
            if(entities.get(i).isRemoved) entities.remove(i);
        }

        //Remove dead npcs
        for(int i = 0; i < npcs.size(); i++) {
            if(npcs.get(i).isRemoved) npcs.remove(i);
        }

        //Update the survivors
        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).update(delta);
        }

        //TAP TOP RIGHT TO SKIP THE LEVEL
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (touchPos.x > 440 && touchPos.y > 750) {
                for (int i = 0; i < npcs.size(); i++) {
                    npcs.remove(i);
                }
            }
        }
    }

    public void addEntity(Entity o) {
        entities.add(o);
        if(o instanceof NPC) {
            npcs.add((NPC) o);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public abstract void dispose();

}
