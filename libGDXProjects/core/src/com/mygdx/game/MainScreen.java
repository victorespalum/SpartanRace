package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainScreen extends ScreenAdapter {
    GdxGame my_game;
    OrthographicCamera guiCamera;
    Rectangle playbutton;
    Rectangle quitbutton;
    Vector3 touchpoint;

    public MainScreen (GdxGame my_game){ // Constructor del mainscreen, le pasamos el juego
        this.my_game = my_game;
        this.guiCamera = new OrthographicCamera(320,480);
        guiCamera.position.set(320 /2 , 480 / 2, 0);
        playbutton = new Rectangle(60,220,200,70);
        quitbutton = new Rectangle(60,120,200,70);
        touchpoint = new Vector3();
    }

    public void update(){
        if(Gdx.input.justTouched()){
            guiCamera.unproject(touchpoint.set(Gdx.input.getX(),Gdx.input.getY(),0));

            if(playbutton.contains(touchpoint.x, touchpoint.y)){
                my_game.setScreen(new GameScreen(my_game));
                return;
            }
            if (quitbutton.contains(touchpoint.x,touchpoint.y)){
                System.exit(0);
            }
        }
    }

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCamera.update();
        my_game.batch.setProjectionMatrix(guiCamera.combined);

        my_game.batch.begin();
        my_game.batch.draw(Assets.backgroundRegion, 0, 0, 320, 480);
        my_game.batch.draw(Assets.playButton,60,220,200,70);
        my_game.batch.draw(Assets.quitButton, 60, 120, 200, 70);
        my_game.batch.end();
    }

    public void render(float delta){
        update();
        draw();
    }
}
