package com.mygdx.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameScreen extends ScreenAdapter {

    static final int GAME_READY = 0;
    static final int GAME_RUNNING = 1;
    static final int GAME_PAUSED = 2;
    static final int GAME_LEVEL_END = 3;
    static final int GAME_OVER = 4;

    GdxGame my_game;
    OrthographicCamera guiCam;
    Vector3 touchPoint;

    GlyphLayout glyphLayout = new GlyphLayout();

    public GameScreen (GdxGame my_game){
        this.my_game = my_game;
        guiCam = new OrthographicCamera(320, 480);
        guiCam.position.set(320 / 2, 480 / 2, 0);
        touchPoint = new Vector3();
    }

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCam.update();
        my_game.batch.setProjectionMatrix(guiCam.combined);

        my_game.batch.begin();
        my_game.batch.draw(Assets.gameBackgroundRegion,0,0,320,480);
        my_game.batch.end();
    }

    @Override
    public void render (float delta) {
       // update();
        draw();
    }


}
