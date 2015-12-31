package pw.owen.FlowBan.main;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
@Override
public void onEnable() {

getServer().getPluginManager().registerEvents(new AutoListener(), this);
}
}
