package blockblock.main;

import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import blockblock.scenes.World;

public class Game {

	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 2;
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
	public static ArrayList<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;
	public static void main(String[] args){
		new Game();
	}
	
	public Game(){
		try {
			Display.setDisplayMode(new DisplayMode(FRAMESIZE.width, FRAMESIZE.height));
			Display.setTitle("Cool block game");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(92f, Display.getWidth() / Display.getHeight(), 1f, 1000f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		scenes.add(new World());
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			
			
			
			Camera camera = getCurrentWorld().camera;
			camera.tick();
			camera.draw();
			
			
			
			GL11.glPushMatrix();
			GL11.glRotatef(camera.xrot, 1, 0, 0);
			GL11.glRotatef(camera.yrot, 0, 1, 0);
			GL11.glRotatef(camera.zrot, 0, 0, 1);
			GL11.glTranslatef(camera.x, camera.y, camera.z);
			
			getCurrentScene().tick();
			getCurrentScene().draw();
			
			for(int i = 0; i < getCurrentScene().instances.size(); i++){
				Instance instance = getCurrentScene().instances.get(i);
				
				instance.tick();
				instance.draw();
				
			}
			
			GL11.glTranslatef(camera.x, camera.y, camera.z);
			
			GL11.glPopMatrix();
			
			Display.sync(60);
			Display.update();
		}
		
		System.exit(0);
		
	}
	
	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}
	
	public static World getCurrentWorld(){
		if(getCurrentScene() instanceof World){
			return (World) getCurrentScene();
		}
		
		return null;
	}
}
