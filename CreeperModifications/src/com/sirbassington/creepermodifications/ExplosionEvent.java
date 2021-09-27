package com.sirbassington.creepermodifications;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Consumer;

public class ExplosionEvent implements Listener {
	
	@EventHandler
	public static void onCreeperExplode(EntityExplodeEvent event)
	{
		Creeper creeper = (Creeper) event.getEntity(); //The entity; creeper
		PotionTracker potionTrack = new PotionTracker(); //Class for pulling potions to draw from
		int amount; //Number of potions to determine
		
		if (event.getEntity() instanceof Creeper)
		{
			PotionEffectType potion1 = null, potion2 = null, potion3 = null;
			World w = Bukkit.getWorld("world");
			
			if (creeper.isPowered())
			{
				amount = 3;
				potionTrack.potionSelection(amount, potion1, potion2, potion3);
				//potion1 decision
				ThrownPotion potion1Thrown = w.spawn(creeper.getLocation(), ThrownPotion.class, new Consumer<ThrownPotion>()
				{
					@Override
					public void accept(ThrownPotion thrownPotion)
					{
						thrownPotion.getEffects().add(new PotionEffect(potion1, 1, 1));
					}
				});
				//potion2 decision
				ThrownPotion potion2Thrown = w.spawn(creeper.getLocation(), ThrownPotion.class, new Consumer<ThrownPotion>()
				{
					@Override
					public void accept(ThrownPotion thrownPotion)
					{
						thrownPotion.getEffects().add(new PotionEffect(potion2, 1, 1));
					}
				});
				//potion3 decision
				ThrownPotion potion3Thrown = w.spawn(creeper.getLocation(), ThrownPotion.class, new Consumer<ThrownPotion>()
				{
					@Override
					public void accept(ThrownPotion thrownPotion)
					{
						thrownPotion.getEffects().add(new PotionEffect(potion3, 1, 1));
					}
				});
			}
			else
			{
				amount = 1;
				potionTrack.potionSelection(amount, potion1, null, null);
				ThrownPotion potion1Thrown = w.spawn(creeper.getLocation(), ThrownPotion.class, new Consumer<ThrownPotion>()
				{
					@Override
					public void accept(ThrownPotion thrownPotion)
					{
						thrownPotion.getEffects().add(new PotionEffect(potion3, 1, 1));
					}
				});
			}
			event.blockList().clear(); //Prevents creepers from destroying blocks; does not affect tile entities
		}
	}
}