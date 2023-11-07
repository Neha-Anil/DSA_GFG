class Interval {
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class FreeTime {
    public static List<Interval> findFreeTime(List<Interval> meetings) {
        meetings.sort(Comparator.comparingInt(a -> a.start));
        List<Interval> freeTime = new ArrayList<>();
        int startTime = 1;
        for (Interval meeting : meetings) {
            if (startTime < meeting.start) {
                freeTime.add(new Interval(startTime, meeting.start));
            }
            startTime = Math.max(startTime, meeting.end);
        }
        freeTime.add(new Interval(endTime, 24));
        return freeTime;
    }

    public static void main(String[] args) {
        List<Interval> meetings = new ArrayList<>();
        // [(2, 6), (2, 3) (8, 10), (15, 18)]
        meetings.add(new Interval(2,6));
        meetings.add(new Interval(2,3));
        meetings.add(new Interval(8,10));
        meetings.add(new Interval(15,18));

        List<Interval> freeTimes = FreeTime.findFreeTime(meetings);
        for (Interval interval: freeTimes) {
            System.out.println(interval.start + " - " + interval.end);
        }

    }

}
