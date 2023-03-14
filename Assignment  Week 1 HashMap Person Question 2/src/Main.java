import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Person person1 = new Person("sloon", 2, 22);
        Operation op = new Operation();
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("yk", 1, 20));
        map.put(2, new Person("russell", 2, 21));
        map.put(3, new Person("aisha", 3, 22));
        map.put(4, new Person("suki", 4, 23));
        map.put(6, new Person("derick", 6, 25));
        map.put(5, new Person("nikolas", 5, 24));
        map.put(7, new Person("ian", 7, 26));
        map.put(8, new Person("kartik", 8, 27));
        map.put(10, new Person("solomon", 10, 29));
        map.put(9, new Person("kenzi", 9, 28));


        //op.addNewPersonWithId(new Person("oi", 1, 23),  map);
        //op.findPersonById(2,map);
        //op.findPersonByName("kenzi", map); UNSOLVED
        op.deleteById(2,map);
        //op.updatePersonNameAge("kiki", 11, 44, map);

        //op.updatePersonAge(22, 19, map);
        //op.updatePersonName(14, "bong", map);
        System.out.println(map);

        //op.displayPersonSorted("", map);




    }
}