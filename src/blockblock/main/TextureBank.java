package blockblock.main;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureBank {
	
	public static Texture DIRT = loadTexture("images/dirt.png");
	public static Texture GRASS = loadTexture("images/grass.png");
	public static Texture GRASS_SIDE = loadTexture("images/grass_side.png");
	public static Texture STONE = loadTexture("images/stone.png");

	
	public static Texture loadTexture(String path){
		Texture t = null;
		try {
			t = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
