package net.joshua.essaiemod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class Piranha<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Piranha;

	public Piranha(ModelPart root) {
		this.Piranha = root.getChild("Piranha");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Piranha = partdefinition.addOrReplaceChild("Piranha", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Corps = Piranha.addOrReplaceChild("Corps", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -12.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(0.0F, -14.0F, 2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(0.0F, -8.0F, 4.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(0.0F, -13.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Machoire = Piranha.addOrReplaceChild("Machoire", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, -1.25F, -0.375F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(15, 11).addBox(2.0F, -1.25F, -0.375F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 15).addBox(-2.0F, -1.25F, -0.375F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 13).addBox(-2.0F, 0.75F, -0.375F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.75F, -1.125F));

		PartDefinition Queue = Piranha.addOrReplaceChild("Queue", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 10.6667F));

		PartDefinition bone = Queue.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.6667F));

		PartDefinition bone2 = Queue.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(10, 10).addBox(0.2597F, -2.0F, -0.1716F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 4).addBox(0.2597F, -3.0F, 1.8284F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 3).addBox(0.2597F, -2.0F, 1.8284F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(0.2597F, 2.0F, 1.8284F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.2597F, 1.0F, 1.8284F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2597F, 0.0F, -1.4951F));

		PartDefinition NageoireGauche = Piranha.addOrReplaceChild("NageoireGauche", CubeListBuilder.create(), PartPose.offset(2.113F, -8.4831F, 1.1268F));

		PartDefinition cube_r1 = NageoireGauche.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-0.0949F, -1.5054F, -0.9695F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9819F, 0.3885F, 0.0427F, -3.1416F, -0.1309F, 1.8326F));

		PartDefinition NageoireDroite = Piranha.addOrReplaceChild("NageoireDroite", CubeListBuilder.create(), PartPose.offset(-3.086F, -8.1762F, 1.0628F));

		PartDefinition cube_r2 = NageoireDroite.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 12).addBox(-0.028F, -1.6129F, -0.9329F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.0109F, 0.0701F, 3.1416F, -0.1309F, 1.309F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		tat
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Piranha.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Piranha;
	}
}