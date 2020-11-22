
package de.fmr.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chunk {
	
	private Tree[] t;
	private int x, y;
	public SpriteBatch b;
	
	public Chunk(int x, int y, SpriteBatch batch,  Tree[] t) {
		
		this.t = t;
		this.x = x;
		this.y = y;
		b = batch;
		
	}
	
	public int getX() {
		return this.x;
	}
	