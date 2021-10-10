package com.sirbassington.creepermodifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.io.BukkitObjectOutputStream;

public class PotionTracker {

	/**
	 * Creates a list for effects offered from PotionEffectType.
	 * Used due to some effects from PotionEffectType not needing to be implemented for this feature 
	 */
	List<PotionEffectType> potions = new ArrayList<PotionEffectType>();
	
	public void potionSelection(int amount, Player p)
	{
		//Negative effect potions
		potions.add(PotionEffectType.HARM);
		potions.add(PotionEffectType.HUNGER);
		potions.add(PotionEffectType.POISON);
		potions.add(PotionEffectType.SLOW);
		potions.add(PotionEffectType.WEAKNESS);
		potions.add(PotionEffectType.WITHER);
		//Positive effect potions
		potions.add(PotionEffectType.DAMAGE_RESISTANCE);
		potions.add(PotionEffectType.FIRE_RESISTANCE);
		potions.add(PotionEffectType.HEAL);
		potions.add(PotionEffectType.INCREASE_DAMAGE);
		potions.add(PotionEffectType.LUCK);
		potions.add(PotionEffectType.REGENERATION);
		//Other
		potions.add(PotionEffectType.BLINDNESS);
		potions.add(PotionEffectType.INVISIBILITY);
		potions.add(PotionEffectType.JUMP);
		potions.add(PotionEffectType.LEVITATION);
		potions.add(PotionEffectType.SLOW_FALLING);
		potions.add(PotionEffectType.NIGHT_VISION);
		
		int rand = ThreadLocalRandom.current().nextInt(potions.size());
		PotionEffectType potion = null;
		
		for (int a = 0; a < amount; a++)
		{
			p.getPlayer().addPotionEffect(new PotionEffect(potions.get(rand), 200, 1));
			potions.remove(rand);
		}
	}
}