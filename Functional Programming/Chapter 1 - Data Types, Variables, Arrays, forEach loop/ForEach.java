class ForEach {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int num : arr) {
            sum = sum + num;
        }

        System.out.println(sum);

        // Iterating a 2D array
        sum = 0;
        int arr2[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };
        for (int temparr[] : arr2) {
            for (int num : temparr) {
                sum = sum + num;
            }
        }

        System.out.println(sum);
    }
}