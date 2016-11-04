package snapchat;

public class Dog {
	public static void main(String args[]){
		Dog d = new Dog();
		d.digHole();
		
	}
	public void digHole() {
		int[][] holes = new int[2][2];
		System.out.println(holes[0][0]);
		newHole(holes);
		System.out.println(holes[0][0]);
	}
	
	private void newHole(int[][] xe) {
		xe[0][0] = 100;
	}
}
