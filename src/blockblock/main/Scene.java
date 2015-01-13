package blockblock.main;

import java.util.ArrayList;

public abstract class Scene {

	public ArrayList<Instance> instances = new ArrayList<Instance>();

	public abstract void tick();
	public abstract void draw();
	
	public void instantiate(Instance instance){
		instances.add(instance);
	}
	
	public void destroyInstance(Instance instance){
		instances.remove(instance);
	}
}
