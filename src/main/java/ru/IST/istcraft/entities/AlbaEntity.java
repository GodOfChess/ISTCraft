package ru.IST.istcraft.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.IST.istcraft.init.ModEntityTypes;
import ru.IST.istcraft.init.ModItems;

import javax.annotation.Nullable;

public class AlbaEntity extends AnimalEntity {

    public static final Ingredient  ingredient= Ingredient.fromItems(ModItems.ISTDIAMOND.get());

    public AlbaEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // func_233815_a_ - Создать атрибут field_233818_a_ - Макс здоровье  field_233822_e_ - Макс скорость
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_,12.0D)
                .func_233815_a_(Attributes.field_233820_c_, 0.25D);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this , 1.1D, ingredient, false));
        this.goalSelector.addGoal(3, new LookAtGoal(this,PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound(){
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Nullable
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn){
        this.playSound(SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return ModEntityTypes.ALBA.get().create(this.world);
    }
}
