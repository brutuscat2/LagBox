package net.brutuscat.LagBox;

        import org.bukkit.Bukkit;
        import org.bukkit.ChatColor;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.player.AsyncPlayerChatEvent;
        import org.bukkit.plugin.java.JavaPlugin;

public class LagBox extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        String lt = LagBox.this.getConfig().getString("lagtime");
        String m = LagBox.this.getConfig().getString("message");
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if(e.getMessage().equalsIgnoreCase("lag")) {
            try {
                e.setMessage(ChatColor.DARK_RED "m");
                Thread.sleep(lt);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (cmd.getName().equalsIgnoreCase("reload")) {
		// Add reload code
	}
    }
}
