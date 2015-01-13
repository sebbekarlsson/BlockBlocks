package blockblock.main;

import blockblock.scenes.World;

public class WorldGenerator {
	public static int worldWidth = 10;
	public static int worldDepth = 1;
	
	public void generateWorld(World world){
		
		
		for(int x = 0; x < worldWidth; x++){
			for(int y = 0; y < worldDepth; y++){
				for(int z = 0; z < worldWidth; z++){
					world.chunks[x][y][z] = new Chunk(world,x*16,y*16,z*16);
				}
			}
		}
	}
}
