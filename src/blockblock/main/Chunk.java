package blockblock.main;

import java.util.Random;

import blockblock.scenes.World;

public class Chunk {
	public int x,y,z = 0;
	Block[][][] blocks = new Block[16][16][16];
	public boolean init = false;
	public World world;
	Random random = new Random();
	
	public Chunk(World world,int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public void init(){
		for(int x = 0; x < blocks.length; x++){
			for(int y = 0; y < blocks[x].length; y++){
				for(int z = 0; z < blocks[x][y].length; z++){
					BlockType type = BlockType.Dirt;
					if(y == 15){type = BlockType.GRASS;}
					if(y < random.nextInt(10)){type = BlockType.STONE;}
					blocks[x][y][z] = new Block(type,this,this.x+x,this.y+y,this.z+z);
				}
			}
		}
	}
	
	public void tick(){
		for(int x = 0; x < blocks.length; x++){
			for(int y = 0; y < blocks[x].length; y++){
				for(int z = 0; z < blocks[x][y].length; z++){
					Block block = blocks[x][y][z];
					if(block != null)
					blocks[x][y][z].tick();
				}
			}
		}
	}
	public void draw(){
		for(int x = 0; x < blocks.length; x++){
			for(int y = 0; y < blocks[x].length; y++){
				for(int z = 0; z < blocks[x][y].length; z++){
					Block block = blocks[x][y][z];
					if(block != null)
					blocks[x][y][z].draw();
				}
			}
		}
	}
	
	public boolean isVisible(){
		int renderSize = 16+4;
		Camera camera = world.camera;
		if(-camera.x >= x-renderSize && -camera.x <= x+renderSize && -camera.z >= z-renderSize && -camera.z <= z+renderSize){
			return true;
		}
		return false;
	}
}
