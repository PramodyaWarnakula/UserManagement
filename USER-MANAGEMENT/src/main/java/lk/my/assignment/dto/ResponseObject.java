package lk.my.assignment.dto;


import java.util.List;

public class ResponseObject<T> {

    private int statusCode;
    private String status;
    private T object;
    private List<T>objects;

    public ResponseObject() {
    }

    public ResponseObject(int statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public ResponseObject(int statusCode, String status, T object) {
        this.statusCode = statusCode;
        this.status = status;
        this.object = object;
    }

    public ResponseObject(int statusCode, String status, T object, List<T> objects) {
        this.statusCode = statusCode;
        this.status = status;
        this.object = object;
        this.objects = objects;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ResposeObject{" +
                "statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", object=" + object +
                ", objects=" + objects +
                '}';
    }
}
