class Arrays {
    public static void main(String args[]) {
        // one dimensional array
        int size = 5;
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // two dimensional array
        int x = 5, y = 4;
        int arr2[][] = new int[x][y];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
    }
}
