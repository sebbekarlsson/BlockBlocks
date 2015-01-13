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
}
