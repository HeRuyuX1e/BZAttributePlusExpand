package xya.angsu.bzattributeplusexpand;

import org.bukkit.entity.Entity;
import org.serverct.ersha.jd.api.AttributeType;
import org.serverct.ersha.jd.api.BaseAttribute;
import org.serverct.ersha.jd.attribute.AttributeData;

public class AttributeRegister extends BaseAttribute {
    public AttributeRegister(AttributeType attributeType, String attributeName, String placeholder) {
        super(attributeType, attributeName, placeholder);
    }

    @Override
    public void run(Entity entity, AttributeData attributeData) {
        super.run(entity, attributeData);
    }
}
