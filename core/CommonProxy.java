package deepcraft.core;

public class CommonProxy {
	public static String ITEMS_PNG = "/deepcraft/mat/items.png";
    public static String BLOCK_PNG = "/deepcraft/mat/block.png";
    public static String INFURNACE_PNG = "/deepcraft/mat/infurnace.png";
    public static String PARTICLES_PNG = "/deepcraft/mat/particles.png";
    
    public static String[] ARMOR_ENDURUM_PNG = new String[]{"/deepcraft/mat/armor_endurum.png", "/deepcraft/mat/armor_endurum_h.png"};
    public static String[] ARMOR_XIRCIUM_PNG = new String[]{"/deepcraft/mat/armor_xircium.png", "/deepcraft/mat/armor_xircium_h.png"};
    public static String[] ARMOR_NETHERITE_PNG = new String[]{"/deepcraft/mat/armor_netherite.png", "/deepcraft/mat/armor_netherite_h.png"};
    public static String[] ARMOR_VALARIUM_PNG = new String[]{"/deepcraft/mat/armor_valarium.png", "/deepcraft/mat/armor_valarium_h.png"};
    public static String[] ARMOR_SCINITE_PNG = new String[]{"/deepcraft/mat/armor_scinite.png", "/deepcraft/mat/armor_scinite_h.png"};
    public static String[] ARMOR_GODUM_PNG = new String[]{"/deepcraft/mat/armor_godum.png", "/deepcraft/mat/armor_godum_h.png"};
    
    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics!
    }
}