package design_pattern.creational.prototype;

import java.io.File;

public class RarArchiver implements Archiver{
    @Override
    public void archive(File file) {
        System.out.println("RAR Archiver.");
    }

    @Override
    public Archiver clone() {
        // Add apache common library to use SerializationUtils.clone();
        // method to return the deep clone (recommended) of object as.
        // return (Archiver) SerializationUtils.clone(this);
        try {
            return (Archiver) super.clone(); // this will give shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
