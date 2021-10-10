package com.sirbassington.creepermodifications;

import java.util.Random;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CreeperPotionEvent implements Listener {

	@EventHandler
	public void onHit(EntityDamageByEntityEvent magic)
	{
		PotionTracker potionTrack = new PotionTracker();
		
		//Determine how many potions should be drawn, never will be 0; implementation for pending future update
		Random random = new Random();
		int amount = random.nextInt(3) + 1;
		
		Entity entity = magic.getEntity();
		
		if (magic.getDamager() instanceof Creeper)
		{
			if (magic.getEntity() instanceof Player)
			{
				Player target = (Player) magic.getEntity();
				potionTrack.potionSelection(amount, target);
			}
		}
	}
}
