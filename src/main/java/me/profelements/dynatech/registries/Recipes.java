package me.profelements.dynatech.registries;

import me.profelements.dynatech.DynaTech;
import me.profelements.dynatech.items.misc.StarDustMeteor;
import me.profelements.dynatech.utils.Recipe;
import me.profelements.dynatech.utils.TimedRecipe;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.bakedlibs.dough.skins.PlayerSkin;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.enchantments.Enchantment;

public class Recipes {
    // START common use items
    private static final ItemStack STICK = new ItemStack(Material.STICK);
    private static final ItemStack OAK_LOG = new ItemStack(Material.OAK_LOG);
    private static final ItemStack REDSTONE_BLOCK = new ItemStack(Material.REDSTONE_BLOCK);
    private static final ItemStack BRICK = new ItemStack(Material.BRICK);
    private static final ItemStack STONE = new ItemStack(Material.STONE);
    private static final ItemStack DEEPSLATE = new ItemStack(Material.DEEPSLATE);
    private static final ItemStack CALCITE = new ItemStack(Material.CALCITE);
    private static final ItemStack IRON_INGOT = new ItemStack(Material.IRON_INGOT);
    private static final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
    private static final ItemStack DIAMOND = new ItemStack(Material.DIAMOND);
    private static final ItemStack DIAMOND_BLOCK = new ItemStack(Material.DIAMOND_BLOCK);
    private static final ItemStack CRYING_OBSIDIAN = new ItemStack(Material.CRYING_OBSIDIAN);
    private static final ItemStack UNBREAKING_3_ENCHANTED_BOOK = new CustomItemStack(Material.ENCHANTED_BOOK, meta -> {
        meta.addEnchant(Enchantment.UNBREAKING, 3, false);
    });

    private static final ItemStack GLASS = new ItemStack(Material.GLASS);
    private static final ItemStack CYAN_CONCRETE = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
    private static final ItemStack PINK_CONCRETE = new ItemStack(Material.PINK_CONCRETE);
    private static final ItemStack STRING = new ItemStack(Material.STRING);
    private static final ItemStack IRON_BARS = new ItemStack(Material.IRON_BARS);
    private static final ItemStack END_STONE = new ItemStack(Material.END_STONE);
    private static final ItemStack CHORUS_FRUIT = new ItemStack(Material.CHORUS_FRUIT);
    private static final ItemStack BOOK = new ItemStack(Material.BOOK);
    private static final ItemStack SMOOTH_STONE = new ItemStack(Material.SMOOTH_STONE);
    private static final ItemStack SMOOTH_STONE_SLAB = new ItemStack(Material.SMOOTH_STONE_SLAB);
    private static final ItemStack BUCKET = new ItemStack(Material.BUCKET);

    // END common use items

    public static void init(Registry<Recipe> registry) {
        for (Material mat : Tag.LOGS.getValues()) {
            Recipe.init()
                    .setKey(new NamespacedKey(DynaTech.getInstance(), mat.toString().toLowerCase() + "_to_charcoal"))
                    .setRecipeType(RecipeTypes.OVENING)
                    .setInput(new ItemStack(mat))
                    .setOutput(new ItemStack(Material.CHARCOAL))
                    .register();
        }

        TimedRecipe.init()
                .setTimeInTicks(20)
                .setKey(new NamespacedKey(DynaTech.getInstance(), "oak_tree"))
                .setRecipeType(RecipeTypes.TREE_GROWTH_CHAMBER)
                .setInput(new ItemStack(Material.OAK_SAPLING))
                .setOutput(
                        new ItemStack[] {
                                new ItemStack(Material.OAK_SAPLING, 2),
                                new ItemStack(Material.OAK_LOG, 6),
                                new ItemStack(Material.OAK_LEAVES, 3)
                        })
                .register();

    }

    // START Mechanical Components

    // Wood Machine Core
    public static final Recipe WOOD_MACHINE_CORE = Recipe.init()
            .setKey(Keys.WOOD_MACHINE_CORE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { STICK, OAK_LOG, STICK, OAK_LOG, REDSTONE_BLOCK, OAK_LOG, STICK, OAK_LOG,
                    STICK })
            .setOutput(Items.WOOD_MACHINE_CORE.stack().item())
            .register();

    // Stone Machine Core
    public static final Recipe STONE_MACHINE_CORE = Recipe.init()
            .setKey(Keys.STONE_MACHINE_CORE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { BRICK, STONE, BRICK,
                    STONE, Items.WOOD_MACHINE_CORE.stack().item(), STONE, BRICK, STONE, BRICK })
            .setOutput(Items.STONE_MACHINE_CORE.stack().item())
            .register();

    // Iron Machine Core
    public static final Recipe IRON_MACHINE_CORE = Recipe.init()
            .setKey(Keys.IRON_MACHINE_CORE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { IRON_INGOT, IRON_BLOCK, IRON_INGOT, IRON_BLOCK,
                    Items.STONE_MACHINE_CORE.stack().item(), IRON_BLOCK, IRON_INGOT, IRON_BLOCK, IRON_INGOT })
            .setOutput(Items.IRON_MACHINE_CORE.stack().item())
            .register();

    // Diamond Machine Core
    public static final Recipe DIAMOND_MACHINE_CORE = Recipe.init()
            .setKey(Keys.DIAMOND_MACHINE_CORE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { DIAMOND, DIAMOND_BLOCK, DIAMOND, DIAMOND_BLOCK,
                    Items.IRON_MACHINE_CORE.stack().item(), DIAMOND_BLOCK, DIAMOND, DIAMOND_BLOCK, DIAMOND })
            .setOutput(Items.DIAMOND_MACHINE_CORE.stack().item())
            .register();

    // Enchanted Machine Core
    public static final Recipe ENCHANTED_MACHINE_CORE = Recipe.init()
            .setKey(Keys.ENCHANTED_MACHINE_CORE.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] { UNBREAKING_3_ENCHANTED_BOOK, CRYING_OBSIDIAN, UNBREAKING_3_ENCHANTED_BOOK,
                    CRYING_OBSIDIAN, Items.DIAMOND_MACHINE_CORE.stack().item(), CRYING_OBSIDIAN,
                    UNBREAKING_3_ENCHANTED_BOOK, CRYING_OBSIDIAN, UNBREAKING_3_ENCHANTED_BOOK })
            .setOutput(Items.ENCHANTED_MACHINE_CORE.stack().item())
            .register();

    // Ancient Machine Core

    public static final Recipe ANCIENT_MACHINE_CORE = Recipe.init()
            .setKey(Keys.ANCIENT_MACHINE_CORE.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.LEAD_INGOT.item(), SlimefunItems.MAGIC_LUMP_1.item(), SlimefunItems.LEAD_INGOT.item(),
                    SlimefunItems.MAGIC_LUMP_1.item(), new ItemStack(Material.REDSTONE_BLOCK), SlimefunItems.MAGIC_LUMP_1.item(),
                    SlimefunItems.LEAD_INGOT.item(), SlimefunItems.MAGIC_LUMP_1.item(), SlimefunItems.LEAD_INGOT.item()
            })
            .setOutput(Items.ANCIENT_MACHINE_CORE.stack().item())
            .register();

    // Energy Storage Component
    public static final Recipe ENERGY_STORAGE_COMPONENT = Recipe.init()
            .setKey(Keys.ENERGY_STORAGE_COMPONENT.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { SlimefunItems.REDSTONE_ALLOY.item(), GLASS, SlimefunItems.REDSTONE_ALLOY.item(), GLASS,
                    SlimefunItems.BATTERY.item(), GLASS, Items.STAINLESS_STEEL_INGOT.stack().item(),
                    Items.IRON_MACHINE_CORE.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item() })
            .setOutput(Items.ENERGY_STORAGE_COMPONENT.stack().item())
            .register();

    // Energy Input Component
    public static final Recipe ENERGY_INPUT_COMPONENT = Recipe.init()
            .setKey(Keys.ENERGY_INPUT_COMPONENT.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE).setInput(new ItemStack[] {
                    SlimefunItems.REDSTONE_ALLOY.item(), PINK_CONCRETE, SlimefunItems.REDSTONE_ALLOY.item(),
                    SlimefunItems.COPPER_WIRE.item(), Items.IRON_MACHINE_CORE.stack().item(), SlimefunItems.COPPER_WIRE.item(),
                    SlimefunItems.REDSTONE_ALLOY.item(), PINK_CONCRETE, SlimefunItems.REDSTONE_ALLOY.item(),
            }).setOutput(Items.ENERGY_INPUT_COMPONENT.stack().item())
            .register();

    // Energy Output Component
    public static final Recipe ENERGY_OUTPUT_COMPONENT = Recipe.init()
            .setKey(Keys.ENERGY_OUTPUT_COMPONENT.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.REDSTONE_ALLOY.item(), CYAN_CONCRETE, SlimefunItems.REDSTONE_ALLOY.item(),
                    SlimefunItems.COPPER_WIRE.item(), Items.IRON_MACHINE_CORE.stack().item(), SlimefunItems.COPPER_WIRE.item(),
                    SlimefunItems.REDSTONE_ALLOY.item(), CYAN_CONCRETE, SlimefunItems.REDSTONE_ALLOY.item()
            })
            .setOutput(Items.ENERGY_OUTPUT_COMPONENT.stack().item())
            .register();

    // Degraded Wind Mill
    public static final Recipe DEGRADED_WIND_MILL = Recipe.init()
            .setKey(Keys.DEGRADED_WIND_MILL.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.WIND_MILL.stack().item() })
            .setOutput(Items.DEGRADED_WIND_MILL.stack().item())
            .register();

    // Degraded Wind Mill 2
    public static final Recipe DEGRADED_WIND_MILL_2 = Recipe.init()
            .setKey(Keys.DEGRADED_WIND_MILL_2.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.WIND_MILL_2.stack().item() })
            .setOutput(Items.DEGRADED_WIND_MILL_2.stack().item())
            .register();

    // Degraded Hydro Mill
    public static final Recipe DEGRADED_WATER_MILL = Recipe.init()
            .setKey(Keys.DEGRADED_WATER_MILL.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.WATER_MILL.stack().item() })
            .setOutput(Items.DEGRADED_WATER_MILL.stack().item())
            .register();

    // Degraded Hydro Mill 2
    public static final Recipe DEGRADED_WATER_MILL_2 = Recipe.init()
            .setKey(Keys.DEGRADED_WATER_MILL_2.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.WATER_MILL_2.stack().item() })
            .setOutput(Items.DEGRADED_WATER_MILL_2.stack().item())
            .register();
    // Degraded Egg Mill
    public static final Recipe DEGRADED_EGG_MILL = Recipe.init()
            .setKey(Keys.DEGRADED_EGG_MILL.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.EGG_MILL.stack().item() })
            .setOutput(Items.DEGRADED_EGG_MILL.stack().item())
            .register();

    // Degraded Egg Mill 2
    public static final Recipe DEGRADED_EGG_MILL_2 = Recipe.init()
            .setKey(Keys.DEGRADED_EGG_MILL_2.key())
            .setRecipeType(RecipeTypes.BLOCK_DROP)
            .setInput(new ItemStack[] { Items.EGG_MILL_2.stack().item() })
            .setOutput(Items.DEGRADED_EGG_MILL_2.stack().item())
            .register();

    // END Mechanical Components

    // Start Generators

    // Water Mill Level 1 (Hydro Generator)
    public static final Recipe WATER_MILL = Recipe.init()
            .setKey(Keys.WATER_MILL.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.WOOD_MACHINE_CORE.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.ENERGY_STORAGE_COMPONENT.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.ENERGY_OUTPUT_COMPONENT.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
            })
            .setOutput(Items.WATER_MILL.stack().item())
            .register();

    // Water Mill Repair
    public static final Recipe WATER_MILL_REPAIR = Recipe.init()
            .setKey(Keys.WATER_MILL_REPAIR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, null, null,
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.DEGRADED_WATER_MILL.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
            })
            .setOutput(Items.WATER_MILL.stack().item())
            .register();

    // Water Mill Level 2 (Hydro Turbine)
    public static final Recipe WATER_MILL_2 = Recipe.init()
            .setKey(Keys.WATER_MILL_2.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.STONE_MACHINE_CORE.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.WATER_MILL.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.WATER_MILL.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
            })
            .setOutput(Items.WATER_MILL_2.stack().item())
            .register();

    // Water Mill Level 2 Repair
    public static final Recipe WATER_MILL_2_REPAIR = Recipe.init()
            .setKey(Keys.WATER_MILL_2_REPAIR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, null, null,
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.DEGRADED_WATER_MILL_2.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
            })
            .setOutput(Items.WATER_MILL_2.stack().item())
            .register();

    // Wind Mill Level 1
    public static final Recipe WIND_MILL = Recipe.init()
            .setKey(Keys.WIND_MILL.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, Items.STAINLESS_STEEL_ROTOR.stack().item(), null,
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.WOOD_MACHINE_CORE.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.ENERGY_STORAGE_COMPONENT.stack().item(), Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.ENERGY_OUTPUT_COMPONENT.stack().item(),
            })
            .setOutput(Items.WIND_MILL.stack().item())
            .register();

    // Wind Mill Level 1 Repair
    public static final Recipe WIND_MILL_REPAIR = Recipe.init()
            .setKey(Keys.WIND_MILL_REPAIR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, IRON_INGOT, null,
                    IRON_INGOT, Items.DEGRADED_WIND_MILL.stack().item(), IRON_INGOT,
                    IRON_BLOCK, IRON_INGOT, IRON_BLOCK
            })
            .setOutput(Items.WIND_MILL.stack().item())
            .register();

    // Wind Mill Level 2
    public static final Recipe WIND_MILL_2 = Recipe.init()
            .setKey(Keys.WIND_MILL_2.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, Items.STAINLESS_STEEL_ROTOR.stack().item(), null,
                    Items.STAINLESS_STEEL_ROTOR.stack().item(), Items.STONE_MACHINE_CORE.stack().item(),
                    Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.WIND_MILL.stack().item(), Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    Items.WIND_MILL.stack().item(),
            })
            .setOutput(Items.WIND_MILL_2.stack().item())
            .register();

    // Wind Mill Level 2 Repair
    public static final Recipe WIND_MILL_2_REPAIR = Recipe.init()
            .setKey(Keys.WIND_MILL_2_REPAIR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, IRON_INGOT, null,
                    IRON_INGOT, Items.DEGRADED_WIND_MILL_2.stack().item(), IRON_INGOT,
                    IRON_BLOCK, IRON_INGOT, IRON_BLOCK
            })
            .setOutput(Items.WIND_MILL_2.stack().item())
            .register();

    // Egg Mill Level 1
    public static final Recipe EGG_MILL = Recipe.init()
            .setKey(Keys.EGG_MILL.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.MAGIC_LUMP_3.item(), END_STONE, SlimefunItems.MAGIC_LUMP_3.item(),
                    CHORUS_FRUIT, Items.WOOD_MACHINE_CORE.stack().item(), CHORUS_FRUIT,
                    Items.ENERGY_OUTPUT_COMPONENT.stack().item(), END_STONE, Items.ENERGY_STORAGE_COMPONENT.stack().item(),
            })
            .setOutput(Items.EGG_MILL.stack().item())
            .register();

    // Egg Mill Level 1 Repair
    public static final Recipe EGG_MILL_REPAIR = Recipe.init()
            .setKey(Keys.EGG_MILL_REPAIR.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.MAGIC_LUMP_1.item(), END_STONE, SlimefunItems.MAGIC_LUMP_1.item(),
                    CHORUS_FRUIT, Items.DEGRADED_EGG_MILL.stack().item(), CHORUS_FRUIT,
                    SlimefunItems.MAGIC_LUMP_1.item(), END_STONE, SlimefunItems.MAGIC_LUMP_1.item(),
            })
            .setOutput(Items.EGG_MILL.stack().item())
            .register();

    // Egg Mill Level 2
    public static final Recipe EGG_MILL_2 = Recipe.init()
            .setKey(Keys.EGG_MILL_2.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.MAGIC_LUMP_3.item(), END_STONE, SlimefunItems.MAGIC_LUMP_3.item(),
                    CHORUS_FRUIT, Items.WOOD_MACHINE_CORE.stack().item(), CHORUS_FRUIT,
                    Items.EGG_MILL.stack().item(), END_STONE, Items.EGG_MILL.stack().item(),
            })
            .setOutput(Items.EGG_MILL_2.stack().item())
            .register();

    // Egg Mill Level 2 Repair
    public static final Recipe EGG_MILL_2_REPAIR = Recipe.init()
            .setKey(Keys.EGG_MILL_2_REPAIR.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.MAGIC_LUMP_1.item(), END_STONE, SlimefunItems.MAGIC_LUMP_1.item(),
                    CHORUS_FRUIT, Items.DEGRADED_EGG_MILL_2.stack().item(), CHORUS_FRUIT,
                    SlimefunItems.MAGIC_LUMP_1.item(), END_STONE, SlimefunItems.MAGIC_LUMP_1.item(),
            })
            .setOutput(Items.EGG_MILL_2.stack().item())
            .register();

    // END Energy Generators

    // START Materials

    // Stainless Steel Ingot
    public static final Recipe STAINLESS_STEEL_INGOT = Recipe.init()
            .setKey(Keys.STAINLESS_STEEL_INGOT.key())
            .setRecipeType(RecipeType.SMELTERY)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_INGOT.item(), SlimefunItems.IRON_DUST.item(), SlimefunItems.ZINC_DUST.item(),
                    SlimefunItems.CARBON.item(),
            })
            .setOutput(Items.STAINLESS_STEEL_INGOT.stack().item())
            .register();

    // Stainless Steel Rotor
    public static final Recipe STAINLESS_STEEL_ROTOR = Recipe.init()
            .setKey(Keys.STAINLESS_STEEL_ROTOR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
                    Items.STAINLESS_STEEL_INGOT.stack().item(), IRON_BLOCK, Items.STAINLESS_STEEL_INGOT.stack().item(),
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
            })
            .setOutput(Items.STAINLESS_STEEL_ROTOR.stack().item())
            .register();

    // Charcoal to Coal Coke Oven Recipe
    public static final Recipe CHARCOAL_TO_COAL = Recipe.init()
            .setKey(Keys.CHARCOAL_TO_COAL.key())
            .setRecipeType(RecipeTypes.OVENING)
            .setInput(new ItemStack[] { new ItemStack(Material.CHARCOAL) })
            .setOutput(new ItemStack[] { new ItemStack(Material.COAL) })
            .register();

    // Logs to Charcoal Coke Oven Recipe
    // for (Material mat : Tag.LOGS.getValues()) {
    // Recipe.init()
    // .setKey(new NamespacedKey(DynaTech.getInstance(),
    // mat.toString().toLowerCase() + "_to_charcoal"))
    // .setRecipeType(RecipeTypes.OVENING)
    // .setInput(new ItemStack(mat))
    // .setOutput(new ItemStack(Material.CHARCOAL))
    // .register(registry);
    // }
    //
    // Coal To Coal Coke Recipe
    public static final Recipe COAL_TO_COAL_COKE = Recipe.init()
            .setKey(Keys.COAL_TO_COAL_COKE.key())
            .setRecipeType(RecipeTypes.OVENING)
            .setInput(new ItemStack(Material.COAL))
            .setOutput(Items.COAL_COKE.stack().item())
            .register();

    public static final Recipe BEE = Recipe.init()
            .setKey(Keys.BEE.key())
            .setRecipeType(RecipeTypes.SCOOPING)
            .setInput(new CustomItemStack(
                    PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                            "12724a9a4cdd68ba49415560e5be40b4a1c47cb5be1d66aedb52a30e62ef2d47")),
                    "&aAny Bee"))
            .setOutput(Items.BEE.stack().item())
            .register();

    public static final Recipe ROBOTIC_BEE = Recipe.init()
            .setKey(Keys.ROBOTIC_BEE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(), SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
                    SlimefunItems.SYNTHETIC_SAPPHIRE.item(), Items.MACHINE_SCRAP.stack().item(), SlimefunItems.SYNTHETIC_SAPPHIRE.item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(), Items.ANCIENT_MACHINE_CORE.stack().item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item()
            })
            .setOutput(Items.ROBOTIC_BEE.stack().item())
            .register();

    public static final Recipe ADVANCED_ROBOTIC_BEE = Recipe.init()
            .setKey(Keys.ADVANCED_ROBOTIC_BEE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.REINFORCED_PLATE.item(), SlimefunItems.REINFORCED_PLATE.item(), SlimefunItems.REINFORCED_PLATE.item(),
                    Items.VEX_GEM.stack().item(), Items.ADVANCED_MACHINE_SCRAP.stack().item(), Items.VEX_GEM.stack().item(),
                    SlimefunItems.GOLD_24K_BLOCK.item(), Items.ANCIENT_MACHINE_CORE.stack().item(), SlimefunItems.GOLD_24K_BLOCK.item()
            })
            .setOutput(Items.ADVANCED_ROBOTIC_BEE.stack().item())
            .register();

    public static final Recipe MACHINE_SCRAP = Recipe.init()
            .setKey(Keys.MACHINE_SCRAP.key())
            .setRecipeType(RecipeType.GRIND_STONE)
            .setInput(SlimefunItems.PROGRAMMABLE_ANDROID.item())
            .setOutput(Items.MACHINE_SCRAP.stack().item(), 8)
            .register();

    public static final Recipe ADVANCED_MACHINE_SCRAP = Recipe.init()

            .setKey(Keys.ADVANCED_MACHINE_SCRAP.key())
            .setRecipeType(RecipeType.GRIND_STONE)
            .setInput(SlimefunItems.PROGRAMMABLE_ANDROID_2.item())
            .setOutput(Items.ADVANCED_MACHINE_SCRAP.stack().item(), 8)
            .register();

    public static final Recipe VEX_GEM = Recipe.init()
            .setKey(Keys.VEX_GEM.key())
            .setRecipeType(RecipeType.MOB_DROP)
            .setInput(new ItemStack[] { null, null, null, null, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin
                    .fromHashCode("c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd")),
                    "&aVex") })
            .setOutput(Items.VEX_GEM.stack().item())
            .register();

    public static final Recipe VEX_GEM_ALT = Recipe.init().setKey(Keys.VEX_GEM_ALT.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] { null, SlimefunItems.SYNTHETIC_SAPPHIRE.item(), null,
                    new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.MAGIC_LUMP_3.item(),
                    new ItemStack(Material.PHANTOM_MEMBRANE),
                    Items.STAR_DUST.stack().item(), Items.STAR_DUST.stack().item(), Items.STAR_DUST.stack().item() })
            .setOutput(Items.VEX_GEM.stack().item())
            .register();

    public static final Recipe GHOSTLY_ESSENCE = Recipe.init()
            .setKey(Keys.GHOSTLY_ESSENCE.key())
            .setRecipeType(RecipeType.MOB_DROP)
            .setInput(new ItemStack[] { null, null, null, null, new CustomItemStack(PlayerHead.getItemStack(PlayerSkin
                    .fromHashCode("c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd")),
                    "&aVex") })
            .setOutput(Items.GHOSTLY_ESSENCE.stack().item())
            .register();

    public static final Recipe TESSERACTING_OBJ = Recipe.init()
            .setKey(Keys.TESSERACTING_OBJ.key())
            .setRecipeType(RecipeType.ANCIENT_ALTAR)
            .setInput(new ItemStack[] {
                    Items.GHOSTLY_ESSENCE.stack().item(), SlimefunItems.ENDER_RUNE.item(), Items.VEX_GEM.stack().item(),
                    SlimefunItems.ENDER_RUNE.item(), new ItemStack(Material.WITHER_ROSE), SlimefunItems.ENDER_RUNE.item(),
                    Items.VEX_GEM.stack().item(), SlimefunItems.ENDER_RUNE.item(), Items.GHOSTLY_ESSENCE.stack().item()
            })
            .setOutput(Items.TESSERACTING_OBJ.stack().item())
            .register();

    public static final Recipe STAR_DUST = Recipe.init()
            .setKey(Keys.STAR_DUST.key())
            .setRecipeType(RecipeType.GRIND_STONE)
            .setInput(StarDustMeteor.STARDUST_METEOR.item())
            .setOutput(Items.STAR_DUST.stack().item())
            .register();
    // END Materials
    // START Tools
    public static final Recipe INVENTORY_FILTER = Recipe.init()
            .setKey(Keys.INVENTORY_FILTER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    STRING, IRON_BARS, STRING,
                    IRON_BARS, Items.IRON_MACHINE_CORE.stack().item(), IRON_BARS,
                    STRING, IRON_BARS, STRING,

            }).setOutput(Items.INVENTORY_FILTER.stack().item())
            .register();

    public static final Recipe ELECTRICAL_STIMULATOR = Recipe.init()
            .setKey(Keys.ELECTRICAL_STIMULATOR.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    Items.STAINLESS_STEEL_INGOT.stack().item(),         null, Items.STAINLESS_STEEL_INGOT.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.FOOD_FABRICATOR.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    SlimefunItems.PLASTIC_SHEET.item(), SlimefunItems.PLASTIC_SHEET.item(), SlimefunItems.PLASTIC_SHEET.item()

            })
            .setOutput(Items.ELECTRICAL_STIMULATOR.stack().item())
            .register();

    public static final Recipe RECIPE_BOOK = Recipe.init()
            .setKey(Keys.RECIPE_BOOK.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
                    Items.STAINLESS_STEEL_INGOT.stack().item(), BOOK, Items.STAINLESS_STEEL_INGOT.stack().item(),
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
            })
            .setOutput(Items.RECIPE_BOOK.stack().item())
            .register();
    public static final Recipe AUTO_OUTPUT_UGPRADE = Recipe.init()
            .setKey(Keys.AUTO_OUTPUT_UPGRADE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.CARGO_MOTOR.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    GLASS, GLASS, GLASS,
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.CARGO_MOTOR.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
            })
            .setOutput(Items.AUTO_OUTPUT_UPGRADE.stack().item())
            .register();

    public static final Recipe AUTO_INPUT_UPGRADE = Recipe.init()
            .setKey(Keys.AUTO_INPUT_UPGRADE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.CARGO_MOTOR.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    new ItemStack(Material.HOPPER), new ItemStack(Material.HOPPER), new ItemStack(Material.HOPPER),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.CARGO_MOTOR.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
            })
            .setOutput(Items.AUTO_INPUT_UPGRADE.stack().item())
            .register();

    public static final Recipe PICNIC_BASKET = Recipe.init()
            .setKey(Keys.PICNIC_BASKET.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.CLOTH.item(), SlimefunItems.CLOTH.item(), SlimefunItems.CLOTH.item(),
                    new ItemStack(Material.BAMBOO), SlimefunItems.COOLER.item(), new ItemStack(Material.BAMBOO),
                    SlimefunItems.HEATING_COIL.item(), new ItemStack(Material.BAMBOO), SlimefunItems.COOLING_UNIT.item() })
            .setOutput(Items.PICNIC_BASKET.stack().item())
            .register();

    public static final Recipe SOUL_BOUND_PICNIC_BASKET = Recipe.init()
            .setKey(Keys.SOUL_BOUND_PICNIC_BASKET.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.ENDER_RUNE.item(),
                    new ItemStack(Material.CRYING_OBSIDIAN),
                    SlimefunItems.ENDER_RUNE.item(), Items.PICNIC_BASKET.stack().item(), SlimefunItems.ENDER_RUNE.item(),
                    new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.ENDER_RUNE.item(),
                    new ItemStack(Material.CRYING_OBSIDIAN)
            })
            .setOutput(Items.SOUL_BOUND_PICNIC_BASKET.stack().item())
            .register();

    public static final Recipe ANGEL_GEM = Recipe.init()
            .setKey(Keys.ANGEL_GEM.key())
            .setRecipeType(RecipeType.ANCIENT_ALTAR)
            .setInput(new ItemStack[] { new ItemStack(Material.NETHERITE_INGOT), SlimefunItems.NUCLEAR_REACTOR.item(),
                    new ItemStack(Material.NETHERITE_INGOT),
                    SlimefunItems.GOLD_24K_BLOCK.item(), Items.VEX_GEM.stack().item(), SlimefunItems.GOLD_24K_BLOCK.item(),
                    SlimefunItems.BLISTERING_INGOT_3.item(), Items.STAINLESS_STEEL_ROTOR.stack().item(),
                    SlimefunItems.BLISTERING_INGOT_3.item()
            })
            .setOutput(Items.ANGEL_GEM.stack().item())
            .register();

    public static final Recipe SCOOP = Recipe.init()
            .setKey(Keys.SCOOP.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] { new ItemStack(Material.WHITE_WOOL), new ItemStack(Material.WHITE_WOOL),
                    new ItemStack(Material.WHITE_WOOL),
                    new ItemStack(Material.WHITE_WOOL), SlimefunItems.BATTERY.item(), new ItemStack(Material.WHITE_WOOL),
                    null, new ItemStack(Material.STICK), null
            })
            .setOutput(Items.SCOOP.stack().item())
            .register();

    public static final Recipe DIMENSIONAL_HOME = Recipe.init()
            .setKey(Keys.DIMENSIONAL_HOME.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    null, null, SlimefunItems.GOLD_24K_BLOCK.item(),
                    SlimefunItems.BRONZE_INGOT.item(), new ItemStack(Material.BLAZE_ROD), null,
                    SlimefunItems.SYNTHETIC_SAPPHIRE.item(), SlimefunItems.BRONZE_INGOT.item(), null

            })
            .setOutput(Items.DIMENSIONAL_HOME.stack().item())
            .register();

    public static final Recipe ITEM_BAND_HASTE = Recipe.init()
            .setKey(Keys.ITEM_BAND_HASTE.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    SlimefunItems.COBALT_PICKAXE.item(), new ItemStack(Material.NETHER_STAR), SlimefunItems.COBALT_PICKAXE.item(),
                    new ItemStack(Material.NETHER_STAR), Items.VEX_GEM.stack().item(), new ItemStack(Material.NETHER_STAR),
                    SlimefunItems.COBALT_PICKAXE.item(), new ItemStack(Material.NETHER_STAR), SlimefunItems.COBALT_PICKAXE.item()

            })
            .setOutput(Items.ITEM_BAND_HASTE.stack().item())
            .register();

    public static final Recipe ITEM_BAND_HEALTH = Recipe.init()
            .setKey(Keys.ITEM_BAND_HEALTH.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.NETHER_STAR),
                    new ItemStack(Material.GOLDEN_CARROT),
                    new ItemStack(Material.NETHER_STAR), Items.VEX_GEM.stack().item(), new ItemStack(Material.NETHER_STAR),
                    new ItemStack(Material.GOLDEN_CARROT), new ItemStack(Material.NETHER_STAR),
                    new ItemStack(Material.GOLDEN_CARROT)
            }).setOutput(Items.ITEM_BAND_HEALTH.stack().item())
            .register();

    public static final Recipe TESSERACT_BINDER = Recipe.init()
            .setKey(Keys.TESSERACT_BINDER.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    null, Items.TESSERACTING_OBJ.stack().item(), null,
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
                    null, Items.STAINLESS_STEEL_INGOT.stack().item(), null,
            })
            .setOutput(Items.TESSERACT_BINDER.stack().item())
            .register();

    // END Tools
    public static final Recipe KITCHEN_AUTO_CRAFTER = Recipe.init()
            .setKey(Keys.KITCHEN_AUTO_CRAFTER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    new ItemStack(Material.BRICK), SlimefunItems.ELECTRIC_FURNACE.item(),
                    new ItemStack(Material.BRICK),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.GOLD_24K_BLOCK.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    new ItemStack(Material.TERRACOTTA), new ItemStack(Material.TERRACOTTA),
                    new ItemStack(Material.TERRACOTTA),

            })
            .setOutput(Items.KITCHEN_AUTO_CRAFTER.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER.key())

            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.HARDENED_GLASS.item(), SlimefunItems.TREE_GROWTH_ACCELERATOR.item(),
                    SlimefunItems.HARDENED_GLASS.item(),
                    new ItemStack(Material.BONE_BLOCK), new ItemStack(Material.GRASS_BLOCK),
                    new ItemStack(Material.BONE_BLOCK),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.CROP_GROWTH_ACCELERATOR_2.item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item()

            })
            .setOutput(Items.GROWTH_CHAMBER.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_MK2 = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_MK2.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER.stack().item(), SlimefunItems.STEEL_PLATE.item(),
                    new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.LIME_STAINED_GLASS),
                    new ItemStack(Material.SAND),
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER.stack().item(), SlimefunItems.STEEL_PLATE.item()

            })
            .setOutput(Items.GROWTH_CHAMBER_MK2.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_END = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_END.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_END.stack().item(), SlimefunItems.STEEL_PLATE.item(),
                    new ItemStack(Material.PURPUR_PILLAR), new ItemStack(Material.PURPLE_STAINED_GLASS),
                    new ItemStack(Material.END_STONE_BRICKS),
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_END.stack().item(), SlimefunItems.STEEL_PLATE.item()

            })
            .setOutput(Items.GROWTH_CHAMBER_END.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_MK2_END = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_MK2_END.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_END.stack().item(), SlimefunItems.STEEL_PLATE.item(),
                    new ItemStack(Material.PURPUR_PILLAR), new ItemStack(Material.PURPLE_STAINED_GLASS),
                    new ItemStack(Material.END_STONE_BRICKS),
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_END.stack().item(), SlimefunItems.STEEL_PLATE.item()

            })
            .setOutput(Items.GROWTH_CHAMBER_MK2_END.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_NETHER = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_NETHER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.HARDENED_GLASS.item(), new ItemStack(Material.RED_STAINED_GLASS),
                    SlimefunItems.HARDENED_GLASS.item(),
                    new ItemStack(Material.CRIMSON_NYLIUM), new ItemStack(Material.SOUL_SAND),
                    new ItemStack(Material.WARPED_NYLIUM),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.GROWTH_CHAMBER.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item()
            })
            .setOutput(Items.GROWTH_CHAMBER_NETHER.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_MK2_NETHER = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_MK2_NETHER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_NETHER.stack().item(), SlimefunItems.STEEL_PLATE.item(),
                    new ItemStack(Material.CRIMSON_NYLIUM), new ItemStack(Material.SOUL_SAND),
                    new ItemStack(Material.WARPED_NYLIUM),
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_NETHER.stack().item(), SlimefunItems.STEEL_PLATE.item()

            })
            .setOutput(Items.GROWTH_CHAMBER_MK2_NETHER.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_OCEAN = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_OCEAN.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.HARDENED_GLASS.item(), new ItemStack(Material.CYAN_STAINED_GLASS),
                    SlimefunItems.HARDENED_GLASS.item(),
                    new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.SAND),
                    new ItemStack(Material.WATER_BUCKET),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), Items.GROWTH_CHAMBER.stack().item(),
                    Items.STAINLESS_STEEL_INGOT.stack().item()
            })
            .setOutput(Items.GROWTH_CHAMBER_OCEAN.stack().item())
            .register();

    public static final Recipe GROWTH_CHAMBER_MK2_OCEAN = Recipe.init()
            .setKey(Keys.GROWTH_CHAMBER_MK2_OCEAN.key())

            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_OCEAN.stack().item(), SlimefunItems.STEEL_PLATE.item(),
                    new ItemStack(Material.GRAVEL), new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS),
                    new ItemStack(Material.DIRT),
                    SlimefunItems.STEEL_PLATE.item(), Items.GROWTH_CHAMBER_OCEAN.stack().item(), SlimefunItems.STEEL_PLATE.item()

            })
            .setOutput(Items.GROWTH_CHAMBER_MK2_OCEAN.stack().item())
            .register();

    public static final Recipe ANTIGRAVITY_BUBBLE = Recipe.init()
            .setKey(Keys.ANTIGRAVITY_BUBBLE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.BLISTERING_INGOT_3.item(), new ItemStack(Material.DIAMOND_BLOCK),
                    SlimefunItems.BLISTERING_INGOT_3.item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(), SlimefunItems.BIG_CAPACITOR.item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(), Items.STAINLESS_STEEL_INGOT.stack().item(),
                    SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
            })
            .setOutput(Items.ANTIGRAVITY_BUBBLE.stack().item())
            .register();

    public static final Recipe WEATHER_CONTROLLER = Recipe.init()
            .setKey(Keys.WEATHER_CONTROLLER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, SlimefunItems.HARDENED_METAL_INGOT.item(), null,
                    new ItemStack(Material.WATER_BUCKET), Items.ANCIENT_MACHINE_CORE.stack().item(),
                    new ItemStack(Material.LAVA_BUCKET),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), new ItemStack(Material.CRYING_OBSIDIAN),
                    Items.STAINLESS_STEEL_INGOT.stack().item()

            })
            .setOutput(Items.WEATHER_CONTROLLER.stack().item())
            .register();

    public static final Recipe POTION_SPRINKLER = Recipe.init()
            .setKey(Keys.POTION_SPRINKLER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    new ItemStack(Material.BREWING_STAND), null, new ItemStack(Material.BREWING_STAND),
                    new ItemStack(Material.IRON_BARS), Items.ANCIENT_MACHINE_CORE.stack().item(),
                    new ItemStack(Material.IRON_BARS),
                    SlimefunItems.FERROSILICON.item(), SlimefunItems.FERROSILICON.item(), SlimefunItems.FERROSILICON.item()
            })
            .setOutput(Items.POTION_SPRINKLER.stack().item())
            .register();

    public static final Recipe BARBED_WIRE = Recipe.init()
            .setKey(Keys.BARBED_WIRE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    new ItemStack(Material.IRON_SWORD), new ItemStack(Material.IRON_SWORD),
                    new ItemStack(Material.IRON_SWORD),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), new ItemStack(Material.OAK_LOG),
                    Items.STAINLESS_STEEL_INGOT.stack().item(),
                    SlimefunItems.ZINC_INGOT.item(), SlimefunItems.ZINC_INGOT.item(), SlimefunItems.ZINC_INGOT.item()

            })
            .setOutput(Items.BARBED_WIRE.stack().item())
            .register();

    public static final Recipe MATERIAL_HIVE = Recipe.init()
            .setKey(Keys.MATERIAL_HIVE.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.HARDENED_METAL_INGOT.item(), SlimefunItems.SYNTHETIC_DIAMOND.item(),
                    SlimefunItems.HARDENED_METAL_INGOT.item(),
                    SlimefunItems.HARDENED_METAL_INGOT.item(), new ItemStack(Material.BEEHIVE),
                    SlimefunItems.HARDENED_METAL_INGOT.item(),
                    Items.ADVANCED_MACHINE_SCRAP.stack().item(), Items.MACHINE_SCRAP.stack().item(),
                    Items.ADVANCED_MACHINE_SCRAP.stack().item()

            })
            .setOutput(Items.MATERIAL_HIVE.stack().item())
            .register();

    public static final Recipe WIRELESS_CHARGER = Recipe.init()
            .setKey(Keys.WIRELESS_CHARGER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    null, SlimefunItems.GPS_TRANSMITTER.item(), null,
                    SlimefunItems.GOLD_24K.item(), SlimefunItems.CHARGING_BENCH.item(), SlimefunItems.GOLD_24K.item(),
                    null, SlimefunItems.SMALL_CAPACITOR.item(), null
            })
            .setOutput(Items.WIRELESS_CHARGER.stack().item())
            .register();

    public static final Recipe SEED_PLUCKER = Recipe.init()
            .setKey(Keys.SEED_PLUCKER.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SlimefunItems.HARDENED_GLASS.item(), Items.STAINLESS_STEEL_INGOT.stack().item(), SlimefunItems.HARDENED_GLASS.item(),
                    new ItemStack(Material.BONE_BLOCK), null, new ItemStack(Material.BONE_BLOCK),
                    Items.STAINLESS_STEEL_INGOT.stack().item(), new ItemStack(Material.SHEARS),
                    Items.STAINLESS_STEEL_INGOT.stack().item()
            })
            .setOutput(Items.SEED_PLUCKER.stack().item())
            .register();

    public static final Recipe TESSERACT = Recipe.init()
            .setKey(Keys.TESSERACT.key())
            .setRecipeType(RecipeType.MAGIC_WORKBENCH)
            .setInput(new ItemStack[] {
                    Items.TESSERACTING_OBJ.stack().item(), Items.ENCHANTED_MACHINE_CORE.stack().item(),
                    Items.TESSERACTING_OBJ.stack().item(),
                    Items.WIRELESS_ENERGY_BANK.stack().item(), Items.ENERGY_INPUT_COMPONENT.stack().item(),
                    Items.WIRELESS_ENERGY_POINT.stack().item(),
                    Items.WIRELESS_ITEM_INPUT.stack().item(), Items.ENERGY_OUTPUT_COMPONENT.stack().item(),
                    Items.WIRELESS_ITEM_OUTPUT.stack().item()
            })
            .setOutput(Items.TESSERACT.stack().item(), 2)
            .register();

    public static final Recipe PETAL_APOTHECARY = Recipe.init()
            .setKey(Keys.PETAL_APOTHECARY.key())
            .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
            .setInput(new ItemStack[] {
                    SMOOTH_STONE, BUCKET, SMOOTH_STONE,
                    null, SMOOTH_STONE, null,
                    SMOOTH_STONE_SLAB, SMOOTH_STONE_SLAB, SMOOTH_STONE_SLAB,
            });

    // START EXPERIMENTAL SHENANIGANS
    public static final Recipe TEST_PETAL_APOTH_RECIPE = Recipe.init()
            .setKey(new NamespacedKey("dynatech", "test_apoth"))
            .setRecipeType(RecipeTypes.PETAL_APOTHECARY)
            .setInput(new ItemStack[] { new ItemStack(Material.BONE), new ItemStack(Material.WHEAT_SEEDS) })
            .setOutput(new ItemStack(Material.WHEAT))
            .register();

    // END EXPERIMETNAL SHENANIGANS

    // END MACHINES

    // START Orechid Recipes
    public static final Recipe STONE_TO_COAL_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_COAL_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.COAL_ORE), 3)
            .register();

    public static final Recipe STONE_TO_IRON_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_IRON_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.IRON_ORE), 2)
            .register();

    public static final Recipe STONE_TO_GOLD_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_GOLD_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.GOLD_ORE), 2)
            .register();

    public static final Recipe STONE_TO_COPPER_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_COPPER_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.COPPER_ORE), 3)
            .register();

    public static final Recipe STONE_TO_LAPIS_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_LAPIS_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.LAPIS_ORE), 3)
            .register();

    public static final Recipe STONE_TO_REDSTONE_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_REDSTONE_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.REDSTONE_ORE), 3)
            .register();

    public static final Recipe STONE_TO_DIAMOND_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_DIAMOND_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.DIAMOND_ORE), 1)
            .register();

    public static final Recipe STONE_TO_EMERALD_ORE = Recipe.init()
            .setKey(Recipes.Keys.STONE_TO_EMERALD_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(STONE)
            .setOutput(new ItemStack(Material.EMERALD_ORE), 1)
            .register();

    public static final Recipe NETHERRACK_TO_QUARTZ_ORE = Recipe.init()
            .setKey(Recipes.Keys.NETHERRACK_TO_QUARTZ_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.NETHERRACK))
            .setOutput(new ItemStack(Material.NETHER_QUARTZ_ORE), 3)
            .register();

    public static final Recipe NETHERRACK_TO_GOLD_ORE = Recipe.init()
            .setKey(Recipes.Keys.NETHERRACK_TO_GOLD_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.NETHERRACK))
            .setOutput(new ItemStack(Material.NETHER_GOLD_ORE), 3)
            .register();

    public static final Recipe NETHERRACK_TO_ANCIENT_DEBRIS = Recipe.init()
            .setKey(Recipes.Keys.NETHERRACK_TO_ANCIENT_DEBRIS.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.NETHERRACK))
            .setOutput(new ItemStack(Material.ANCIENT_DEBRIS), 3)
            .register();

    public static final Recipe NETHERRACK_TO_BASALT = Recipe.init()
            .setKey(Recipes.Keys.NETHERRACK_TO_BASALT.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.NETHERRACK))
            .setOutput(new ItemStack(Material.BASALT), 5)
            .register();

    public static final Recipe NETHERRACK_TO_BLACKSTONE = Recipe.init()
            .setKey(Recipes.Keys.NETHERRACK_TO_BLACKSTONE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.NETHERRACK))
            .setOutput(new ItemStack(Material.BLACKSTONE), 5)
            .register();

    public static final Recipe DEEPSLATE_TO_COAL_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_COAL_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_COAL_ORE), 3)
            .register();

    public static final Recipe DEEPSLATE_TO_IRON_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_IRON_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_IRON_ORE), 2)
            .register();

    public static final Recipe DEEPSLATE_TO_GOLD_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_GOLD_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_GOLD_ORE), 2)
            .register();

    public static final Recipe DEEPSLATE_TO_COPPER_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_COPPER_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_COPPER_ORE), 3)
            .register();

    public static final Recipe DEEPSLATE_TO_LAPIS_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_LAPIS_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_LAPIS_ORE), 3)
            .register();

    public static final Recipe DEEPSLATE_TO_REDSTONE_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_REDSTONE_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_REDSTONE_ORE), 3)
            .register();

    public static final Recipe DEEPSLATE_TO_DIAMOND_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_DIAMOND_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_DIAMOND_ORE), 1)
            .register();

    public static final Recipe DEEPSLATE_TO_EMERALD_ORE = Recipe.init()
            .setKey(Recipes.Keys.DEEPSLATE_TO_EMERALD_ORE.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(DEEPSLATE)
            .setOutput(new ItemStack(Material.DEEPSLATE_EMERALD_ORE), 1)
            .register();

    public static final Recipe CALCITE_TO_LIVINGROCK = Recipe.init()
            .setKey(Recipes.Keys.CALCITE_TO_LIVINGROCK.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(CALCITE)
            .setOutput(Items.LIVINGROCK.stack().item())
            .register();

    public static final Recipe DARK_OAK_TO_LIVINGWOOD = Recipe.init()
            .setKey(Recipes.Keys.DARK_OAK_TO_LIVINGWOOD.key())
            .setRecipeType(RecipeTypes.ORECHID)
            .setInput(new ItemStack(Material.DARK_OAK_LOG))
            .setOutput(Items.LIVINGWOOD.stack().item())
            .register();

    // END Orechid Recipes

    public static final class Keys {

        // START Mechanical Components
        public static final TypedKey<Recipe> WOOD_MACHINE_CORE = TypedKey.create("dynatech", "wood_machine_core");

        public static final TypedKey<Recipe> STONE_MACHINE_CORE = TypedKey.create("dynatech", "stone_machine_core");

        public static final TypedKey<Recipe> IRON_MACHINE_CORE = TypedKey.create("dynatech", "iron_machine_core");

        public static final TypedKey<Recipe> DIAMOND_MACHINE_CORE = TypedKey.create("dynatech", "diamond_machine_core");

        public static final TypedKey<Recipe> ENCHANTED_MACHINE_CORE = TypedKey.create("dynatech",
                "enchanted_machine_core");

        public static final TypedKey<Recipe> ANCIENT_MACHINE_CORE = TypedKey.create("dynatech",
                "ancient_machine_core");

        public static final TypedKey<Recipe> ENERGY_STORAGE_COMPONENT = TypedKey.create("dynatech",
                "energy_storage_component");

        public static final TypedKey<Recipe> ENERGY_INPUT_COMPONENT = TypedKey.create("dynatech",
                "energy_input_component");

        public static final TypedKey<Recipe> ENERGY_OUTPUT_COMPONENT = TypedKey.create("dynatech",
                "energy_output_component");

        public static final TypedKey<Recipe> DEGRADED_WATER_MILL = TypedKey.create("dynatech",
                "degraded_water_mill");

        public static final TypedKey<Recipe> DEGRADED_WATER_MILL_2 = TypedKey.create("dynatech",
                "degraded_water_mill_2");

        public static final TypedKey<Recipe> DEGRADED_WIND_MILL = TypedKey.create("dynatech",
                "degraded_wind_mill");

        public static final TypedKey<Recipe> DEGRADED_WIND_MILL_2 = TypedKey.create("dynatech",
                "degraded_wind_mill_2");

        public static final TypedKey<Recipe> DEGRADED_EGG_MILL = TypedKey.create("dynatech",
                "degraded_egg_mill");

        public static final TypedKey<Recipe> DEGRADED_EGG_MILL_2 = TypedKey.create("dynatech",
                "degraded_egg_mill_2");

        // END Mechanical Components
        // START Energy Generators
        public static final TypedKey<Recipe> WATER_MILL = TypedKey.create("dynatech",
                "water_mill");

        public static final TypedKey<Recipe> WATER_MILL_2 = TypedKey.create("dynatech",
                "water_mill_2");

        public static final TypedKey<Recipe> WATER_MILL_REPAIR = TypedKey.create("dynatech",
                "water_mill_repair");

        public static final TypedKey<Recipe> WATER_MILL_2_REPAIR = TypedKey.create("dynatech",
                "water_mill_2_repair");

        public static final TypedKey<Recipe> WIND_MILL = TypedKey.create("dynatech",
                "wind_mill");

        public static final TypedKey<Recipe> WIND_MILL_2 = TypedKey.create("dynatech",
                "wind_mill_2");

        public static final TypedKey<Recipe> WIND_MILL_REPAIR = TypedKey.create("dynatech",
                "wind_mill_repair");

        public static final TypedKey<Recipe> WIND_MILL_2_REPAIR = TypedKey.create("dynatech",
                "wind_mill_2_repair");

        public static final TypedKey<Recipe> EGG_MILL = TypedKey.create("dynatech",
                "egg_mill");

        public static final TypedKey<Recipe> EGG_MILL_2 = TypedKey.create("dynatech",
                "egg_mill_2");

        public static final TypedKey<Recipe> EGG_MILL_REPAIR = TypedKey.create("dynatech",
                "egg_mill_repair");

        public static final TypedKey<Recipe> EGG_MILL_2_REPAIR = TypedKey.create("dynatech",
                "egg_mill_2_repair");

        public static final TypedKey<Recipe> DURABILITY_GENERATOR = TypedKey.create("dynatech",
                "durability_generator");

        public static final TypedKey<Recipe> FOOD_GENERATOR = TypedKey.create("dynatech", "food_generator");

        public static final TypedKey<Recipe> STARDUST_GENERATOR = TypedKey.create("dynatech",
                "stardust_generator");
        // END Energy Generators

        // START Materials
        public static final TypedKey<Recipe> STAINLESS_STEEL_INGOT = TypedKey.create("dynatech",
                "stainless_steel_ingot");

        public static final TypedKey<Recipe> STAINLESS_STEEL_ROTOR = TypedKey.create("dynatech",
                "stainless_steel_rotor");

        public static final TypedKey<Recipe> BEE = TypedKey.create("dynatech", "bee");
        public static final TypedKey<Recipe> ROBOTIC_BEE = TypedKey.create("dynatech", "robotic_bee");
        public static final TypedKey<Recipe> ADVANCED_ROBOTIC_BEE = TypedKey.create("dynatech", "advanced_robotic_bee");

        public static final TypedKey<Recipe> CHARCOAL_TO_COAL = TypedKey.create("dynatech", "charcoal_to_coal");

        public static final TypedKey<Recipe> COAL_TO_COAL_COKE = TypedKey.create("dynatech", "coal_to_coal_coke");

        public static final TypedKey<Recipe> MACHINE_SCRAP = TypedKey.create("dynatech", "machine_scrap");
        public static final TypedKey<Recipe> ADVANCED_MACHINE_SCRAP = TypedKey.create("dynatech",
                "advanced_machine_scrap");

        public static final TypedKey<Recipe> VEX_GEM = TypedKey.create("dynatech", "vex_gem");
        public static final TypedKey<Recipe> VEX_GEM_ALT = TypedKey.create("dynatech", "vex_gem_alt");
        public static final TypedKey<Recipe> GHOSTLY_ESSENCE = TypedKey.create("dynatech", "ghostly_essence");

        public static final TypedKey<Recipe> TESSERACTING_OBJ = TypedKey.create("dynatech", "tesseracting_object");

        public static final TypedKey<Recipe> STAR_DUST = TypedKey.create("dynatech", "star_dust");
        // END Materials

        // START Tools
        public static final TypedKey<Recipe> ELECTRICAL_STIMULATOR = TypedKey.create("dynatech",
                "electrical_stimulator");

        public static final TypedKey<Recipe> INVENTORY_FILTER = TypedKey.create("dynatech", "inventory_filter");

        public static final TypedKey<Recipe> RECIPE_BOOK = TypedKey.create("dynatech", "recipe_book");

        public static final TypedKey<Recipe> AUTO_OUTPUT_UPGRADE = TypedKey.create("dynatech", "auto_output_upgrade");

        public static final TypedKey<Recipe> AUTO_INPUT_UPGRADE = TypedKey.create("dynatech", "auto_input_upgrade");

        public static final TypedKey<Recipe> PICNIC_BASKET = TypedKey.create("dynatech", "picnic_basket");
        public static final TypedKey<Recipe> SOUL_BOUND_PICNIC_BASKET = TypedKey.create("dynatech",
                "soul_bound_picnic_basket");

        public static final TypedKey<Recipe> ANGEL_GEM = TypedKey.create("dynatech", "angel_gem");

        public static final TypedKey<Recipe> SCOOP = TypedKey.create("dynatech", "scoop");

        public static final TypedKey<Recipe> DIMENSIONAL_HOME = TypedKey.create("dynatech", "dimensional_home");

        public static final TypedKey<Recipe> ITEM_BAND_HASTE = TypedKey.create("dynatech", "haste_item_band");
        public static final TypedKey<Recipe> ITEM_BAND_HEALTH = TypedKey.create("dynatech", "health_item_band");

        public static final TypedKey<Recipe> TESSERACT_BINDER = TypedKey.create("dynatech", "tesseract_binder");
        // END Tools
        // START Machines
        public static final TypedKey<Recipe> KITCHEN_AUTO_CRAFTER = TypedKey.create("dynatech", "kitchen_auto_crafter");

        public static final TypedKey<Recipe> GROWTH_CHAMBER = TypedKey.create("dynatech", "growth_chamber");
        public static final TypedKey<Recipe> GROWTH_CHAMBER_MK2 = TypedKey.create("dynatech", "growth_chamber_mk2");
        public static final TypedKey<Recipe> GROWTH_CHAMBER_END = TypedKey.create(Items.Keys.GROWTH_CHAMBER_END.key());
        public static final TypedKey<Recipe> GROWTH_CHAMBER_MK2_END = TypedKey
                .create(Items.Keys.GROWTH_CHAMBER_MK2_END.key());
        public static final TypedKey<Recipe> GROWTH_CHAMBER_NETHER = TypedKey
                .create(Items.Keys.GROWTH_CHAMBER_NETHER.key());
        public static final TypedKey<Recipe> GROWTH_CHAMBER_MK2_NETHER = TypedKey
                .create(Items.Keys.GROWTH_CHAMBER_MK2_NETHER.key());
        public static final TypedKey<Recipe> GROWTH_CHAMBER_OCEAN = TypedKey
                .create(Items.Keys.GROWTH_CHAMBER_OCEAN.key());
        public static final TypedKey<Recipe> GROWTH_CHAMBER_MK2_OCEAN = TypedKey
                .create(Items.Keys.GROWTH_CHAMBER_MK2_OCEAN.key());

        public static final TypedKey<Recipe> ANTIGRAVITY_BUBBLE = TypedKey.create(Items.Keys.ANTIGRAVITY_BUBBLE.key());

        public static final TypedKey<Recipe> WEATHER_CONTROLLER = TypedKey.create(Items.Keys.WEATHER_CONTROLLER.key());

        public static final TypedKey<Recipe> POTION_SPRINKLER = TypedKey.create(Items.Keys.POTION_SPRINKLER.key());

        public static final TypedKey<Recipe> BARBED_WIRE = TypedKey.create(Items.Keys.BARBED_WIRE.key());

        public static final TypedKey<Recipe> MATERIAL_HIVE = TypedKey.create(Items.Keys.MATERIAL_HIVE.key());

        public static final TypedKey<Recipe> WIRELESS_CHARGER = TypedKey.create(Items.Keys.WIRELESS_CHARGER.key());

        public static final TypedKey<Recipe> SEED_PLUCKER = TypedKey.create(Items.Keys.SEED_PLUCKER.key());

        public static final TypedKey<Recipe> TESSERACT = TypedKey.create(Items.Keys.TESSERACT.key());

        public static final TypedKey<Recipe> PETAL_APOTHECARY = TypedKey.create(Items.Keys.PETAL_APOTHECARY.key());

        // Orechid Recipes
        public static final TypedKey<Recipe> STONE_TO_COAL_ORE = TypedKey.create("dynatech", "stone_to_coal_ore");

        public static final TypedKey<Recipe> STONE_TO_IRON_ORE = TypedKey.create("dynatech", "stone_to_iron_ore");

        public static final TypedKey<Recipe> STONE_TO_GOLD_ORE = TypedKey.create("dynatech", "stone_to_gold_ore");

        public static final TypedKey<Recipe> STONE_TO_COPPER_ORE = TypedKey.create("dynatech", "stone_to_copper_ore");

        public static final TypedKey<Recipe> STONE_TO_LAPIS_ORE = TypedKey.create("dynatech", "stone_to_lapis_ore");

        public static final TypedKey<Recipe> STONE_TO_REDSTONE_ORE = TypedKey.create("dynatech",
                "stone_to_redstone_ore");
        public static final TypedKey<Recipe> STONE_TO_DIAMOND_ORE = TypedKey.create("dynatech", "stone_to_diamond_ore");

        public static final TypedKey<Recipe> STONE_TO_EMERALD_ORE = TypedKey.create("dynatech",
                "stone_to_emerald_core");

        public static final TypedKey<Recipe> NETHERRACK_TO_QUARTZ_ORE = TypedKey.create("dynatech",
                "netherrack_to_quartz_ore");

        public static final TypedKey<Recipe> NETHERRACK_TO_GOLD_ORE = TypedKey.create("dynatech",
                "netherrack_to_gold_ore");

        public static final TypedKey<Recipe> NETHERRACK_TO_ANCIENT_DEBRIS = TypedKey.create("dynatech",
                "netherrack_to_ancient_debris");

        public static final TypedKey<Recipe> NETHERRACK_TO_BASALT = TypedKey.create("dynatech", "netherrack_to_basalt");

        public static final TypedKey<Recipe> NETHERRACK_TO_BLACKSTONE = TypedKey.create("dynatech",
                "netherrack_to_blackstone");

        public static final TypedKey<Recipe> DEEPSLATE_TO_COAL_ORE = TypedKey.create("dynatech",
                "deepslate_to_coal_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_IRON_ORE = TypedKey.create("dynatech",
                "deepslate_to_iron_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_GOLD_ORE = TypedKey.create("dynatech",
                "deepslate_to_gold_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_COPPER_ORE = TypedKey.create("dynatech",
                "deepslate_to_copper_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_LAPIS_ORE = TypedKey.create("dynatech",
                "deepslate_to_lapis_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_REDSTONE_ORE = TypedKey.create("dynatech",
                "deepslate_to_redstone_ore");
        public static final TypedKey<Recipe> DEEPSLATE_TO_DIAMOND_ORE = TypedKey.create("dynatech",
                "deepslate_to_diamond_ore");

        public static final TypedKey<Recipe> DEEPSLATE_TO_EMERALD_ORE = TypedKey.create("dynatech",
                "deepslate_to_emerald_core");

        public static final TypedKey<Recipe> CALCITE_TO_LIVINGROCK = TypedKey.create("dynatech",
                "calcite_to_livingrock");

        public static final TypedKey<Recipe> DARK_OAK_TO_LIVINGWOOD = TypedKey.create("dynatech",
                "dark_oak_to_livingwood");
    }
}
