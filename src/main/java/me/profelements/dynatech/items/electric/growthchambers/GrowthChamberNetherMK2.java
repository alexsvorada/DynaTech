package me.profelements.dynatech.items.electric.growthchambers;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.profelements.dynatech.items.abstracts.AbstractElectricMachine;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GrowthChamberNetherMK2 extends AbstractElectricMachine {
   
    private static final int[] INPUT_SLOTS = new int[] {1,2,3,4,5,6,7};
    private static final int[] OUTPUT_SLOTS = new int[] {28,29,30,31,32,33,34,37,38,39,40,41,42,43,46,47,48,49,50,51,52};

    private static final int[] INPUT_BORDER_SLOTS = new int[] {0,8,9,10,11,12,14,15,16,17};
    private static final int[] OUTPUT_BORDER_SLOTS = new int[] {18,19,20,21,22,23,24,25,26,27,35,36,44,45,53};
    private static final int[] BACKGROUND_SLOTS = new int[] {}; 
    
    private static final ItemStack PROGRESS_ITEM = new ItemStack(Material.NETHERRACK);

    public GrowthChamberNetherMK2(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

    }

    @Override
    public void postRegister() {
        registerDefaultRecipes();
    }

    protected void registerDefaultRecipes() {

        registerRecipe(12, new ItemStack(Material.NETHER_WART), new ItemStack(Material.NETHER_WART, 12));
        registerRecipe(9, new ItemStack(Material.WEEPING_VINES), new ItemStack(Material.WEEPING_VINES, 12));
        registerRecipe(9, new ItemStack(Material.TWISTING_VINES), new ItemStack(Material.TWISTING_VINES, 12));
        registerRecipe(9, new ItemStack(Material.CRIMSON_ROOTS), new ItemStack(Material.CRIMSON_ROOTS, 12));
        registerRecipe(9, new ItemStack(Material.WARPED_ROOTS), new ItemStack(Material.WARPED_ROOTS, 12));
        registerRecipe(9, new ItemStack(Material.NETHER_SPROUTS), new ItemStack(Material.NETHER_SPROUTS, 12));

        registerRecipe(30, new ItemStack[] {new ItemStack(Material.CRIMSON_FUNGUS)}, new ItemStack[] {new ItemStack(Material.CRIMSON_FUNGUS, 6), new ItemStack(Material.CRIMSON_STEM, 18), new ItemStack(Material.SHROOMLIGHT, 6), new ItemStack(Material.NETHER_WART_BLOCK, 12)});
        registerRecipe(30, new ItemStack[] {new ItemStack(Material.WARPED_FUNGUS)}, new ItemStack[] {new ItemStack(Material.WARPED_FUNGUS, 6), new ItemStack(Material.WARPED_STEM, 18), new ItemStack(Material.SHROOMLIGHT, 6), new ItemStack(Material.WARPED_WART_BLOCK, 12)});

    }
    
    @Override
    public int[] getInputSlots() {
        return INPUT_SLOTS;
    }
    @Override
    public int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }

    @Override
    public ItemStack getProgressBar() {
        return PROGRESS_ITEM;
    }
    
    @Override
    public int getProgressSlot() {
        return 13;
    }
    
    @Override
	public List<ItemStack> getDisplayRecipes() {
		List<ItemStack> display = new ArrayList<>(); 
        for (MachineRecipe recipe : recipes) {
           display.add(recipe.getInput()[0]);
           if (recipe.getOutput().length > 1) {
            display.add(recipe.getOutput()[1]);
           } else {
            display.add(recipe.getOutput()[0]);
           }
        }
        return display;
	}

	@Override
	protected void setupMenu(BlockMenuPreset preset) {
		for (int slot : BACKGROUND_SLOTS) {
            preset.addItem(slot, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int slot : INPUT_BORDER_SLOTS) {
            preset.addItem(slot, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        for (int slot : OUTPUT_BORDER_SLOTS) {
            preset.addItem(slot, ChestMenuUtils.getOutputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(getProgressSlot(), CustomItemStack.create(Material.BLACK_STAINED_GLASS_PANE, " "), ChestMenuUtils.getEmptyClickHandler());
        
        for (int slot : getOutputSlots()) {
            preset.addMenuClickHandler(slot,new ChestMenu.AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action) {
                    return cursor.getType().isAir();
                }

                @Override
                public boolean onClick(Player p, int slot, ItemStack item, ClickAction action) {
                    return false;
                }
            });
        }
	}


}
