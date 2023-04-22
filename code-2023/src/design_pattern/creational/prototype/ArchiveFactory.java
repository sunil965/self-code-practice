package design_pattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ArchiveFactory {
    private static final Map<String, Archiver> prototypes = new HashMap<>();

    static {
        prototypes.put("zip", new ZipArchiver());
        prototypes.put("rar", new RarArchiver());
    }

    public static Archiver getPrototypeOf(String archiverType){
        return prototypes.get(archiverType).clone();
    }
}
