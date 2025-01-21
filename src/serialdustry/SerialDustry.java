package serialdustry;

import mindustry.mod.*;
import serialdustry.logic.*;

public class SerialDustry extends Mod{

    public SerialDustry(){
    }

    @Override
    public void loadContent(){
        SerialLogic.load();
    }

}
