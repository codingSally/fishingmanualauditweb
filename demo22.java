package leetTest;

import java.util.ArrayList;
import java.util.List;

/**
 * [
  	"((()))",
  	"(()())",
  	"(())()",
  	"()(())",
  	"()()()"
   ]
   parentheses：括弧
      参考网址：https://blog.csdn.net/timberwolf_2012/article/details/38642115
 * @author xueshangling
 * @date 2019-06-17
 */
public class demo22 {

	public static void main(String[] args) {
		List<String> res = generateParenthesis(2);
		res.forEach(System.out::println);
	}

    public static List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<String>();
        generate(n, n, "", res);
        return res;
    }
    
    private static void generate(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        generate(left - 1, right, out + "(", res);
        generate(left, right - 1, out + ")", res);
    }
    
}
