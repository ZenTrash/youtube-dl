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
		this.x = this.y = 0;
		this.state = 0;
		img[0] = new Texture("SpielerN.png");
		img[1] = new Texture("SpielerO.png");
		img[2] = new Texture("SpielerS.png");
		img[3] = new Texture("SpielerW.png");
		
		
	}
	
	public void render(SpriteBatch b) {
		
		b.begin();
		b.draw(img[this.state], this.sx, this.sy, 64, 64);
		b.end();
		
	}
	
	public int getX() {
		return this.x;
	}
	
	public in