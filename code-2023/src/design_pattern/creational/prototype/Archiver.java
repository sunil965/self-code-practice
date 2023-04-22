package design_pattern.creational.prototype;

import java.io.File;

public interface Archiver extends Cloneable {

    void archive(File file);

    Archiver clone();
}
