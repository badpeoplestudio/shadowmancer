package com.badperson.shadowmancer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DescriptionScreen implements Screen {

    private Core core;

    private Sprite description;
    private SpriteBatch batch;

    private float time;

    public DescriptionScreen(Core core) {
        this.core = core;

        description = new Sprite(new Texture(Gdx.files.internal("description.png")));
        description.setPosition(0, 0);
        description.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        description.setAlpha(0);

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
            description.setAlpha(time / 2);
        }

        if (time > 5) {
            description.setAlpha(1 - (time - 5) / 2);
        }

        if (time > 7) {
            this.dispose();
            core.setScreen(new MainDamnedScreen(core));
        }

        batch.begin();
        description.draw(batch);
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
        description.getTexture().dispose();
        batch.dispose();
    }
}
