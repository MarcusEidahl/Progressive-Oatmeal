package com.mygdx.game.Entities.Players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Projectiles.PlayerProjectile;
import com.mygdx.game.Levels.Level;

public class Player extends Entity {

    private static final float BASE_TIME_BETWEEN_SHOTS = .5f;
    private static final float BASE_SPEED = 100;
    private static final float BASE_HEALTH = 100;
    private static final float ACCLEROMETER_DEAD_ZONE = .5f;

    private float timeBetweenShots;
    private float fireTimer;

    public int shotsFired;

    public Player(float x, float y, Level level) {
        super(x, y, level);
    }

    protected void init() {
        sprite = level.game.sprites.player_upgrade_2;
        radius = 13;
        isEnemy = false;
        health = BASE_HEALTH;
        timeBetweenShots = BASE_TIME_BETWEEN_SHOTS;
        fireTimer = timeBetweenShots / 2;
        shotsFired = 0;
    }

    public void update(float delta) {

        if(health <= 0) remove();
        else {

            //Get accelerometer data and move the player
            float accelX = Gdx.input.getAccelerometerX();
            float accelY = Gdx.input.getAccelerometerY();
            int orientation = 1;
            if(Gdx.input.getAccelerometerZ() < 0) orientation = -1;

            if (Math.abs(accelX) > ACCLEROMETER_DEAD_ZONE) {
                x += BASE_SPEED * -accelX * delta * orientation;
            }

            if (Math.abs(accelY) > ACCLEROMETER_DEAD_ZONE) {
                y += BASE_SPEED * -accelY * delta;
            }

            //---------------------------------------------------
            //Bound the player movement to the screen
            if (x < sprite.getWidth() / 2) x = sprite.getWidth() / 2;
            if (x > Level.WIDTH - sprite.getWidth() / 2) x = Level.WIDTH - sprite.getWidth() / 2;
            if (y < sprite.getHeight() / 2) y = sprite.getHeight() / 2;
            if (y > Level.HEIGHT - sprite.getWidth() / 2) y = Level.HEIGHT - sprite.getHeight() / 2;

            //---------------------------------------------------
            // get touch input and shoot
            if (Gdx.input.isTouched()) {
                shoot();
            }
            fireTimer += delta;
            if(fireTimer > timeBetweenShots) fireTimer = timeBetweenShots;
        }
    }

    private void shoot() {

        if(fireTimer >= timeBetweenShots) {
            level.addEntity(new PlayerProjectile(x, y + radius, level, new Vector2(0, -1), this));
            shotsFired++;
            fireTimer -= timeBetweenShots;
        }
    }
}
