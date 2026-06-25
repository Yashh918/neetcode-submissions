// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();

        List<List<Pair>> ans = new ArrayList<>();

        if(n == 0) return ans;

        ans.add(new ArrayList<>(pairs));

        int i = 1;
        while (i < n) {
            Pair p1 = pairs.get(i);

            int j = i - 1;
            while (j >= 0) {
                Pair p2 = pairs.get(j);

                if (p1.key >= p2.key)
                    break;

                pairs.set(j + 1, p2);
                --j;
            }

            pairs.set(j+1, p1);

            ++i;
            ans.add(new ArrayList<>(pairs));
        }

        return ans;
    }
}
