/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        int m = 0;

        if(guess(l) == 0) return l;
        if(guess(r) == 0) return r;

        while(l < r-1) {
            m = l + (r-l)/2;

            int res = guess(m);
            if(res == 0){
                return m;
            } else if(res == -1){
                r = m;
            } else {
                l = m;
            }
        }

        return m;
    }
}