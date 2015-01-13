package blockblock.main;

import org.lwjgl.util.vector.Vector3f;

import blockblock.scenes.World;

public class Entity extends Instance {

	public float dx,dy,dz = 0;
	public float friction = 0.3f;
	public float frictionY = 0f;
	public World world;
	public boolean onGround = false;

	public Entity(World world,float x, float y, float z) {
		super(x, y, z);
		this.world = world;
	}

	public void updatePhysics(){
		onGround = false;
		x += dx;
		y += dy;
		z += dz;

		Chunk chunk = getChunk();
		if(chunk != null){
			for(int x = 0; x < chunk.blocks.length; x++){
				for(int y = 0; y < chunk.blocks[x].length; y++){
					for(int z = 0; z < chunk.blocks[x][y].length; z++){
						Block block = chunk.blocks[x][y][z];
						if(Collision.pointMeeting(-this.x, -this.y-4, -this.z, block)){

							onGround = true;
							addForce(new Vector3f(0,-dy,0));

						}
					}
				}
			}
		}


		if(dx < 0){
			if(dx + friction > 0){
				dx = 0;
			}else{dx += friction;}
		}

		if(dx > 0){
			if(dx - friction < 0){
				dx = 0;
			}else{dx -= friction;}
		}


		if(dy < 0){
			if(dy + frictionY > 0){
				dy = 0;
			}else{dy += frictionY;}
		}

		if(dy > 0){
			if(dy - friction < 0){
				dy = 0;
			}else{dy -= friction;}
		}

		if(dz < 0){
			if(dz + friction > 0){
				dz = 0;
			}else{dz += friction;}
		}

		if(dz > 0){
			if(dz - friction < 0){
				dz = 0;
			}else{dz -= friction;}
		}

		if(!onGround)
			addForce(new Vector3f(0f,0.40f,0f));


	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub

	}

	public void addForce(Vector3f vector){
		dx += vector.getX();
		dy += vector.getY();
		dz += vector.getZ();
	}

	public Chunk getChunk(){
		for(int x = 0; x < world.chunks.length; x++){
			for(int y = 0; y < world.chunks[x].length; y++){
				for(int z = 0; z < world.chunks[x][y].length; z++){
					Chunk chunk = world.chunks[x][y][z];
					if(chunk != null){

						if(-this.x >= chunk.x && -this.x <= chunk.x+16 && -this.z >= chunk.z && -this.z <= chunk.z+16){

							return chunk;
						}
					}
				}
			}
		}
		return null;
	}

}
