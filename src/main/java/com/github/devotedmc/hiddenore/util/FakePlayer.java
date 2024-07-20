package com.github.devotedmc.hiddenore.util;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.entity.LookAnchor;
import io.papermc.paper.entity.TeleportFlag;
import io.papermc.paper.math.Position;
import io.papermc.paper.threadedregions.scheduler.EntityScheduler;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.util.TriState;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.sign.Side;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.inventory.InventoryCloseEvent.Reason;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.*;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.*;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class FakePlayer implements Player {
	private final ItemStack inHand;
	private final Location location;

	public FakePlayer(final Location location, final ItemStack inHand) {
		this.inHand = inHand;
		this.location = location;
	}

	@Override
	public String getName() {
		return "Spoof";
	}

	@Override
	public PlayerInventory getInventory() {
		return new PlayerInventory() {

			@Override
			public int getSize() {
				return 0;
			}

			@Override
			public int getMaxStackSize() {
				return 0;
			}

			@Override
			public void setMaxStackSize(int size) {
			}

			@Override
			public ItemStack getItem(int index) {
				return null;
			}

			@Override
			public HashMap<Integer, ItemStack> addItem(ItemStack...items) throws IllegalArgumentException {
				return null;
			}

			@Override
			public HashMap<Integer, ItemStack> removeItem(ItemStack...items) throws IllegalArgumentException {
				return null;
			}

			@Override
			public ItemStack[] getContents() {
				return null;
			}

			@Override
			public void setContents(ItemStack[] items) throws IllegalArgumentException {
			}

			@Override
			public ItemStack[] getStorageContents() {
				return null;
			}

			@Override
			public void setStorageContents(ItemStack[] items) throws IllegalArgumentException {
			}

			@Override
			public boolean contains(Material material) throws IllegalArgumentException {
				return false;
			}

			@Override
			public boolean contains(ItemStack item) {
				return false;
			}

			@Override
			public boolean contains(Material material, int amount) throws IllegalArgumentException {
				return false;
			}

			@Override
			public boolean contains(ItemStack item, int amount) {
				return false;
			}

			@Override
			public boolean containsAtLeast(ItemStack item, int amount) {
				return false;
			}

			@Override
			public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
				return null;
			}

			@Override
			public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
				return null;
			}

			@Override
			public int first(Material material) throws IllegalArgumentException {
				return 0;
			}

			@Override
			public int first(ItemStack item) {
				return 0;
			}

			@Override
			public int firstEmpty() {
				return 0;
			}

			@Override
			public void remove(Material material) throws IllegalArgumentException {
			}

			@Override
			public void remove(ItemStack item) {
			}

			@Override
			public void clear(int index) {
			}

			@Override
			public void clear() {
			}

			/**
			 * Closes the inventory for all viewers.
			 *
			 * @return the number if viewers the inventory was closed for
			 */
			@Override
			public int close() {
				return 0;
			}

			@Override
			public List<HumanEntity> getViewers() {
				return null;
			}

			@Override
			public InventoryType getType() {
				return null;
			}

			@Override
			public ListIterator<ItemStack> iterator() {
				return null;
			}

			@Override
			public ListIterator<ItemStack> iterator(int index) {
				return null;
			}

			@Override
			public Location getLocation() {
				return location;
			}

			@Override
			public ItemStack[] getArmorContents() {
				return null;
			}

			@Override
			public ItemStack[] getExtraContents() {
				return null;
			}

			@Override
			public ItemStack getHelmet() {
				return null;
			}

			@Override
			public ItemStack getChestplate() {
				return null;
			}

			@Override
			public ItemStack getLeggings() {
				return null;
			}

			@Override
			public ItemStack getBoots() {
				return null;
			}

			@Override
			public void setItem(int index, ItemStack item) {
			}

			@Override
			public void setArmorContents(ItemStack[] items) {
			}

			@Override
			public void setExtraContents(ItemStack[] items) {
			}

			@Override
			public void setHelmet(ItemStack helmet) {
			}

			@Override
			public void setChestplate(ItemStack chestplate) {
			}

			@Override
			public void setLeggings(ItemStack leggings) {
			}

			@Override
			public void setBoots(ItemStack boots) {
			}

			@Override
			public ItemStack getItemInMainHand() {
				return inHand;
			}

			@Override
			public void setItemInMainHand(ItemStack item) {
			}

			@Override
			public ItemStack getItemInOffHand() {
				return null;
			}

			@Override
			public void setItemInOffHand(ItemStack item) {
			}

			@Override
			public ItemStack getItemInHand() {
				return inHand;
			}

			@Override
			public void setItemInHand(ItemStack stack) {
			}

			@Override
			public int getHeldItemSlot() {
				return 0;
			}

			@Override
			public void setHeldItemSlot(int slot) {
			}

			@Override
			public HumanEntity getHolder() {
				return null;
			}

			@Override
			public void setItem(EquipmentSlot slot, ItemStack item) {
			}

			@Override
			public ItemStack getItem(EquipmentSlot slot) {
				return null;
			}

			@Override
			public InventoryHolder getHolder(boolean arg0) {
				return null;
			}

			@Override
			public boolean isEmpty() {
				return true;
			}

			@Override
			public HashMap<Integer, ItemStack> removeItemAnySlot(ItemStack... arg0) throws IllegalArgumentException {
				return null;
			}
		};
	}

	@Override
	public Inventory getEnderChest() {
		return null;
	}

	@Override
	public MainHand getMainHand() {
		return null;
	}

	@Override
	public boolean setWindowProperty(Property prop, int value) {
		return false;
	}

	@Override
	public int getEnchantmentSeed() {
		return 0;
	}

	@Override
	public void setEnchantmentSeed(int seed) {

	}

	@Override
	public InventoryView getOpenInventory() {
		return null;
	}

	@Override
	public InventoryView openInventory(Inventory inventory) {
		return null;
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean force) {
		return null;
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean force) {
		return null;
	}

	@Override
	public void openInventory(InventoryView inventory) {
	}

	@Override
	public InventoryView openMerchant(Villager trader, boolean force) {
		return null;
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public ItemStack getItemInHand() {
		return inHand;
	}

	@Override
	public void setItemInHand(ItemStack item) {
	}

	@Override
	public ItemStack getItemOnCursor() {
		return null;
	}

	@Override
	public void setItemOnCursor(ItemStack item) {
	}

	@Override
	public boolean isSleeping() {
		return false;
	}

	/**
	 * Gets if the entity is climbing.
	 *
	 * @return if the entity is climbing
	 */
	@Override
	public boolean isClimbing() {
		return false;
	}

	@Override
	public int getSleepTicks() {
		return 0;
	}

	@Override
	public GameMode getGameMode() {
		return null;
	}

	@Override
	public void setGameMode(GameMode mode) {
	}

	@Override
	public boolean isBlocking() {
		return false;
	}

	@Override
	public int getExpToLevel() {
		return 0;
	}

	@Override
	public double getEyeHeight() {
		return 0;
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		return 0;
	}

	@Override
	public Location getEyeLocation() {
		return location;
	}

	@Override
	public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
		return null;
	}

	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		return null;
	}

	@Override
	public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
		return null;
	}

	@Override
	public @Nullable Block getTargetBlock(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
		return null;
	}

	@Override
	public @Nullable BlockFace getTargetBlockFace(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
		return null;
	}

	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
		return null;
	}

	@Override
	public int getRemainingAir() {
		return 0;
	}

	@Override
	public void setRemainingAir(int ticks) {
	}

	@Override
	public int getMaximumAir() {
		return 0;
	}

	@Override
	public void setMaximumAir(int ticks) {
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
	}

	@Override
	public double getLastDamage() {
		return 0;
	}

	@Override
	public void setLastDamage(double damage) {

	}

	@Override
	public int getNoDamageTicks() {

		return 0;
	}

	@Override
	public void setNoDamageTicks(int ticks) {

	}

	@Override
	public int getNoActionTicks() {
		return 0;
	}

	@Override
	public void setNoActionTicks(int ticks) {

	}

	@Override
	public Player getKiller() {

		return null;
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect) {

		return false;
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect, boolean force) {

		return false;
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> effects) {

		return false;
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType type) {

		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType type) {

	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {

		return null;
	}

	@Override
	public boolean clearActivePotionEffects() {
		return false;
	}

	@Override
	public boolean hasLineOfSight(Entity other) {

		return false;
	}

	/**
	 * Checks whether the living entity has block line of sight to the given block.
	 * <p>
	 * This uses the same algorithm that hostile mobs use to find the closest
	 * player.
	 *
	 * @param location the location to determine line of sight to
	 * @return true if there is a line of sight, false if not
	 */
	@Override
	public boolean hasLineOfSight(@NotNull Location location) {
		return false;
	}

	@Override
	public boolean getRemoveWhenFarAway() {

		return false;
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove) {

	}

	@Override
	public EntityEquipment getEquipment() {

		return null;
	}

	@Override
	public void setCanPickupItems(boolean pickup) {

	}

	@Override
	public boolean getCanPickupItems() {

		return false;
	}

	@Override
	public boolean isLeashed() {

		return false;
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {

		return null;
	}

	@Override
	public boolean setLeashHolder(Entity holder) {

		return false;
	}

	@Override
	public boolean isGliding() {

		return false;
	}

	@Override
	public void setGliding(boolean gliding) {

	}

	@Override
	public void setAI(boolean ai) {

	}

	@Override
	public boolean hasAI() {

		return false;
	}

	@Override
	public void setCollidable(boolean collidable) {

	}

	@Override
	public boolean isCollidable() {

		return false;
	}

	@Override
	public AttributeInstance getAttribute(Attribute attribute) {

		return null;
	}

	/**
	 * Registers a generic attribute to that attributable instance.
	 * Allows it to add attributes not registered by default to that entity.
	 *
	 * @param attribute the generic attribute to register
	 */
	@Override
	public void registerAttribute(@NotNull Attribute attribute) {

	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public Location getLocation(Location loc) {
		return location;
	}

	@Override
	public void setVelocity(Vector velocity) {

	}

	@Override
	public Vector getVelocity() {

		return null;
	}

	@Override
	public World getWorld() {
		return location.getWorld();
	}

	@Override
	public boolean teleport(Location location) {

		return false;
	}

	@Override
	public boolean teleport(Location location, TeleportCause cause) {

		return false;
	}

	@Override
	public boolean teleport(Entity destination) {

		return false;
	}

	@Override
	public boolean teleport(Entity destination, TeleportCause cause) {

		return false;
	}

	@Override
	public @NotNull CompletableFuture<Boolean> teleportAsync(@NotNull Location loc, @NotNull PlayerTeleportEvent.TeleportCause cause, @NotNull TeleportFlag @NotNull ... teleportFlags) {
		return null;
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {

		return null;
	}

	@Override
	public int getEntityId() {

		return 0;
	}

	@Override
	public int getFireTicks() {

		return 0;
	}

	@Override
	public int getMaxFireTicks() {

		return 0;
	}

	@Override
	public void setFireTicks(int ticks) {

	}

	/**
	 * Sets if the entity has visual fire (it will always appear to be on fire).
	 *
	 * @param fire whether visual fire is enabled
	 */
	@Override
	public void setVisualFire(boolean fire) {

	}

	/**
	 * Gets if the entity has visual fire (it will always appear to be on fire).
	 *
	 * @return whether visual fire is enabled
	 */
	@Override
	public boolean isVisualFire() {
		return false;
	}

	/**
	 * Returns the entity's current freeze ticks (amount of ticks the entity has
	 * been in powdered snow).
	 *
	 * @return int freeze ticks
	 */
	@Override
	public int getFreezeTicks() {
		return 0;
	}

	/**
	 * Returns the entity's maximum freeze ticks (amount of ticks before it will
	 * be fully frozen)
	 *
	 * @return int max freeze ticks
	 */
	@Override
	public int getMaxFreezeTicks() {
		return 0;
	}

	/**
	 * Sets the entity's current freeze ticks (amount of ticks the entity has
	 * been in powdered snow).
	 *
	 * @param ticks Current ticks
	 */
	@Override
	public void setFreezeTicks(int ticks) {

	}

	/**
	 * Gets if the entity is fully frozen (it has been in powdered snow for max
	 * freeze ticks).
	 *
	 * @return freeze status
	 */
	@Override
	public boolean isFrozen() {
		return false;
	}

	@Override
	public boolean isFreezeTickingLocked() {
		return false;
	}

	@Override
	public void lockFreezeTicks(boolean locked) {

	}

	@Override
	public void remove() {

	}

	@Override
	public boolean isDead() {

		return false;
	}

	@Override
	public boolean isValid() {

		return false;
	}

	@Override
	public Server getServer() {

		return null;
	}

	@Override
	public Entity getPassenger() {

		return null;
	}

	@Override
	public boolean setPassenger(Entity passenger) {

		return false;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public boolean eject() {

		return false;
	}

	@Override
	public float getFallDistance() {

		return 0;
	}

	@Override
	public void setFallDistance(float distance) {

	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {

	}

	@Override
	public EntityDamageEvent getLastDamageCause() {

		return null;
	}

	@Override
	public UUID getUniqueId() {

		return null;
	}

	@Override
	public int getTicksLived() {

		return 0;
	}

	@Override
	public void setTicksLived(int value) {

	}

	@Override
	public void playEffect(EntityEffect type) {

	}

	@Override
	public EntityType getType() {

		return null;
	}

	@Override
	public @NotNull Sound getSwimSound() {
		return null;
	}

	@Override
	public @NotNull Sound getSwimSplashSound() {
		return null;
	}

	@Override
	public @NotNull Sound getSwimHighSpeedSplashSound() {
		return null;
	}

	@Override
	public boolean isInsideVehicle() {

		return false;
	}

	@Override
	public boolean leaveVehicle() {

		return false;
	}

	@Override
	public Entity getVehicle() {

		return null;
	}

	@Override
	public void setCustomName(String name) {

	}

	/**
	 * Gets the custom name.
	 *
	 * <p>This value has no effect on players, they will always use their real name.</p>
	 *
	 * @return the custom name
	 */
	@Override
	public @Nullable Component customName() {
		return null;
	}

	/**
	 * Sets the custom name.
	 *
	 * <p>This name will be used in death messages and can be sent to the client as a nameplate over the mob.</p>
	 *
	 * <p>Setting the name to {@code null} will clear it.</p>
	 *
	 * <p>This value has no effect on players, they will always use their real name.</p>
	 *
	 * @param customName the custom name to set
	 */
	@Override
	public void customName(@Nullable Component customName) {

	}

	@Override
	public String getCustomName() {

		return "Spoof";
	}

	@Override
	public void setCustomNameVisible(boolean flag) {

	}

	@Override
	public boolean isCustomNameVisible() {

		return false;
	}

	@Override
	public void setVisibleByDefault(boolean visible) {

	}

	@Override
	public boolean isVisibleByDefault() {
		return false;
	}

	@Override
	public @NotNull Set<Player> getTrackedBy() {
		return null;
	}

	@Override
	public void setGlowing(boolean flag) {

	}

	@Override
	public boolean isGlowing() {

		return false;
	}

	@Override
	public void setInvulnerable(boolean flag) {

	}

	@Override
	public boolean isInvulnerable() {

		return false;
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {

		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {

		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {

	}

	@Override
	public void sendMessage(String message) {

	}

	@Override
	public void sendMessage(String[] messages) {

	}

	@Override
	public boolean isPermissionSet(String name) {

		return false;
	}

	@Override
	public boolean isPermissionSet(Permission perm) {

		return false;
	}

	@Override
	public boolean hasPermission(String name) {

		return false;
	}

	@Override
	public boolean hasPermission(Permission perm) {

		return false;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {

		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {

	}

	@Override
	public void recalculatePermissions() {

	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {

		return null;
	}

	@Override
	public boolean isOp() {

		return false;
	}

	@Override
	public void setOp(boolean value) {

	}

	@Override
	public void damage(double amount) {

	}

	@Override
	public void damage(double amount, Entity source) {

	}

	@Override
	public void damage(double amount, @NotNull DamageSource damageSource) {

	}

	@Override
	public double getHealth() {

		return 0;
	}

	@Override
	public void setHealth(double health) {

	}

	@Override
	public void heal(double v, @NotNull EntityRegainHealthEvent.RegainReason regainReason) {

	}

	@Override
	public double getMaxHealth() {

		return 0;
	}

	@Override
	public void setMaxHealth(double health) {

	}

	@Override
	public void resetMaxHealth() {

	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {

		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {

		return null;
	}

	@Override
	public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> projectile, @Nullable Vector velocity, java.util.function.@Nullable Consumer<? super T> function) {
		return null;
	}

	@Override
	public boolean isConversing() {

		return false;
	}

	@Override
	public void acceptConversationInput(String input) {

	}

	@Override
	public boolean beginConversation(Conversation conversation) {

		return false;
	}

	@Override
	public void abandonConversation(Conversation conversation) {

	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {

	}

	@Override
	public boolean isOnline() {

		return false;
	}

	@Override
	public boolean isConnected() {
		return false;
	}

	@Override
	public boolean isBanned() {

		return false;
	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Date expires, @Nullable String source) {
		return null;
	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Instant expires, @Nullable String source) {
		return null;
	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Duration duration, @Nullable String source) {
		return null;
	}

	@Override
	public boolean isWhitelisted() {

		return false;
	}

	@Override
	public void setWhitelisted(boolean value) {

	}

	@Override
	public Player getPlayer() {

		return null;
	}

	@Override
	public long getFirstPlayed() {

		return 0;
	}

	@Override
	public long getLastPlayed() {

		return 0;
	}

	@Override
	public boolean hasPlayedBefore() {

		return false;
	}

	@Override
	public Map<String, Object> serialize() {

		return null;
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {

	}

	@Override
	public Set<String> getListeningPluginChannels() {

		return null;
	}

	@Override
	public @NotNull Identity identity() {
		return Player.super.identity();
	}

	@Override
	public @UnmodifiableView @NotNull Iterable<? extends BossBar> activeBossBars() {
		return null;
	}

	/**
	 * Gets the "friendly" name to display of this player.
	 *
	 * @return the display name
	 */
	@Override
	public @NotNull Component displayName() {
		return null;
	}

	/**
	 * Sets the "friendly" name to display of this player.
	 *
	 * @param displayName the display name to set
	 */
	@Override
	public void displayName(@Nullable Component displayName) {

	}

	@Override
	public String getDisplayName() {
		return "Spoof";
	}

	@Override
	public void setDisplayName(String name) {

	}

	/**
	 * Sets the name that is shown on the in-game player list.
	 * <p>
	 * If the value is null, the name will be identical to {@link #getName()}.
	 *
	 * @param name new player list name
	 */
	@Override
	public void playerListName(@Nullable Component name) {

	}

	/**
	 * Gets the name that is shown on the in-game player list.
	 *
	 * @return the player list name
	 */
	@Override
	public @NotNull Component playerListName() {
		return null;
	}

	/**
	 * Gets the currently displayed player list header for this player.
	 *
	 * @return player list header or null
	 */
	@Override
	public @Nullable Component playerListHeader() {
		return null;
	}

	/**
	 * Gets the currently displayed player list footer for this player.
	 *
	 * @return player list footer or null
	 */
	@Override
	public @Nullable Component playerListFooter() {
		return null;
	}

	@Override
	public String getPlayerListName() {
		return "Spoof";
	}

	@Override
	public void setPlayerListName(String name) {

	}

	@Override
	public void setCompassTarget(Location loc) {

	}

	@Override
	public Location getCompassTarget() {

		return null;
	}

	@Override
	public InetSocketAddress getAddress() {

		return null;
	}

	@Override
	public @Nullable InetSocketAddress getHAProxyAddress() {
		return null;
	}

	@Override
	public boolean isTransferred() {
		return false;
	}

	@Override
	public @NotNull CompletableFuture<byte[]> retrieveCookie(@NotNull NamespacedKey key) {
		return null;
	}

	@Override
	public void storeCookie(@NotNull NamespacedKey key, @NotNull byte[] value) {

	}

	@Override
	public void transfer(@NotNull String host, int port) {

	}

	@Override
	public void sendRawMessage(String message) {

	}

	@Override
	public void kickPlayer(String message) {

	}

	@Override
	public void kick() {

	}

	/**
	 * Kicks player with custom kick message.
	 *
	 * @param message kick message
	 */
	@Override
	public void kick(@Nullable Component message) {

	}

	/**
	 * Kicks player with custom kick message and cause.
	 *
	 * @param message kick message
	 * @param cause   kick cause
	 */
	@Override
	public void kick(@Nullable Component message, PlayerKickEvent.@NotNull Cause cause) {

	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Instant expires, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String reason, @Nullable Duration duration, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Date expires, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Instant expires, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public @Nullable BanEntry<InetAddress> banIp(@Nullable String reason, @Nullable Duration duration, @Nullable String source, boolean kickPlayer) {
		return null;
	}

	@Override
	public void chat(String msg) {

	}

	@Override
	public boolean performCommand(String command) {

		return false;
	}

	@Override
	public boolean isSneaking() {

		return false;
	}

	@Override
	public void setSneaking(boolean sneak) {

	}

	@Override
	public void setPose(@NotNull Pose pose, boolean fixed) {

	}

	@Override
	public boolean hasFixedPose() {
		return false;
	}

	@Override
	public boolean isSprinting() {

		return false;
	}

	@Override
	public void setSprinting(boolean sprinting) {

	}

	@Override
	public void saveData() {

	}

	@Override
	public void loadData() {

	}

	@Override
	public void setSleepingIgnored(boolean isSleeping) {

	}

	@Override
	public boolean isSleepingIgnored() {

		return false;
	}

	@Override
	public void playNote(Location loc, byte instrument, byte note) {

	}

	@Override
	public void playNote(Location loc, Instrument instrument, Note note) {

	}

	@Override
	public void playSound(Location location, Sound sound, float volume, float pitch) {

	}

	@Override
	public void playSound(Location location, String sound, float volume, float pitch) {

	}

	@Override
	public void playEffect(Location loc, Effect effect, int data) {

	}

	@Override
	public <T> void playEffect(Location loc, Effect effect, T data) {

	}

	/**
	 * Force this player to break a Block using the item in their main hand.
	 * <p>
	 * This method will respect enchantments, handle item durability (if
	 * applicable) and drop experience and the correct items according to the
	 * tool/item in the player's hand.
	 * <p>
	 * Note that this method will call a {@link BlockBreakEvent}, meaning that
	 * this method may not be successful in breaking the block if the event was
	 * cancelled by a third party plugin. Care should be taken if running this
	 * method in a BlockBreakEvent listener as recursion may be possible if it
	 * is invoked on the same {@link Block} being broken in the event.
	 * <p>
	 * Additionally, a {@link BlockDropItemEvent} is called for the items
	 * dropped by this method (if successful).
	 * <p>
	 * The block must be in the same world as the player.
	 *
	 * @param block the block to break
	 * @return true if the block was broken, false if the break failed
	 */
	@Override
	public boolean breakBlock(@NotNull Block block) {
		return false;
	}

	@Override
	public void sendBlockChange(Location loc, Material material, byte data) {

	}


	/**
	 * Send a sign change. This fakes a sign change packet for a user at
	 * a certain location. This will not actually change the world in any way.
	 * This method will use a sign at the location's block or a faked sign
	 * sent via
	 * {@link #sendBlockChange(Location, Material, byte)}.
	 * <p>
	 * If the client does not have a sign at the given location it will
	 * display an error message to the user.
	 *
	 * @param loc   the location of the sign
	 * @param lines the new text on the sign or null to clear it
	 * @throws IllegalArgumentException if location is null
	 * @throws IllegalArgumentException if lines is non-null and has a length less than 4
	 */
	@Override
	public void sendSignChange(@NotNull Location loc, @Nullable List<? extends Component> lines) throws IllegalArgumentException {

	}

	/**
	 * Send a sign change. This fakes a sign change packet for a user at
	 * a certain location. This will not actually change the world in any way.
	 * This method will use a sign at the location's block or a faked sign
	 * sent via
	 * {@link #sendBlockChange(Location, Material, byte)}.
	 * <p>
	 * If the client does not have a sign at the given location it will
	 * display an error message to the user.
	 *
	 * @param loc      the location of the sign
	 * @param lines    the new text on the sign or null to clear it
	 * @param dyeColor the color of the sign
	 * @throws IllegalArgumentException if location is null
	 * @throws IllegalArgumentException if dyeColor is null
	 * @throws IllegalArgumentException if lines is non-null and has a length less than 4
	 */
	@Override
	public void sendSignChange(@NotNull Location loc, @Nullable List<? extends Component> lines, @NotNull DyeColor dyeColor) throws IllegalArgumentException {

	}

	/**
	 * Send a sign change. This fakes a sign change packet for a user at
	 * a certain location. This will not actually change the world in any way.
	 * This method will use a sign at the location's block or a faked sign
	 * sent via
	 * {@link #sendBlockChange(Location, Material, byte)}.
	 * <p>
	 * If the client does not have a sign at the given location it will
	 * display an error message to the user.
	 *
	 * @param loc            the location of the sign
	 * @param lines          the new text on the sign or null to clear it
	 * @param dyeColor       the color of the sign
	 * @param hasGlowingText whether the text of the sign should glow as if dyed with a glowing ink sac
	 * @throws IllegalArgumentException if location is null
	 * @throws IllegalArgumentException if dyeColor is null
	 * @throws IllegalArgumentException if lines is non-null and has a length less than 4
	 */
	@Override
	public void sendSignChange(@NotNull Location loc, @Nullable List<? extends Component> lines, @NotNull DyeColor dyeColor, boolean hasGlowingText) throws IllegalArgumentException {

	}

	/*@Override
	public void sendBlockChange(Location loc, int material, byte data) {

	}*/

	@Override
	public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {

	}

	@Override
	public void sendMap(MapView map) {

	}

	@Override
	public void showWinScreen() {

	}

	@Override
	public boolean hasSeenWinScreen() {
		return false;
	}

	@Override
	public void setHasSeenWinScreen(boolean hasSeenWinScreen) {

	}

	@Override
	public void updateInventory() {

	}

	@Override
	public @Nullable GameMode getPreviousGameMode() {
		return null;
	}

	@Override
	public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {

	}

	@Override
	public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {

	}

	@Override
	public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {

	}

	@Override
	public int getStatistic(Statistic statistic) throws IllegalArgumentException {

		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {

	}

	@Override
	public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {

		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {

	}

	@Override
	public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {

	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {

	}

	@Override
	public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {

		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
			throws IllegalArgumentException {

	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {

	}

	@Override
	public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {

	}

	@Override
	public void setPlayerTime(long time, boolean relative) {

	}

	@Override
	public long getPlayerTime() {

		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {

		return 0;
	}

	@Override
	public boolean isPlayerTimeRelative() {

		return false;
	}

	@Override
	public void resetPlayerTime() {

	}

	@Override
	public void setPlayerWeather(WeatherType type) {

	}

	@Override
	public WeatherType getPlayerWeather() {

		return null;
	}

	@Override
	public void resetPlayerWeather() {

	}

	@Override
	public void giveExp(int amount) {

	}

	@Override
	public int getExpCooldown() {
		return 0;
	}

	@Override
	public void setExpCooldown(int ticks) {

	}

	@Override
	public void giveExpLevels(int amount) {

	}

	@Override
	public float getExp() {

		return 0;
	}

	@Override
	public void setExp(float exp) {

	}

	@Override
	public int getLevel() {

		return 0;
	}

	@Override
	public void setLevel(int level) {

	}

	@Override
	public int getTotalExperience() {

		return 0;
	}

	@Override
	public void setTotalExperience(int exp) {

	}

	@Override
	public @Range(from = 0L, to = 2147483647L) int calculateTotalExperiencePoints() {
		return 0;
	}

	@Override
	public void setExperienceLevelAndProgress(@Range(from = 0L, to = 2147483647L) int totalExperience) {

	}

	@Override
	public int getExperiencePointsNeededForNextLevel() {
		return 0;
	}

	@Override
	public float getExhaustion() {

		return 0;
	}

	@Override
	public void setExhaustion(float value) {

	}

	@Override
	public float getSaturation() {

		return 0;
	}

	@Override
	public void setSaturation(float value) {

	}

	@Override
	public int getFoodLevel() {

		return 0;
	}

	@Override
	public void setFoodLevel(int value) {

	}

	/**
	 * Get the regeneration rate (1 health per x ticks) of
	 * the HumanEntity when they have saturation and
	 * their food level is {@literal >=} 20. Default is 10.
	 *
	 * @return the regeneration rate
	 */
	@Override
	public int getSaturatedRegenRate() {
		return 0;
	}

	/**
	 * Set the regeneration rate (1 health per x ticks) of
	 * the HumanEntity when they have saturation and
	 * their food level is {@literal >=} 20. Default is 10.
	 * Not affected if the world's difficulty is peaceful.
	 *
	 * @param ticks the amount of ticks to gain 1 health.
	 */
	@Override
	public void setSaturatedRegenRate(int ticks) {

	}

	/**
	 * Get the regeneration rate (1 health per x ticks) of
	 * the HumanEntity when they have no saturation and
	 * their food level is {@literal >=} 18. Default is 80.
	 *
	 * @return the regeneration rate
	 */
	@Override
	public int getUnsaturatedRegenRate() {
		return 0;
	}

	/**
	 * Get the regeneration rate (1 health per x ticks) of
	 * the HumanEntity when they have no saturation and
	 * their food level is {@literal >=} 18. Default is 80.
	 * Not affected if the world's difficulty is peaceful.
	 *
	 * @param ticks the amount of ticks to gain 1 health.
	 */
	@Override
	public void setUnsaturatedRegenRate(int ticks) {

	}

	/**
	 * Get the starvation rate (1 health per x ticks) of
	 * the HumanEntity. Default is 80.
	 *
	 * @return the starvation rate
	 */
	@Override
	public int getStarvationRate() {
		return 0;
	}

	/**
	 * Get the starvation rate (1 health per x ticks) of
	 * the HumanEntity. Default is 80.
	 *
	 * @param ticks the amount of ticks to lose 1 health
	 */
	@Override
	public void setStarvationRate(int ticks) {

	}

	@Override
	public @Nullable Location getLastDeathLocation() {
		return null;
	}

	@Override
	public void setLastDeathLocation(@Nullable Location location) {

	}

	@Override
	public @Nullable Firework fireworkBoost(@NotNull ItemStack fireworkItemStack) {
		return null;
	}

	@Override
	public Location getBedSpawnLocation() {

		return null;
	}

	@Override
	public @Nullable Location getRespawnLocation() {
		return null;
	}

	@Override
	public void setBedSpawnLocation(Location location) {

	}

	@Override
	public void setRespawnLocation(@Nullable Location location) {

	}

	@Override
	public void setBedSpawnLocation(Location location, boolean force) {

	}

	@Override
	public void setRespawnLocation(@Nullable Location location, boolean force) {

	}

	@Override
	public boolean getAllowFlight() {

		return false;
	}

	@Override
	public void setAllowFlight(boolean flight) {

	}

	@Override
	public void setFlyingFallDamage(@NotNull TriState flyingFallDamage) {

	}

	@Override
	public @NotNull TriState hasFlyingFallDamage() {
		return null;
	}

	@Override
	public void hidePlayer(Plugin plugin, Player player) {

	}

	@Override
	public void hidePlayer(Player player) {

	}

	@Override
	public void showPlayer(Plugin plugin, Player player) {

	}

	@Override
	public void showPlayer(Player player) {

	}

	@Override
	public boolean canSee(Player player) {

		return false;
	}

	@Override
	public void hideEntity(@NotNull Plugin plugin, @NotNull Entity entity) {

	}

	@Override
	public void showEntity(@NotNull Plugin plugin, @NotNull Entity entity) {

	}

	@Override
	public boolean canSee(@NotNull Entity entity) {
		return false;
	}

	@Override
	public boolean isListed(@NotNull Player other) {
		return false;
	}

	@Override
	public boolean unlistPlayer(@NotNull Player other) {
		return false;
	}

	@Override
	public boolean listPlayer(@NotNull Player other) {
		return false;
	}

	@Override
	public boolean isOnGround() {

		return false;
	}

	@Override
	public boolean isFlying() {

		return false;
	}

	@Override
	public void setFlying(boolean value) {

	}

	@Override
	public void setFlySpeed(float value) throws IllegalArgumentException {

	}

	@Override
	public void setWalkSpeed(float value) throws IllegalArgumentException {

	}

	@Override
	public float getFlySpeed() {

		return 0;
	}

	@Override
	public float getWalkSpeed() {

		return 0;
	}

	@Override
	public void setTexturePack(String url) {

	}

	@Override
	public void setResourcePack(String url) {

	}

	@Override
	public Scoreboard getScoreboard() {

		return null;
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

	}

	@Override
	public @Nullable WorldBorder getWorldBorder() {
		return null;
	}

	@Override
	public void setWorldBorder(@Nullable WorldBorder border) {

	}

	@Override
	public boolean isHealthScaled() {

		return false;
	}

	@Override
	public void setHealthScaled(boolean scale) {

	}

	@Override
	public void setHealthScale(double scale) throws IllegalArgumentException {

	}

	@Override
	public double getHealthScale() {

		return 0;
	}

	@Override
	public void sendHealthUpdate(double health, int foodLevel, float saturationLevel) {

	}

	@Override
	public void sendHealthUpdate() {

	}

	@Override
	public Entity getSpectatorTarget() {

		return null;
	}

	@Override
	public void setSpectatorTarget(Entity entity) {

	}

	@Override
	public void sendTitle(String title, String subtitle) {

	}

	@Override
	public void resetTitle() {

	}

	@Override
	public void spawnParticle(Particle particle, Location location, int count) {

	}

	@Override
	public void spawnParticle(Particle particle, double x, double y, double z, int count) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, Location location, int count, T data) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data) {

	}

	@Override
	public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
			double offsetZ) {

	}

	@Override
	public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
			double offsetZ, T data) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
			double offsetY, double offsetZ, T data) {

	}

	@Override
	public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
			double offsetZ, double extra) {

	}

	@Override
	public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
							  double offsetY, double offsetZ, double extra) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY,
								  double offsetZ, double extra, T data) {

	}

	@Override
	public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX,
								  double offsetY, double offsetZ, double extra, T data) {

	}

	@Override
	public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3, @Nullable T t, boolean b) {

	}

	@Override
	public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t, boolean b) {

	}

	@Override
	public Spigot spigot() {
		return null;
	}

	@Override
	public @NotNull Component name() {
		return null;
	}

	@Override
	public @NotNull Component teamDisplayName() {
		return null;
	}

	@Override
	public boolean isSilent() {
		return false;
	}

	@Override
	public void setSilent(boolean flag) {
	}

	@Override
	public boolean hasGravity() {
		return false;
	}

	@Override
	public void setGravity(boolean gravity) {
	}

	@Override
	public void stopSound(Sound sound) {
	}

	@Override
	public void stopSound(String sound) {
	}

	@Override
	public int getCooldown(Material arg0) {
		return 0;
	}

	@Override
	public Entity getShoulderEntityLeft() {
		return null;
	}

	@Override
	public Entity getShoulderEntityRight() {
		return null;
	}

	@Override
	public boolean hasCooldown(Material arg0) {
		return false;
	}

	@Override
	public boolean isHandRaised() {
		return false;
	}

	/**
	 * Gets the hand raised by this living entity. Will be either
	 * {@link EquipmentSlot#HAND} or
	 * {@link EquipmentSlot#OFF_HAND}.
	 *
	 * @return the hand raised
	 */
	@Override
	public @NotNull EquipmentSlot getHandRaised() {
		return null;
	}

	/**
	 * Gets the item that the player is using (eating food, drawing back a bow,
	 * blocking, etc.)
	 *
	 * @return the item being used by the player, or null if they are not using
	 * an item
	 */
	@Override
	public @Nullable ItemStack getItemInUse() {
		return null;
	}

	@Override
	public int getItemInUseTicks() {
		return 0;
	}

	@Override
	public void setItemInUseTicks(int ticks) {

	}

	@Override
	public InventoryView openMerchant(Merchant arg0, boolean arg1) {
		return null;
	}

	@Override
	public void setCooldown(Material arg0, int arg1) {

	}

	/**
	 * If the player has slept enough to count towards passing the night.
	 *
	 * @return true if the player has slept enough
	 */
	@Override
	public boolean isDeeplySleeping() {
		return false;
	}

	@Override
	public void setShoulderEntityLeft(Entity arg0) {

	}

	@Override
	public void setShoulderEntityRight(Entity arg0) {

	}

	@Override
	public PotionEffect getPotionEffect(PotionEffectType arg0) {
		return null;
	}

	@Override
	public boolean addPassenger(Entity arg0) {
		return false;
	}

	@Override
	public boolean addScoreboardTag(String arg0) {
		return false;
	}

	@Override
	public double getHeight() {
		return 1.0;
	}

	@Override
	public List<Entity> getPassengers() {
		return null;
	}

	@Override
	public int getPortalCooldown() {
		return 0;
	}

	@Override
	public Set<String> getScoreboardTags() {
		return null;
	}

	@Override
	public double getWidth() {
		return 0.33;
	}

	@Override
	public boolean removePassenger(Entity arg0) {
		return false;
	}

	@Override
	public boolean removeScoreboardTag(String arg0) {
		return false;
	}

	@Override
	public void setPortalCooldown(int arg0) {

	}

	@Override
	public AdvancementProgress getAdvancementProgress(Advancement arg0) {
		return null;
	}

	@Override
	public String getLocale() {
		return null;
	}

	@Override
	public void playSound(Location arg0, Sound arg1, SoundCategory arg2, float arg3, float arg4) {

	}

	@Override
	public void playSound(Location arg0, String arg1, SoundCategory arg2, float arg3, float arg4) {

	}

	@Override
	public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch, long seed) {

	}

	@Override
	public void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch, long seed) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull Sound sound, float volume, float pitch) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull String sound, float volume, float pitch) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch, long seed) {

	}

	@Override
	public void playSound(@NotNull Entity entity, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch, long seed) {

	}

	@Override
	public void sendTitle(String arg0, String arg1, int arg2, int arg3, int arg4) {

	}

	@Override
	public void setResourcePack(String arg0, byte[] arg1) {

	}

	@Override
	public void setResourcePack(@NotNull String url, @Nullable byte[] hash, @Nullable String prompt) {

	}

	@Override
	public void setResourcePack(@NotNull String url, @Nullable byte[] hash, boolean force) {

	}

	@Override
	public void setResourcePack(@NotNull String url, @Nullable byte[] hash, @Nullable String prompt, boolean force) {

	}

	@Override
	public void setResourcePack(@NotNull String url, byte @Nullable [] hash, @Nullable Component prompt, boolean force) {

	}

	@Override
	public void setResourcePack(@NotNull UUID id, @NotNull String url, @Nullable byte[] hash, @Nullable String prompt, boolean force) {

	}

	@Override
	public void setResourcePack(@NotNull UUID uuid, @NotNull String url, byte @Nullable [] hash, @Nullable Component prompt, boolean force) {

	}

	@Override
	public void stopSound(Sound arg0, SoundCategory arg1) {

	}

	@Override
	public void stopSound(String arg0, SoundCategory arg1) {

	}

	@Override
	public void stopSound(@NotNull SoundCategory category) {

	}

	@Override
	public void stopAllSounds() {

	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return null;
	}

	@Override
	public boolean isSwimming() {
		return false;
	}

	@Override
	public void setSwimming(boolean arg0) {

	}

	@Override
	public void sendBlockChange(Location arg0, BlockData arg1) {

	}

	@Override
	public void sendBlockChanges(@NotNull Collection<BlockState> blocks) {

	}

	@Override
	public void sendBlockChanges(@NotNull Collection<BlockState> blocks, boolean suppressLightUpdates) {

	}

	/**
	 * Send block damage. This fakes block break progress for a user at a
	 * certain location. This will not actually change the block's break
	 * progress in any way.
	 *
	 * @param loc      the location of the damaged block
	 * @param progress the progress from 0.0 - 1.0 where 0 is no damage and
	 */
	@Override
	public void sendBlockDamage(@NotNull Location loc, float progress) {

	}

	@Override
	public void sendMultiBlockChange(@NotNull Map<? extends Position, BlockData> blockChanges) {

	}

	@Override
	public void sendMultiBlockChange(@NotNull Map<? extends Position, BlockData> blockChanges, boolean suppressLightUpdates) {

	}

	@Override
	public void sendBlockDamage(@NotNull Location loc, float progress, @NotNull Entity source) {

	}

	@Override
	public void sendBlockDamage(@NotNull Location loc, float progress, int sourceId) {

	}

	@Override
	public void sendEquipmentChange(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack item) {

	}

	@Override
	public void sendEquipmentChange(@NotNull LivingEntity entity, @NotNull Map<EquipmentSlot, ItemStack> items) {

	}

	@Override
	public boolean isRiptiding() {
		return false;
	}

	@Override
	public boolean isPersistent() {
		return false;
	}

	@Override
	public void setPersistent(boolean arg0) {
	}

	@Override
	public String getPlayerListFooter() {
		return null;
	}

	@Override
	public String getPlayerListHeader() {
		return null;
	}

	@Override
	public void setPlayerListFooter(String arg0) {
	}

	@Override
	public void setPlayerListHeader(String arg0) {
	}

	@Override
	public void setPlayerListHeaderFooter(String arg0, String arg1) {
	}

	@Override
	public void updateCommands() {
	}

	@Override
	public boolean sleep(Location location, boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void wakeup(boolean setSpawnLocation) {
		// TODO Auto-generated method stub

	}

	@Override
	public Location getBedLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean discoverRecipe(NamespacedKey recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int discoverRecipes(Collection<NamespacedKey> recipes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean undiscoverRecipe(NamespacedKey recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int undiscoverRecipes(Collection<NamespacedKey> recipes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Block getTargetBlockExact(int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getTargetBlockExact(int maxDistance, FluidCollisionMode fluidCollisionMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RayTraceResult rayTraceBlocks(double maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RayTraceResult rayTraceBlocks(double maxDistance, FluidCollisionMode fluidCollisionMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getMemory(MemoryKey<T> memoryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void setMemory(MemoryKey<T> memoryKey, T memoryValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public @Nullable Sound getHurtSound() {
		return null;
	}

	@Override
	public @Nullable Sound getDeathSound() {
		return null;
	}

	@Override
	public @NotNull Sound getFallDamageSound(int fallHeight) {
		return null;
	}

	@Override
	public @NotNull Sound getFallDamageSoundSmall() {
		return null;
	}

	@Override
	public @NotNull Sound getFallDamageSoundBig() {
		return null;
	}

	@Override
	public @NotNull Sound getDrinkingSound(@NotNull ItemStack itemStack) {
		return null;
	}

	@Override
	public @NotNull Sound getEatingSound(@NotNull ItemStack itemStack) {
		return null;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}

	@Override
	public double getAbsorptionAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAbsorptionAmount(double arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoundingBox getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRotation(float yaw, float pitch) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean teleport(@NotNull Location location, @NotNull TeleportCause cause, @NotNull TeleportFlag @NotNull ... teleportFlags) {
		return false;
	}

	@Override
	public void lookAt(double x, double y, double z, @NotNull LookAnchor playerAnchor) {

	}

	@Override
	public void lookAt(@NotNull Entity entity, @NotNull LookAnchor playerAnchor, @NotNull LookAnchor entityAnchor) {

	}

	@Override
	public void showElderGuardian(boolean silent) {

	}

	@Override
	public int getWardenWarningCooldown() {
		return 0;
	}

	@Override
	public void setWardenWarningCooldown(int cooldown) {

	}

	@Override
	public int getWardenTimeSinceLastWarning() {
		return 0;
	}

	@Override
	public void setWardenTimeSinceLastWarning(int time) {

	}

	@Override
	public int getWardenWarningLevel() {
		return 0;
	}

	@Override
	public void setWardenWarningLevel(int warningLevel) {

	}

	@Override
	public void increaseWardenWarningLevel() {

	}

	@Override
	public @NotNull Duration getIdleDuration() {
		return null;
	}

	@Override
	public void resetIdleDuration() {

	}

	@Override
	public @NotNull @Unmodifiable Set<Long> getSentChunkKeys() {
		return Set.of();
	}

	@Override
	public @NotNull @Unmodifiable Set<Chunk> getSentChunks() {
		return Set.of();
	}

	@Override
	public boolean isChunkSent(long chunkKey) {
		return false;
	}

	@Override
	public BlockFace getFacing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pose getPose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull SpawnCategory getSpawnCategory() {
		return null;
	}

	@Override
	public boolean isInWorld() {
		return false;
	}

	@Override
	public @Nullable String getAsString() {
		return "";
	}

	@Override
	public @Nullable EntitySnapshot createSnapshot() {
		return null;
	}

	@Override
	public @NotNull Entity copy() {
		return null;
	}

	@Override
	public @NotNull Entity copy(@NotNull Location to) {
		return null;
	}

	@Override
	public PersistentDataContainer getPersistentDataContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendSignChange(Location loc, String[] lines, DyeColor dyeColor) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	/**
	 * Send a sign change. This fakes a sign change packet for a user at
	 * a certain location. This will not actually change the world in any way.
	 * This method will use a sign at the location's block or a faked sign
	 * sent via
	 * {@link #sendBlockChange(Location, Material, byte)}.
	 * <p>
	 * If the client does not have a sign at the given location it will
	 * display an error message to the user.
	 *
	 * @param loc            the location of the sign
	 * @param lines          the new text on the sign or null to clear it
	 * @param dyeColor       the color of the sign
	 * @param hasGlowingText if the sign's text should be glowing
	 * @throws IllegalArgumentException if location is null
	 * @throws IllegalArgumentException if dyeColor is null
	 * @throws IllegalArgumentException if lines is non-null and has a length less than 4
	 * @deprecated Deprecated in favour of {@link #sendSignChange(Location, List, DyeColor, boolean)}
	 */
	@Override
	public void sendSignChange(@NotNull Location loc, @Nullable String[] lines, @NotNull DyeColor dyeColor, boolean hasGlowingText) throws IllegalArgumentException {

	}

	@Override
	public void sendBlockUpdate(@NotNull Location loc, @NotNull TileState tileState) throws IllegalArgumentException {

	}

	@Override
	public void sendPotionEffectChange(@NotNull LivingEntity entity, @NotNull PotionEffect effect) {

	}

	@Override
	public void sendPotionEffectChangeRemove(@NotNull LivingEntity entity, @NotNull PotionEffectType type) {

	}

	@Override
	public int getClientViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the player's current locale.
	 *
	 * @return the player's locale
	 */
	@Override
	public @NotNull Locale locale() {
		return null;
	}

	/**
	 * Gets the player's estimated ping in milliseconds.
	 * <p>
	 * In Vanilla this value represents the average of the response time to the
	 * last four application layer ping packets sent. This value does not
	 * represent the network round trip time and as such may have less
	 * granularity and be impacted by other sources. For these reasons it
	 * <b>should not</b> be used for anti-cheat purposes. Its recommended use is
	 * only as a <b>qualitative</b> indicator of connection quality (Vanilla
	 * uses it for this purpose in the tab list).
	 *
	 * @return player ping
	 */
	@Override
	public int getPing() {
		return 0;
	}

	@Override
	public void openBook(ItemStack book) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getAttackCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasDiscoveredRecipe(NamespacedKey recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<NamespacedKey> getDiscoveredRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attack(Entity target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void swingMainHand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swingOffHand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playHurtAnimation(float yaw) {

	}

	@Override
	public Set<UUID> getCollidableExemptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendExperienceChange(float progress) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendExperienceChange(float progress, int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory(Reason arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean dropItem(boolean arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Location getPotentialBedLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable FishHook getFishHook() {
		return null;
	}

	@Override
	public InventoryView openAnvil(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryView openCartographyTable(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryView openGrindstone(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryView openLoom(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openSign(Sign arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openSign(@NotNull Sign sign, @NotNull Side side) {

	}

	@Override
	public void showDemoScreen() {

	}

	@Override
	public boolean isAllowingServerListings() {
		return false;
	}

	@Override
	public InventoryView openSmithingTable(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryView openStonecutter(Location arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity releaseLeftShoulderEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity releaseRightShoulderEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearActiveItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getActiveItemRemainingTime() {
		return 0;
	}

	@Override
	public void setActiveItemRemainingTime(@Range(from = 0L, to = 2147483647L) int ticks) {

	}

	@Override
	public boolean hasActiveItem() {
		return false;
	}

	@Override
	public int getActiveItemUsedTime() {
		return 0;
	}

	@Override
	public @NotNull EquipmentSlot getActiveItemHand() {
		return null;
	}

	@Override
	public float getSidewaysMovement() {
		return 0;
	}

	@Override
	public float getUpwardsMovement() {
		return 0;
	}

	@Override
	public float getForwardsMovement() {
		return 0;
	}

	@Override
	public void startUsingItem(@NotNull EquipmentSlot hand) {

	}

	@Override
	public void completeUsingActiveItem() {

	}

	@Override
	public ItemStack getActiveItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArrowCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArrowsInBody() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArrowsStuck() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityCategory getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHandRaisedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHurtDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemUseRemainingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getShieldBlockingDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlockFace getTargetBlockFace(int arg0, FluidCollisionMode arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable TargetBlockInfo getTargetBlockInfo(int maxDistance, TargetBlockInfo.@NotNull FluidMode fluidMode) {
		return null;
	}

	@Override
	public Entity getTargetEntity(int arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable TargetEntityInfo getTargetEntityInfo(int maxDistance, boolean ignoreBlocks) {
		return null;
	}

	@Override
	public @Nullable RayTraceResult rayTraceEntities(int maxDistance, boolean ignoreBlocks) {
		return null;
	}

	@Override
	public boolean isInvisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setNoPhysics(boolean noPhysics) {

	}

	@Override
	public boolean hasNoPhysics() {
		return false;
	}

	@Override
	public boolean isJumping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playPickupItemAnimation(Item arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArrowCooldown(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArrowsInBody(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArrowsInBody(int count, boolean fireEvent) {

	}

	@Override
	public void setNextArrowRemoval(@Range(from = 0L, to = 2147483647L) int ticks) {

	}

	@Override
	public int getNextArrowRemoval() {
		return 0;
	}

	@Override
	public void setArrowsStuck(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHurtDirection(float arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void knockback(double strength, double directionX, double directionZ) {

	}

	@Override
	public void broadcastSlotBreak(@NotNull EquipmentSlot slot) {

	}

	@Override
	public void broadcastSlotBreak(@NotNull EquipmentSlot slot, @NotNull Collection<Player> players) {

	}

	@Override
	public @NotNull ItemStack damageItemStack(@NotNull ItemStack stack, int amount) {
		return null;
	}

	@Override
	public void damageItemStack(@NotNull EquipmentSlot slot, int amount) {

	}

	@Override
	public float getBodyYaw() {
		return 0;
	}

	@Override
	public void setBodyYaw(float bodyYaw) {

	}

	@Override
	public boolean canUseEquipmentSlot(@NotNull EquipmentSlot slot) {
		return false;
	}

	@Override
	public void setInvisible(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setJumping(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setKiller(Player arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setShieldBlockingDelay(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean fromMobSpawner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chunk getChunk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpawnReason getEntitySpawnReason() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnderWater() {
		return false;
	}

	@Override
	public Location getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInBubbleColumn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInLava() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInRain() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInWater() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInWaterOrBubbleColumn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInWaterOrRain() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInWaterOrRainOrBubbleColumn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTicking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendMessage(UUID arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessage(UUID arg0, String[] arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendRawMessage(UUID arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getLastLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastSeen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProtocolVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InetSocketAddress getVirtualHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int applyMending(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Firework boostElytra(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Send a packet to the player indicating its operator status level.
	 * <p>
	 * <b>Note:</b> This will not persist across more than the current connection, and setting the player's operator
	 * status as a later point <i>will</i> override the effects of this.
	 *
	 * @param level The level to send to the player. Must be in {@code [0, 4]}.
	 * @throws IllegalArgumentException If the level is negative or greater than {@code 4} (i.e. not within {@code [0, 4]}).
	 */
	@Override
	public void sendOpLevel(byte level) {

	}

	@Override
	public void addAdditionalChatCompletions(@NotNull Collection<String> completions) {

	}

	@Override
	public void removeAdditionalChatCompletions(@NotNull Collection<String> completions) {

	}

	/**
	 * @return Returns a set of Players within this player's tracking range (that the player's client can "see")
	 */
	@Override
	public @NotNull Set<Player> getTrackedPlayers() {
		return null;
	}

	@Override
	public boolean spawnAt(@NotNull Location location, @NotNull SpawnReason reason) {
		return false;
	}

	@Override
	public boolean isInPowderedSnow() {
		return false;
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		return 0;
	}

	@Override
	public double getZ() {
		return 0;
	}

	@Override
	public float getPitch() {
		return 0;
	}

	@Override
	public float getYaw() {
		return 0;
	}

	@Override
	public boolean collidesAt(@NotNull Location location) {
		return false;
	}

	@Override
	public boolean wouldCollideUsing(@NotNull BoundingBox boundingBox) {
		return false;
	}

	@Override
	public @NotNull EntityScheduler getScheduler() {
		return null;
	}

	@Override
	public @NotNull String getScoreboardEntryName() {
		return null;
	}

	@Override
	public boolean getAffectsSpawning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getClientBrandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getClientOption(ClientOption<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getCooldownPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getCooledAttackStrength(float arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PlayerProfile getPlayerProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResourcePackHash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status getResourcePackStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void giveExp(int arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasResourcePack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addResourcePack(@NotNull UUID id, @NotNull String url, @Nullable byte[] hash, @Nullable String prompt, boolean force) {

	}

	@Override
	public void removeResourcePack(@NotNull UUID id) {

	}

	@Override
	public void removeResourcePacks() {

	}

	@Override
	public void hideTitle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendHurtAnimation(float yaw) {

	}

	@Override
	public void sendLinks(@NotNull ServerLinks links) {

	}

	@Override
	public void addCustomChatCompletions(@NotNull Collection<String> completions) {

	}

	@Override
	public void removeCustomChatCompletions(@NotNull Collection<String> completions) {

	}

	@Override
	public void setCustomChatCompletions(@NotNull Collection<String> completions) {

	}

	@Override
	public void resetCooldown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendActionBar(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendActionBar(BaseComponent... arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendActionBar(char arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendTitle(Title arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAffectsSpawning(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerListHeaderFooter(BaseComponent[] arg0, BaseComponent[] arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerListHeaderFooter(BaseComponent arg0, BaseComponent arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerProfile(PlayerProfile arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResourcePack(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	/**
	 * Request that the player's client download and switch resource packs.
	 * <p>
	 * The player's client will download the new resource pack asynchronously
	 * in the background, and will automatically switch to it once the
	 * download is complete. If the client has downloaded and cached the same
	 * resource pack in the past, it will perform a quick timestamp check
	 * over the network to determine if the resource pack has changed and
	 * needs to be downloaded again. When this request is sent for the very
	 * first time from a given server, the client will first display a
	 * confirmation GUI to the player before proceeding with the download.
	 * <p>
	 * Notes:
	 * <ul>
	 * <li>Players can disable server resources on their client, in which
	 *     case this method will have no affect on them.
	 * <li>There is no concept of resetting resource packs back to default
	 *     within Minecraft, so players will have to relog to do so.
	 * </ul>
	 *
	 * @param url      The URL from which the client will download the resource
	 *                 pack. The string must contain only US-ASCII characters and should
	 *                 be encoded as per RFC 1738.
	 * @param hash     A 40 character hexadecimal and lowercase SHA-1 digest of
	 *                 the resource pack file.
	 * @param required Marks if the resource pack should be required by the client
	 * @throws IllegalArgumentException Thrown if the URL is null.
	 * @throws IllegalArgumentException Thrown if the URL is too long. The
	 *                                  length restriction is an implementation specific arbitrary value.
	 */
	@Override
	public void setResourcePack(@NotNull String url, @NotNull String hash, boolean required) {

	}

	/**
	 * Request that the player's client download and switch resource packs.
	 * <p>
	 * The player's client will download the new resource pack asynchronously
	 * in the background, and will automatically switch to it once the
	 * download is complete. If the client has downloaded and cached the same
	 * resource pack in the past, it will perform a quick timestamp check
	 * over the network to determine if the resource pack has changed and
	 * needs to be downloaded again. When this request is sent for the very
	 * first time from a given server, the client will first display a
	 * confirmation GUI to the player before proceeding with the download.
	 * <p>
	 * Notes:
	 * <ul>
	 * <li>Players can disable server resources on their client, in which
	 *     case this method will have no affect on them.
	 * <li>There is no concept of resetting resource packs back to default
	 *     within Minecraft, so players will have to relog to do so.
	 * </ul>
	 *
	 * @param url                The URL from which the client will download the resource
	 *                           pack. The string must contain only US-ASCII characters and should
	 *                           be encoded as per RFC 1738.
	 * @param hash               A 40 character hexadecimal and lowercase SHA-1 digest of
	 *                           the resource pack file.
	 * @param required           Marks if the resource pack should be required by the client
	 * @param resourcePackPrompt A Prompt to be displayed in the client request
	 * @throws IllegalArgumentException Thrown if the URL is null.
	 * @throws IllegalArgumentException Thrown if the URL is too long. The
	 *                                  length restriction is an implementation specific arbitrary value.
	 */
	@Override
	public void setResourcePack(@NotNull String url, @NotNull String hash, boolean required, @Nullable Component resourcePackPrompt) {

	}

	@Override
	public void setSubtitle(BaseComponent[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSubtitle(BaseComponent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitleTimes(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setViewDistance(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSimulationDistance() {
		return 0;
	}

	@Override
	public void setSimulationDistance(int simulationDistance) {

	}

	@Override
	public int getNoTickViewDistance() {
		return 0;
	}

	@Override
	public void setNoTickViewDistance(int viewDistance) {

	}

	@Override
	public int getSendViewDistance() {
		return 0;
	}

	@Override
	public void setSendViewDistance(int viewDistance) {
		// TODO Auto-generated method stub
	}

	@Override
	public void showTitle(BaseComponent[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showTitle(BaseComponent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showTitle(BaseComponent[] arg0, BaseComponent[] arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showTitle(BaseComponent arg0, BaseComponent arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTitle(Title arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBeeStingerCooldown() {
		return 0;
	}

	@Override
	public void setBeeStingerCooldown(int ticks) {

	}

	@Override
	public int getBeeStingersInBody() {
		return 0;
	}

	@Override
	public void setBeeStingersInBody(int count) {

	}

	@Override
	public void setNextBeeStingerRemoval(@Range(from = 0L, to = 2147483647L) int ticks) {

	}

	@Override
	public int getNextBeeStingerRemoval() {
		return 0;
	}

	@Override
	public @NotNull TriState getFrictionState() {
		return null;
	}

	@Override
	public void setFrictionState(@NotNull TriState state) {

	}
}
