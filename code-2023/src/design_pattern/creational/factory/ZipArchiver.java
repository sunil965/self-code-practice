package design_pattern.creational.factory;

import java.io.File;

public class ZipArchiver implements Archiver{

    @Override
    public void archive(File file) {
        System.out.println("Zip archiver");
    }
}
