import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 0) return result;
        
        result.add(1);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < result.size() - 1; j++) {
                row.add(result.get(j) + result.get(j + 1));
            }
            row.add(1);
            result = row;
        }
        return result;
    }
}