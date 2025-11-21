public class Sorting {
    public int[] sort7(int[] array) { //Bucket sort O(n+k)
        int[] count = new int[50];

        for (int num : array) { //Loop through array
            count[num]++; //Throw amount of numbers into bucket
        }
        //Take numbers out of buckets in accending order
        int index = 0;
        for (int value = 1; value <= 49; value++) {
            int c = count[value];
            while (c > 0) {
                array[index++] = value;
                c--;
            }
        }

        return array;
    }

    public int[] insertionSort(int[] array){ //Insertion sort O(n) -> O(n²)
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i]; //Element that gets inserted in the sorted section
            int j = i - 1; //Last element of the sorted path

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--; //Stop loop
            }

            array[j + 1] = key; //Place key
        }

        return array;
    }
}
