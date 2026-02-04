package Java.Orientation2;

import java.util.PriorityQueue;

public class Task2EventList {
    public static void main(String[] args) {
        EventList list = new EventList();

        /* Lista tapahtumista */
        list.add(new Event(12.0, EventType.EXIT));
        list.add(new Event(1.5, EventType.ARRIVAL));
        list.add(new Event(8.0, EventType.EXIT));
        list.add(new Event(1.0, EventType.ARRIVAL));
        list.add(new Event(1.0, EventType.EXIT));

        System.out.println("Alku:");
        System.out.println(list);

        /* Seuraava tapahtuma */
        Event next = list.removeNext();
        System.out.println("Poistettiin tapahtuma: " + next);

        /* Tulostus aikajärjestyksessä */
        System.out.println("Jäljellä vielä:");
        System.out.println(list);
    }
}

enum EventType {
    ARRIVAL,
    EXIT
}

class Event implements Comparable<Event> {
    private final double time;
    private final EventType type;

    public Event(double time, EventType type) {
        this.time = time;
        this.type = type;
    }

    public double getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    @Override
    public int compareTo(Event other) {
        int c = Double.compare(this.time, other.time);
        if (c != 0) {
            return c;
        }
        return this.type.compareTo(other.type);
    }

    @Override
    public String toString() {
        return "t=" + time + ", type=" + type;
    }
}

class EventList {
    private final PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    public void add(Event event) {
        events.add(event);
    }

    public Event peekNext() {
        return events.peek();
    }

    public Event removeNext() {
        return events.poll();
    }

    @Override
    public String toString() {
        /* Varmistetaan oikea järjestys */
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        StringBuilder sb = new StringBuilder();
        sb.append("Tapahtumalista! (").append(events.size()).append(")\n");

        while (!copy.isEmpty()) {
            sb.append(copy.poll()).append('\n');
        }

        return sb.toString();
    }
}
