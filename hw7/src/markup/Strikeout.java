package markup;

import java.util.List;

public class Strikeout extends AbstractBBCode implements BBCode {

    public Strikeout(List<BBCode> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "~" );
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        super.toBBCode(sb, "[s]" , "[/s]");
    }
}
