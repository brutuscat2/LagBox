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
        System.out.println("LagBox 1.0 successfully enabled");
        Bukkit.getPluginManager().registerEvents(new LagListen(), this);
    }


    public void onDisable() {
        System.out.println("LagBox 1.0 successfully disabled!");
    }

    public static class LagListen implements Listener {

        @EventHandler
        public void onPlayerChat(AsyncPlayerChatEvent e) {
            if(e.getMessage().equalsIgnoreCase("lag")) {
                try {
                    String nm = e.getMessage().replaceAll("lag", ChatColor.DARK_RED + "I'm the one who lagged the server, blame me!");
                    e.setMessage(nm);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else {
                // Some code goes here. Give suggestions to brutuscat2 on Spigot forums if you want to.
            }
        }
    }
}