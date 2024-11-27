class Solution {
    private void soln(List<String> result, StringBuilder currExp, String num, int target, int ind, long eval,
            long prev) {
        if (ind == num.length() && eval == target) {
            result.add(currExp.toString());
            return;
        }

        for (int i = ind; i < num.length(); i++) {
            if (i != ind && num.charAt(ind) == '0')
                break;

            long cur = Long.parseLong(num.substring(ind, i + 1));
            int len = currExp.length();

            if (ind == 0) {
                currExp.append(cur);
                soln(result, currExp, num, target, i + 1, cur, cur);
                currExp.setLength(len);
            } else {
                currExp.append('+').append(cur);
                soln(result, currExp, num, target, i + 1, eval + cur, cur);
                currExp.setLength(len);

                currExp.append('-').append(cur);
                soln(result, currExp, num, target, i + 1, eval - cur, -cur);
                currExp.setLength(len);

                currExp.append('*').append(cur);
                soln(result, currExp, num, target, i + 1, eval - prev + (prev * cur), cur * prev);
                currExp.setLength(len);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        soln(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }
}