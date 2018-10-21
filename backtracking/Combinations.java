public class Solution {
    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(A == 0){
            solution.add(subset);
            return solution;
        }
        
        for(int i=0;i<A;i++){
            list.add(i, i+1);
        }
        
        combineUtil(list, subset, 0, B);
        return solution;
    }
    
    public void combineUtil(ArrayList<Integer> list, ArrayList<Integer> subset, int index, int k){
        if(subset.size() >= list.size()){
            return ;
        }
        for(int i=index;i<list.size();i++){
            subset.add(i, list.get(i));
            if(subset.size() == k){
                solution.add(new ArrayList<Integer>(subset));
            }
            combineUtil(list, subset, i + 1, k);
            subset.remove(subset.size() - 1);
        }
    }
}
