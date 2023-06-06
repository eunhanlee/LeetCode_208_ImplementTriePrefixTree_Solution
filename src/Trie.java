public class Trie {
    private TrieNode root;

    /**
     * Constructor for the Trie class.
     * Creates a new Trie instance and initializes the root node.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a given word into the Trie.
     *
     * @param word The word to be inserted.
     */
    public void insert(String word) {
        TrieNode curr = root;

        // Traverse each character of the word and insert it into the Trie.
        for (char c : word.toCharArray()) {
            TrieNode child = curr.getChild(c);
            if (child == null) {
                child = new TrieNode();
                curr.setChild(c, child);
            }
            curr = child;
        }

        // Set the last character node as the end of the word.
        curr.setEndOfWord(true);
    }

    /**
     * Searches for a given word in the Trie.
     *
     * @param word The word to be searched.
     * @return True if the word is found in the Trie, false otherwise.
     */
    public boolean search(String word) {
        TrieNode curr = root;

        // Traverse each character of the word and search in the Trie.
        for (char c : word.toCharArray()) {
            TrieNode child = curr.getChild(c);
            if (child == null) return false;
            curr = child;
        }

        // Return whether the last character node represents the end of a word.
        return curr.isEndOfWord();
    }

    /**
     * Searches for words in the Trie that start with a given prefix.
     *
     * @param prefix The prefix to search for.
     * @return True if there are words in the Trie starting with the given prefix, false otherwise.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        // Traverse each character of the prefix and search in the Trie.
        for (char c : prefix.toCharArray()) {
            TrieNode child = curr.getChild(c);
            if (child == null) return false;
            curr = child;
        }

        // Return whether the prefix is found in the Trie.
        return true;
    }

    /**
     * TrieNode class representing a node in the Trie.
     */
    class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        /**
         * Constructor for TrieNode class.
         * Initializes the array of children nodes representing the lowercase alphabet,
         * and sets the end of word flag to false.
         */
        public TrieNode() {
            children = new TrieNode[26]; // Array representing the lowercase alphabet
            isEndOfWord = false;
        }

        /**
         * Sets the flag indicating the end of a word.
         *
         * @param isEndOfWord The flag value indicating the end of a word.
         */
        public void setEndOfWord(boolean isEndOfWord) {
            this.isEndOfWord = isEndOfWord;
        }

        /**
         * Returns the flag indicating the end of a word.
         *
         * @return The flag value indicating the end of a word.
         */
        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        /**
         * Returns the child node corresponding to the given character.
         *
         * @param c The character to get the child node for.
         * @return The child node corresponding to the given character.
         */
        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        /**
         * Sets the child node for the given character.
         *
         * @param c    The character to set the child node for.
         * @param node The child node to be set.
         */
        public void setChild(char c, TrieNode node) {
            children[c - 'a'] = node;
        }
    }
}
