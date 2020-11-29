
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
	
	public int getY() {
		return this.y;
	}
	
	public void render(Player Player) {
		
		for(Tree t : this.t) {
			if(Player.getY() + Gdx.graphics.getHeight() / 2 <= t.getY() + 32) {
				t.setRenderXY(t.getX() - Player.getX(), t.getY() - Player.getY());
				t.render(b);
			}
		}
		
		
		
	}
	
	public void renderForeground(Player Player) {
		
		for(Tree t : this.t) {
			if(Player.getY() + Gdx.graphics.getHeight() / 2 > t.getY() + 32) {
				t.setRenderXY(t.getX() - Player.getX(), t.getY() - Player.getY());
				t.render(b);
			}
		}
		
	}
	
	public boolean collidesW(Player p) {
		//does nothing if chunks is too far away
		//if(p.getX() > this.x + 700 || p.getX() < this.x - 100 || p.getY() > this.y - 100 || p.getY() < this.y + 700) return false;
		
		if((p.getX() + p.getSX() > this.x + 650 || p.getX() + p.getSX() < this.x - 650 || p.getY() + p.getSY() < this.y - 650 || p.getY() + p.getSY() > this.y + 650)) return false;
		
		
		boolean collides = false;
		
		for(Tree t : this.t) {
			
			if(Game.checkIfCollidesTreeFront(p.getSX() + p.getX(), p.getSY() + p.getY() + 10, t.getX() + 10, t.getY()) &&
					Game.checkIfCollidesTreeFront(p.getSX() + p.getX() + 1, p.getSY() + p.getY() + 10, t.getX() + 10, t.getY())) return true;
			
			
			
		}
		
		return false;
	}
	
	public boolean collidesA(Player p) {
		
		return false;
	}
	
	public boolean collidesS(Player p) {


		for(Tree t : this.t) {
			if(Game.checkIfCollidesTreeFront(p.getSX() + p.getX(), p.getSY() + p.getY() + 0, t.getX() + 10, t.getY()) &&
					Game.checkIfCollidesTreeFront(p.getSX() + p.getX() + 1, p.getSY() + p.getY() + 0, t.getX() + 10, t.getY())) return true;
			
		}
		
		return false;
	}

}