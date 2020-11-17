package SecondHMW.Polynomial;

public class Polynomial {
    PolyNode head;

    Polynomial() {
        head = new PolyNode();
    }

    /**
     * @param s: a polynomial like "-2x^3 +3x^2 -5", each node is separated by a space
     */
    public Polynomial(String s) {
        String[] polyNodes = s.split(" ");
        head = new PolyNode(polyNodes[0], "x");
        PolyNode pointer = head;
        for (int i = 1; i < polyNodes.length; i++) {
            pointer.next = new PolyNode(polyNodes[i], "x");
            pointer = pointer.next;
        }
    }

    public void printPoly() {
        PolyIterator iterator = new PolyIterator(head);
        while (!iterator.isEnd()) {
            System.out.print(iterator.current.item);
            iterator.advance();
        }
    }

    public int length() {
        int count = 0;
        PolyNode pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }

    public static Polynomial addTwoPoly(Polynomial P1, Polynomial P2) {
        PolyIterator itr1 = new PolyIterator(P1.head);
        PolyIterator itr2 = new PolyIterator(P2.head);
        int maxsize = (int) Math.ceil
                (Math.max(Double.parseDouble(P1.head.expo), Double.parseDouble(P2.head.expo))) + 1;
        PolyNode[] polyNodes = new PolyNode[maxsize];
        Polynomial res = new Polynomial();

        double expo1, expo2, coef1, coef2, coef_new;
        int count = 0;
        while (!itr1.isEnd() && !itr2.isEnd()) {
            ///////
            expo1 = Double.parseDouble(itr1.current.expo);
            expo2 = Double.parseDouble(itr2.current.expo);
            coef1 = Double.parseDouble(itr1.current.coef);
            coef2 = Double.parseDouble(itr2.current.coef);
            ///////

            if (expo1 == expo2) { // 指数相等，合并

                //////
                coef_new = coef1 + coef2;
                String item_new;
                if (coef_new == 0) { // 系数和为0，整体为0
                    itr1.advance();
                    itr2.advance();
                    continue;
                }
                if (coef_new % 1 == 0) { // 系数为整数
                    if (coef_new == 1) { // 系数为1时，不能出现x^1
                        if (expo1 != 0) // 若指数不为0
                            if (expo1 != 1)
                                item_new = itr1.current.element + "^" + itr1.current.expo;
                            else
                                item_new = itr1.current.element;
                        else
                            item_new = "1";
                    } else {
                        if (expo1 != 0)
                            if (expo1 != 1)
                                item_new = (int) coef_new + itr1.current.element + "^" + itr1.current.expo;
                            else
                                item_new = (int) coef_new + itr1.current.element;
                        else
                            item_new = String.valueOf((int) coef_new);
                    }
                } else {
                    if (expo1 != 0)
                        item_new = coef_new + itr1.current.element + "^" + itr1.current.expo;
                    else // 系数为0时，不能出现x^0
                        item_new = Double.toString(coef_new);
                }
                //////

                if (coef_new > 0 && count > 0) // 若系数为正，特别注意要添加一个加号
                    polyNodes[count] = new PolyNode("+" + item_new, "x");
                else
                    polyNodes[count] = new PolyNode(item_new, "x");
                itr1.advance();
                itr2.advance();
                count++;
            } else if (expo1 > expo2) {
                if (count > 0 && coef1 > 0 && !itr1.current.item.contains("+"))
                    polyNodes[count] = new PolyNode("+" + itr1.current.item, "x");
                else {
                    polyNodes[count] = itr1.current;
                }
                itr1.advance();
                count++;
            } else {
                if (count > 0 && coef2 > 0 && !itr2.current.item.contains("+"))
                    polyNodes[count] = new PolyNode("+" + itr2.current.item, "x");
                else
                    polyNodes[count] = itr2.current;
                itr2.advance();
                count++;
            }
        }
        // 退出循环，说明多项式1到头或多项式2到头，将没有处理完的多项式剩余项加入res
        for (; !itr1.isEnd(); itr1.advance()) {
            polyNodes[count] = itr1.current;
            count++;
        }
        for (; !itr2.isEnd(); itr2.advance()) {
            polyNodes[count] = itr2.current;
            count++;
        }

        res.head = polyNodes[0];
        PolyIterator iterator = new PolyIterator(res.head);
        for (int i = 1; i < count; i++) {
            iterator.current.next = polyNodes[i];
            iterator.advance();
        }

        return res;
    }

    public static void main(String[] a) {
        Polynomial P1 = new Polynomial("9x^6 +111x^3 -7x +11");
        Polynomial P2 = new Polynomial("3x^3 +2x^2 +9");
        Polynomial.addTwoPoly(P1, P2).printPoly();
    }
}
