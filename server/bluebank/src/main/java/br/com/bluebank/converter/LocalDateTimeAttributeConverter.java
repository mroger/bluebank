package br.com.bluebank.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Converter between the new LocalDateTime and Timestamp
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
    	return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
    
}
