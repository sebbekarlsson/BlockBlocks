package blockblock.main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import blockblock.scenes.World;

public class Camera extends Entity {
	public Camera(World world,float x, float y, float z) {
		super(world,x, y, z);
		// TODO Auto-generated constructor stub
	}
	public float xrot, yrot, zrot = 0;
	public float speed = 0.5f;
	
	public void tick(){
		updatePhysics();
		yrot += Mouse.getDX();
		xrot -= Mouse.getDY();
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			x -= Math.sin(Math.toRadians(yrot)) * speed;
			z += Math.cos(Math.toRadians(yrot)) * speed;
			//y += Math.sin(Math.toRadians(xrot)) * speed;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			if(onGround){
				addForce(new Vector3f(0,-2f,0));
			}
		}
	}
	public void draw(){}
}
