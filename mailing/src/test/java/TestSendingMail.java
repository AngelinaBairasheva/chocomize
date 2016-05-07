import mail.Mailing;


public class TestSendingMail {
    public static void main(String[] args) {
        Mailing mailing=new Mailing();
        mailing.sendMail("milronnie@mail.ru", "Здавствуй!");
        System.out.println(mailing.isStatus());
    }
}
