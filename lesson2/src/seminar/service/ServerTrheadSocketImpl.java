package seminar.service;

public class ServerTrheadSocketImpl implements ServerTrheadSocket{
    @Override
    public void onStart() {
        System.out.println("Log: Server started!");
    }

    @Override
    public void onStop() {
        System.out.println("Log: Server stoped!");
    }
}
