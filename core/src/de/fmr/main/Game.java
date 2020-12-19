
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
		
		int newY;
		
		chunkOut = new Tree[a];
		
		for(int i = 0; i < a; i++) {
			newY = lastY - stepY;
			lastY = newY;
			
			chunkOut[i] = new Tree(r.nextInt(500) + x, newY);
		}
		
		return chunkOut;
	}
	
	public static void clrChunkCache() {
		chunkOut = null;
	}
	
	static boolean checkIfCollidesTreeFront(int x, int y, int ex, int ey) {
		return x > ex && x < ex + 38 && y > ey && y < ey + 10;
	}
	
	static boolean checkIfCollidesTreeBack(int x, int y, int ex, int ey) {
		return x > ex && x < ex + 38;
	}
	
	static Chunk[] actualizeChunk(Chunk[] chunks, Player p, SpriteBatch b) {
		
		Tout = null;
		
		//System.gc();
		
		Tout = new Chunk[chunks.length];
		
		//System.out.println("Started the method");
		
		//Chunk[] neverUSed = null;
		
		
		//Chunk[] out = new Chunk[chunks.length];
		
		//Tout = new Chunk[16];
		
		
		
		int CX = 0;
		int CY = 0;
		
		
		
		for(Chunk c : chunks) {
			
			if(p.getX() + p.getSX() >= c.getX() && p.getX() + p.getSX() <= c.getX() + 600 && p.getY() + p.getSY() >= c.getY() && p.getY() + p.getSY() <= c.getY() + 600) {
				CX = c.getX();
				CY = c.getY();
			}
		}
		
		int counter = -1;
		
		Chunk chunk = null;
		
		
		for(int x = (CX - 1200); x < CX + 1200; x += 600) {
			for(int y = CY + 1200; y > (CY - 1200); y -= 600) {
				
				counter++;
				
				//System.out.println(counter);
				