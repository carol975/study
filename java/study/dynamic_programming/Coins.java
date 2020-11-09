package dynamic_programming;

public class Coins {
	public int coins(int amount, int[] coinType, int typeIndex){
		if(typeIndex >= coinType.length-1){
			if(amount % coinType[typeIndex] == 0){
				return 1;
			}
			return 0;
		}
		
		int ways = 0;
		for(int i = 0; i * coinType[typeIndex] <= amount; i++){
			int deducedAmount = amount - i*coinType[typeIndex];
			ways+= coins(deducedAmount, coinType, typeIndex+1);
		}
		return ways;
	}
	
	public static void main(String[] args){
		int[] coinType = {25,10,5,1};
		Coins c = new Coins();
		System.out.println(c.coins(10, coinType, 0));
	}
}
