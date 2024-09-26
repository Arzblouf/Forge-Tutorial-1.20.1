package net.joshua.essaiemod.entity;

import net.joshua.essaiemod.TutorialMod;
import net.joshua.essaiemod.entity.custom.PiranhaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.html.parser.Entity;

public class ModEntitites {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<PiranhaEntity>> PIRANHA =
            ENTITY_TYPES.register("piranha", ()-> EntityType.Builder.of(PiranhaEntity::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3f).build("piranha"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
