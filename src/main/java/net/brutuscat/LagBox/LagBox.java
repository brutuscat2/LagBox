package net.brutuscat.LagBox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LagBox extends JavaPlugin implements Listener {

    final String m = LagBox.this.getConfig().getString("message", "I'm the one who lagged the server, blame me!");
    final int lt = LagBox.this.getConfig().getInt("lagtime", 1000);
    final int v = LagBox.this.getConfig().getInt("version");
    final int vn = 102;
    final boolean c = LagBox.this.getConfig().getBoolean("lagchat", true);

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        if(v != vn) {
            getConfig().addDefault("version", vn);
            getConfig().addDefault("lagtime", 1000);
            getConfig().addDefault("lagchat", Boolean.TRUE);
            getConfig().addDefault("message", "I'm the one who lagged the server, blame me!");
            getConfig().options().copyDefaults(false);
            saveConfig();
        }
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if(e.getMessage().equalsIgnoreCase("lag")) {
            try {
                if(m != null && m != "")
                    e.setMessage(ChatColor.DARK_RED + this.m);
                if(c != false)
                    Thread.sleep(this.lt);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("lbreload")) {
        System.out.println(ChatColor.AQUA + "Reloading configuration..");
        final String m = LagBox.this.getConfig().getString("message");
        final int lt = LagBox.this.getConfig().getInt("lagtime");
        System.out.println(ChatColor.AQUA + "LagBox successfully reloaded.");
    } return true;
    }
}
