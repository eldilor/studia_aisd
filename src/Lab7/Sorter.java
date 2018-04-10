package Lab7;

public abstract class Sorter {
    protected int[] numbersArray;

    Sorter(int[] numbersArray) {
        this.numbersArray = new int[numbersArray.length];
        System.arraycopy(numbersArray, 0, this.numbersArray, 0, this.numbersArray.length);
    }

    public int[] sort() {
        return this.numbersArray;
    }

    public void setNumbersArray(int[] numbersArray) {
        this.numbersArray = new int[numbersArray.length];
        System.arraycopy(numbersArray, 0, this.numbersArray, 0, this.numbersArray.length);
    }
}
