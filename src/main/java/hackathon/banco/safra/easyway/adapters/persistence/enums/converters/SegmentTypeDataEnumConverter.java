package hackathon.banco.safra.easyway.adapters.persistence.enums.converters;

import hackathon.banco.safra.easyway.adapters.persistence.enums.SegmentTypeDataEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SegmentTypeDataEnumConverter implements AttributeConverter<SegmentTypeDataEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SegmentTypeDataEnum segmentTypeDataEnum) {
        if(segmentTypeDataEnum == null){
            return null;
        }
        return segmentTypeDataEnum.getCode();
    }

    @Override
    public SegmentTypeDataEnum convertToEntityAttribute(Integer code) {
        return SegmentTypeDataEnum.fromCode(code);
    }
}
