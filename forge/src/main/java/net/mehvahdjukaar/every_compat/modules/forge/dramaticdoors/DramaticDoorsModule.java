package net.mehvahdjukaar.every_compat.modules.forge.dramaticdoors;

import com.fizzware.dramaticdoors.forge.DDRegistry;
import com.fizzware.dramaticdoors.forge.blocks.ShortDoorBlock;
import com.fizzware.dramaticdoors.forge.blocks.TallDoorBlock;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class DramaticDoorsModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> shortDoors;
    public final SimpleEntrySet<WoodType, Block> tallDoors;

    public DramaticDoorsModule(String modId) {
        super(modId, "dd");

        tallDoors = SimpleEntrySet.builder(WoodType.class, "door", "tall",
                        () -> getModBlock("tall_oak_door"), () -> WoodTypeRegistry.OAK_TYPE, w -> new TallDoorBlock(Blocks.OAK_DOOR,
                                w.toVanillaOrOak().setType()))
                .addTextureM(modRes("block/tall_oak_door_bottom"), EveryCompat.res("block/dd/tall_oak_door_bottom_m"))
                .addTextureM(modRes("block/tall_oak_door_middle"), EveryCompat.res("block/dd/tall_oak_door_middle_m"))
                .addTextureM(modRes("block/tall_oak_door_top"), EveryCompat.res("block/dd/tall_oak_door_top_m"))
                .addTextureM(modRes("item/tall_oak_door"), EveryCompat.res("item/dd/tall_oak_door_m"))
                .addTag(modRes("tall_wooden_doors"), Registries.BLOCK)
                .addTag(modRes("tall_wooden_doors"), Registries.ITEM)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setRenderType(() -> RenderType::cutout)
                .setTabKey(() -> DDRegistry.MAIN_TAB)
                .copyParentDrop()
                .defaultRecipe()
                .build();

        this.addEntry(tallDoors);

        shortDoors = SimpleEntrySet.builder(WoodType.class, "door", "short",
                        () -> getModBlock("short_oak_door"), () -> WoodTypeRegistry.OAK_TYPE, w -> new ShortDoorBlock(Blocks.OAK_DOOR,
                                w.toVanillaOrOak().setType()))
                .addTextureM(modRes("block/short_oak_door"), EveryCompat.res("block/dd/short_oak_door_m"))
                .addTextureM(modRes("item/short_oak_door"), EveryCompat.res("item/dd/short_oak_door_m"))
                .addTag(modRes("short_wooden_doors"), Registries.BLOCK)
                .addTag(modRes("short_wooden_doors"), Registries.ITEM)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setRenderType(() -> RenderType::cutout)
                .setTabKey(() -> DDRegistry.MAIN_TAB)
                .copyParentDrop()
                .defaultRecipe()
                .build();

        this.addEntry(shortDoors);
    }

    @Override
    public List<String> getAlreadySupportedMods() {
        return List.of(
                "automaticdoors", "doubledoors", "couplings", "woodworks",
                "chipped", "mcwdoors", "manyideas_doors", "quark", "supplementaries",
                "statement", "abundant_atmosphere", "ad_astra", "aether",
                "aether_redux", "alexscaves", "architects_palette", "atum",
                "aurorasdeco", "bambooeverything", "betterarcheology", "betterend",
                "betternether", "bewitchment", "biomancy", "biomemakeover", "biomesoplenty",
                "blocksplus", "blockus", "byg", "caupona", "ceilands", "charm", "cinderscapes",
                "cobblemon", "colorfulazaleas", "copperoverhaul", "alloyed", "createdeco",
                "create_things_and_misc", "darkerdepths", "deep_aether", "deeperdarker",
                "desolation", "dustrial_decor", "ecologics", "endlessbiomes", "enhanced_mushrooms",
                "phantasm", "enderscape", "enlightened_end", "everythingcopper", "extendedmushrooms",
                "fruittrees", "forbidden_arcanus", "gardens_of_the_dead", "goodending", "graveyard",
                "hexcasting", "hexerei", "horizons", "integrateddynamics", "malum", "modern_glass_doors",
                "ms", "morecraft", "mysticsbiomes", "nethers_exoticism", "newworld", "pokecube",
                "prehistoricfauna", "premium_wood", "promenade", "pyromancer", "quark",
                "regions_unexplored", "silentgear", "snowyspirit", "supplementaries",
                "tconstruct", "techreborn", "terraqueous", "terrestria", "traverse",
                "twilightforest", "undergarden", "vinery", "wilderwild", "windswept",
                "xps_additions", "yippee", "chipped", "mcwdoors", "manyideas_doors"
        );
    }
}
