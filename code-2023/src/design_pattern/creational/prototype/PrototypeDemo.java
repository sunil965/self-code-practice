package design_pattern.creational.prototype;

import java.io.File;

public class PrototypeDemo {

    public static void main(String[] args) {

        Archiver zipArchiver = ArchiveFactory.getPrototypeOf("zip");
        Archiver rarArchiver = ArchiveFactory.getPrototypeOf("rar");

        zipArchiver.archive(new File(""));
        rarArchiver.archive(new File(""));
    }
}
