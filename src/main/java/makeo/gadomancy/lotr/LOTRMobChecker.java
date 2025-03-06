package makeo.gadomancy.lotr;

import lotr.common.LOTRLevelData;
import lotr.common.entity.LOTRRandomSkinEntity;
import lotr.common.entity.animal.LOTRAmbientCreature;
import lotr.common.entity.animal.LOTRAnimalSpawnConditions;
import lotr.common.entity.animal.LOTREntityAnimalMF;
import lotr.common.entity.npc.LOTRBoss;
import lotr.common.entity.npc.LOTRCharacter;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRNPCMount;
import lotr.common.world.biome.LOTRBiomeGenNearHarad;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nonnull;

import static makeo.gadomancy.ModChecker.hasLOTR;

public class LOTRMobChecker {

    public static boolean isLOTRMob(@Nonnull EntityLivingBase mob){
        if (!hasLOTR()){return false;}
        return mob instanceof LOTRAmbientCreature
                || mob instanceof LOTREntityAnimalMF
                || mob instanceof LOTRAnimalSpawnConditions
                || mob instanceof LOTRRandomSkinEntity
                || mob instanceof LOTRBiomeGenNearHarad.ImmuneToHeat
                || mob instanceof LOTRNPCMount
                || mob instanceof LOTRCharacter
                || mob instanceof LOTRBoss;//not all?
    }

    public static boolean isHostileToPlayer(@Nonnull EntityPlayer entityplayer,EntityLivingBase lotrMOB){
        if (
                lotrMOB instanceof LOTREntityAnimalMF
                || lotrMOB instanceof LOTRAnimalSpawnConditions
                || lotrMOB instanceof LOTRAmbientCreature
        ){
            return true;
        }
        if (lotrMOB instanceof LOTREntityNPC){
            LOTREntityNPC npc = (LOTREntityNPC) lotrMOB;
            return LOTRLevelData.getData(entityplayer).getAlignment(npc.getFaction()) < 0.0f;
        }
        return false;
    }
}
