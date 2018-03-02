package com.badperson.shadowmancer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TeamSplashScreen implements Screen {

    private Core core;

    private Sprite splash;
    private SpriteBatch batch;

    private float time;

    public TeamSplashScreen(Core core) {
        this.core = core;

        splash = new Sprite(new Texture(Gdx.files.internal("splash.png")));
        splash.setPosition(0, 0);
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        splash.setAlpha(0);

        batch = new SpriteBatch();

        time = 0;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        time += delta;

        if (time <= 2) {
            splash.setAlpha(time / 2);
        }

        if (time > 5) {
            splash.setAlpha(1 - (time - 5) / 2);
        }

        if (time > 7) {
            this.dispose();
            core.setScreen(new DescriptionScreen(core));
        }

        batch.begin();
        splash.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //splash.getTexture().dispose();
        batch.dispose();
    }
}
