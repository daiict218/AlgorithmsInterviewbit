public class Solution {
  public ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<Integer> l = removeDuplicates(A);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        combinationSumUtil(l, subset, 0, B);
        return solution;
    }

    public void combinationSumUtil(ArrayList<Integer> A, ArrayList<Integer> subset, int index, int B){
        if(index >= A.size()){
            return ;
        }
        
        for(int i=index;i<A.size(); i++){
            subset.add(A.get(i));
            int s = subsetSum(subset);
            if(s < B){
                combinationSumUtil(A, subset, i, B);
            } 
            if(s == B){
                ArrayList<Integer> l = new ArrayList<Integer>(subset);
                Collections.sort(l);
                solution.add(l);
            }
            subset.remove(subset.size() - 1);
        }
    }
    
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list)
    {
        ArrayList<Integer> res = new ArrayList<>(list.size());
        
        res.add(list.get(0));
        
        int p2 = 0;
        
        for(int i = 1 ; i < list.size() ; i++)
        {
            if(res.get(p2) != list.get(i))
            {
                res.add(list.get(i));
                p2++;
            }
        }
        
        return res;
    }

    public int subsetSum(ArrayList<Integer> subset){
        int sum = 0;
        for(int i=0;i<subset.size();i++){
            sum += subset.get(i);
        }
        return sum;
    }
}
