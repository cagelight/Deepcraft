package sensory.fx;

import sensory.core.CommonProxy;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;

public class EntityBlueFlameFX extends EntityFlameFX{
	
	@Override
	public String getTexture () {
		return CommonProxy.PARTICLES_PNG;
	}

	public EntityBlueFlameFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
	}

}
