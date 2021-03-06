package deepcraft.fx;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLTextureFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import deepcraft.core.CommonProxy;
import deepcraft.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class TextureBlueLavaFlowingFX extends FMLTextureFX
{
    protected float[] red = new float[256];
    protected float[] green = new float[256];
    protected float[] blue = new float[256];
    protected float[] alpha = new float[256];
    int tickCounter = 0;

    public TextureBlueLavaFlowingFX()
    {
        super(SBlocks.lavaBlueMoving.blockIndexInTexture + 1);
        this.tileSize = 2;
        setup();
    }

    @Override
    public void setup()
    {
        super.setup();
        red = new float[tileSizeSquare];
        green = new float[tileSizeSquare];
        blue = new float[tileSizeSquare];
        alpha = new float[tileSizeSquare];
        tickCounter = 0;
    }

    public void onTick()
    {
        ++this.tickCounter;
        int var2;
        float var3;
        int var5;
        int var6;
        int var7;
        int var8;
        int var9;

        for (int var1 = 0; var1 < tileSizeBase; ++var1)
        {
            for (var2 = 0; var2 < tileSizeBase; ++var2)
            {
                var3 = 0.0F;
                int var4 = (int)(MathHelper.sin((float)var2 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);
                var5 = (int)(MathHelper.sin((float)var1 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);

                for (var6 = var1 - 1; var6 <= var1 + 1; ++var6)
                {
                    for (var7 = var2 - 1; var7 <= var2 + 1; ++var7)
                    {
                        var8 = var6 + var4 & tileSizeMask;
                        var9 = var7 + var5 & tileSizeMask;
                        var3 += this.red[var8 + var9 * tileSizeBase];
                    }
                }

                this.green[var1 + var2 * tileSizeBase] = var3 / 10.0F + (this.blue[(var1 + 0 & tileSizeMask) + (var2 + 0 & tileSizeMask) * tileSizeBase] + this.blue[(var1 + 1 & tileSizeMask) + (var2 + 0 & tileSizeMask) * tileSizeBase] + this.blue[(var1 + 1 & tileSizeMask) + (var2 + 1 & tileSizeMask) * tileSizeBase] + this.blue[(var1 + 0 & tileSizeMask) + (var2 + 1 & tileSizeMask) * tileSizeBase]) / 4.0F * 0.8F;
                this.blue[var1 + var2 * tileSizeBase] += this.alpha[var1 + var2 * tileSizeBase] * 0.01F;

                if (this.blue[var1 + var2 * tileSizeBase] < 0.0F)
                {
                    this.blue[var1 + var2 * tileSizeBase] = 0.0F;
                }

                this.alpha[var1 + var2 * tileSizeBase] -= 0.06F;

                if (Math.random() < 0.005D)
                {
                    this.alpha[var1 + var2 * tileSizeBase] = 1.5F;
                }
            }
        }

        float[] var11 = this.green;
        this.green = this.red;
        this.red = var11;

        for (var2 = 0; var2 < tileSizeSquare; ++var2)
        {
            var3 = this.red[(var2 - this.tickCounter / 3 * tileSizeBase) & tileSizeSquareMask] * 2.0F;

            if (var3 > 1.0F)
            {
                var3 = 1.0F;
            }

            if (var3 < 0.0F)
            {
                var3 = 0.0F;
            }

            var5 = (int)(var3 * 100.0F + 155.0F);
            var6 = (int)(var3 * var3 * 255.0F);
            var7 = (int)(var3 * var3 * var3 * var3 * 128.0F);

            if (this.anaglyphEnabled)
            {
                var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
                var9 = (var5 * 30 + var6 * 70) / 100;
                int var10 = (var5 * 30 + var7 * 70) / 100;
                var5 = var8;
                var6 = var9;
                var7 = var10;
            }

            this.imageData[var2 * 4 + 2] = (byte)var5;
            this.imageData[var2 * 4 + 0] = (byte)var6;
            this.imageData[var2 * 4 + 1] = (byte)var7;
            this.imageData[var2 * 4 + 3] = -1;
        }
    }
    
	@Override
    public void bindImage(RenderEngine par1RenderEngine)
    {
        if (this.tileImage == 0)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1RenderEngine.getTexture(CommonProxy.BLOCK_PNG));
        }
        else if (this.tileImage == 1)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1RenderEngine.getTexture(CommonProxy.ITEMS_PNG));
        }
    }
}
