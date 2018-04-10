package Lab7;

public class MergeSorter extends Sorter {
    MergeSorter(int[] numbersArray) {
        super(numbersArray);
    }

    public int[] sort() {
        this.sortInRange(this.numbersArray, 0, this.numbersArray.length - 1);

        return this.numbersArray;
    }

    private void sortInRange(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sortInRange(arr, left, middle);
            sortInRange(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(int arr[], int left, int medium, int right) {
        int leftArrayLength = medium - left + 1, rightArrayLength = right - medium;
        int tempLeftArray[] = new int[leftArrayLength], tempRightArray[] = new int[rightArrayLength];

        for (int i = 0; i < leftArrayLength; ++i) {
            tempLeftArray[i] = arr[left + i];
        }

        for (int j = 0; j < rightArrayLength; ++j) {
            tempRightArray[j] = arr[medium + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < leftArrayLength && j < rightArrayLength) {
            arr[k++] = tempLeftArray[i] <= tempRightArray[j] ? tempLeftArray[i++] : tempRightArray[j++];
        }

        while (i < leftArrayLength) {
            arr[k++] = tempLeftArray[i++];
        }

        while (j < rightArrayLength) {
            arr[k++] = tempRightArray[j++];
        }
    }
}
