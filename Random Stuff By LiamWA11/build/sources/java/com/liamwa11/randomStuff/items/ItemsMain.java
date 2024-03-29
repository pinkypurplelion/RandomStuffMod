package com.liamwa11.randomStuff.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.liamwa11.randomStuff.RandomStuffMain;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsMain extends RandomStuffMain{

	 public static CreativeTabs itemsTab = new CreativeTabs("itemsTab"){
	    	public Item getTabIconItem(){
			return gemRuby;}
	    };
	    
	 public static CreativeTabs toolsTab = new CreativeTabs("toolsTab"){
		 public Item getTabIconItem(){
			 return pickaxeRuby;}
		 };
	 
	    
	 public static Item gemRuby;
	 public static Item shovelRuby;
	 public static Item pickaxeRuby;
	 public static Item axeRuby;
	 
	 public static void loadItems(){
		 
		 gemRuby = new Item().setCreativeTab(itemsTab).setUnlocalizedName("gemRuby").setTextureName(modid + ":" + "ruby");
		 GameRegistry.registerItem(gemRuby, "Gem Ruby");
		 
		 //ITEM + RECIPE
		 shovelRuby = new CustomShovel(MATERIALgemRuby).setUnlocalizedName("shovelRuby").setCreativeTab(toolsTab).setTextureName(modid + ":" + "shovelRuby");
		 GameRegistry.registerItem(shovelRuby, "shovelRuby");
		 GameRegistry.addRecipe(new ItemStack(shovelRuby), new Object[]{
				"A","B","B", 'A', gemRuby, 'B', Items.stick
		 });
		 
		 pickaxeRuby = new CustomPickaxe(MATERIALgemRuby).setUnlocalizedName("pickaxeRuby").setCreativeTab(toolsTab).setTextureName(modid + ":" + "pickaxeRuby");
		 GameRegistry.registerItem(pickaxeRuby, "pickaxeRuby");
		 GameRegistry.addRecipe(new ItemStack(pickaxeRuby), new Object[]{
			 "AAA", " B ", " B ", 'A', gemRuby, 'B', Items.stick
		 });
		 
		 axeRuby = new CustomAxe(MATERIALgemRuby).setUnlocalizedName("axeRuby").setCreativeTab(toolsTab).setTextureName(modid + ":" + "axeRuby");
		 GameRegistry.registerItem(axeRuby, "axeRuby");
		 GameRegistry.addRecipe(new ItemStack(axeRuby), new Object[]{
			 "AA ", "AB ", " B ", 'A', gemRuby, 'B', Items.stick
		 });
		 GameRegistry.addRecipe(new ItemStack(axeRuby), new Object[]{
		     " AA", " BA", " B ", 'A', gemRuby, 'B', Items.stick
		 });
	 }
	    
	
}
