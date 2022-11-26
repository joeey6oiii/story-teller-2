import java.io.CharArrayReader;

public enum Time {
    NIGHT,
    DAY,
    MORNING,
    NOT_FOR_LONG,
    RIGHT_NOW;

    public static String whatTime(Time time){
      return switch (time){
          case NIGHT -> "ночь";
          case DAY -> "день";
          case MORNING -> "утро";
          case NOT_FOR_LONG -> "недолго";
          case RIGHT_NOW -> "в это время";
      };
    }
}
