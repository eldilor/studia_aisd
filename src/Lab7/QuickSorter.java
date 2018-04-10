package Lab7;

public class QuickSorter extends Sorter {
    private boolean sortAscending;

    QuickSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        return this.sort(true);
    }

    public int[] sort(boolean sortAscending) {
        this.sortAscending = sortAscending;
        this.quicksort(0, this.numbersArray.length - 1);

        return this.numbersArray;
    }

    private void quicksort(int low, int high) {
        int i = low, j = high, pivot = this.numbersArray[low + (high - low) / 2];

        while (i <= j) {
            if (this.sortAscending) {
                while (this.numbersArray[i] < pivot) {
                    i++;
                }

                while (this.numbersArray[j] > pivot) {
                    j--;
                }
            } else {
                while (this.numbersArray[i] > pivot) {
                    i++;
                }

                while (this.numbersArray[j] < pivot) {
                    j--;
                }
            }

            if (i <= j) {
                this.exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            this.quicksort(low, j);
        }

        if (i < high) {
            this.quicksort(i, high);
        }
    }

    private void exchange(int i, int j) {
        int temp = this.numbersArray[i];
        this.numbersArray[i] = this.numbersArray[j];
        this.numbersArray[j] = temp;
    }
}
