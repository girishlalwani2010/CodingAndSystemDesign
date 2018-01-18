package datastructure.week3;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring2 {

    private static FastScanner in;
    private static PrintWriter out;
    private static int prime = 101;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String s = input.pattern, p = input.text;
        int m = s.length(), n = p.length(), d=256, h=1, q=101, hashp=0,hasht=0,i,j;
        char[] pat = s.toCharArray();
        char[] txt = p.toCharArray();
        
        for (i = 0; i < m-1; i++)
        {
            h = (h*d)%q;
        
        }
        
        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < m; i++)
        {
            hashp = (d*hashp + pat[i])%q;
            hasht = (d*hasht + txt[i])%q;
        }
        List<Integer> occurrences = new ArrayList<Integer>();
     // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++)
        {
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters one by one
            if ( hashp == hasht)
            {
                /* Check for characters one by one */
                for (j = 0; j < m; j++)
                {
                    if (txt[i+j] != pat[j])
                        break;
                }
     
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == m)
                {
                	occurrences.add(i);
                }
            }
     
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < n-m)
            {
            	hasht = (d*(hasht - txt[i]*h) + txt[i+m])%q;
     
                // We might get negative value of t, converting it
                // to positive
                if (hasht < 0)
                hasht = (hasht + q);
            }
        }
        return occurrences;
    }
    
    
    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

