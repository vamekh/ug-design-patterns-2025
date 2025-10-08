package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

public class UiToolkit {
    String os;
    public UiToolkit(String os) {
        this.os = os;
    }
    public Button createButton() {
        if (os.equals("MacOS")) {
            return new MacosButton();
        } else if (os.equals("Windows")){
            return new WindowsButton();
        } else {
            return null;
        }
    }

    public ScrollBar createScrollBar() {
        if (os.equals("MacOS")) {
            return new MacosScrollbar();
        } else if (os.equals("Windows")){
            return new WindowsScrollbar();
        } else {
            return null;
        }
    }
}
