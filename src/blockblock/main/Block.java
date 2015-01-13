package blockblock.main;

import org.lwjgl.opengl.GL11;

public class Block extends Instance {

	public BlockType blockType;
	public Chunk chunk;

	public Block(BlockType type,Chunk chunk,float x, float y, float z) {
		super(x, y, z);
		this.blockType = type;
		this.chunk = chunk;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint() {
		boolean draw = true;

		
		if((x - chunk.x)-1 >= 0 && (x - chunk.x)+1 <= 15 && (z - chunk.z)-1 >= 0 && (z - chunk.z)+1 <= 15  && (y)-1 >= 0 && (y)+1 <= 15){
			if(
					chunk.blocks[(int)((x - chunk.x)-1)][(int)(y)][(int)(z - chunk.z)] != null && chunk.blocks[(int)((x - chunk.x)+1)][(int)(y)][(int)(z - chunk.z)] != null
					&& chunk.blocks[(int)((x - chunk.x)+1)][(int)(y)][(int)(z - chunk.z)] != null
					&& chunk.blocks[(int)(x - chunk.x)][(int)((y)-1)][(int)(z - chunk.z)] != null
					&& chunk.blocks[(int)(x - chunk.x)][(int)((y)+1)][(int)(z - chunk.z)] != null
					&& chunk.blocks[(int)(x - chunk.x)][(int)(y)][(int)((z - chunk.z)-1)] != null
					&& chunk.blocks[(int)(x - chunk.x)][(int)(y)][(int)((z - chunk.z)+1)] != null
					){
				draw = false;
			}
		}


		if(draw){


			
			GL11.glPushMatrix();
			

			blockType.left.bind();
			
			GL11.glBegin(GL11.GL_QUADS);



			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(0, 0, 0);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(1, 0, 0);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex3f(1, 1, 0);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex3f(0, 1, 0);

			GL11.glEnd();


			blockType.right.bind();
			
			GL11.glBegin(GL11.GL_QUADS);



			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(0, 0, -1);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(1, 0, -1);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex3f(1, 1, -1);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex3f(0, 1, -1);

			GL11.glEnd();




			blockType.top.bind();
			GL11.glBegin(GL11.GL_QUADS);


			GL11.glTexCoord2f(0,0);
			GL11.glVertex3f(0, 1, 0);

			GL11.glTexCoord2f(0,-1);
			GL11.glVertex3f(0, 1, -1);

			GL11.glTexCoord2f(1, -1);
			GL11.glVertex3f(1, 1, -1);

			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(1, 1, 0);


			GL11.glEnd();

			blockType.bottom.bind();
			GL11.glBegin(GL11.GL_QUADS);


			GL11.glTexCoord2f(0,0);
			GL11.glVertex3f(0, 0, 0);

			GL11.glTexCoord2f(0,-1);
			GL11.glVertex3f(0, 0, -1);

			GL11.glTexCoord2f(1, -1);
			GL11.glVertex3f(1, 0, -1);

			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(1, 0, 0);


			GL11.glEnd();


			blockType.front.bind();
	
			GL11.glBegin(GL11.GL_QUADS);


			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(0, 0, 0);

			GL11.glTexCoord2f(0, -1);
			GL11.glVertex3f(0, 0, -1);

			GL11.glTexCoord2f(1, -1);
			GL11.glVertex3f(0, 1, -1);

			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(0, 1, 0);


			GL11.glEnd();


			blockType.back.bind();
			GL11.glBegin(GL11.GL_QUADS);


			GL11.glTexCoord2f(0, 0);
			GL11.glVertex3f(1, 0, 0);

			GL11.glTexCoord2f(0, -1);
			GL11.glVertex3f(1, 0, -1);

			GL11.glTexCoord2f(1, -1);
			GL11.glVertex3f(1, 1, -1);

			GL11.glTexCoord2f(1, 0);
			GL11.glVertex3f(1, 1, 0);


			GL11.glEnd();

			GL11.glPopMatrix();

		}

	}

}
