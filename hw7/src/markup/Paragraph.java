package markup;

import java.util.List;

public class Paragraph extends AbstractBBCode implements BBCode {

    public Paragraph(List<BBCode> list) {
        super(list);
    }   

    @Override
    public  void toMarkdown(StringBuilder s) {
        super.toMarkdown(s, "");
    }
    @Override
    public void toBBCode(StringBuilder sb) {
        super.toBBCode(sb, "", "");
    }
}

