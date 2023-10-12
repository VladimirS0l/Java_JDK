package seminar.service;

public class ThreadSocketImpl implements ThreadSocket{

    @Override
    public void onButton(String button) {
        System.out.println("Push button: " + button);
    }
}
