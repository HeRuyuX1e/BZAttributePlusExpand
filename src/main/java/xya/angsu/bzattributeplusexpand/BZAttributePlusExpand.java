package xya.angsu.bzattributeplusexpand;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.serverct.ersha.jd.api.AttributeType;
import xya.angsu.bzattributeplusexpand.AttributeRegisters.Collection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class BZAttributePlusExpand extends JavaPlugin {
    public static String MessagePrefix;
    private static YamlConfiguration Attribute;

    @Override
    public void onLoad() {
        // 创建文件对象
        File fileConfig = new File(getDataFolder(),"config.yml");
        File fileAttribute = new File(getDataFolder(),"Attribute.yml");
        Attribute = YamlConfiguration.loadConfiguration(fileAttribute);
        // 判断配置文件是否存在
        getLogger().info("正在载入配置文件...");
        if (fileConfig.exists()){
            getLogger().info("配置文件已经存在，正在检查版本选项。");
            // 检查配置文件版本是否与主版本一致
            if (getDescription().getVersion().equalsIgnoreCase(getConfig().getString("Version"))){
                getLogger().info("配置文件与插件版本一致，已通过检查。");
            }else{
                getLogger().warning("警告: 配置文件与插件版本不一致，将按照设定进行操作！");
                // 判断是否允许自动升级配置文件
                if (getConfig().getBoolean("AutoUpdateConfig")){
                    getLogger().warning("即将对配置文件进行重置操作，此操作将会重置默认配置文件！");
                    // 删除原配置文件
                    fileConfig.delete();
                    // 释放默认配置文件
                    saveResource("config.yml",true);
                    // 重载配置文件
                    reloadConfig();
                }else{
                    getLogger().warning("根据设定，禁止自动重置默认配置文件！请参照GitHub版本迭代的提示进行添加！");
                }
            }
        }else{
            // 释放默认配置文件
            saveResource("config.yml",false);
        }
        getLogger().info("配置文件载入完成！");
        getLogger().info("正在载入属性文件...");
        if (fileAttribute.exists()){
            getLogger().info("属性文件载入中！");
        }else{
            getLogger().warning("属性文件不存在，正在释放默认属性文件。");
            saveResource("Attribute.yml",true);
        }
        getLogger().info("属性文件载入完成！");
        MessagePrefix = getConfig().getString("MessagePrefix").replace("&","§");
    }

    @Override
    public void onEnable() {
        getLogger().info("开启注册额外属性...");
        Set<String> setAttribute = Attribute.getConfigurationSection("Attribute").getKeys(false);
        // 这里好像不转化为List类型也可以，只是不想里面有重复元素导致重复注册。
        List<String> attribute = new ArrayList<>(setAttribute);
        for (String s: attribute){
            getLogger().info("注册属性："+s+" 变量名称为：%ap_"+Attribute.getString("Attribute."+s+".ID")+"%");
            if (s.equalsIgnoreCase("采集伤害")){
                new Collection().registerAttribute();
                continue;
            }
            new AttributeRegister(AttributeType.DAMAGE, s, Attribute.getString("Attribute." + s + ".ID")).registerAttribute();

        }
        getLogger().info("额外属性注册完成！");
    }

    @Override
    public void onDisable() {

    }
}
