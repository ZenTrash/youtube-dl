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
	
	public int getY() {
		return this.y;
	}
	
	public int getState() {
		return this.state;
	}
	
	public int getSX() {
		return this.sx;
	}
	
	public int getSY() {
		return this.sy;
	}
	
	public void actualize(Chunk[] chunks) {
		
		boolean Wallowed = true;
		
		boolean Sallowed = true;
		
		for(Chunk c : chunks) {
			if(c.collidesW(this)) { 
				Wallowed = false;
			
			}
			
			if(c.collidesS(this)) {
				Sallowed = false;
			}
			
			if(Sallowed == false && Wallowed == false) break;
			
			
		}
		
		
		//speed
		
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) speed = 3;
		else speed = 1;
		
		
		//keys
		if (Gdx.input.isKeyPressed(Input.Keys.W) && Wallowed) {
			this.y += speed;
			if(this.state != 0) this.state = 0;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			this.x += speed;
			if(this.state != 1) this.state = 1;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) && Sallowed) {
			this.y -= speed;
			if(this.state != 2) this.state = 2;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.x -= speed;
			if(this.state != 3) this.state = 3;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D) && this.state != 1) this.state = 1; 
		
		
		
	}

}
