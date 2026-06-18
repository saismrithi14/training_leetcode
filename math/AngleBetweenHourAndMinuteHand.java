public class AngleBetweenHourAndMinuteHand {
    public double angleClock(int hour, int minutes) {
        double minuteHandAngle = minutes * 6;
        double hourHandAngle = (30 * hour) + (0.5 * minutes);
        double angle = Math.abs(hourHandAngle - minuteHandAngle);
        return Math.min(angle, 360-angle);

    }
}