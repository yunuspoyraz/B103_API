package pojos;

public class DummyRestApiDeleteBodyPojo {

    private String status;
    private String data;
    private String message;

    public DummyRestApiDeleteBodyPojo() {
    }

    public DummyRestApiDeleteBodyPojo(String status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiDeleteBodyPojo{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

/*
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
 */