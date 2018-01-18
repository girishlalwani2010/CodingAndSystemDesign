package datastructure.string;

class PermutationOfString {
	public static void main (String[] args) {
		String str = "ae";
		printAllPermutations(str);
	}
	
	private static void printAllPermutations(String str) {
        if (str == null) return;
        printAllPermutations(str.toCharArray(), 0);
    }

    private static void printAllPermutations(char[] arr, int i) {
        if (i < arr.length) {
            for (int k = i; k < arr.length; ++k) {
                swap(arr, i, k);
                printAllPermutations(arr, i+1);
                swap(arr, i, k);
            }
        } else {
            print(arr);
            System.out.println();
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(char[] arr) {
        for (char ch : arr) {
            System.out.print(ch);
        }
    }
}