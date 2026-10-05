package ge.edu.ug.patterns.structural.proxy.imageprocessor;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: the gallery creates a DiskImageProcessor for every path up front,
// so every image is loaded from disk even if the user only ever looks at one of them.
public class Gallery {
    private final List<ImageProcessor> images = new ArrayList<>();

    public Gallery(List<String> paths) {
        for (String path : paths) {
            images.add(new DiskImageProcessor(path));
        }
    }

    public void display(int index) {
        images.get(index).display();
    }
}
