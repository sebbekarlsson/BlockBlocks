package blockblock.main;

import org.newdawn.slick.opengl.Texture;

public enum BlockType {
	
	Dirt(TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT),
	GRASS(TextureBank.GRASS,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT,TextureBank.DIRT),
	STONE(TextureBank.STONE,TextureBank.STONE,TextureBank.STONE,TextureBank.STONE,TextureBank.STONE,TextureBank.STONE);
	
	Texture top;
	Texture bottom;
	Texture front;
	Texture back;
	Texture left;
	Texture right;
	
	
	
	BlockType(Texture top, Texture bottom, Texture front, Texture back, Texture left, Texture right ){
		this.top = top;
		this.bottom = bottom;
		this.front = front;
		this.back = back;
		this.left = left;
		this.right = right;
	}
	
	
}
