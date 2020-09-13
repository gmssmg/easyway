package hackathon.banco.safra.easyway.adapters.persistence.enums.converters;

import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CustomerTypeDataEnumConverter implements AttributeConverter<CustomerTypeDataEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CustomerTypeDataEnum customerTypeDataEnum) {
        if(customerTypeDataEnum == null){
            return null;
        }
        return customerTypeDataEnum.getCode();
    }

    @Override
    public CustomerTypeDataEnum convertToEntityAttribute(Integer code) {
        return CustomerTypeDataEnum.fromCode(code);
    }
}
