package ru.IST.istcraft.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.client.model.AlbaModel;
import ru.IST.istcraft.entities.AlbaEntity;

public class AlbaRenderer extends MobRenderer<AlbaEntity, AlbaModel<AlbaEntity>> {

    protected  static final ResourceLocation TEXTURE = new ResourceLocation(ISTCraft.MOD_ID, "textures/entity/alba.png");

    public AlbaRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new AlbaModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(AlbaEntity albaEntity) {
        return TEXTURE;
    }
}
