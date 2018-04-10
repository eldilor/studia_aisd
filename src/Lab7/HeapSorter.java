package Lab7;

public class HeapSorter extends Sorter {
    HeapSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        for (int i = this.numbersArray.length / 2 - 1; i >= 0; i--) {
            heapify(this.numbersArray, this.numbersArray.length, i);
        }

        for (int i = this.numbersArray.length - 1; i >= 0; i--) {
            int temp = this.numbersArray[0];

            this.numbersArray[0] = this.numbersArray[i];
            this.numbersArray[i] = temp;

            heapify(this.numbersArray, i, 0);
        }

        return this.numbersArray;
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];

            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
