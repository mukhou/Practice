package conceptual;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/23/18
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class StudentTest {
    public static void main(String[] args){
        StudentManager studentManager = new StudentManager();
        try {
            Student student = studentManager.find("34567");
        }catch (StudentNotFoundException e){
            e.printStackTrace();
        }
    }
}
