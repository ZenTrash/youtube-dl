
package de.fmr.main;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer sp;
	Player Player;
	
	public static final int RENDER_CHUNKS = 16;
	
	Chunk chunk;
	Chunk[] chunks;
	Game g;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sp = new ShapeRenderer();
		Player = new Player(Gdx.graphics.getWidth() / 2 - 32, Gdx.graphics.getHeight() / 2 - 32);
		
		
		g = new Game();
		
		
		//chunk = new Chunk(0, 600, batch, g.createSpawnChunk());
		
		
		
		chunks = new Chunk[RENDER_CHUNKS ];
		System.out.println("HEllo World!");
		int counter = -1;
		for(int x = (int) -(Math.sqrt(RENDER_CHUNKS) / 2 * 600); x < Math.sqrt(RENDER_CHUNKS) / 2 * 600; x += 600) {
			for(int y = (int) Math.sqrt(RENDER_CHUNKS) / 2 * 600; y > -Math.sqrt(RENDER_CHUNKS) / 2 * 600; y -= 600) {
				System.out.print("DONE:");
				System.out.println(counter);
				counter++;
				chunks[counter] = new Chunk(x, y, batch, Game.createChunk(x, y));
			}
		}
		
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		
		//draw background
		sp.begin(ShapeRenderer.ShapeType.Filled);
		sp.setColor(Color.GREEN);
		sp.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		sp.end();
		
		
		//Trees
		
		
		
		//Chunk
		//chunk.render(Player);
		
		for(Chunk c : chunks) {
			c.render(Player);
		}
		
		
		
		//Player
		Player.render(batch);
		
		//spieler hinter baum
		//chunk.renderForeground(Player);
		
		for(Chunk c : chunks) {
			c.renderForeground(Player);
		}
		
		
		
	}
	
	@Override
	public void dispose () {
		sp.dispose();
		batch.dispose();