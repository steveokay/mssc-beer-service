package guru.springframework.msscbeerservice.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

// we do this because the dates in Beer and BeerDto are of diff types
// one is timestamp and another is OffsetDateTime which are incompatible during mapping
// this class converts them
@Component
public class DateMapper {
    // convert timestamp to offset
    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        if(ts != null){
            return OffsetDateTime.of(ts.toLocalDateTime().getYear(),
                    ts.toLocalDateTime().getMonthValue(),
                    ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(),
                    ts.toLocalDateTime().getMinute(), ts.toLocalDateTime().getSecond(),
                    ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        }else{
            return null;
        }
    }
    // convert offsetdatetime to timestamp
    public Timestamp asTimestamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime != null){
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }else{
            return null;
        }
    }
}
