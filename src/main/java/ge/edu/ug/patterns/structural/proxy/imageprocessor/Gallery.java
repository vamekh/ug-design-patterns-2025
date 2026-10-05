package ge.edu.ug.patterns.structural.proxy.imageprocessor;

import java.util.ArrayList;
import java.util.List;

// Client: works with ImageProcessor and does not know it holds proxies
public class Gallery {
    private final List<ImageProcessor> images = new ArrayList<>();

    public Gallery(List<String> paths) {
        for (String path : paths) {
            images.add(new DiskImageProcessorProxy(path));
        }
    }

    public void display(int index) {
        images.get(index).display();
    }
}
