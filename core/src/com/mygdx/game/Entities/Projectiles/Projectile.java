package com.mygdx.game.Entities.Projectiles;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Levels.Level;


public abstract class Projectile extends Entity {

    public Entity shooter;
    protected float damage;
    protected float speed;
    protected float distanceTraveled;
    protected float range;
    protected Vector2 direction;

    protected Projectile(float x, float y, Level level, Vector2 direction, Entity shooter) {
        super(x, y, level);
        this.shooter = shooter;
        this.direction = direction;
        distanceTraveled = 0;
    }

    //This is the base movement code for a projectile to move in the direction of some 2d vector
    //To adjust the direction of a projectile, simply edit the 2d direction vector
    public void update(float delta) {
        if(distanceTraveled > range) remove();
        else {
            y -= speed * delta * direction.y;
            x -= speed * delta * direction.x;
            distanceTraveled += speed * delta;
            for(Entity target : level.getEntities()) {
                if(target == this) continue;
                if(target == shooter) continue;
                if(target instanceof Projectile) continue;
                if(target.isEnemy == shooter.isEnemy) continue;
                if (Math.sqrt((x - target.x) * (x - target.x) + (y - target.y) * (y - target.y)) < radius + target.radius)  {
                    target.health -= damage;
                    remove();
                }
            }
        }
    }
}
