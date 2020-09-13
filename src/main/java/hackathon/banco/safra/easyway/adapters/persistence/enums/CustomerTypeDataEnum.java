package hackathon.banco.safra.easyway.adapters.persistence.enums;

import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import lombok.Getter;

@Getter
public enum CustomerTypeDataEnum {

    INVESTMENT(1, CustomerTypeEnum.INVESTMENT),
    LOAN(2, CustomerTypeEnum.LOAN),
    MICROCREDIT(3, CustomerTypeEnum.MICROCREDIT);

    private final Integer code;
    private final CustomerTypeEnum customerTypeEnum;

    CustomerTypeDataEnum(Integer code, CustomerTypeEnum customerTypeEnum) {
        this.code = code;
        this.customerTypeEnum = customerTypeEnum;
    }

    public Integer getCode(){return code;}

    public CustomerTypeEnum getCustomerTypeEnum(){return customerTypeEnum;}

    public static CustomerTypeDataEnum fromCode(Integer code){
        for (CustomerTypeDataEnum customerTypeDataEnum : CustomerTypeDataEnum.values()){
            if(customerTypeDataEnum.getCode().equals(code)){
                return customerTypeDataEnum;
            }
        }
        return null;
    }

    public static CustomerTypeDataEnum fromEnum(CustomerTypeEnum customerTypeEnum){
        for (CustomerTypeDataEnum customerTypeDataEnum : CustomerTypeDataEnum.values()){
            if(customerTypeDataEnum.getCustomerTypeEnum() == customerTypeEnum)
                return customerTypeDataEnum;
        }
        return null;
    }

}
