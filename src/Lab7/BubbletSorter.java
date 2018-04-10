package Lab7;

public class BubbletSorter extends Sorter {
    BubbletSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        for (int i = 0; i < this.numbersArray.length; i++) {
            for (int j = 1; j < (this.numbersArray.length - i); j++) {
                if (this.numbersArray[j - 1] > this.numbersArray[j]) {
                    int temp = this.numbersArray[j - 1];
                    this.numbersArray[j - 1] = this.numbersArray[j];
                    this.numbersArray[j] = temp;
                }

            }
        }

        return this.numbersArray;
    }
}
