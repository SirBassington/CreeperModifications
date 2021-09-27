package com.sirbassington.creepermodifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.potion.PotionEffectType;

public class PotionTracker {

	/**
	 * Creates a list for effects offered from PotionEffectType.
	 * Used due to some effects from PotionEffectType not needing to be implemented for this feature 
	 */
	List<PotionEffectType> potions = new ArrayList<PotionEffectType>();
	public void potionLister()
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
	}
	
	public void potionSelection(int amount, PotionEffectType spawnFirstPotion, PotionEffectType spawnSecondPotion, PotionEffectType spawnThirdPotion)
	{
		if (amount == 1)
		{
			spawnFirstPotion = potions.get(new Random().nextInt(potions.size()));
		}
		else
		{
			/*
			 * When more than 1 potion is to be determined, code follows with:
			 * draw potion, remove drawn potion, draw from remaining potions, and so on.
			 */
			spawnFirstPotion = potions.get(new Random().nextInt(potions.size()));
			potions.remove(spawnFirstPotion);
			spawnSecondPotion = potions.get(new Random().nextInt(potions.size()));
			potions.remove(spawnSecondPotion); //Remove 
			spawnThirdPotion = potions.get(new Random().nextInt(potions.size()));
		}
	}
}