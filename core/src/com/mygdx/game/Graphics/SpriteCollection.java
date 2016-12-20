package com.mygdx.game.Graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteCollection {


    //PLAYER TEXTURES

    //Upgrade 0 radius =
    //Upgrade 1 radius =
    //Upgrade 2 radius = 13ish
    private Texture playerTexture0;
    private Texture playerTexture1;
    private Texture playerTexture2;


    //NPC TEXTURES
    private Texture bomberGreenTexture;
    private Texture bomberRedTexture;

    //drone radius = 13ish
    private Texture droneBlueTexture;
    private Texture droneGreenTexture;
    private Texture droneOrangeTexture;
    private Texture dronePurpleTexture;

    private Texture heavyGreenTexture;
    private Texture heavyYellowTexture;

    private Texture orbBlueTexture;
    private Texture orbGreenTexture;
    private Texture orbRedTexture;

    private Texture scoutRedTexture;
    private Texture scoutYellowTexture;

    //EFFECT TEXTURES
    private Texture bombBlueSheet;
    private Texture bombGreenSheet;
    private Texture bombPurpleSheet;
    private Texture bombRedSheet;
    private Texture bombYellowSheet;

    private Texture bulletBlueSheet;
    private Texture bulletGreenSheet;
    private Texture bulletPurpleSheet;
    private Texture bulletRedSheet;
    private Texture bulletYellowSheet;

    private Texture laserBlueSheet;
    private Texture laserGreenSheet;

    //PLAYER SPRITES
    public Sprite player_upgrade_0;
    public Sprite player_upgrade_1;
    public Sprite player_upgrade_2;

    //NPC SPRITES
    public Sprite bomber_red;
    public Sprite bomber_green;

    public Sprite drone_blue;
    public Sprite drone_green;
    public Sprite drone_orange;
    public Sprite drone_purple;

    public Sprite heavy_green;
    public Sprite heavy_yellow;

    public Sprite orb_blue;
    public Sprite orb_green;
    public Sprite orb_red;

    public Sprite scout_red;
    public Sprite scout_yellow;


    //EFFECT SPRITES
    //BOMB LARGE RADIUS = 12
    //BOMB MEDIUM RADIUS = 10
    //BOMB SMALL RADIUS = 7
    public Sprite bomb_blue_lrg;
    public Sprite bomb_blue_med;
    public Sprite bomb_blue_sml;

    public Sprite bomb_green_lrg;
    public Sprite bomb_green_med;
    public Sprite bomb_green_sml;

    public Sprite bomb_purple_lrg;
    public Sprite bomb_purple_med;
    public Sprite bomb_purple_sml;

    public Sprite bomb_red_lrg;
    public Sprite bomb_red_med;
    public Sprite bomb_red_sml;

    public Sprite bomb_yellow_lrg;
    public Sprite bomb_yellow_med;
    public Sprite bomb_yellow_sml;

    public Sprite bullet_blue_sml;
    public Sprite bullet_blue_med;
    public Sprite bullet_blue_lrg;

    public Sprite bullet_green_sml;
    public Sprite bullet_green_med;
    public Sprite bullet_green_lrg;

    public Sprite bullet_purple_sml;
    public Sprite bullet_purple_med;
    public Sprite bullet_purple_lrg;

    public Sprite bullet_red_sml;
    public Sprite bullet_red_med;
    public Sprite bullet_red_lrg;

    public Sprite bullet_yellow_sml;
    public Sprite bullet_yellow_med;
    public Sprite bullet_yellow_lrg;

    public Sprite laser_blue_partial;
    public Sprite laser_blue_full;

    public Sprite laser_green_partial;
    public Sprite laser_green_full;


    public SpriteCollection() {
        loadAllTextures();
        loadAllSprites();
    }

    //dispose all the textures
    public void dispose() {

        //dispose player textures
        playerTexture0.dispose();
        playerTexture1.dispose();
        playerTexture1.dispose();

        //dispose npc textures
        bomberRedTexture.dispose();
        bomberGreenTexture.dispose();

        droneBlueTexture.dispose();
        droneGreenTexture.dispose();
        droneOrangeTexture.dispose();
        dronePurpleTexture.dispose();

        heavyGreenTexture.dispose();
        heavyYellowTexture.dispose();

        orbBlueTexture.dispose();
        orbGreenTexture.dispose();
        orbRedTexture.dispose();

        scoutRedTexture.dispose();
        scoutYellowTexture.dispose();

        //dipose effect textures
        bombBlueSheet.dispose();
        bombGreenSheet.dispose();
        bombPurpleSheet.dispose();
        bombRedSheet.dispose();
        bombYellowSheet.dispose();

        bulletBlueSheet.dispose();
        bulletGreenSheet.dispose();
        bulletPurpleSheet.dispose();
        bulletRedSheet.dispose();
        bulletYellowSheet.dispose();

        laserBlueSheet.dispose();
        laserGreenSheet.dispose();

    }

    private void loadAllTextures() {
        //PLAYER TEXTURES
        playerTexture0 = new Texture(Gdx.files.internal("Space/Player/idle_player_basic.png"));
        playerTexture1 = new Texture(Gdx.files.internal("Space/Player/idle_player_upgrade1.png"));
        playerTexture2 = new Texture(Gdx.files.internal("Space/Player/idle_player_upgrade2.png"));

        //NPC TEXTURES
        bomberRedTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_bomber_red.png"));
        bomberGreenTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_bomber_green.png"));

        droneBlueTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_drone_blue.png"));
        droneGreenTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_drone_green.png"));
        droneOrangeTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_drone_orange.png"));
        dronePurpleTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_drone_purple.png"));

        heavyGreenTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_heavy_green.png"));
        heavyYellowTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_heavy_yellow.png"));

        orbBlueTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_orb_blue.png"));
        orbGreenTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_orb_green.png"));
        orbRedTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_orb_red.png"));

        scoutRedTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_scout_red.png"));
        scoutYellowTexture = new Texture(Gdx.files.internal("Space/Enemy/idle_scout_yellow.png"));

        //EFFECT TEXTURES
        bombBlueSheet = new Texture(Gdx.files.internal("Space/Effects/BulletBombSpriteSheetBlue.png"));
        bombGreenSheet = new Texture(Gdx.files.internal("Space/Effects/BulletBombSpriteSheetGreen.png"));
        bombPurpleSheet = new Texture(Gdx.files.internal("Space/Effects/BulletBombSpriteSheetPurple.png"));
        bombRedSheet = new Texture(Gdx.files.internal("Space/Effects/BulletBombSpriteSheetRed.png"));
        bombYellowSheet = new Texture(Gdx.files.internal("Space/Effects/BulletBombSpriteSheetYellow.png"));

        bulletBlueSheet = new Texture(Gdx.files.internal("Space/Effects/BulletsSpriteSheetBlue.png"));
        bulletGreenSheet = new Texture(Gdx.files.internal("Space/Effects/BulletsSpriteSheetGreen.png"));
        bulletPurpleSheet = new Texture(Gdx.files.internal("Space/Effects/BulletsSpriteSheetPurple.png"));
        bulletRedSheet = new Texture(Gdx.files.internal("Space/Effects/BulletsSpriteSheetRed.png"));
        bulletYellowSheet = new Texture(Gdx.files.internal("Space/Effects/BulletsSpriteSheetYellow.png"));

        laserBlueSheet = new Texture(Gdx.files.internal("Space/Effects/LaserSpriteSheetBlue.png"));
        laserGreenSheet = new Texture(Gdx.files.internal("Space/Effects/LaserSpriteSheetGreen.png"));
    }

    private void loadAllSprites() {

        //PLAYER SPRITES
        player_upgrade_0 = new Sprite(playerTexture0);
        player_upgrade_1 = new Sprite(playerTexture1);
        player_upgrade_2 = new Sprite(playerTexture2);

        //NPC SPRITES
        bomber_red = new Sprite(bomberRedTexture);
        bomber_green = new Sprite(bomberGreenTexture);

        drone_blue = new Sprite(droneBlueTexture);
        drone_green = new Sprite(droneGreenTexture);
        drone_orange = new Sprite(droneOrangeTexture);
        drone_purple = new Sprite(dronePurpleTexture);

        heavy_green = new Sprite(heavyGreenTexture);
        heavy_yellow = new Sprite(heavyYellowTexture);

        orb_blue = new Sprite(orbBlueTexture);
        orb_green = new Sprite(orbGreenTexture);
        orb_red = new Sprite(orbRedTexture);

        scout_red = new Sprite(scoutRedTexture);
        scout_yellow = new Sprite(scoutYellowTexture);

        //EFFECT SPRITES
        bomb_blue_lrg = new Sprite(bombBlueSheet, 0, 0, 32, 32);
        bomb_blue_med = new Sprite(bombBlueSheet, 31, 0, 32, 32);
        bomb_blue_sml = new Sprite(bombBlueSheet, 0, 31, 32, 32);

        bomb_green_lrg = new Sprite(bombGreenSheet, 0, 0, 32, 32);
        bomb_green_med = new Sprite(bombGreenSheet, 31, 0, 32, 32);
        bomb_green_sml = new Sprite(bombGreenSheet, 0, 31, 32, 32);

        bomb_purple_lrg = new Sprite(bombPurpleSheet, 0, 0, 32, 32);
        bomb_purple_med = new Sprite(bombPurpleSheet, 31, 0, 32, 32);
        bomb_purple_sml = new Sprite(bombPurpleSheet, 0, 31, 32, 32);

        bomb_red_lrg = new Sprite(bombRedSheet, 0, 0, 32, 32);
        bomb_red_med = new Sprite(bombRedSheet, 31, 0, 32, 32);
        bomb_red_sml = new Sprite(bombRedSheet, 0, 31, 32, 32);

        bomb_yellow_lrg = new Sprite(bombYellowSheet, 0, 0, 32, 32);
        bomb_yellow_med = new Sprite(bombYellowSheet, 31, 0, 32, 32);
        bomb_yellow_sml = new Sprite(bombYellowSheet, 0, 31, 32, 32);

        //TODO: BULLET AND LAZER SPRITES
        bullet_blue_lrg = new Sprite(bulletBlueSheet, 0, 0, 32, 32);
        bullet_blue_med = new Sprite(bulletBlueSheet, 0, 0, 32, 32);
        bullet_blue_sml = new Sprite(bulletBlueSheet, 0, 0, 32, 32);


    }

}

