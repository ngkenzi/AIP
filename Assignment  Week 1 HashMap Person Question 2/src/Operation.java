import java.util.*;

public class Operation {


    //add new person with unique id
    public void addNewPersonWithId(Person person, Map<Integer, Person> map) {
        int id = person.getId();
        try {
            if (!map.containsKey(id)) {
                map.put(id, person);

            }
            throw new Exception("Id found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //find person object by id
    public void findPersonById(int id, Map<Integer, Person> map) {
        try {
            if (!map.containsKey(id)) {
                throw new Exception("Id not found");
            } else {
                //retrieve id and store it in pId
                Person pId = map.get(id);
                System.out.println(pId.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //find person object by name
    public void findPersonByName(String name, Map <Integer, Person> map) {
        try {
            for (Person person : map.values()){
                String personName = person.getName();
                if (personName == name) {
                    System.out.println(personName.toString());
                } else {
                    throw new Exception("Person object not found");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteById(int id, Map<Integer, Person> map){
        try {
            if (map.containsKey(id)){
                map.remove(id);
                System.out.println("deleted");
            }else {
                throw new Exception("Id not found could not delete");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    //update age and name together
    public void updatePersonNameAge (String name, int id,  int age, Map <Integer, Person> map ) {
        try {
            if (!map.containsKey(id)) {
                throw new Exception("Person not found");
            } else {
                //store id into {person}
                Person person = map.get(id);
                //modify according to passed in parameter
                person.setAge(age);
                person.setName(name);
                System.out.println("Age and name updated");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePersonName (int id, String name, Map <Integer, Person> map) {
        try {

            if (!map.containsKey(id)) {
                throw new Exception("Person not found");
            } else {
                //store id into {person}
                Person person = map.get(id);
                //modify according to passed in parameter
                person.setName(name);
                System.out.println("Name updated only");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void updatePersonAge (int age, int id, Map <Integer, Person> map ) {
        try {
            if (!map.containsKey(id)) {
                throw new Exception("Person not found");
            } else {
                //store id into {person}
                Person person = map.get(id);
                //modify according to passed in parameter
                person.setAge(age);
                System.out.println("age updated only");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void displayPersonSorted (String order, Map<Integer,Person> map) {
        Set <Person> displayPersonNormal = new HashSet<>(map.values()) {
        };

        if (Objects.equals(order, "id") | Objects.equals(order, "ID")) {
            List <Person> personList = new ArrayList<Person>(map.values());
            personList.sort(Comparator.comparingInt(Person::getId));
            System.out.println(personList);
        } else if (Objects.equals(order, "name") | Objects.equals(order, "Name")) {
            List <Person> personList = new ArrayList<Person>(map.values());
            personList.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
            System.out.println(personList);
        } else {
            System.out.println(displayPersonNormal);
        }
    }
}
