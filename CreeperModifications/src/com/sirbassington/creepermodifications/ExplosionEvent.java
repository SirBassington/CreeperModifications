package com.sirbassington.creepermodifications;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.potion.PotionEffectType;

public class ExplosionEvent implements Listener {
	
	@EventHandler
	public static void onCreeperExplode(EntityExplodeEvent boomEvent)
	{
		if (boomEvent.getEntity() instanceof Creeper)
		{
			boomEvent.blockList().clear(); //Prevents creepers from destroying blocks; does not affect tile entities as they are not blocks
		}
	}
}