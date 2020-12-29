package ru.IST.istcraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.entities.AlbaEntity;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ISTCraft.MOD_ID);

    //Виды сущностей
    public static final RegistryObject<EntityType<AlbaEntity>> ALBA = ENTITY_TYPES.register("alba",()-> EntityType.Builder.create(AlbaEntity::new,
            EntityClassification.CREATURE).size(1.0f,2.0f).build(new ResourceLocation(ISTCraft.MOD_ID, "alba").toString()));
}
