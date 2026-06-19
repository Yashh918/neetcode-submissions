class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] count = new int[2];
        
        for(int student : students){
            count[student]++;
        }

        for(int sandwich : sandwiches){
            if(count[sandwich] > 0){
                count[sandwich]--;
                n--;
            } else {
                break;
            }
        }

        return n;
    }

}