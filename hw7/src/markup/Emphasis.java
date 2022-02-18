package markup;

import java.util.List;

public class Emphasis extends AbstractBBCode implements BBCode {

    public Emphasis(List<BBCode> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "*");
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        super.toBBCode(sb, "[i]", "[/i]");
    }
}
