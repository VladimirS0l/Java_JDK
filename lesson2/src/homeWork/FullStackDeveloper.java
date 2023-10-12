package homeWork;

public class FullStackDeveloper extends Developer implements FullStack{
    @Override
    public void createServer() {
        System.out.println("Написал серверную часть");
    }

    @Override
    public void createFront() {
        System.out.println("Написал фронтенд часть");
    }
}
