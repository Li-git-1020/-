package 数据结构与算法.algorithm.sort;

public class Student implements Comparable<Student>{
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

//alt+insert
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

//Alt+enter
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }
}
