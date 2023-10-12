package homeWork;

public class HW2App {
    public static void main(String[] args) {
        Developer dev = new FrontendDeveloper();
        if (dev instanceof Frontend) {
            ((Frontend) dev).createFront();
        }
    }
}
