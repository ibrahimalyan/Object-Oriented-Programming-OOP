

public class ComplexTag extends Tag {

    private Tag[] tags;
    private int num = 0;
    private final int MAX_TAGS = 20;

    public ComplexTag(String tagName){
        super(tagName);
        tags = new Tag[MAX_TAGS];
    }
    public String toString() {

        String innerText = "";

        for(int i = 0 ; i < num ; i ++ ){
            innerText += tags[i].toString();
        }
        String result = "[" + tagName + "]" + innerText + "[/" + tagName + "]";

        return result;
    }

    public void addTag(Tag t) {

        tags[num] = t;
        num ++;

    }

    public Tag getTag(String tagName) {

        for(int i = 0 ; i < num ; i ++ ){
            if (tags[i].getTagName().equals(tagName)){
                return tags[i];
            } else if ( tags[i] instanceof ComplexTag){
                Tag tg = ((ComplexTag) tags[i]).getTag(tagName);
                if (tg != null){
                    return tg;
                }
            }
        }
        return null;
        
    }
}
