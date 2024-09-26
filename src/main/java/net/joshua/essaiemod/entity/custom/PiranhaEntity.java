package net.joshua.essaiemod.entity.custom;

import net.joshua.essaiemod.entity.ModEntitites;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.Swim;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.conditions.TrueCondition;
import org.jetbrains.annotations.Nullable;

public class PiranhaEntity extends Animal {
    public PiranhaEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.5D, Ingredient.of(Items.COD), false));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WaterAnimal.class, true));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5D)
                .add(Attributes.FOLLOW_RANGE, 15D)
                .add(Attributes.MOVEMENT_SPEED, 5D)
                .add(Attributes.ATTACK_DAMAGE, 0.5f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.25f)
                .add(Attributes.ATTACK_SPEED, 3f);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntitites.PIRANHA.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COD);
    }
}
