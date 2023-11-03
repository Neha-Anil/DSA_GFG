// A string s is called good if there are no two different characters in s that have the same frequency.

// Given a string s, return the minimum number of characters you need to delete to make s good.Freq of 0 is ignored

//SET SOLUTION
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

//HEAP SOLUTION
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
