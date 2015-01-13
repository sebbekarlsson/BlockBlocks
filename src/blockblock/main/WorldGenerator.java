package blockblock.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import blockblock.scenes.World;

public class WorldGenerator {
	public static int worldWidth = 16*8;
	public static int worldDepth = 1;
	Random random = new Random();

	public void generateWorld(World world){

		BufferedImage img = new BufferedImage(worldWidth, worldWidth, BufferedImage.TYPE_INT_RGB);

		for(int x = 0; x < img.getWidth(); x++){
			for(int y = 0; y < img.getHeight(); y++){
				if(img.getRGB(x, y) == -16777216)
				img.setRGB(x, y, new Color(0,12,0).getRGB());
				if(random.nextInt(100) == 0){
					for(int xx = -5; xx < 5; xx++){
						for(int yy = -5; yy < 5; yy++){
							if(x+xx > 0 && x+xx < img.getWidth() && y+yy > 0 && y+yy < img.getHeight()){
								
								float distance = (float) Math.sqrt((x-x+xx)*(x-x+xx) + (y-y+yy)*(y-y+yy));
								if(distance < 5 && distance > 0){
									System.out.println(distance);
									img.setRGB(x+xx, y+yy, new Color(0,((int)distance)+7,0).getRGB());
								}
							}
						}
					}
				}

			}
		}


		File dir = new File("chunkimages");
		dir.mkdirs();
		File outputfile = new File("saved.png");
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Image saved");

		for(int x = 0; x < img.getWidth(); x++){
			for(int z = 0; z < img.getHeight(); z++){
				if(x*16+16 > 0 && x*16+16 < img.getWidth() && z*16+16 > 0 && z*16+16 < img.getHeight()){
					BufferedImage imagePart = img.getSubimage(x*16, z*16, 16, 16);
					world.chunks[x][z] = new Chunk(imagePart,world,x*16,z*16);
					
				}
			}
		}

	}
}
