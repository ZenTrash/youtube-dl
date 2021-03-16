package de.fmr.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Object {
	protected int x, y, sx, sy;
	
	
	
	
	public Object(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	

	
	
	
	public void setRenderXY(int x, int y) {
		this.sx