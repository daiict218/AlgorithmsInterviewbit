public class Solution {
    public ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        solution.add(subset);
        if(A.size() == 0){
            return solution;
        }
        
        subsetsWithDupUtil(A, subset, 0);
        return solution;
    }
    
    public void subsetsWithDupUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int index){
        if(index >= A.size()){
            return ;
        }
        
        for(int i=index;i<A.size();i++){
            //if the previous element is same then the current element then we must've
            //included in this subset earlier
            if(i > index && A.get(i) == A.get(i - 1)){
                continue;
            }
            subset.add(A.get(i));
            ArrayList<Integer> list = new ArrayList<Integer>(subset);
            solution.add(list);
            
            subsetsWithDupUtil(A, list, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
