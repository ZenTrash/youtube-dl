
package de.fmr.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tree extends Object{
	
	

	public Tree(int x, int y) {
		super(x, y);
		
	}
	
	public void render(SpriteBatch b) {
		b.begin();
		b.draw(Game.TreeTexture, this.sx, this.sy, 128, 128);
		b.end();
	}

}