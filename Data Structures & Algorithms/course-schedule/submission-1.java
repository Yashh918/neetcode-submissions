class Solution {
    private Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private Set<Integer> safe = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] each : prerequisites) {
            int course = each[0];
            int prerequisite = each[1];

            if (!map.containsKey(course)) {
                map.put(course, new ArrayList<>(List.of(prerequisite)));
            } else {
                map.get(course).add(prerequisite);
            }
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; ++i) {
            if(!dfs(i, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int num, Set<Integer> visited) {
        if(visited.contains(num)) return false;
        if(safe.contains(num)) return true;

        visited.add(num);
        ArrayList<Integer> paths = map.getOrDefault(num, new ArrayList<>());

        for(Integer path : paths){
            if(!dfs(path, visited)){
                return false;
            }
            safe.add(path);
            visited.remove(path);
        }

        visited.remove(num);
        safe.add(num);
        return true;
    }
}
