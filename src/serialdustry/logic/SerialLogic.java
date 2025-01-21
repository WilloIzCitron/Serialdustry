package serialdustry.logic;

import arc.graphics.Color;
import mindustry.gen.Icon;
import mindustry.graphics.Pal;
import mindustry.logic.LCategory;

public class SerialLogic {
    public static final LCategory
    categorySerial = new LCategory("serial", Pal.techBlue, Icon.treeSmall);

    public static void load(){
        SerialLStatement.load();
    }
}
