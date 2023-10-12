package homeWork;

public class FrontendDeveloper extends Developer implements Frontend{
    @Override
    public void createFront() {
        System.out.println("Написал фронтенд часть");
    }
}
