import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileAttribute = new File("resources\\Attribute.yml");
        if (fileAttribute.exists()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
        }
    }
}
