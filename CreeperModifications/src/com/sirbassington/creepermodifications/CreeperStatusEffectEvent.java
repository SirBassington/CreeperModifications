package com.sirbassington.creepermodifications;

import java.util.Random;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class CreeperStatusEffectEvent implements Listener {

	@EventHandler
	public void onHit(EntityDamageByEntityEvent magic)
	{
		StatusEffectTracker potionTrack = new StatusEffectTracker();
		
		//Determine how many effects should be drawn
		Random random = new Random();
		int amount = random.nextInt(4); //range 0 - 3
		
		if (magic.getDamager() instanceof Creeper)
		{
			if (magic.getEntity() instanceof Player)
			{
				Player target = (Player) magic.getEntity();
				potionTrack.effectSelection(amount, target);
			}
		}
	}
}
