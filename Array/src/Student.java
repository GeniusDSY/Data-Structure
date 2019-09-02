/**
 * @author :DengSiYuan
 * @date :2019/8/4 16:54
 * @desc : 测试自定义泛型数组的学生类
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
