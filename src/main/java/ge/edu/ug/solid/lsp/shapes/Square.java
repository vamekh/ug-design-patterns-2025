package ge.edu.ug.solid.lsp.shapes;

public class Square implements Shape{

    int side;

    public void setSide(int w) {
        this.side = w;
    }

    @Override
    public int area() {
        return side * side;
    }
}
