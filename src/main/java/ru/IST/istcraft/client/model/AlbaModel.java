package ru.IST.istcraft.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.MathHelper;
import ru.IST.istcraft.entities.AlbaEntity;

public class AlbaModel<T extends AlbaEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer headwear;
    private final ModelRenderer body;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;

    public AlbaModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        headwear = new ModelRenderer(this);
        headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        headwear.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        body.setTextureOffset(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(-8.0F, 2.0F, 0.0F);
        right_arm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        right_arm.setTextureOffset(40, 32).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(8.0F, 2.0F, 0.0F);
        left_arm.setTextureOffset(32, 48).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        left_arm.setTextureOffset(48, 48).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        right_leg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        right_leg.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
        left_leg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        left_leg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        headwear.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void setRotationAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.left_leg.copyModelAngles(this.left_leg);
        this.right_leg.copyModelAngles(this.right_leg);
        this.left_arm.copyModelAngles(this.left_arm);
        this.right_arm.copyModelAngles(this.right_arm);
        this.body.copyModelAngles(this.body);
        if (p_225597_1_.getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty()) {
            if (p_225597_1_.isCrouching()) {
                this.head.rotationPointZ = 1.4F;
                this.head.rotationPointY = 1.85F;
            } else {
                this.head.rotationPointZ = 0.0F;
                this.head.rotationPointY = 0.0F;
            }
        } else if (p_225597_1_.isCrouching()) {
            this.head.rotationPointZ = 0.3F;
            this.head.rotationPointY = 0.8F;
        } else {
            this.head.rotationPointZ = -1.1F;
            this.head.rotationPointY = -0.85F;
        }

    }
}

