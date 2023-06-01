package com.github.devotedmc.hiddenore;

import java.util.ArrayList;
import java.util.List;

import com.mineinabyss.blocky.api.BlockyBlocks;
import com.mineinabyss.geary.papermc.datastore.DataStoreKt;
import com.mineinabyss.geary.prefabs.PrefabKey;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.eclipse.sisu.inject.Logs;

public class DropItemConfig {
	private ItemStack template;
	private boolean canTransform;
	
	public DropItemConfig(ItemStack template) {
		this.template = template;
		PrefabKey key = DataStoreKt.decodePrefabs(template.getItemMeta().getPersistentDataContainer()).stream().findFirst().orElse(null);
		this.canTransform = (key != null && BlockyBlocks.INSTANCE.isBlockyBlock(key)) || template.getType().isBlock();
	}
	
	public boolean canTransform() {
		if (canTransform) return true;
		else {
			PrefabKey key = DataStoreKt.decodePrefabs(template.getItemMeta().getPersistentDataContainer()).stream().findFirst().orElse(null);
			if (key != null) {
				return BlockyBlocks.INSTANCE.isBlockyBlock(key);
			}
		}
		return canTransform;
	}
	
	public ItemStack render(double multiplier) {
		ItemStack is = template.clone();
		is.setAmount((int) Math.round((double) is.getAmount() * multiplier));
		if (is.getAmount() > is.getMaxStackSize()) {
			is.setAmount(is.getMaxStackSize());
		}
		return is;
	}
	
	public static List<DropItemConfig> transform(List<ItemStack> items) {
		ArrayList<DropItemConfig> drops = new ArrayList<DropItemConfig>(items.size());
		for (ItemStack item : items) {
			if (item != null) {
				drops.add(new DropItemConfig(item));
			}
		}
		
		return drops;
	}
}
