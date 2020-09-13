package hackathon.banco.safra.easyway.application.enums;

import lombok.Getter;

@Getter
public enum CustomerTypeEnum {

    INVESTMENT(1, "INVESTMENT"),
    LOAN(2, "LOAN"),
    MICROCREDIT(3, "MICROCREDIT");

    private final Integer code;
    private final String description;

    CustomerTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CustomerTypeEnum fromDescription(String description){
        for (CustomerTypeEnum customerTypeEnum : CustomerTypeEnum.values()){
            if(customerTypeEnum.getDescription().equals(description)){
                return customerTypeEnum;
            }
        }
        return null;
    }

}
