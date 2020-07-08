package xya.angsu.bzattributeplusexpand.AttributeRegisters;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.serverct.ersha.jd.api.AttributeType;
import org.serverct.ersha.jd.api.BaseAttribute;
import org.serverct.ersha.jd.attribute.AttributeData;
import xya.angsu.bzattributeplusexpand.BZAttributePlusExpand;

// 采集属性
/*
 * RUNTIME 自身
 * DAMAGE  攻击怪物
 * INJURED 被攻击
 */

public class Collection extends BaseAttribute {
    private static String MessagePrefix = BZAttributePlusExpand.MessagePrefix;
    public Collection() {
        super(AttributeType.DAMAGE, "采集伤害", "collection");
    }

    @Override
    public void run(Entity damager, Entity entity, double attributeValue) {
        if (entity instanceof Player){
            setDamage(entity,true);
            return;
        }
        entity.getWorld().playEffect(entity.getLocation(),Effect.VILLAGER_PLANT_GROW,5);
        // 实际造成伤害的代码
        ((LivingEntity)entity).damage(attributeValue);
    }

}
