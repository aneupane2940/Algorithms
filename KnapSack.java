
public class Tesp {
	public static void main(String[] args) {
		int weight = 7;
		int[] value =   { 6, 2, 1, 1, 4, 5, 1 };
		int[] weights = { 1, 2, 2, 1, 2, 3, 1 };

		int[][] k = new int[weight + 1][weights.length + 1];

		System.out.println(findOptimalItems(7, 0, value, weights, k));
	}

	public static int findOptimalItems(int w, int n, int[] val, int[] weight, int[][] optimalKnapsack) {
		if (w == 0 || n == weight.length) {
			return optimalKnapsack[w][n];
		}
		if (weight[n] > w)
			return (optimalKnapsack[w][n + 1] == 0) ? findOptimalItems(w, n + 1, val, weight, optimalKnapsack)
					: optimalKnapsack[w][n + 1];
		int include_n_benefit = optimalKnapsack[w - weight[n]][n + 1] == 0
				? findOptimalItems(w - weight[n], n + 1, val, weight, optimalKnapsack)
				: optimalKnapsack[w - weight[n]][n + 1];

		include_n_benefit += val[n];

		int exclude_n_benefit = (optimalKnapsack[w][n + 1] == 0)
				? findOptimalItems(w, n + 1, val, weight, optimalKnapsack)
				: optimalKnapsack[w][n + 1];

		optimalKnapsack[w][n] = Math.max(exclude_n_benefit, include_n_benefit);

		return Math.max(exclude_n_benefit, include_n_benefit);
	}
}
