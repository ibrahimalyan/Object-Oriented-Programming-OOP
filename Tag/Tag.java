

public abstract class Tag {
    protected String tagName;
    public Tag(String tagName) {
        this.tagName = tagName;
    }
    public String getTagName() { return tagName; }
    public abstract String toString();
}