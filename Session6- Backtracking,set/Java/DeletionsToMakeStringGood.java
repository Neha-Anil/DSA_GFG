// A string s is called good if there are no two different characters in s that have the same frequency.

// Given a string s, return the minimum number of characters you need to delete to make s good.Freq of 0 is ignored

//SET SOLUTION  O(N)
class Solution {
    public int minDeletions(String s) {
        // Create an array to store character frequencies (one for each letter of the alphabet)
        int[] charFrequency = new int[26];
        
        // Create a set to keep track of existing frequencies in the new string
        Set<Integer> existingFrequencies = new HashSet<>();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        
        int deletions = 0 ;

        // Iterate through the sorted frequencies in reverse order
        for(int i = charFrequency.length - 1; i >= 0 ; i --){
            int curFreq = charFrequency[i] ;
            
            // Adjust frequency if it already exists in the new string
            while(curFreq > 0 && existingFrequencies.contains(curFreq)){
                deletions ++ ;
                curFreq -- ;
            }
            
            // Add the adjusted frequency to the set
            existingFrequencies.add(curFreq) ;
        }

        return deletions;
    }
}

//HEAP SOLUTION O(NlogN)
class Solution {
    public int minDeletions(String s) {
        // Create a map to store character frequencies
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Create a set to keep track of existing frequencies in new string
        Set<Integer> existingFrequencies = new HashSet<>();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a max heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        // Push frequencies into the max heap
        for (int freq : charFrequency.values()) {
            maxHeap.offer(freq);
        }

        int deletions = 0;
        while (!maxHeap.isEmpty()) {
            int curFreq = maxHeap.poll();
            
            // Adjust frequency if it already exists in the new string
            while (curFreq > 0 && existingFrequencies.contains(curFreq)) {
                curFreq--;
                deletions++;
            }
            
            // Add the adjusted frequency to the set
            existingFrequencies.add(curFreq);
        }
        return deletions;
    }
}

//ONLY USING HEAP
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class Solution {
    public int minDeletions(String s) {
        // Create a HashMap to count the frequency of each character.
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Iterate through the characters in the input string 's'.
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a max-heap (PriorityQueue) to store character frequencies in decreasing order.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Populate the max-heap with character frequencies from the map.
        maxHeap.addAll(frequencyMap.values());

        // Initialize a variable to keep track of the minimum number of deletions needed.
        int count = 0;

        // Continue as long as there are at least two frequencies in the max-heap.
        while (maxHeap.size() > 1) {
            int top = maxHeap.poll(); // Get the character frequency with the highest count.

            // Check if the next character in the max-heap has the same frequency as 'top' (and it's not zero).
            if (maxHeap.peek() != null && maxHeap.peek() == top && top != 0) {
                count++; // Increment the deletion count.
                maxHeap.add(top - 1); // Decrease 'top' frequency by 1 and push it back into the max-heap.
            }
        }

        // Return the minimum number of deletions required to make the string "good."
        return count;
    }
}

