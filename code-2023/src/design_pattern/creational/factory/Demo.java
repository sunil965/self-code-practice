package design_pattern.creational.factory;

import java.io.File;

public class Demo {

    public static void main(String[] args) {
        Archiver zip = ArchiveFactory.getArchiver("zip");
        Archiver rar = ArchiveFactory.getArchiver("rar");

        assert zip != null;
        zip.archive(new File(""));
        assert rar != null;
        rar.archive(new File(""));

        System.out.println(ArchiveFactory.getArchiver("zip") == zip);
    }
}
