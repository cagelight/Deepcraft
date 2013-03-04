package deepcraft.block.misc;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialLiquidSensMod extends MaterialLiquid{
	
	private int mobilityFlag;

	public MaterialLiquidSensMod(MapColor par1MapColor) {
		super(par1MapColor);
	}
	
	@Override
    public Material setNoPushMobility()
    {
        this.mobilityFlag = 1;
        return this;
    }

}
