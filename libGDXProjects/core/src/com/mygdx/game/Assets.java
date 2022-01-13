package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

    public static Texture background;
    public static TextureRegion gameBackgroundRegion;
    public static Texture gameBackground;
    public static TextureRegion backgroundRegion;
    public static Texture items;
    public static TextureRegion playButton;
    public static TextureRegion quitButton;


    public static Texture loadTexture (String file){
        return new Texture(Gdx.files.internal(file));
    }

    public static void load (){
        background = loadTexture("data/Test1.jpg");
        backgroundRegion = new TextureRegion(background,0,0,320,480);

        gameBackground = loadTexture("data/gameMenu.png");
        gameBackgroundRegion = new TextureRegion(gameBackground,0,0,320,480);

        items = loadTexture("data/buttons.png");
        playButton = new TextureRegion(items,8,0,222,114);
        quitButton = new TextureRegion(items, 8,114, 222, 107);
    }


}
