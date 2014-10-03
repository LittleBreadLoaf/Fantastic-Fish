package fantastic.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import fantastic.FantasticInfo;
import fantastic.tiles.ContainerLobsterPot;
import fantastic.tiles.TileLobsterPot;

public class GuiLobsterPot extends GuiContainer {

        public GuiLobsterPot (InventoryPlayer inventoryPlayer,
                        TileLobsterPot tileEntity) {
                //the container is instanciated and passed to the superclass for handling
                super(new ContainerLobsterPot(inventoryPlayer, tileEntity));
        }
        private static final ResourceLocation texture = new ResourceLocation(FantasticInfo.ID.toLowerCase(), "textures/guis/lobster_pot_gui.png");

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {

            	FontRenderer var8 = this.mc.fontRenderer;
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                var8.drawString("Lobster Pot", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                var8.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
        	this.mc.getTextureManager().bindTexture(texture);
                //draw your Gui here, only thing you need to change is the path
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}