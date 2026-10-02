abstract class GardenTool {
    public GardenTool() {
    }
    public String use() {
        return "using garden tool";
    }
}
class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }
    public String use() {
        return super.use() + " - blade sharpened first";
    }
}
class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}
public class Backyard{
    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        System.out.println(c.use());
        Pruner p = new Pruner();
        System.out.println(p.use());
    }
}