// package net.tiphainelaurent.chiselforfabric.api;

// import java.util.Set;

// public abstract class FamilyRegistry {
//     abstract public Set<BasicBlock> getBlocks();

//     public void registerAll(final ItemGroup group)
//     {
//         final String andesite = Registry.ITEM.getId(Items.ANDESITE).getPath();

//         for (BasicBlock block : getBlocks())
//         {
//             block.register(group);
//             block.write(block.asLootTable().build())
//                  .writeBlockStates()
//                  .writeModel()
//                  .writeItem()
//                  .writeRecipe(new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, block.getIdentifier().getPath())),
//                     "Chisel",
//                     Ingredient.ofItems(Items.ANDESITE),
//                     new ItemStack(block)));

//             for (BasicBlock reverseBlock : blocks)
//             {
//                 if (reverseBlock.is(block))
//                 {
//                     reverseBlock.writeRecipe(new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, block.getIdentifier().getPath())),
//                         "Chisel",
//                         Ingredient.ofItems(block),
//                         new ItemStack(Items.ANDESITE)
//                         ));
//                 }
//                 else
//                 {
//                     reverseBlock.writeRecipe(new StonecuttingRecipe(new Identifier(ChiselForFabric.MOD_ID, String.format("stonecutting-%s_ot_%s", andesite, block.getIdentifier().getPath())),
//                         "Chisel",
//                         Ingredient.ofItems(reverseBlock),
//                         new ItemStack(block)
//                         ));
//                 }
//             }
//         }
//     }
// }
