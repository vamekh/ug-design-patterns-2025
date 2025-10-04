package ge.edu.ug.solid.lsp.shapes;

public class Square extends Rectangle{
    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }
    @Override
    public void setHeight(int h) {
        super.setWidth(h);
        super.setHeight(h);
    }
}
