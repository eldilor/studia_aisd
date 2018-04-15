package Lab7;

import services.Helper;

public class App {
    private final int dataCapacity = 50000;
    private int[] randomIntegers = new int[dataCapacity], minToMaxSortedIntegers, maxToMinSortedIntegers;

    public static void run() {
        App app = new App();

        for (int i = 0; i < app.dataCapacity; i++) {
            app.randomIntegers[i] = Helper.getRandomIntInRange(0, 1000);
        }

        QuickSorter sorter = new QuickSorter(app.randomIntegers);
        app.minToMaxSortedIntegers = sorter.sort(true);
        sorter.setNumbersArray(app.randomIntegers);
        app.maxToMinSortedIntegers = sorter.sort(false);


        app.testInsertSort();
        app.testBubbleSort();
        app.testSelectSort();
        app.testQuickSort();
        app.testHeapSort();
        app.testMergeSort();

        System.out.println("Najlepiej wypada quicksort, w każdym przypadku. Najgorzej poradził sobie bubble sort. \n" +
                "Dla danych posortowanych rosnąco wyjątkowo dobrze poradził sobie insertsort.");
    }

    private void testInsertSort() {
        InsertSorter insertSorter = new InsertSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        insertSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        insertSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        insertSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        insertSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        insertSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("INSERTSORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void testBubbleSort() {
        BubbletSorter bubbleSorter = new BubbletSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        bubbleSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        bubbleSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        bubbleSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        bubbleSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        bubbleSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("BUBBLESORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void testSelectSort() {
        SelectSorter selectSorter = new SelectSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        selectSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        selectSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        selectSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        selectSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        selectSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("SELECTSORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void testQuickSort() {
        QuickSorter quickSorter = new QuickSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        quickSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        quickSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        quickSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        quickSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        quickSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("QUICKSORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void testHeapSort() {
        HeapSorter heapSorter = new HeapSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        heapSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        heapSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        heapSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        heapSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        heapSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("HEAPSORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void testMergeSort() {
        MergeSorter mergeSorter = new MergeSorter(this.randomIntegers);
        long randomDataStartTime, ascendingDataStartTime, descendingDataStartTime;
        long randomDataStopTime, ascendingDataStopTime, descendingDataStopTime;

        randomDataStartTime = System.currentTimeMillis();
        mergeSorter.sort();
        randomDataStopTime = System.currentTimeMillis();

        mergeSorter.setNumbersArray(this.minToMaxSortedIntegers);
        ascendingDataStartTime = System.currentTimeMillis();
        mergeSorter.sort();
        ascendingDataStopTime = System.currentTimeMillis();

        mergeSorter.setNumbersArray(this.maxToMinSortedIntegers);
        descendingDataStartTime = System.currentTimeMillis();
        mergeSorter.sort();
        descendingDataStopTime = System.currentTimeMillis();

        this.displayAlgorithmResult("MERGESORT",
                randomDataStopTime - randomDataStartTime,
                ascendingDataStopTime - ascendingDataStartTime,
                descendingDataStopTime - descendingDataStartTime);
    }

    private void displayAlgorithmResult(String name, long randTime, long ascTime, long descTime) {
        System.out.println("===== " + name + " =====");
        System.out.println("   RAND |  ASC | DESC  ");
        System.out.printf("   %4d | %4d | %4d \n\n", randTime, ascTime, descTime);
    }
}
