package normal;

/**
 * indexOf字符串首次出现位置
 * @author 胡鹏
 *
 */
public class KMP {

	private int[][] dp;
	
	private String pat;

	public KMP(String pat) {
		this.pat = pat;
		int M = pat.length();
		dp = new int[M][256];
		dp[0][pat.charAt(0)] = 1;
		int X = 0;

		for (int j = 1; j < M; j++) {
			for (int c = 0; c < 256; c++) {
				dp[j][c] = dp[X][c];
			}
			dp[j][pat.charAt(j)] = j + 1;
			X = dp[X][pat.charAt(j)];
		}
	}
	
	public int search(String txt) {
		int N = txt.length();
		int M = pat.length();
		int j = 0;
		for (int i = 0; i < N; i++) {
			j = dp[j][txt.charAt(i)];
			if (j == M) {
				return i - M + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int index = new KMP("ll").search("hello");
		System.out.println(index);
	}

}
