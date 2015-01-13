package blockblock.main;

import org.lwjgl.opengl.GL11;

public abstract class Instance {
	public float x;
	public float y;
	public float z = 0;
	
	public Instance(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public abstract void tick();
	public void draw(){
		GL11.glPushMatrix();
		GL11.glTranslatef(x,y,z);
			paint();
		GL11.glTranslatef(-x,-y,-z);
		GL11.glPopMatrix();
	}
	public abstract void paint();
}
