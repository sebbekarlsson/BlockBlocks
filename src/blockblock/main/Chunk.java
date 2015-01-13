package blockblock.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import blockblock.scenes.World;

public class Chunk {
	public int x,z = 0;
	Block[][][] blocks = new Block[16][255][16];
	public boolean init = false;
	public World world;
	Random random = new Random();
	public BufferedImage chunkImage;
	
	public Chunk(BufferedImage chunkImage,World world,int x, int z){
		this.x = x;
		this.z = z;
		this.world = world;
		this.chunkImage = chunkImage;
	}
	
	public void init(){
		for(int i = 0; i < chunkImage.getWidth(); i++){
			for(int ii = 0; ii < chunkImage.getHeight(); ii++){
				Color color = new Color(chunkImage.getRGB(i, ii));
				int blockY = 62-color.getGreen();
				blocks[i][blockY][ii] = new Block(BlockType.GRASS,this,x+i,blockY,z+ii);
				
				for(int b = blockY-1; b > blockY-10; b--){
					blocks[i][blockY-b][ii] = new Block(BlockType.STONE,this,x+i,blockY-b,z+ii);
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
		if(-camera.x >= x-renderSize && -camera.x <= x+renderSize*2 && -camera.z >= z-renderSize && -camera.z <= z+renderSize*2){
			return true;
		}
		return false;
	}
}
