package srp;

public class PhoneClient {
    public static void main(String[] args) {
        Phone iphone = new Phone();
        iphone.dial("9284932809428409");
        iphone.disconnect();

        iphone.send("Hello");
    }
}
