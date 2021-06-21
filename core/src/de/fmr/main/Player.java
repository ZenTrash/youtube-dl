package de.fmr.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	private int x, y, sx, sy;
	private int state;
	private Texture[] img = new Texture[4];
	private int speed = 1;
	
	
	public Player(int x, int y) {
		this.sx = x;
		this.sy = y;
		this.x = this.y =