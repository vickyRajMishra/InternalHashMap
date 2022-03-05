
// For better performance we can increase the size of NodeList
// when total elements in customHashMap reaches size and adjust the index of all items

public class MainSource {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("ABC", 1);
        customHashMap.put("ABC1", 2);
        customHashMap.remove("ABC");

        System.out.println(customHashMap.get("ABC"));
    }
}
