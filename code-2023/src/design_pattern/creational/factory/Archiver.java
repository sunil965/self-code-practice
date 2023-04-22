package design_pattern.creational.factory;

import java.io.File;

public interface Archiver extends Cloneable {

    void archive(File file);
}
