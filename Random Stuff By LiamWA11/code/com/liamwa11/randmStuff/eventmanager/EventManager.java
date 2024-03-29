package com.liamwa11.randmStuff.eventmanager;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.liamwa11.randomStuff.blocks.BlocksMain;

import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator{


	
	/**
     * Method to get what world we are generating.
     * For each case, we can have a different generator (0 = overworld, 1 = end, -1 = nether)
     * We multiply chunkX by 16, to change the 'chunknumber' to an actual coordinate.
	 * @return 
     */
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case 0: generateSurface(random, chunkX*16, chunkZ*16, world); break;
            case 1: generateEnd(random, chunkX*16, chunkZ*16, world); break;
            case -1: generateNether(random, chunkX*16, chunkZ*16, world); break;
            default:;
        }
    }
    
    /**
     * This is where you add your blocks to spawn for the overworld.
     * call addOreSpawn, and give these parameters:
     * Block: Block to generate
     * World: world var (see params)
     * Random: a random (see params)
     * ChunkX: The x coordinate of a chunk (see params)
     * ChunkZ: The z coordinate of a chunk (see params)
     * minVainSize: Minimal vain size
     * maxVainSize: The max vain siz
     * chanceToSpawn: The chance to spawn. Dont make this extreme like 1000, keep it around at most 50, or your world wont load.
     * minY: Lowest point to spawn
     * maxY: Highest point to spawn.
     *
     * Nether and End go the same way
     */

	private void generateNether(Random random, int chunkX, int chunkZ, World world) {
		//Add nether gen
		
	}

	private void generateEnd(Random random, int chunkX, int chunkZ, World world) {
		//Add end gen
		addOreSpawn(BlocksMain.oreRuby, world, random, chunkX, chunkZ, 5, 13, 40, 1, 128);
	}

	private void generateSurface(Random random, int chunkX, int chunkZ, World world) {
		//Add overworld gen
		
		addOreSpawn(BlocksMain.oreRuby, world, random, chunkX, chunkZ, 5, 13, 23, 1, 128);
		
	}
	
	/**
    *
    * This method adds our block to the world.
    * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
    * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
    *
    *@param block The block you want to spawn
    *@param world The world
    *@param blockXPos the blockXpos of a chunk
    *@param blockZPos the blockZpos of a chunk
    *@param maxVainSize max vain
    *@param chancesToSpawn the chance to spawn. Usually around 2
    *@param minY lowest point to spawn
    *@param maxY highest point to spawn
    */
   public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVainSize, int maxVainSize, int chancesToSpawn, int minY, int maxY )
   {
       for(int i = 0; i < chancesToSpawn; i++)
       {
           int posX = blockXPos + random.nextInt(16);
           int posY = minY + random.nextInt(maxY - minY);
           int posZ = blockZPos + random.nextInt(16);
           new WorldGenMinable(block, (minVainSize + random.nextInt(maxVainSize - minVainSize)), Blocks.stone).generate(world, random, posX, posY, posZ);
       }
   }

}
