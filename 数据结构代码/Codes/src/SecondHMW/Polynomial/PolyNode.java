package SecondHMW.Polynomial;


public class PolyNode {
    String item, coef, expo, element;
    PolyNode next;

    PolyNode() {
        coef = null;
        expo = null;
        element = null;
        next = null;
        item = null;
    }

    public PolyNode(String s, String var) {
        item = s;
        if (!s.contains(var)) {
            coef = s;
            expo = "0";
        } else {
            coef = s.substring(0, s.indexOf(var));
            if (!s.contains("^"))
                expo = "1";
            else
                expo = s.substring(s.indexOf("^") + 1);
        }
        if (coef.equals("") || coef.equals("+")) coef = "1";
        if (coef.equals("-")) coef = "-1";
        element = var;
        next = null;
    }


}
