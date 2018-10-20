import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class main {
	public static ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
      ArrayList<Integer> subset = new ArrayList<Integer>();
      if(n == 0){
          solution.add(subset);
          return solution;
      }
      ArrayList<Integer> A = new ArrayList<Integer>();
      for(int i=0;i<n;i++){
        A.add(i, i+1);
      }

		// solution.add(subset);
		combineUtil(A, subset, k, 0);
		return solution;
	}

	public static void combineUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int k, int index){
			if(subset.size() >= A.size()){
				return;
			}

			for(int i=index;i<A.size();i++){
					//including the element
					subset.add(A.get(i));

					//adding subset to the solution
          if(subset.size() == k){
					       solution.add(new ArrayList<Integer>(subset));
          }
					combineUtil(A, subset, k, i+1);

					//excluding the element
					subset.remove(A.get(i));
			}
	}

		public static void main(String args[]){
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
      int k = input.nextInt();

			System.out.println(combine(n, k));
		}
}
