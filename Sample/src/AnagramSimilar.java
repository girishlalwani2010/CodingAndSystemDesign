import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AnagramSimilar {
	public static void checkAndFindSimilarAnagrams(String[] arr) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < arr.length; i++) {
			char[] charArray = arr[i].toCharArray();
			Arrays.sort(charArray);
			String sortedString = new String(charArray);
			sortedString = sortedString.replace(" ", "");
			map.put(new Integer(i), sortedString);
		}
		int i = 0,count=0;
		for (Entry<Integer, String> entry : map.entrySet()) {
			String str = entry.getValue();
			for (Entry<Integer, String> entry1 : map.entrySet()) 	{
				if (str.equalsIgnoreCase(entry1.getValue())) {
					System.out.print(arr[entry1.getKey()] + ",");
					count++;
				}
			}
			System.out.println();
			if(count == arr.length) break;

		}
	}

	public static void main(String args[]) {
		String[] arr = { "pear", "amleth", "dormitory", "tinsel", "dirty room", "hamlet", "listen", "silent" };
		checkAndFindSimilarAnagrams(arr);
	}

}
