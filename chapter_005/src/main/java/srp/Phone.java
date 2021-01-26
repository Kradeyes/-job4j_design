package srp;

public class Phone implements PhoneFunction {
    @Override
    public void dial(String phoneNumber) {
        System.out.println("Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected");
    }

    @Override
    public void send(String message) {
        System.out.println("Message sent");
    }
}
