package blockblock.main;

public class Collision {
	public static boolean pointMeeting(float x, float y, float z, Instance instance){
		if(instance != null){
			if(x >= instance.x && x <= instance.x+1 && y >= instance.y && y <= instance.y+1 && z >= instance.z && z <= instance.z+1){
				return true;
			}
		}
		return false;
	}

	public static boolean overLapping(Instance instance1, Instance instance2){
		if(instance1 != null && instance2 != null){
			if(-instance1.x >= instance2.x && -instance1.x <= instance2.x+1 && -instance1.y >= instance2.y && -instance1.y <= instance2.y+1 && -instance1.z >= instance2.z && -instance1.z <= instance2.z+1){
				return true;
			}
		}
		return false;
	}
}
