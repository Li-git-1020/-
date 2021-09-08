package dayOne;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String s = "hello";
//        StringBuilderDemo s2 = s; 这个方法是错误的
        StringBuilder s2 = new StringBuilder(s);
        System.out.println(s2);

        StringBuilder s3 = new StringBuilder();
        s3.append("hello");
        String s4 = s3.toString();
        System.out.println(s4);
    }
}
