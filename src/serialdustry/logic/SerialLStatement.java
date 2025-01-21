package serialdustry.logic;

import arc.func.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.logic.*;
import com.fazecast.jSerialComm.*;
import mindustry.ui.Styles;

public class SerialLStatement {
    static SerialPort port;

    public static class SerialConf extends LStatement {
        public SerialConf(String commPort) {

        }

        public SerialConf() {

        }

        @Override
        public LCategory category(){
            return SerialLogic.categorySerial;
        }

        @Override
        public void build(Table table) {
            rebuild(table);
        }

        void rebuild(Table table) {
            table.clearChildren();

            table.left();

            table.add("connection from port ");
            table.button(b -> {
                b.label(() -> port == null ? "No Port" : port.getSystemPortName());
                b.clicked(() -> showSelect(b, SerialPort.getCommPorts(), port, prt -> {
                        port = prt;
                        rebuild(table);
                }, 1, cell -> {cell.height(50); cell.growX();}));
            }, Styles.logict, () -> {
            }).size(90, 40).color(table.color).left().padLeft(2);
            row(table);
        }

    @Override
    public LExecutor.LInstruction build(LAssembler lAssembler) {
        return null;
    }
}

    public static void load(){
        registerStatement("serialconf", arg -> new SerialConf(arg[0]), SerialConf::new);
    }

    /** Mimics the RegisterStatement annotation.
     * @param name The name of the statement to be registered.
     * @param func The statement function. Used for reading saves.
     * @param prov The statement provider. Used for examples.
     */
    public static void registerStatement(String name, Func<String[], LStatement> func, Prov<LStatement> prov){
        LAssembler.customParsers.put(name, func);
        LogicIO.allStatements.add(prov);
    }
}
