import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class main {
	public static ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
			Collections.sort(A);
			ArrayList<Integer> subset = new ArrayList<Integer>();
			if(A.size() == 0){
					solution.add(subset);
					return solution;
			}

			solution.add(subset);
			subsetsUtil(A, subset, 0);
			return solution;
	}

	public static void subsetsUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int index){
			if(subset.size() >= A.size()){
				return;
			}

			for(int i=index;i<A.size();i++){
					//including the element
					subset.add(A.get(i));

					//adding subset to the solution
					solution.add(new ArrayList<Integer>(subset));
					subsetsUtil(A, subset, i+1);

					//excluding the element
					subset.remove(A.get(i));
			}
	}

		public static void main(String args[]){
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();

			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				list.add(i, input.nextInt());
			}

			System.out.println(subsets(list));
		}
}
