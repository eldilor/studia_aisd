package Lab7;

public class InsertSorter extends Sorter {
    InsertSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        for (int i = 1; i < this.numbersArray.length; ++i) {
            int key = this.numbersArray[i], j = i - 1;

            while (j >= 0 && this.numbersArray[j] > key) {
                this.numbersArray[j + 1] = this.numbersArray[j];
                j--;
            }

            this.numbersArray[j + 1] = key;
        }

        return this.numbersArray;
    }
}
