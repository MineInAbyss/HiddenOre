package com.github.devotedmc.hiddenore;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class BlockConfig {
	public Set<Byte> subtypes;
	public boolean dropMultiple;
	private Map<String, DropConfig> dropConfigs;
	private String prefix;
	
	public BlockConfig(boolean dropMultiple, String prefix) {
		this(null, dropMultiple, prefix);
	}
	
	public BlockConfig(Collection<Byte> subtype, boolean dropMultiple, String prefix) {
		this.subtypes = (subtype != null) ? new HashSet<Byte>(subtype) : new HashSet<Byte>();
		this.dropMultiple = dropMultiple;
		this.dropConfigs = new HashMap<String, DropConfig>();
		this.prefix = prefix;
	}
	
	public boolean checkSubType(Byte subtype) {
		return this.subtypes.isEmpty() || this.subtypes.contains(subtype);
	}
	
	public String getPrefix(String drop) {
		if (drop == null) return prefix;
		DropConfig dc = dropConfigs.get(drop);
		return (dc == null || dc.prefix == null) ? prefix : dc.prefix;
	}
	
	public boolean hasCustomPrefix(String drop) {
		if (drop == null) return false;
		DropConfig dc = dropConfigs.get(drop);
		return (dc == null || dc.prefix == null) ? (prefix != null) : true;
	}
	
	public void addDropConfig(String drop, DropConfig dropConfig) {
		dropConfigs.put(drop, dropConfig);
	}
	
	public Set<String> getDrops() {
		return dropConfigs.keySet();
	}
	
	public DropConfig getDropConfig(String drop) {
		return dropConfigs.get(drop);
	}
	
	public String getDropConfig(double dice, String biome, String tool, int blockY) {
		// accrue possible drops based on biome / tool
		// check dice against stacked probabilities
		
		double cumChance = 0.0d;
		double localChance = 0.0d;
		int counted = 0;
		
		for (Map.Entry<String, DropConfig> dc : dropConfigs.entrySet()) {
			if (dc.getValue().dropsWithTool(biome, tool) && blockY <= dc.getValue().getMaxY(biome) && 
					blockY >= dc.getValue().getMinY(biome)) {
				localChance = dc.getValue().getChance(biome);
				if (dice >= cumChance && dice < cumChance + localChance) {
					return dc.getKey();
				}
				cumChance += localChance;
				counted ++;
			}
		}
		if (Config.isDebug) {
			HiddenOre.getPlugin().getLogger().log(Level.INFO, "{0} tested {1} cumm {2} dice",
					new Object[]{counted, cumChance, dice});
		}
		
		return null;
	}
}