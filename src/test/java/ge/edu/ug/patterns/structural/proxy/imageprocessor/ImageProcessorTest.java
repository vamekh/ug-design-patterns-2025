package ge.edu.ug.patterns.structural.proxy.imageprocessor;

import org.junit.jupiter.api.Test;

class ImageProcessorTest {
    @Test
    public void testImageManager(){
        ImageProcessor diskImage = new DiskImageProcessor("C:\\Users\\Albert\\Pictures\\test.jpg");
        diskImage.display();
    }

    @Test
    public void testProxy(){
        ImageProcessor diskImage = new DiskImageProcessorProxy("pathhhh");
        diskImage.display();
    }

}
