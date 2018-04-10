package Lab7;

public class SelectSorter extends Sorter {
    SelectSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        for (int i = 0; i < this.numbersArray.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < this.numbersArray.length; j++) {
                if (this.numbersArray[j] < this.numbersArray[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = this.numbersArray[minIndex];

            this.numbersArray[minIndex] = this.numbersArray[i];
            this.numbersArray[i] = temp;
        }

        return this.numbersArray;
    }
}
