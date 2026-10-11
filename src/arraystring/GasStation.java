package arraystring;

public class GasStation {

	public static void main(String[] args) {
		int gas[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };

		int findStartIndex = findStartIndex(gas, cost);
		System.out.println(findStartIndex);

	}

	public static int findStartIndex(int gas[], int cost[]) {

		int start = 0;
		int totalGas = 0;
		int tank = 0;

		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];// spent petrol
			totalGas += diff;// this is to check the negative
			tank += diff;// current petrol in tank.
			if (tank < 0) {// petrol finished
				start = i + 1;
				tank = 0;
			}
		}
		return totalGas < 0 ? -1 : start;
	}

}
