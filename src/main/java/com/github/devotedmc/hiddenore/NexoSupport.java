package com.github.devotedmc.hiddenore;

import com.nexomc.nexo.api.NexoBlocks;
import com.nexomc.nexo.mechanics.custom_block.CustomBlockMechanic;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.BlockData;

/**
 * Nexo identifies items and blocks by a flat lowercase id with no namespace, while HiddenOre keys every
 * configured block by NamespacedKey. Nexo ids are therefore held under a reserved "nexo" namespace,
 * which can never collide with a vanilla material key.
 */
public final class NexoSupport {
	public static final String NAMESPACE = "nexo";

	private NexoSupport() {
	}

	/**
	 * @return the key a Nexo item id is stored under, or null if the id is blank or not a legal key
	 */
	public static NamespacedKey keyOf(String itemId) {
		if (itemId == null || itemId.isBlank()) return null;
		return NamespacedKey.fromString(NAMESPACE + ":" + itemId.toLowerCase());
	}

	public static boolean isNexoKey(NamespacedKey key) {
		return key != null && NAMESPACE.equals(key.getNamespace());
	}

	/**
	 * @return the Nexo item id a key refers to, or null if the key is not a Nexo one
	 */
	public static String idOf(NamespacedKey key) {
		return isNexoKey(key) ? key.getKey() : null;
	}

	/**
	 * @return the key of the Nexo block this data belongs to, or null if it is not a Nexo block
	 */
	public static NamespacedKey keyOf(BlockData data) {
		if (data == null) return null;
		CustomBlockMechanic mechanic = NexoBlocks.customBlockMechanic(data);
		return mechanic == null ? null : keyOf(mechanic.getItemID());
	}
}
