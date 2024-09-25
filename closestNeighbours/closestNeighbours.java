public class closestNeighbours {
	public static void main(String[] args) {
		
		int[] numbers = {0, 5, 1200, 6, 2, 111, 112, 33};
		int[] neigh = new int[2];
		int smallerDiff;

		smallerDiff = Math.abs(numbers[0] - numbers[1]) + 1;

		System.out.print("Sequência:");
		for(int number : numbers) {
			System.out.print(" " + number);
		}
		System.out.println();
			
		for(int i = 0; i < numbers.length - 1; i++) {
			
			if(smallerDiff > Math.abs(numbers[i] - numbers[i + 1])) {
				smallerDiff = Math.abs(numbers[i] - numbers[i + 1]);
				neigh[0] = numbers[i];
				neigh[1] = numbers[i + 1];
			}
		}
		
		System.out.println("Resultado: " + neigh[0] + " " + neigh[1]);
	}
} 
