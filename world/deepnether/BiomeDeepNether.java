package deepcraft.world.deepnether;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeDeepNether extends BiomeGenBase
{
    public BiomeDeepNether(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.field_82914_M.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 200, 16, 32));
    }
}
