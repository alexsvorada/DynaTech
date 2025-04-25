package me.profelements.dynatech.listeners;

import io.github.thebusybiscuit.slimefun4.utils.ChargeUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.profelements.dynatech.DynaTech;
import me.profelements.dynatech.registries.Items;
import me.profelements.dynatech.items.tools.ElectricalStimulator;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class ElectricalStimulatorListener implements Listener {

    private final ElectricalStimulator electricalStimulator;

    public ElectricalStimulatorListener(@Nonnull DynaTech plugin, @Nonnull ElectricalStimulator electricalStimulator) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.electricalStimulator = electricalStimulator;
    }

    @EventHandler
    public void onHungerLoss(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player p && p.getFoodLevel() < 20 && feedPlayer(p)) {
            e.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onHungerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p && e.getCause() == EntityDamageEvent.DamageCause.STARVATION
                && feedPlayer(p)) {
            p.setFoodLevel(20);
            p.setSaturation(20f);
        }
    }

    private boolean feedPlayer(Player p) {
        if (electricalStimulator == null || electricalStimulator.isDisabled()) {
            return false;
        }

        for (ItemStack item : p.getInventory().getStorageContents()) {
            if (item != null && item.getType() == electricalStimulator.getItem().getType()
                    && SlimefunUtils.isItemSimilar(item, Items.ELECTRICAL_STIMULATOR.stack().item(), false, false)
                    && ChargeUtils.getCharge(item.getItemMeta()) > electricalStimulator.getEnergyComsumption()) {
                if (SlimefunUtils.canPlayerUseItem(p, item, true)) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 1F, 1F);
                    electricalStimulator.removeItemCharge(item, electricalStimulator.getEnergyComsumption());
                    return true;
                }
            }
        }
        return false;
    }

}
