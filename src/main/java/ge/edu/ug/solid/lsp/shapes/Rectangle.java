package ge.edu.ug.solid.lsp.shapes;

public class Rectangle implements Shape {
    protected int width;
    protected int height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int area() {
        return width * height;
    }

}
