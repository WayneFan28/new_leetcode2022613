package UnionFind;

import org.junit.Test;

public class SatisfiabilityOfEqualityEquations {//leetcode990

    public boolean equationsPossible(String[] equations){
        UF_eq uf = new UF_eq(26);
        for(String eq : equations){
            if (eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String eq : equations){
            if (eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a', y - 'a')){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        SatisfiabilityOfEqualityEquations se = new SatisfiabilityOfEqualityEquations();
        String[] equations = {"f==a","a==b","f!=e","a==c","b==e","c==f"};
        System.out.println(se.equationsPossible(equations));
    }

}
