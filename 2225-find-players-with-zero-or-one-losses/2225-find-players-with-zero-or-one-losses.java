class Solution {
   public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> def = new HashMap<>();
        for(int[] arr : matches){
            def.put(arr[1], def.getOrDefault(arr[1], 0) + 1);
        }
        List<Integer> defeat = new ArrayList<>();
        for(int val : def.keySet()){
            if(def.get(val) == 1){
                defeat.add(val);
            }
        }
        Collections.sort(defeat);
        HashMap<Integer, Integer> win = new HashMap<>();
        for(int[] arr : matches){
            win.put(arr[0], win.getOrDefault(arr[0], 0) + 1);
        }
        List<Integer> winner = new ArrayList<>();
        
        for(int val : win.keySet()){
            if(!def.containsKey(val)){
                winner.add(val);
            }
        }
        Collections.sort(winner);
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(winner);
        res.add(defeat);
        return res;
        //[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]
    }
}