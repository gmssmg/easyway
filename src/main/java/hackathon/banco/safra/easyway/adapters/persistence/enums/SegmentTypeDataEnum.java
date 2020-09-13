package hackathon.banco.safra.easyway.adapters.persistence.enums;

import hackathon.banco.safra.easyway.application.enums.SegmentTypeEnum;
import lombok.Getter;

@Getter
public enum SegmentTypeDataEnum {

    MEI(1, SegmentTypeEnum.MEI),
    AUTONOMOUS(2, SegmentTypeEnum.AUTONOMOUS);

    private final Integer code;
    private final SegmentTypeEnum segmentTypeEnum;

    SegmentTypeDataEnum(Integer code, SegmentTypeEnum segmentTypeEnum) {
        this.code = code;
        this.segmentTypeEnum = segmentTypeEnum;
    }

    public Integer getCode(){return code;}

    public SegmentTypeEnum getSegmentTypeEnum(){return segmentTypeEnum;}

    public static SegmentTypeDataEnum fromCode(Integer code){
        for (SegmentTypeDataEnum segmentTypeDataEnum : SegmentTypeDataEnum.values()){
            if(segmentTypeDataEnum.getCode().equals(code)){
                return segmentTypeDataEnum;
            }
        }
        return null;
    }

    public static SegmentTypeDataEnum fromEnum(SegmentTypeEnum segmentTypeEnum){
        for (SegmentTypeDataEnum segmentTypeDataEnum : SegmentTypeDataEnum.values()){
            if(segmentTypeDataEnum.getSegmentTypeEnum() == segmentTypeEnum)
                return segmentTypeDataEnum;
        }
        return null;
    }
}
