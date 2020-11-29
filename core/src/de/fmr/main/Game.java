
package de.fmr.main;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game {
	
	public static Texture TreeTexture = new Texture("Baum.png");
	public static Random r = new Random();
	
	public static Tree[] chunkOut = null;
	
	public static Chunk[] Tout = new Chunk[MyGdxGame.RENDER_CHUNKS];
	
	
	
	
		
		
	static Tree[] createChunk(int x, int y) {
		
		chunkOut = null;
		
		int a = r.nextInt(16) + 16;
		
		int lastY = y;
		
		int stepY = 500 / a;