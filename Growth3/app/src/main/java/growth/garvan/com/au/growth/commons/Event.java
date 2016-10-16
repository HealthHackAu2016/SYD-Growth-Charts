package growth.garvan.com.au.growth.commons;

import java.util.List;

public class Event<T> {

    private int eventCode;
    private T item;

    public Event(){}

    public Event(int eventCode,T item){
        this.eventCode = eventCode;
        this.item = item;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
