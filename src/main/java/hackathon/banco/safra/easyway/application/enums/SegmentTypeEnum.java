package hackathon.banco.safra.easyway.application.enums;

import lombok.Getter;

@Getter
public enum SegmentTypeEnum {

    MEI(1, "MEI"),
    AUTONOMOUS(2, "AUTONOMOUS");

    private final Integer code;
    private final String description;

    SegmentTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SegmentTypeEnum fromDescription(String description){
        for (SegmentTypeEnum segmentTypeEnum : SegmentTypeEnum.values()){
            if(segmentTypeEnum.getDescription().equals(description)){
                return segmentTypeEnum;
            }
        }
        return null;
    }
}
