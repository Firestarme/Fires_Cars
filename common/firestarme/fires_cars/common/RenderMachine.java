
	package firestarme.fires_cars.common;


	import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Render;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

	@SideOnly(Side.CLIENT)
	public class RenderMachine extends TileEntitySpecialRenderer
	{

		int ModelMeta = 0;
	    private ModelDerrik modelDerrik; 

	    public RenderMachine()
	    {
	    	modelDerrik = new ModelDerrik();
	    	
	    } 

	    public void renderAModelAt(TileEntity tile, double d, double d1, double d2, float f)
	    {

	    if(tile.worldObj != null) 
	    {
	    
	    	ModelMeta =(tile.worldObj.getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord));
	    	
	    	this.bindTextureByName("/firestarme/common/Derrik.png");
	    }
	    
	    
	    GL11.glPushMatrix();
	    GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
	    GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
	    GL11.glScalef(1.0F, -1F, -1F); 
	   switch(ModelMeta)
	   {
	   case 0 :
	    modelDerrik.renderModel(1/4F); 
	    break;
	   }
	    GL11.glPopMatrix();

	    }
	    



	    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	    {
	    renderAModelAt((TileEntityMachine) tileentity, d, d1, d2, f);
	    }

	    }

	    


