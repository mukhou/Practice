package conceptual;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/23/18
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class StudentManager {

    public Student find(String studentId) throws StudentNotFoundException{
        if(studentId.equals("12345")){
            return new Student();
        }else throw new StudentNotFoundException("could not find student with id " + studentId);
    }
}
