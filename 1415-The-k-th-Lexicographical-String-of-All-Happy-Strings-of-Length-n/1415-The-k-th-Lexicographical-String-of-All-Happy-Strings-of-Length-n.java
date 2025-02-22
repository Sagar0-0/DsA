class Solution {
    // List to store all happy strings
    List<String> list = new ArrayList<>();

    // Method to get the k-th happy string of length n
    public String getHappyString(int n, int k) {
        char[] chr = {'a', 'b', 'c'};

        // Generate all happy strings of length n
        solve(chr, n, new StringBuilder());

        // Sort the list of happy strings lexicographically
        Collections.sort(list);

        // Return the k-th happy string if it exists, otherwise return an empty string
        return list.size() < k ? "" : list.get(k - 1);
    }

    // Recursive method to generate happy strings
    void solve(char[] chr, int n, StringBuilder sb) {
        // If the current string length equals n, add it to the list
        if (n == sb.length()) {
            list.add(sb.toString());
            return;
        }

        // Iterate through each character in chr array
        for (int i = 0; i < chr.length; i++) {
            // Skip if the current character is the same as the last character in the string
            if (sb.length() > 0 && chr[i] == sb.charAt(sb.length() - 1)) continue;

            // Append the current character to the string
            sb.append(chr[i]);
            // Recursively generate the next character
            solve(chr, n, sb);
            // Remove the last character to backtrack
            sb.setLength(sb.length() - 1);
        }
    }
}

