/**
 *
 * Test hast table
 *
 **/

public class HashTest {
    public static void main(String[] args) {
        Hash<String, Integer> map = new Hash<String, Integer>();
        
        map.put("abc", 123);
        if (map.containsKey("abc")) {
            Integer prev = map.put("abc", 456);
            System.out.format("before: %d\n", prev);
            System.out.format("after: %d\n", map.get("abc"));
        }

        if (!map.containsKey("xyz")) {
            System.out.println("Not found");
            map.put("xyz", 890);
            System.out.println("inserted: " + map.get("xyz"));
        }
    }
}