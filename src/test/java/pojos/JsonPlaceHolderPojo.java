package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


// PojoClass => i)encapsulatıon yapılabilir ii)güvenli iii)hızlı



@JsonIgnoreProperties(ignoreUnknown = true) // olmayan dataları ignore et görmezden gel.
public class JsonPlaceHolderPojo {

    //wrapper class data type ında olusturduk.
    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo() { //gson, jackson ile obje olustururken kullancagız de-serilization için.
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

