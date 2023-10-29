

public class SimpleTag extends Tag {
    private String tagData;
    public SimpleTag(String tagName, String tagData) {
        super(tagName);
        this.tagData = tagData;
    }
    public String getTagData() {
        return tagData;
    }
    public String toString() {
        return "[" + tagName + "]" + tagData +
                "[/" + tagName + "]";
    }
}
