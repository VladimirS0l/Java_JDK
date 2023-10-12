package homeWork;

public class BackendDeveloper extends Developer implements Backend{
    @Override
    public void createServer() {
        System.out.println("Написал серверную часть");
    }
}
