package design_pattern.creational.prototype;

import java.io.File;

public class ZipArchiver implements Archiver{
    @Override
    public void archive(File file) {
        System.out.println("ZIP Archiver.");
    }

    @Override
    public Archiver clone() {
        // Add apache common library to use SerializationUtils.clone();
        // method to return the deep clone (recommended) of object as.
        // return (Archiver) SerializationUtils.clone(this);
        try {
            // this will give shallow copy, and for this implement Cloneable interface
            // just for demo using shallow copy, recommended to use deep copy.
            return (Archiver) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
