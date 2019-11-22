import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class LeafFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class LeafFactory {
    private static Map<String, LeafType> leafTypes = new HashMap<>();

    static LeafType getLeafType(String name, String imageFile, String soundFile) {
        LeafType leafType = leafTypes.get(name);
        if (leafType == null) {
            leafType = new LeafType(new GreenfootImage(imageFile), soundFile != null ? new GreenfootSound(soundFile) : null);
            leafTypes.put(name, leafType);
        }
        return leafType;
    }
}
