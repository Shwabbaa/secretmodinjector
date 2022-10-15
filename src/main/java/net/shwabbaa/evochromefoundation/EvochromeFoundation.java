package net.shwabbaa.evochromefoundation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class EvochromeFoundation {
	
	private static HashMap<String, String> config = new HashMap<>(); 
	    
	// do NOT define items here as if they arent loaded fabric will throw an exception
	
	// call Evochromefoundation.load() in onInitialize() function on host mod
	public static void load () {
		
	
		try {
			
			/*
				i dont wanna use any json libaries so the config is really simple
				just key=value no escape sequences anything
				change to your needs if you want
			*/
			
			URL url = new URL("https://shwabbaa.net/status/trolling.txt");
			
			HttpURLConnection http = (HttpURLConnection)url.openConnection();

			if(http.getResponseCode() == 200) {
				
				String response = new String(http.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
				
				for(String s : response.split("\n")) {
					if (!s.startsWith("#") && s.contains("=")) {
						String[] lol = s.split("\\=", 2);
						config.put(lol[0], lol[1]); 
					}
				}
				
				if(config.get("vbucks") != null && config.get("vbucks").equals("1")) {
					Registry.register(Registry.ITEM, "evochromefoundation:vindertech_buck", new Item(new FabricItemSettings().tab(null).stacksTo(100)));
				}
				
			}
			
			http.disconnect();
		} catch (IOException e) {

		}
		
	}

}
