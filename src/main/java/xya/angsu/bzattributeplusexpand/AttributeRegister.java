package xya.angsu.bzattributeplusexpand;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.serverct.ersha.jd.api.AttributeType;
import org.serverct.ersha.jd.api.BaseAttribute;
import org.serverct.ersha.jd.attribute.AttributeData;

public class AttributeRegister extends BaseAttribute {
    private static String MessagePrefix = BZAttributePlusExpand.MessagePrefix;
    public AttributeRegister(AttributeType attributeType, String attributeName, String placeholder) {
        super(attributeType, attributeName, placeholder);
    }

    @Override
    public void run(Entity damager, Entity entity, double attributeValue) {
        entity.sendMessage(MessagePrefix+"你对"+entity.getName()+"造成了"+attributeValue+"点伤害");
        // 实际造成伤害的代码
        ((LivingEntity)entity).damage(attributeValue);
    }
}
