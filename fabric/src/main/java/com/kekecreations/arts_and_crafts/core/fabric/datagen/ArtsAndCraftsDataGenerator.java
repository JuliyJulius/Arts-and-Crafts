package com.kekecreations.arts_and_crafts.core.fabric.datagen;

import com.kekecreations.arts_and_crafts.core.fabric.datagen.client.ArtsAndCraftsLangProvider;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.server.ArtsAndCraftsItemTagGenerator;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.server.ArtsAndCraftsLootTableGenerator;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.client.ArtsAndCraftsModelProvider;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.server.ArtsAndCraftsBlockTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ArtsAndCraftsDataGenerator implements DataGeneratorEntrypoint {

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ArtsAndCraftsModelProvider::new);
        pack.addProvider(ArtsAndCraftsBlockTagGenerator::new);
        pack.addProvider(ArtsAndCraftsItemTagGenerator::new);
        pack.addProvider(ArtsAndCraftsLootTableGenerator::new);
        pack.addProvider(ArtsAndCraftsLangProvider::new);
    }
}