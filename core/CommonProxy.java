package sensory.core;

public class CommonProxy {
	public static String ITEMS_PNG = "/sensory/mat/items.png";
    public static String BLOCK_PNG = "/sensory/mat/block.png";
    public static String INFURNACE_PNG = "/sensory/mat/infurnace.png";
    public static String PARTICLES_PNG = "/sensory/mat/particles.png";
    
    public static String[] ARMOR_ENDURUM_PNG = new String[]{"/sensory/mat/armor_endurum.png", "/sensory/mat/armor_endurum_h.png"};
    public static String[] ARMOR_XIRCIUM_PNG = new String[]{"/sensory/mat/armor_xircium.png", "/sensory/mat/armor_xircium_h.png"};
    public static String[] ARMOR_NETHERITE_PNG = new String[]{"/sensory/mat/armor_netherite.png", "/sensory/mat/armor_netherite_h.png"};
    public static String[] ARMOR_VALARIUM_PNG = new String[]{"/sensory/mat/armor_valarium.png", "/sensory/mat/armor_valarium_h.png"};
    public static String[] ARMOR_SCINITE_PNG = new String[]{"/sensory/mat/armor_scinite.png", "/sensory/mat/armor_scinite_h.png"};
    public static String[] ARMOR_GODUM_PNG = new String[]{"/sensory/mat/armor_godum.png", "/sensory/mat/armor_godum_h.png"};
    
    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics!
    }
}