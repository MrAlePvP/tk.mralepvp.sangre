package me.sangreyt;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Primaria extends JavaPlugin
  implements Listener
{
  public void onEnable()
  {
    System.out.println("El plugin se ha activado correctamente");
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
  }
  public void onDisable()
  {
    System.out.println("El plugin se ha desactivado correctamente");
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void dañoe(EntityDamageByEntityEvent e)
  {
	e.getEntity()
	  .getLocation()
	  .getWorld()
	  .playEffect(e.getEntity().getLocation().add(0.0D, 1.0D, 0.0D),
	  Effect.STEP_SOUND, 55);
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void dañob(EntityDamageByBlockEvent e) {
	e.getEntity()
	  .getLocation()
	  .getWorld()
	  .playEffect(e.getEntity().getLocation().add(0.0D, 1.0D, 0.0D),
	  Effect.STEP_SOUND, 55);
  }
}