import java.util.*;
class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list = new ArrayList<>();
    private Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val))
        {

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }

        else
        {


            int index = map.get(val);

            int temp = list.get(index);

            int last_element = list.get(list.size() - 1);
            list.set(index, last_element);
            list.set(list.size()-1, temp);

            map.remove(val);
            list.remove(list.size() - 1);
            if(temp != last_element)
            {
                map.put(list.get(index), index);
            }
            return true;
        }


    }

    public int getRandom() {
        int random_index = rand.nextInt(list.size());
        return list.get(random_index);

    }
}