public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int n) {
        this.N = n;
    }

    /** Returns true if characters are equal by the rules of the implementing class. */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == this.N;
    }
}
