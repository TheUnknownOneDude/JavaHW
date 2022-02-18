package markup;

import java.util.List;


public interface BBCode {
    public void toMarkdown(StringBuilder sb);
    public void toBBCode(StringBuilder sb);
}
