package pw.owen.FlowBan.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;




public class AutoListener implements Listener {
	private static final int MAX = 8;
	@EventHandler
	public void ede(BlockFromToEvent e){

if(e.getBlock().getState().getType().name().equalsIgnoreCase(Material.STATIONARY_WATER.name()))
			if (getL(e.getToBlock(), Material.STATIONARY_WATER, Material.WATER) > MAX)
		{e.setCancelled(true);
		return;
		}

if(e.getBlock().getState().getType().name().equalsIgnoreCase(Material.WATER.name()))
			if (getL(e.getToBlock(), Material.STATIONARY_WATER, Material.WATER) > MAX)
		{e.setCancelled(true);
		return;
		}



if(e.getBlock().getState().getType().name().equalsIgnoreCase(Material.STATIONARY_LAVA.name()))
			if (getL(e.getToBlock(), Material.STATIONARY_LAVA, Material.LAVA) > MAX)
{e.setCancelled(true);
return;
}



if(e.getBlock().getState().getType().name().equalsIgnoreCase(Material.LAVA.name()))
			if (getL(e.getToBlock(), Material.STATIONARY_LAVA, Material.LAVA) > MAX)
{e.setCancelled(true);
return;
}



	}
	
	private int getL(Block b,Material... type) {
		int X=b.getX();
		int Z=b.getZ();
		int Y = b.getY()+1;
		List<Block> bs= new ArrayList<Block>();
		bs.add(b.getWorld().getBlockAt(X, Y, Z));
		bs.add(b.getWorld().getBlockAt(X+1, Y, Z));
		bs.add(b.getWorld().getBlockAt(X-1, Y, Z));
		bs.add(b.getWorld().getBlockAt(X, Y, Z+1));
		bs.add(b.getWorld().getBlockAt(X, Y, Z-1));
		bs.add(b.getWorld().getBlockAt(X+1, Y, Z+1));
		bs.add(b.getWorld().getBlockAt(X+1, Y, Z-1));
		bs.add(b.getWorld().getBlockAt(X-1, Y, Z+1));
		bs.add(b.getWorld().getBlockAt(X-1, Y, Z-1));
		for(int i=0;i<bs.size();i++){
		for(int l=0;l<type.length;l++)
		if(bs.get(i).getState().getType().name().equalsIgnoreCase(type[l].name()))
			return 1+getL(bs.get(i),type);	

		}

		return 1;
	}


}

