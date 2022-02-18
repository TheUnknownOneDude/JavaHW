package markup;

public class Text implements BBCode{
    private String text;

    public Text(String s) {
        text = s;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(text);
    }

    @Override
    public void toBBCode(StringBuilder sb) {
        sb.append(text);
    }
}
