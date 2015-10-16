package filnari.fundrops.main;

// import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
// import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;
// import org.bukkit.event.entity.EntityShootBowEvent;
// import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
// import org.bukkit.inventory.PlayerInventory;
// import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

// import com.gmail.stevenpcc.arrowhitblockevent.ArrowHitBlockEvent;

public class guts extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getLogger().info("Plugin started!");
		getServer().getPluginManager().registerEvents(this,this);
		// This is run when the server starts
	}
	@Override
	public void onDisable() {
		getLogger().info("Plugin stopped!");
		// This is run when the server stops
	}
//
@EventHandler
	public void leaves(LeavesDecayEvent event)
	{
	// Block of leaves has decayed
	// 5% chance a stick will drop
	if (Math.random() > .95) {
		// Make a stick
		ItemStack item = new ItemStack(Material.STICK,1);
		// Find where to drop it
		World world = event.getBlock().getWorld();
		// Drop it
		world.dropItem(event.getBlock().getLocation(),item);
		getLogger().info("Dropped a stick");
		}
	}
@EventHandler
	public void breakin(BlockBreakEvent event)
	{
		
		Block b = event.getBlock();    // get the block broken
		Material bt = b.getType();     // get its material type
		Player p = event.getPlayer();  // who broke it?

		switch (bt) {
		case COAL_ORE:
			if (Math.random()>.999) { // was .999
				// .1% chance to drop a diamond
				ItemStack item = new ItemStack(Material.DIAMOND);
				World world = b.getWorld();
				world.dropItem(b.getLocation(), item);
				// tell player "Have a diamond, what a lucky find!"
				p.sendMessage(ChatColor.AQUA + "Have a diamond. What a lucky find!");
				// and log it
				getLogger().info("Gave a diamond to " + p.getName() );
			}
			break;
		case IRON_ORE:
			if (Math.random()>.997) { // was .997
				// .3% chance to drop a gold nugget
				ItemStack item = new ItemStack(Material.GOLD_NUGGET);
				World world = b.getWorld();
				world.dropItem(b.getLocation(),item);
				// tell player "Have a gold nugget, what a lucky find!"
				p.sendMessage(ChatColor.AQUA + "Have a gold nugget. What a lucky find!");
				// and log it
				getLogger().info("Gave a gold nugget to " + p.getName() );
			}
			break;
		case DIAMOND_ORE:
			if (Math.random()>.99) { // was .99
				// 1% chance to drop a cookie!
				ItemStack item = new ItemStack(Material.COOKIE,1);
				World world = b.getWorld();
				world.dropItem(b.getLocation(), item);
				// tell player "That's hard work. Have a cookie!"
				p.sendMessage("ChatColor.AQUA + That's hard work. Have a cookie!");
				// and log it
				getLogger().info("Gave a cookie to " + p.getName() );
			}
			break;
		default:
			break;

		}
	}
/*
@EventHandler
	public void arrowshot(EntityShootBowEvent e){
		final JavaPlugin plugin = this;
		// If first line of Lore is "LightBringer" then
		// Entity ent = event.getEntity();
		// Player player = event
		// PlayerInventory playerInv = player.getInventory();
		//  if (playerInv.getItemInHand().getItemMeta().hasLore()){
		//	if (playerInv.getItemInHand().getItemMeta().getLore().equals("LightBringer")){
		//		player.sendMessage("Light!");
				// assign dummy NBT tag to projectile?
		//	}
		Bukkit.broadcastMessage(ChatColor.YELLOW+"projectile shot");
		if (e.getProjectile() instanceof Arrow) {
			Arrow a = (Arrow) e.getProjectile();
			Player p = (Player) a.getShooter();
			p.sendMessage("Projectile is an arrow");
			if (a.getShooter() instanceof Player) {
				p.sendMessage("Shooter is a player");
				PlayerInventory playerInv = p.getInventory();
				if (playerInv.getItemInHand().getItemMeta().hasLore()){
					p.sendMessage("Has Lore!");
					if (playerInv.getItemInHand().getItemMeta().getLore().contains("LightBringer")) {
						// p.sendMessage( "lore here" );
						p.sendMessage("Let there be light!");
						// Tag the arrow with light metadata
						e.getProjectile().setMetadata("Light", new FixedMetadataValue(plugin,"1"));
						
					}
				}
			}
		}
		
	}

	public void arrowhit(ProjectileHitEvent e) {
		Bukkit.broadcastMessage(ChatColor.YELLOW+"Projectile hit");
		if (e.getEntity() instanceof Arrow) {
			Bukkit.broadcastMessage(ChatColor.YELLOW+"Arrow hit");
			if (e.getEntity().hasMetadata("Light")) {
				Bukkit.broadcastMessage(ChatColor.YELLOW+"Light planted!");
			}
		}
	}
	public void arrowhit2(ArrowHitBlockEvent e) {
		Bukkit.broadcastMessage(ChatColor.GREEN+"Arrow hit");
		if (e.getArrow().hasMetadata("Light")) {
			Bukkit.broadcastMessage(ChatColor.GREEN+"Light it!");
			}
	}
*/

}

