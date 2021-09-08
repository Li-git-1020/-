package dayOne;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello,World!");
        System.out.println(num(3));
    }


    //阶乘3
    public static int num(int i){
        if(i == 1){
            return 1;
        }else{
            return i*num(i-1);

        }
    }
}