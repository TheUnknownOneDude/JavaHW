package markup;

import java.util.List;

public abstract class AbstractBBCode  implements  BBCode{

    List<BBCode> data;

    public AbstractBBCode(List<BBCode> list) {
        data = list;
    }


    public  void toMarkdown(StringBuilder sb, String s) {
        sb.append(s);

        for (BBCode i : data) {
            i.toMarkdown(sb);
        }

        sb.append(s);
    }

    public  void toBBCode(StringBuilder sb, String s, String ss) {
        sb.append(s);

        for (BBCode i : data) {
            i.toBBCode(sb);
        }

        sb.append(ss);
    }
}
