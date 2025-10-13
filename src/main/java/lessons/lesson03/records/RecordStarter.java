package lessons.lesson03.records;

public class RecordStarter {

    public static void main(String[] args) {
        var user1 = new UserRecord(18, "Mike");
        System.out.println(user1);

        var user2 = new UserClass(18, "Mike");
        user2.setAge(20);
        System.out.println(user2);
    }
}
