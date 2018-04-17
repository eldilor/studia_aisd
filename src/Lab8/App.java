package Lab8;

import java.math.BigInteger;

public class App {
    private int dataCapacity;
    private BigInteger[] numbersArray;
    private int version = 0;

    public static void run() {
        App app = new App();
        int[] dataSizes = {5000, 10000, 50000, 100000};

        for (int dataSize : dataSizes) {
            app.dataCapacity = dataSize;
            app.numbersArray = new BigInteger[app.dataCapacity];

            long[][] results = new long[4][3];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        app.generateFirstTypeArray();
                    } else if (i == 1) {
                        app.generateSecondTypeArray();
                    } else if (i == 2) {
                        app.generateThirdTypeArray();
                    } else if (i == 3) {
                        app.generateFourthTypeArray();
                    }

                    app.version = j;
                    results[i][j] = app.sort();
                }
            }

            app.renderResultsTable(results);
        }
    }

    private void renderResultsTable(long[][] results) {
        System.out.println("\n\nLICZBA ELEMENTOW: " + this.numbersArray.length + "\n");
        System.out.println("#############################################################");
        System.out.println("#        #    WERSJA 1    #    WERSJA 2    #    WERSJA 3    #");
        System.out.println("#############################################################");
        for (int i = 0; i < results.length; i++) {
            System.out.print("# Ciąg " + i + " #");
            for (long resultCell : results[i]) {
                System.out.print("       " + resultCell + "ms      #");
            }
            System.out.println("\n#############################################################");
        }
    }

    private void generateFirstTypeArray() {
        for (int i = 0; i < this.dataCapacity; i++) {
            this.numbersArray[i] = i == 0 ? BigInteger.valueOf(1) : this.numbersArray[i - 1].multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
        }
    }

    private void generateSecondTypeArray() {
        for (int i = 0; i < this.dataCapacity; i++) {
            this.numbersArray[i] = BigInteger.valueOf((int) Math.pow(2, (double) (i + 1)) - 1);
        }
    }

    private void generateThirdTypeArray() {
        for (int i = 0; i < this.dataCapacity; i++) {
            this.numbersArray[i] = BigInteger.valueOf(i == 0 ? 1 : (int) Math.pow(2, (double) i) + 1);
        }
    }

    private void generateFourthTypeArray() {
        for (int i = 0; i < this.dataCapacity; i++) {
            this.numbersArray[i] = i > 1 ? this.numbersArray[i - 1].add(this.numbersArray[i - 2]) : BigInteger.valueOf(i);
        }
    }

    private long sort() {
        BigInteger[] arr = new BigInteger[this.dataCapacity];
        int gap = arr.length / 2;

        System.arraycopy(this.numbersArray, 0, arr, 0, this.numbersArray.length);

        long startTime = System.currentTimeMillis(), endTime;

        while (gap > 0) {
            if (gap == 1) {
                if (this.version == 1 || this.version == 3) {
                    this.insertSort(arr, gap);
                } else if (version == 2) {
                    this.bubbleSort(arr, gap);
                    this.bubbleSort(arr, gap);
                }
            } else {
                if (this.version == 1 || this.version == 2) {
                    this.insertSort(arr, gap);
                } else if (version == 3) {
                    this.bubbleSort(arr, gap);
                }
            }

            gap /= 2;
        }

        endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private void insertSort(BigInteger[] arr, int from) {
        for (int i = from; i < arr.length; i++) {
            BigInteger tmp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(tmp) == 1) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = tmp;
        }
    }

    private void bubbleSort(BigInteger[] arr, int from) {
        for (int i = from; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) == 1) {
                    BigInteger temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
