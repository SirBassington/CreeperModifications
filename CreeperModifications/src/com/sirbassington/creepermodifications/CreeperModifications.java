package com.sirbassington.creepermodifications;

import org.bukkit.plugin.java.JavaPlugin;

public class CreeperModifications extends JavaPlugin {

	/**
	 * Server plugin for my home-hosted Minecraft server.
	 * Features of this plugin are determined by the players on the server through a vote process.
	 * Plugin may branch out into other features or said features may split into their own unique plugins.
	 * 
	 * Goal of this plugin is to modify all things creeper!
	 */
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new ExplosionEvent(), this);
		getServer().getPluginManager().registerEvents(new CreeperStatusEffectEvent(), this);
	}
	
	@Override
	public void onDisable()
	{
		
	}
}