package blockblock.scenes;

import blockblock.main.Camera;
import blockblock.main.Chunk;
import blockblock.main.Scene;
import blockblock.main.WorldGenerator;

public class World extends Scene {

	public Chunk[][] chunks = new Chunk[WorldGenerator.worldWidth][WorldGenerator.worldWidth];
	WorldGenerator generator = new WorldGenerator();
	public Camera camera = new Camera(this,0,0,0);

	public World(){
		//instantiate(new Block(BlockType.Dirt,0,1,-10));
		camera.y = -16*4;
		camera.x = -10;
		camera.z = -10;
		generator.generateWorld(this);
	}

	@Override
	public void tick() {
		for(int x = 0; x < chunks.length; x++){
			
				for(int z = 0; z < chunks[x].length; z++){
					Chunk chunk = chunks[x][z];
					if(chunk != null){
						if(chunk.isVisible()){
							if(chunk.init == false){
								chunk.init();
								chunk.init = true;
							}
							chunk.tick();
						}
					}
				}
			
		}

	}

	@Override
	public void draw() {
		for(int x = 0; x < chunks.length; x++){
			
				for(int z = 0; z < chunks[x].length; z++){
					Chunk chunk = chunks[x][z];
					if(chunk != null){
						if(chunk.isVisible()){
							chunk.draw();
						}
					}
				}
			
		}

	}

}
