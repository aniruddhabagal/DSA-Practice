/*

- By Krish Jani (KrishJani)

Window Sliding Technique

The technique can be best understood with the window pane in bus, 
consider a window of length n and the pane which is fixed in it of 
length k. Consider, initially the pane is at extreme left i.e., at 
0 units from the left. Now, co-relate the window with array arr[] 
of size n and pane with current_sum of size k elements. Now, if we 
apply force on the window such that it moves a unit distance ahead. 
The pane will cover next k consecutive elements. 


Basic template of such problems is basically 3 steps.

Step1: Have a counter or hash-map to count specific array input and keep on increasing the window toward right using outer loop.
Step2: Have a while loop inside to reduce the window side by sliding toward right. Movement will be based on constraints of problem. 
Step3: Store the current maximum window size or minimum window size or number of windows based on problem requirement.

*/



// 1. The Templet

public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }
}




/*

Now let's understand this concept with an example.


Question: Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

Soultion...
*/

    public int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }



/*

Here's a list of questions that come under sliding window technique..
https://leetcode.com/list/x1lbzfk3/


And here's a list of questions that don't come under sliding window method. Make sure to solve them too.
    -    https://leetcode.com/problems/subarray-sums-divisible-by-k/
    -    https://leetcode.com/problems/subarray-sum-equals-k/
    -    https://leetcode.com/problems/maximum-product-subarray/
    -    https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    -    https://leetcode.com/problems/continuous-subarray-sum/

*/
