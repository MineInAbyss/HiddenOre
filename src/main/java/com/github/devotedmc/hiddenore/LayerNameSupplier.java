package com.github.devotedmc.hiddenore;

import com.mineinabyss.components.layer.Layer;
import org.bukkit.Location;

import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface LayerNameSupplier {
	LayerNameSupplier NOOP_LAYER_ITERATOR = (location) -> null;

	String getLayerForLocation(Location location);
}
