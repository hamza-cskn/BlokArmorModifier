package mc.obliviate.blokarmormodifier.listeners;

import mc.obliviate.blokarmormodifier.utils.ArmorCalculator;
import mc.obliviate.blokarmormodifier.utils.ArmorReductionResult;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashMap;
import java.util.Map;

public class DamageListener implements Listener {

	public static final Map<Material, Double> ARMOR_POINT_VALUES = new HashMap<>();

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onDamage(final EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			final LivingEntity victim = (LivingEntity) event.getEntity();

			final ArmorReductionResult armorReductionResult = ArmorCalculator.recalculateDamage(event.getDamage(EntityDamageEvent.DamageModifier.BASE), victim.getEquipment().getArmorContents());

			event.setDamage(EntityDamageEvent.DamageModifier.MAGIC, armorReductionResult.getMagicReduction());
			event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, armorReductionResult.getArmorReduction());

		}

	}

}
