public class Palindrome {

    /** Takes in a string and turns it into a deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palindromeDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            palindromeDeque.addLast(word.charAt(i));
        }
        return palindromeDeque;
    }

    /** determines if String word is a palindrome */
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> d = this.wordToDeque(word);
        return isPalindromeHelper(d);
    }

    /** helper function for isPalindrome(String word) */
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else if (deque.removeFirst().equals(deque.removeLast())) {
            return isPalindromeHelper(deque);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (cc == null) {
            return this.isPalindrome(word);
        }
        if (word == null) {
            return false;
        }

        Deque<Character> d = this.wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        } else if (cc.equalChars(deque.removeFirst(), (deque.removeLast()))) {
            return isPalindromeHelper(deque, cc);
        } else {
            return false;
        }
    }
}
