package com.badperson.shadowmancer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class MainDamnedScreen implements Screen {

    private Core core;

    private SpriteBatch batch;
    private Texture myFavouritePicture;

    private float time;

    public MainDamnedScreen(Core core) {
        this.core = core;
        ShaderProgram program = new ShaderProgram(Gdx.files.internal("shader_final_ver.vert"), Gdx.files.internal("shader_test.frag")); // got high on Unity, fix later
        ShaderProgram.pedantic = false;
        batch = new SpriteBatch(1000, program);
        program.begin();
        program.setUniform2fv("resolution", new float[]{Gdx.graphics.getWidth(), Gdx.graphics.getHeight()}, 0, 2);
        program.end();
        myFavouritePicture = new Texture(Gdx.files.internal("flag.png"));
        time = 0;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        time += delta;
        batch.begin();
        batch.getShader().setUniformf("time", time);
        batch.draw(myFavouritePicture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
        batch.dispose();
        myFavouritePicture.dispose();
    }
}
