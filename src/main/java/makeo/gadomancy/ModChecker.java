package makeo.gadomancy;

public class ModChecker {
    public enum ModCheckResult {
        UNCHECKED,EXISTS,NOT_EXISTS;
    }

    public static ModCheckResult LOTRExistence = ModCheckResult.UNCHECKED;

    public static boolean hasLOTR() {
        if (LOTRExistence == ModCheckResult.UNCHECKED) {
            try {
                Class.forName("lotr.common.LOTRMod");
                System.out.println("ThaumicBases: Found LOTR installed");
                LOTRExistence = ModCheckResult.EXISTS;
            } catch (ClassNotFoundException var1) {
                System.out.println("ThaumicBases: LOTR not found");
                LOTRExistence = ModCheckResult.NOT_EXISTS;
            }
        }

        return LOTRExistence == ModCheckResult.EXISTS;
    }
}
