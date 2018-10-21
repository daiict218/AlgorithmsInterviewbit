public class Solution {
    public ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<Integer> list = removeDuplicates(A);
        
        ArrayList<Integer> subset = new ArrayList<Integer>();
        combinationSumUtil(list, subset, 0, B);
        return solution;
    }
    
    public void combinationSumUtil(ArrayList<Integer> list, ArrayList<Integer> subset, int index, int sum){
        for(int i=index;i<list.size();i++){
            subset.add(list.get(i));
            int sumOfSubset = subsetSum(subset);
            
            if(sumOfSubset > sum){
                combinationSumUtil(list, subset, i + 1, sum);
            } else if(sumOfSubset < sum){
                combinationSumUtil(list, subset, i, sum);
            } else {
                ArrayList<Integer> newSol = new ArrayList<Integer>(subset);
                Collections.sort(newSol);
                solution.add(newSol);
                combinationSumUtil(list, subset, i+1, sum);
            }
            
            subset.remove(subset.size() - 1);
        }
    }
    
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        
        int index = 0;
        newList.add(list.get(0));
        for(int i=1;i<list.size();i++){
            if(newList.get(index) != list.get(i)){
                newList.add(list.get(i));
                index++;
            }
        }
        
        return newList;
    }
    
    public int subsetSum(ArrayList<Integer> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        
        return sum;
    }
}
