package markup;

import java.util.List;

public class Strong extends AbstractBBCode implements BBCode {

    public Strong(List<BBCode> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb,"__");
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        super.toBBCode(sb, "[b]", "[/b]");
    }
}
