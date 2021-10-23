package com.sirbassington.creepermodifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StatusEffectTracker {

	/**
	 * Creates a list for effects offered from PotionEffectType.
	 * Used due to some effects from PotionEffectType not needing to be implemented for this feature 
	 */
	List<PotionEffectType> effects = new ArrayList<PotionEffectType>();
	
	public void effectSelection(int amount, Player p)
	{
		//Negative effects
		effects.add(PotionEffectType.HARM);
		effects.add(PotionEffectType.HUNGER);
		effects.add(PotionEffectType.POISON);
		effects.add(PotionEffectType.SLOW);
		effects.add(PotionEffectType.WEAKNESS);
		effects.add(PotionEffectType.SLOW_DIGGING);
		effects.add(PotionEffectType.WITHER);
		effects.add(PotionEffectType.UNLUCK);
		effects.add(PotionEffectType.BLINDNESS);
		//Positive effects
		effects.add(PotionEffectType.DAMAGE_RESISTANCE);
		effects.add(PotionEffectType.FIRE_RESISTANCE);
		effects.add(PotionEffectType.HEAL);
		effects.add(PotionEffectType.INCREASE_DAMAGE);
		effects.add(PotionEffectType.LUCK);
		effects.add(PotionEffectType.REGENERATION);
		effects.add(PotionEffectType.INVISIBILITY);
		effects.add(PotionEffectType.JUMP);
		effects.add(PotionEffectType.SLOW_FALLING);
		effects.add(PotionEffectType.NIGHT_VISION);
		//Other effects
		effects.add(PotionEffectType.LEVITATION);
		
		/*
		 * Minecraft uses a tick ratio of 20 ticks per second
		 */
		
		int rand = ThreadLocalRandom.current().nextInt(effects.size());
		PotionEffectType potion = effects.get(rand);
		int duration = 200; //The default duration that an effect should last, 10 seconds
		
		for (int a = 0; a < amount; a++)
		{
			if (potion == PotionEffectType.HARM) //this effect should not tick multiple times, tick for 1 second
			{
				duration = 1;
			}
			p.getPlayer().addPotionEffect(new PotionEffect(effects.get(rand), duration, 1));
			effects.remove(rand); //When looping more than once, remove the last effect as to not duplicate effects to pull from
		}
	}
}