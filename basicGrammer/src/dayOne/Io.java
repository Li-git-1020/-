package dayOne;

import java.util.Scanner;

public class Io {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(str);

        }
        //凡是属于IO流的类如果不关闭会一直占用资源，要养成好习惯用完就关掉
        scanner.close();
    }
}
