package net.prug.prugutilexample;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.*;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.explosion.Explosion.DestructionType;
import net.prug.prugutils.main.*;

public class PrugUtilExample implements ModInitializer {

	//creates an explosive block thats twice as explosive as tnt and breaks and not destory item drops
	public static final ConfigurableExplosiveBlock MINING_CHARGE = new ConfigurableExplosiveBlock(
			FabricBlockSettings.of(Material.METAL).hardness(4.0f), 8.0f, false, DestructionType.BREAK);

	//creates a basic item called player protection equipment [maybe we can create a class for an item with a tooltip]
	public static final Item PLAYERPROTEKEQU = new Item(new Item.Settings().group(PrugUtilExample.HMORINBLOCKS));

	//creates a drinkable called soda that gives speed (id 1) and slowness (id 2) for 200 ticks with a multiplyer of 0
	public static final ConfigurableDrinkableEffectType SPEEDSODA = new ConfigurableDrinkableEffectType(
			new Item.Settings().group(PrugUtilExample.HMORINBLOCKS), StatusEffect.byRawId(1), 200, 0,
			StatusEffect.byRawId(2), 200, 0, PrugUtilExample.MINING_CHARGE);


	public static final ItemGroup HMORINBLOCKS = FabricItemGroupBuilder
			.create(new Identifier("prugutilexample", "prugblocks"))
			.icon(() -> new ItemStack(PrugUtilExample.MINING_CHARGE)).appendItems(stacks -> {
				stacks.add(new ItemStack(PrugUtilExample.MINING_CHARGE));
				stacks.add(new ItemStack(PrugUtilExample.PLAYERPROTEKEQU));
				stacks.add(new ItemStack(PrugUtilExample.SPEEDSODA));
			}).build();
			
	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("prugutilexample", "miningcharge"), MINING_CHARGE);
		Registry.register(Registry.ITEM, new Identifier("prugutilexample", "miningcharge"),
				new BlockItem(MINING_CHARGE, new Item.Settings().group(PrugUtilExample.HMORINBLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("prugutilexample", "player_protek_equ"), PLAYERPROTEKEQU);
		Registry.register(Registry.ITEM, new Identifier("prugutilexample", "soda_speed"), SPEEDSODA);
	}
	
}


