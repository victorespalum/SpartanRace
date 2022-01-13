package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GdxGame extends Game {
	SpriteBatch batch; // usado por todas las pantallas

	@Override
	public void create() {
		batch = new SpriteBatch();
		Assets.load();
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		super.render();
	}

}


