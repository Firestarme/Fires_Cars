package firestarme.fires_cars.common;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Render;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCar extends Render
{
    /** instance of ModelCar for rendering */
    
    private ModelCar model;

    public RenderCar()
    {
        this.shadowSize = 0.5F;
        this.model = new ModelCar();
    }
    

    /**
     * The render method used in RenderCar that renders the car model.
     */
    public void renderCar(EntityCar par1EntityCar, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
        
        float var12 = 0.75F;
        GL11.glScalef(var12, var12, var12);
        GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
        GL11.glScalef(2F,2F,2F);
        this.loadTexture("/firestarme/fires_cars/CarTexture.png");
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.model.render(par1EntityCar, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 1/16F);
        GL11.glPopMatrix();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCar((EntityCar)par1Entity, par2, par4, par6, par8, par9);
    }
}
